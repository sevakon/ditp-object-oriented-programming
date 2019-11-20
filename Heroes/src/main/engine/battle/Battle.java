package main.engine.battle;

import main.engine.battle.exception.BattleAlreadyHasStackAwaitingActionException;
import main.engine.battle.exception.PerformingStackDoesNotMatchException;
import main.engine.specialties.*;

import java.util.LinkedList;
import java.util.Random;

/**
 * Battle Class
 * main class of the game engine
 */
public class Battle {
    private Status status;
    private BattleArmy firstArmy;
    private BattleArmy secondArmy;
    private int numberOfRoundsPlayed = 0;

    private BattleUnitsStack currentStack = null;
    private LinkedList<BattleUnitsStack> madeActionStacks;
    private LinkedList<BattleUnitsStack> stacksSortedByInitiative;

    /**
     * Battle Constructor
     * Requires two BattleArmies
     * @param firstArmy
     * @param secondArmy
     */
    public Battle(BattleArmy firstArmy, BattleArmy secondArmy) {
        this.firstArmy = firstArmy;
        this.secondArmy = secondArmy;
        this.stacksSortedByInitiative = new LinkedList<>();
        this.madeActionStacks = new LinkedList<>();
        this.firstArmy.getStacks().forEach(stack -> {
            stacksSortedByInitiative.add(stack);
            stack.setBattleSide(BattleSide.FIRST_ARMY);
        });
        this.secondArmy.getStacks().forEach(stack -> {
            stacksSortedByInitiative.add(stack);
            stack.setBattleSide(BattleSide.SECOND_ARMY);
        });
        sortByInitiative();
        this.status = Status.IN_ACTION;
    }

    /**
     * Public Methods for Battle Handling
     * getNextStack() for getting current playing stack
     * performAttack(), performDefence(), performCast(),
     * performSurrender(), performWait() for performing
     * playing stack's action
     */
    public BattleUnitsStack getNextStack() throws Exception {
        checkIfBattleHasCurrentStack();
        if (stacksSortedByInitiative.size() == 0)
            roundFinished();
        updateBattleStatus();
        currentStack = stacksSortedByInitiative.removeFirst();
        return currentStack;
    }

    public void performAttack(BattleUnitsStack attackingStack, BattleUnitsStack targetStack) throws Exception {
        checkPerformingActionStack(attackingStack);
        if (attackingStack.getAvailableSkills().contains(Skill.ACCURATE_SHOT)) {
            attack(attackingStack, targetStack, true);
        } else if (attackingStack.getAvailableSkills().contains(Skill.SHOT_TO_ALL)) {
            if (attackingStack.getBattleSide() == BattleSide.FIRST_ARMY)
                getSecondArmy().getStacks().forEach(defendingStack -> attack(attackingStack, defendingStack, false));
            else
                getFirstArmy().getStacks().forEach(defendingStack -> attack(attackingStack, defendingStack, false));
        } else {
            attack(attackingStack, targetStack, false);
        }
        madeActionStacks.add(attackingStack);
        currentStack = null;
    }

    public void performDefence(BattleUnitsStack battleUnitsStack) throws Exception {
        checkPerformingActionStack(battleUnitsStack);
        defence(battleUnitsStack);
        madeActionStacks.add(battleUnitsStack);
        currentStack = null;
    }

    public void performCast(BattleUnitsStack stack, Cast cast, BattleUnitsStack targetStack) throws Exception {
        checkPerformingActionStack(stack);
        // raise exception if unit does not have this cast
        stack.getAvailableCasts().remove(cast);
        // perform cast
        madeActionStacks.add(stack);
        currentStack = null;
    }

    public void performWait(BattleUnitsStack battleUnitsStack) throws Exception {
        checkPerformingActionStack(battleUnitsStack);
        stacksSortedByInitiative.add(battleUnitsStack);
        currentStack = null;
    }

    public void performSurrender(BattleUnitsStack battleUnitsStack) throws Exception {
        checkPerformingActionStack(battleUnitsStack);
        if (battleUnitsStack.getBattleSide() == BattleSide.FIRST_ARMY)
            status = Status.SECOND_ARMY_WON;
        else
            status = Status.FIRST_ARMY_WON;
        madeActionStacks.add(battleUnitsStack);
        currentStack = null;
    }

    /**
     * private checkers
     */
    private void checkPerformingActionStack(BattleUnitsStack performingActionStack)
            throws PerformingStackDoesNotMatchException {
        if (performingActionStack != currentStack)
            throw new PerformingStackDoesNotMatchException();
    }

    private void checkIfBattleHasCurrentStack() throws BattleAlreadyHasStackAwaitingActionException {
        if (currentStack != null)
            throw new BattleAlreadyHasStackAwaitingActionException();
    }

    /**
     * private methods for Battle Handling
     */
    private void roundFinished() {
        numberOfRoundsPlayed += 1;
        stacksSortedByInitiative = madeActionStacks;
        madeActionStacks.clear();
        removeDeadStacks();
        sortByInitiative();
    }

    private void removeDeadStacks() {
        stacksSortedByInitiative.forEach(stack -> {
            if (stack.getHealthPoints() < 0) stacksSortedByInitiative.remove(stack);
        });
    }

    private void updateBattleStatus() {
        Boolean allFirstArmyStacksDead = true;
        Boolean allSecondArmyStacksDead = true;
        for (BattleUnitsStack stack : stacksSortedByInitiative) {
            if (stack.getBattleSide() == BattleSide.FIRST_ARMY)
                allFirstArmyStacksDead = false;
            else
                allSecondArmyStacksDead = false;
        }
        if (allFirstArmyStacksDead) status = Status.SECOND_ARMY_WON;
        if (allSecondArmyStacksDead) status = Status.FIRST_ARMY_WON;
    }

    private static void attack(BattleUnitsStack attackingStack, BattleUnitsStack defendingStack, Boolean ignoreDefence) {
        int attack = attackingStack.getBattleAttack();
        int defence = defendingStack.getBattleDefence();
        if (ignoreDefence) defence = 0;
        int lowerBoundDamage = attackingStack.getNumberOfAliveUnits() * attackingStack.getUnit().getLowerDamage();
        int upperBoundDamage = attackingStack.getNumberOfAliveUnits() * attackingStack.getUnit().getUpperDamage();
        if (attack > defence) {
            lowerBoundDamage *= (int) (1 + 0.05 * (attack - defence));
            upperBoundDamage *= (int) (1 + 0.05 * (attack - defence));
        } else {
            lowerBoundDamage /= (int) (1 + 0.05 * (defence - attack));
            upperBoundDamage /= (int) (1 + 0.05 * (defence - attack));
        }
        int damage = new Random().nextInt((upperBoundDamage - lowerBoundDamage) + 1) + lowerBoundDamage;
        defendingStack.subtractHealthPoints(damage);
    }

    private static void defence(BattleUnitsStack battleUnitsStack) {
        int defenceToAdd = (int) (0.4 * battleUnitsStack.getBattleDefence());
        battleUnitsStack.addDefence(defenceToAdd);
    }

    public void logCurrentStacksQueue() {
        for (BattleUnitsStack stack: stacksSortedByInitiative) {
            System.out.println(stack.getUnit().getType() + "; Initiative: " +
                    stack.getBattleInitiative() + "; Side: " + stack.getBattleSide());
        }
        System.out.print('\n');
    }

    /**
     * Sorting doubly-linked list of stacks by
     * unit initiative in O(n^2) time-complexity
     */
    private void sortByInitiative() {
    this.stacksSortedByInitiative.sort((s1, s2) -> Double.compare(
            s2.getBattleInitiative(), s1.getBattleInitiative()));
    }

    public Status getStatus() {
        return status;
    }

    public int getNumberOfRoundsPlayed() {
        return numberOfRoundsPlayed;
    }

    public BattleArmy getFirstArmy() {
        return firstArmy;
    }

    public BattleArmy getSecondArmy() {
        return secondArmy;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Battle Info: \n\n");
        stringBuilder.append("First Army: \n");
        stringBuilder.append(firstArmy + "\n");
        stringBuilder.append("Second Army: \n");
        stringBuilder.append(secondArmy + "\n");
        stringBuilder.append(status + "\n");
        stringBuilder.append("Rounds: " + numberOfRoundsPlayed + "\n");
        return stringBuilder.toString();
    }

}

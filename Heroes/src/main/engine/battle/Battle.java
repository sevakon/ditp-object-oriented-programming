package main.engine.battle;

import main.engine.battle.exception.*;
import main.engine.specialties.*;

import java.util.LinkedList;
import java.util.Random;

/**
 * Battle Class
 * main class of the game engine
 */
public class Battle {
    private Status status;
    private BattleQueue queue;
    private BattleArmy firstArmy;
    private BattleArmy secondArmy;
    private BattleUnitsStack currentStack = null;

    /**
     * Battle Constructor
     * Requires two BattleArmies
     * @param firstArmy
     * @param secondArmy
     */
    public Battle(BattleArmy firstArmy, BattleArmy secondArmy) {
        this.firstArmy = firstArmy;
        this.secondArmy = secondArmy;
        this.queue = new BattleQueue(firstArmy, secondArmy);
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
        currentStack = queue.poll();
        return currentStack;
    }

    public void performAttack(BattleUnitsStack targetStack) throws Exception {
        checkIfBattleDoesNotHaveCurrentStack();
        if (currentStack.getAvailableSkills().contains(Skill.ACCURATE_SHOT)) {
            attack(currentStack, targetStack, true);
        } else if (currentStack.getAvailableSkills().contains(Skill.SHOT_TO_ALL)) {
            if (currentStack.getBattleSide() == BattleSide.FIRST_ARMY)
                getSecondArmy().getStacks().forEach(defendingStack -> attack(currentStack, defendingStack, false));
            else
                getFirstArmy().getStacks().forEach(defendingStack -> attack(currentStack, defendingStack, false));
        } else {
            attack(currentStack, targetStack, false);
        }
        queue.addToMadeActions(currentStack);
        currentStack = null;
        updateBattleStatus();
    }

    public void performDefence() throws Exception {
        checkIfBattleDoesNotHaveCurrentStack();
        defence(currentStack);
        queue.addToMadeActions(currentStack);
        currentStack = null;
    }

    public void performCast(BattleUnitsStack targetStack, Cast cast) throws Exception {
        checkIfBattleDoesNotHaveCurrentStack();
        // raise exception if unit does not have this cast
        currentStack.getAvailableCasts().remove(cast);
        // perform cast
        queue.addToMadeActions(currentStack);
        currentStack = null;
        updateBattleStatus();
    }

    public void performWait() throws Exception {
        checkIfBattleDoesNotHaveCurrentStack();
        queue.addToWaiting(currentStack);
        currentStack = null;
    }

    public void performSurrender(BattleUnitsStack battleUnitsStack) throws Exception {
        checkIfBattleDoesNotHaveCurrentStack();
        if (battleUnitsStack.getBattleSide() == BattleSide.FIRST_ARMY)
            status = Status.SECOND_ARMY_WON;
        else
            status = Status.FIRST_ARMY_WON;
        queue.addToMadeActions(battleUnitsStack);
        currentStack = null;
    }

    /**
     * Exceptions Raising
     */
    private void checkIfBattleHasCurrentStack() throws Exception {
        if (currentStack != null)
            throw new BattleAlreadyHasStackAwaitingActionException();
    }

    private void checkIfBattleDoesNotHaveCurrentStack() throws Exception {
        if (currentStack == null)
            throw new BattleDoesNotHaveStackAwaitingActionException();
    }

    /**
     * Private methods for Battle Controlling
     */
    private void updateBattleStatus() {
        boolean allFirstArmyStacksDead = true;
        boolean allSecondArmyStacksDead = true;
        for (BattleUnitsStack stack : firstArmy.getStacks())
            if (stack.getHealthPoints() != 0) {
                allFirstArmyStacksDead = false;
                break;
            }
        for (BattleUnitsStack stack : secondArmy.getStacks())
            if (stack.getHealthPoints() != 0) {
                allFirstArmyStacksDead = false;
                break;
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
        int defenceToAdd = (int) (0.3 * battleUnitsStack.getBattleDefence());
        battleUnitsStack.addDefence(defenceToAdd);
    }

    public Status getStatus() {
        return status;
    }

    public int getNumberOfRoundsPlayed() {
        return queue.getNumberOfRearrangements();
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
        stringBuilder.append("Rounds: " + getNumberOfRoundsPlayed() + "\n");
        return stringBuilder.toString();
    }

}

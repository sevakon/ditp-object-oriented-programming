package main.engine.battle;

import java.util.Random;
import main.engine.campaign.*;
import main.engine.exception.*;
import main.engine.specialties.*;


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
     * @param firstArmy first BattleArmy
     * @param secondArmy second BattleArmy
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
        checkIfBattleIsOver();
        checkCurrentStackPresence(false);
        currentStack = queue.poll();
        return currentStack;
    }

    public void performAttack(BattleUnitsStack targetStack) throws Exception {
        checkCurrentStackPresence(true);
        if (currentStack.getAvailableSkills()
                .stream()
                .filter(skill -> skill.getName() == "ACCURATE SHOT")
                .count() > 0) {
            attack(currentStack, targetStack, true);
        } else if (currentStack.getAvailableSkills()
                    .stream()
                    .filter(skill -> skill.getName() == "SHOT_TO_ALL")
                    .count() > 0) {
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
        checkCurrentStackPresence(true);
        defence(currentStack);
        queue.addToMadeActions(currentStack);
        currentStack = null;
    }

    public void performCast(BattleUnitsStack targetStack, Cast cast) throws Exception {
        checkCurrentStackPresence(true);
        checkIfCurrentStackHasCast(cast);
        if (cast.getName() == "REINCARNATION")
            cast.multiplyHealthPointsToAdd(targetStack.getNumberOfAliveUnits());
        targetStack.takeCast(cast);
        currentStack.removeCast(cast);
        queue.addToMadeActions(currentStack);
        queue.sort();
        currentStack = null;
        updateBattleStatus();
    }

    public void performWait() throws Exception {
        checkCurrentStackPresence(true);
        queue.addToWaiting(currentStack);
        currentStack = null;
    }

    public void performSurrender() throws Exception {
        checkCurrentStackPresence(true);
        if (currentStack.getBattleSide() == BattleSide.FIRST_ARMY)
            status = Status.SECOND_ARMY_WON;
        else
            status = Status.FIRST_ARMY_WON;
        queue.addToMadeActions(currentStack);
        currentStack = null;
    }

    /**
     * Raising Exceptions if Current Performing Stack
     * already exists and the Next Performing Stack is asked;
     * or the Perform Action is defined but the Current
     * Performing Stack was not defined
     */
    private void checkCurrentStackPresence(boolean shouldBePresent) throws Exception {
        if (shouldBePresent && currentStack == null)
            throw new BattleDoesNotHaveStackAwaitingActionException();
        else if (!shouldBePresent && currentStack != null)
            throw new BattleAlreadyHasStackAwaitingActionException();
    }

    /**
     * Raising Exception if Current Performing Stack
     * is to use a Cast that it does not have
     */
    private void checkIfCurrentStackHasCast(Cast cast) throws Exception {
        if (!currentStack.doesHaveCast(cast))
            throw new StackDoesNotHaveCastException(cast);
    }

    /**
     * Raising Exception if the next Stack
     * is asked but the battle is over
     */
    private void checkIfBattleIsOver() throws Exception {
        if (status != Status.IN_ACTION)
            throw new BattleIsOverException();
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
                allSecondArmyStacksDead = false;
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

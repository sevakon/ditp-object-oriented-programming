package main.engine.battle;

import main.engine.actions.Attack;
import main.engine.actions.Defend;
import main.engine.actions.Surrender;
import main.engine.actions.Wait;
import main.engine.campaign.Cast;
import main.engine.exception.BattleAlreadyHasStackAwaitingActionException;
import main.engine.exception.BattleDoesNotHaveStackAwaitingActionException;
import main.engine.exception.BattleIsOverException;
import main.engine.exception.StackDoesNotHaveCastException;


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
        this.status = Status.IN_ACTION;
        this.queue = new BattleQueue(firstArmy, secondArmy);
        for (BattleUnitsStack stack : firstArmy.getStacks()) stack.setBattleSide(BattleSide.FIRST_ARMY);
        for (BattleUnitsStack stack : secondArmy.getStacks()) stack.setBattleSide(BattleSide.SECOND_ARMY);
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
        new Attack().perform(this, currentStack, targetStack);
        queue.addToMadeActions(currentStack);
        currentStack = null;
        updateBattleStatus();
    }

    public void performDefence() throws Exception {
        checkCurrentStackPresence(true);
        new Defend().perform(this, currentStack, currentStack);
        queue.addToMadeActions(currentStack);
        currentStack = null;
    }

    public void performCast(BattleUnitsStack targetStack, Cast cast) throws Exception {
        checkCurrentStackPresence(true);
        checkIfCurrentStackHasCast(cast);
        cast.use(this, currentStack, targetStack);
        currentStack.removeCast(cast);
        queue.addToMadeActions(currentStack);
        queue.sort();
        currentStack = null;
        updateBattleStatus();
    }

    public void performWait() throws Exception {
        checkCurrentStackPresence(true);
        new Wait().perform(this, currentStack, currentStack);
        currentStack = null;
    }

    public void performSurrender() throws Exception {
        checkCurrentStackPresence(true);
        new Surrender().perform(this, currentStack, currentStack);
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
            throw new StackDoesNotHaveCastException(currentStack, cast);
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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

    public BattleQueue getQueue() {
        return queue;
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

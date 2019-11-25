package main.engine.battle;

import java.util.LinkedList;
import java.util.Iterator;
import java.util.stream.Collectors;

/**
 * Battle Queue class
 * Builds queue of stacks for Battle
 */
public class BattleQueue {
    private LinkedList<BattleUnitsStack> playingStacks = new LinkedList<>();
    private LinkedList<BattleUnitsStack> waitingStacks = new LinkedList<>();
    private LinkedList<BattleUnitsStack> madeActionStacks = new LinkedList<>();

    private int numberOfRearrangements = 0;

    public BattleQueue(BattleArmy firstArmy, BattleArmy secondArmy) {
        firstArmy.getStacks().forEach(stack -> playingStacks.add(stack));
        secondArmy.getStacks().forEach(stack -> playingStacks.add(stack));
        this.sortPlaying();
    }

    /**
     * Public Methods of Battle Queue
     */
    public BattleUnitsStack poll() {
        if (playingStacks.size() != 0)
            return playingStacks.removeFirst();
        else if (waitingStacks.size() != 0)
            return waitingStacks.removeFirst();
        else {
            deleteDeadStacks();
            rearrange();
            return playingStacks.removeFirst();
        }
    }

    public void addToPlaying(BattleUnitsStack stack) {
        playingStacks.add(stack);
        sortPlaying();
    }

    public void addToWaiting(BattleUnitsStack stack) {
        waitingStacks.addFirst(stack);
    }

    public void addToMadeActions(BattleUnitsStack stack) {
        madeActionStacks.add(stack);
    }

    /**
     * Private Methods for Battle Queue controlling
     */
    private void rearrange() {
        playingStacks.addAll(madeActionStacks);
        madeActionStacks.clear();
        sortPlaying();
        madeActionStacks.clear();
        numberOfRearrangements++;
    }

    private void deleteDeadStacks() {
        for (BattleUnitsStack stack : madeActionStacks)
            if (stack.getHealthPoints() == 0)
                madeActionStacks.remove(stack);
    }

    /**
     * Sorting doubly-linked list of playing stacks
     * by unit initiative in descending order
     * time-complexity: O(n log(n))
     */
    private void sortPlaying() {
        this.playingStacks.sort((s1, s2) -> Double.compare(
                s2.getBattleInitiative(), s1.getBattleInitiative()));
    }

    /**
     * Sorting doubly-linked list of waiting stacks
     * by unit initiative in ascending order
     * time-complexity: O(n log(n))
     */
    private void sortWaiting() {
        this.waitingStacks.sort((s1, s2) -> Double.compare(
                s1.getBattleInitiative(), s2.getBattleInitiative()));
    }

    public int getNumberOfRearrangements() {
        return numberOfRearrangements;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Battle Queue status:\n");
        stringBuilder.append("Playing: ");
        playingStacks.forEach(stack -> stringBuilder.append(
                stack.getUnit().getType() + ", Initiative: " + stack.getBattleInitiative() + "; "));
        stringBuilder.append("\n");
        stringBuilder.append("Waiting: ");
        waitingStacks.forEach(stack -> stringBuilder.append(
                stack.getUnit().getType() + ", Initiative: " + stack.getBattleInitiative() + "; "));
        stringBuilder.append("\n");
        stringBuilder.append("Made Action: ");
        madeActionStacks.forEach(stack -> stringBuilder.append(
                stack.getUnit().getType() + ", Initiative: " + stack.getBattleInitiative() + "; "));
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}

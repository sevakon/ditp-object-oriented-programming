package main.engine.battle;

import java.util.LinkedList;

public class Battle {
    private BattleArmy firstArmy;
    private BattleArmy secondArmy;
    private LinkedList<BattleUnitsStack> stacksSortedByInitiative;
    private Status status;

    public Battle(BattleArmy firstArmy, BattleArmy secondArmy) {
        this.firstArmy = firstArmy;
        this.secondArmy = secondArmy;
        this.stacksSortedByInitiative = new LinkedList<>();
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

    public void playRound() {
        LinkedList<BattleUnitsStack> usedStacks = new LinkedList<>();
        while (stacksSortedByInitiative.size() > 0) {
            BattleUnitsStack currentUnit = stacksSortedByInitiative.removeFirst();
            // if wait
            //    stacksSortedByInitiative.add(currentUnit);
            // else
            //    usedStacks.add(currentUnit);
            // logCurrentStacksQueue();
        }
    }

    public void logCurrentStacksQueue() {
        for (BattleUnitsStack stack: stacksSortedByInitiative) {
            System.out.println(stack.getUnit().getType() + "; Initiative: " +
                    stack.getBattleInitiative() + "; Side: " + stack.getBattleSide());
        }
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
        return stringBuilder.toString();
    }

}

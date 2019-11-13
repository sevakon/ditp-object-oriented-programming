package battle;

import java.util.ArrayList;
import java.util.Comparator;

public class Battle {
    private BattleArmy firstArmy;
    private BattleArmy secondArmy;
    private ArrayList<BattleUnitsStack> stacksSortedByInitiative;
    private Status status;

    public Battle(BattleArmy firstArmy, BattleArmy secondArmy) {
        this.firstArmy = firstArmy;
        this.secondArmy = secondArmy;
        this.stacksSortedByInitiative = new ArrayList<>();
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

    public void nextTurn() {
        System.out.println(stacksSortedByInitiative);
    }

    public void logCurrentStacksQueue() {
        for (BattleUnitsStack stack: stacksSortedByInitiative) {
            System.out.println(stack.getUnit().getType() + "; Initiative: " + stack.getUnit().getInitiative()
                + "; Side: " + stack.getBattleSide());
        }
    }

    private void sortByInitiative() {
        Comparator<BattleUnitsStack> initiativeComparator = (s1, s2) -> Double.compare(
                s2.getUnit().getInitiative(), s1.getUnit().getInitiative());
        this.stacksSortedByInitiative.sort(initiativeComparator);
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
        StringBuilder stringBuilder = new StringBuilder("Battle Info: \n");
        stringBuilder.append("First Army: \n");
        stringBuilder.append(firstArmy + "\n");
        stringBuilder.append("Second Army: \n");
        stringBuilder.append(secondArmy + "\n");
        stringBuilder.append(status + "\n");
        return stringBuilder.toString();
    }

}

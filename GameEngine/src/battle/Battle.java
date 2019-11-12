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
        this.firstArmy.getStacks().forEach(stack -> stacksSortedByInitiative.add(stack));
        this.secondArmy.getStacks().forEach(stack -> stacksSortedByInitiative.add(stack));
        sortByInitiative();
        this.status = Status.IN_ACTION;
    }

    public void nextTurn() {
        System.out.println(stacksSortedByInitiative);
    }

    private void sortByInitiative() {
        Comparator<BattleUnitsStack> initiativeComparator = (s1, s2) -> Double.compare(
                s1.getUnit().getInitiative(), s2.getUnit().getInitiative());
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

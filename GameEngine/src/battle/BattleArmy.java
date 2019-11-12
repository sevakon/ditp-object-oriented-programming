package battle;

import campaign.UnitsStack;
import campaign.exception.StackSizeExceededException;
import campaign.Army;
import java.util.ArrayList;
import java.util.Collections;

public class BattleArmy {
    private ArrayList<BattleUnitsStack> stacks;
    private int MAX_STACK_SIZE = 9;

    public BattleArmy(Army army) {
        stacks = new ArrayList<>();
        ArrayList<UnitsStack> campaignStacks = army.getStacks();
        for (UnitsStack stack : campaignStacks) {
            BattleUnitsStack battleStack = new BattleUnitsStack(stack);
            stacks.add(battleStack);
        }
    }

    public BattleArmy(ArrayList<BattleUnitsStack> battleStacks) throws StackSizeExceededException{
        if (battleStacks.size() > MAX_STACK_SIZE)
            throw new StackSizeExceededException("Your Battle Unit Stack Size exceeds maximal size");
        stacks = new ArrayList<>(battleStacks);
    }

    public BattleArmy(BattleUnitsStack... unitsStacks) throws StackSizeExceededException {
        stacks = new ArrayList<>();
        if (unitsStacks.length > MAX_STACK_SIZE)
            throw new StackSizeExceededException("Your Battle Unit Stack Size exceeds maximal size");
        Collections.addAll(stacks, unitsStacks);
    }

    public BattleArmy(BattleArmy army) throws StackSizeExceededException {
        this(army.getStacks());
    }

    public void addStack(BattleUnitsStack... battleStacks) throws StackSizeExceededException {
        if (stacks.size() + battleStacks.length > MAX_STACK_SIZE)
            throw new StackSizeExceededException("Your Battle Unit Stack Size exceeded maximal size");
        for (BattleUnitsStack battleStack : battleStacks)
            stacks.add(battleStack);
    }

    public ArrayList<BattleUnitsStack> getStacks() {
        return stacks;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Battle Army info:\n");
        stacks.forEach(stack -> stringBuilder.append(stack + "\n"));
        return stringBuilder.toString();
    }

}

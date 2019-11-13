package battle;

import campaign.UnitsStack;
import campaign.exception.StackSizeExceededException;
import campaign.Army;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BattleArmy {
    private ArrayList<BattleUnitsStack> stacks;
    private int MAX_STACK_SIZE = 9;

    public BattleArmy() {
        stacks = new ArrayList<>();
    }

    public BattleArmy(Army army) {
        stacks = new ArrayList<>();
        ArrayList<UnitsStack> campaignStacks = army.getStacks();
        for (UnitsStack stack : campaignStacks) {
            BattleUnitsStack battleStack = new BattleUnitsStack(stack);
            stacks.add(battleStack);
        }
    }

    public BattleArmy(ArrayList<BattleUnitsStack> battleStacks) throws StackSizeExceededException{
        checkNewSize(battleStacks.size());
        stacks = new ArrayList<>(battleStacks);
    }

    public BattleArmy(BattleUnitsStack... unitsStacks) throws StackSizeExceededException {
        checkNewSize(unitsStacks.length);
        stacks = new ArrayList<>();
        Collections.addAll(stacks, unitsStacks);
    }

    public BattleArmy(BattleArmy army) throws StackSizeExceededException {
        this(army.getStacks());
    }

    public void addStack(BattleUnitsStack... battleStacks) throws StackSizeExceededException {
        checkNewSize(stacks.size() + battleStacks.length);
        Arrays.stream(battleStacks).forEach(stack -> stacks.add(stack));
    }

    public void addStack(ArrayList<BattleUnitsStack> battleStacks) throws StackSizeExceededException {
        checkNewSize(battleStacks.size() + battleStacks.size());
        battleStacks.forEach(stack -> stacks.add(stack));
    }

    private void checkNewSize(int newSize) throws StackSizeExceededException {
        if (newSize > MAX_STACK_SIZE)
            throw new StackSizeExceededException("Your Battle Unit Stack Size exceeded maximal size");
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

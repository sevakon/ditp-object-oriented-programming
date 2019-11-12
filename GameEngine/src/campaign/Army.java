package campaign;

import campaign.exception.StackSizeExceededException;

import java.util.ArrayList;
import java.util.Collections;

public class Army {
    private ArrayList<UnitsStack> stacks;
    private static int MAX_STACK_SIZE = 6;

    public Army() {
        stacks = new ArrayList<>();
    }

    public Army(ArrayList<UnitsStack> unitsStacks) throws StackSizeExceededException {
        if (unitsStacks.size() > MAX_STACK_SIZE)
            throw new StackSizeExceededException("Your Unit Stack Size exceeds maximal size");
        stacks = new ArrayList<>(unitsStacks);
    }

    public Army(UnitsStack... unitsStacks) throws StackSizeExceededException {
        stacks = new ArrayList<>();
        if (unitsStacks.length > MAX_STACK_SIZE)
            throw new StackSizeExceededException("Your Unit Stack Size exceeds maximal size");
        Collections.addAll(stacks, unitsStacks);
    }

    public Army(Army army) throws StackSizeExceededException {
        this(army.getStacks());
    }

    public ArrayList<UnitsStack> getStacks() {
        return stacks;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Army info:\n");
        stacks.forEach(stack -> stringBuilder.append(stack + "\n"));
        return stringBuilder.toString();
    }
}

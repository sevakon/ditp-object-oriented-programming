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
        checkSize(unitsStacks.size());
        stacks = new ArrayList<>(unitsStacks);
    }

    public Army(UnitsStack... unitsStacks) throws StackSizeExceededException {
        checkSize(unitsStacks.length);
        stacks = new ArrayList<>();
        Collections.addAll(stacks, unitsStacks);
    }

    private void checkSize(int size) throws StackSizeExceededException {
        if (size > MAX_STACK_SIZE)
            throw new StackSizeExceededException("Your Unit Stack Size exceeds maximal size");
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

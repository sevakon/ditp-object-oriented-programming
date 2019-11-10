package campaign;

import campaign.exception.SizeExceededException;
import javafx.css.Size;

import java.util.ArrayList;
import java.util.Collections;

public class Army {
    private ArrayList<UnitsStack> stacks;
    private static int MAX_STACKS_SIZE = 6;

    public Army(ArrayList<UnitsStack> unitsStacks) throws SizeExceededException {
        if (unitsStacks.size() > MAX_STACKS_SIZE) {
            throw new SizeExceededException("Your Unit Stack Size exceeds maximal size");
        }
        stacks = new ArrayList<>(unitsStacks);
    }

    public Army(UnitsStack... unitsStacks) throws SizeExceededException {
        if (unitsStacks.length > MAX_STACKS_SIZE) {
            throw new SizeExceededException("Your Unit Stack Size exceeds maximal size");
        }
        stacks = new ArrayList<>();
        Collections.addAll(stacks, unitsStacks);
    }

    public Army(Army army) throws SizeExceededException {
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

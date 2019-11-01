package campaign;

public class Army {
    private UnitsStack[] stacks;

    public Army(UnitsStack... unitsStacks) {
        stacks = new UnitsStack[6];
        int index = 0;

        for (UnitsStack unitsStack : unitsStacks) {
            if (index == 6) break;
            stacks[index] = unitsStack;
            index++;
        }
    }

    public UnitsStack[] getStacks() {
        return stacks;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Army info: ");

        for (int i = 0; i < stacks.length; i++)
            if (stacks[i] != null)
                stringBuilder.append(stacks[i] + "; ");

        return stringBuilder.toString();
    }
}

package units;

public class Army {
    private UnitsStack[] stacks;

    public Army(UnitsStack... unitsStacks) {
        stacks = new UnitsStack[6];
        int index = 0;

        for (UnitsStack unitsStack : unitsStacks) {
            stacks[index] = unitsStack;
            index++;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Army info: ");

        for (int i = 0; i < stacks.length; i++)
            if (stacks[i] != null)
                stringBuilder.append(stacks[i].toString() + "; ");

        return stringBuilder.toString();
    }
}

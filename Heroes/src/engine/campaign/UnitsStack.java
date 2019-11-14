package engine.campaign;

public class UnitsStack {
    private Unit unit;
    private int numberOfUnits;

    public UnitsStack(Unit unit, int numberOfUnits) {
        this.unit = unit;
        this.numberOfUnits = numberOfUnits;
    }

    public UnitsStack(UnitsStack unitsStack) {
        this(unitsStack.getUnit(), unitsStack.getNumberOfUnits());
    }

    public Unit getUnit() {
        return unit;
    }

    public int getNumberOfUnits() {
        return numberOfUnits;
    }

    @Override
    public String toString() {
        return unit.toString() + ", number: " + numberOfUnits;
    }
}

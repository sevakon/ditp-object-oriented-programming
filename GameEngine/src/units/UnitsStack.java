package units;

public class UnitsStack {
    private Unit unit;
    private int numberOfUnits;

    public UnitsStack(Unit unit, int numberOfUnits) {
        this.unit = unit;
        this.numberOfUnits = numberOfUnits;
    }

    @Override
    public String toString() {
        return unit.toString() + ", number: " + numberOfUnits;
    }
}

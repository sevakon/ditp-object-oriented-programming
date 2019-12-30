package main.engine.campaign;

import main.engine.exception.UnitsStackNumberIsLessThanOneException;

public class UnitsStack {
    private Unit unit;
    private int numberOfUnits;

    public UnitsStack(Unit unit, int numberOfUnits) throws Exception {
        checkNumberOfUnits(numberOfUnits);
        this.unit = unit;
        this.numberOfUnits = numberOfUnits;
    }

    public UnitsStack(UnitsStack unitsStack) throws Exception{
        this(unitsStack.getUnit(), unitsStack.getNumberOfUnits());
    }

    public Unit getUnit() {
        return unit;
    }

    public int getNumberOfUnits() {
        return numberOfUnits;
    }

    private void checkNumberOfUnits(int numberOfUnits) throws Exception {
        if (numberOfUnits <= 0) throw new UnitsStackNumberIsLessThanOneException(numberOfUnits);
    }

    @Override
    public String toString() {
        return unit.toString() + ", number: " + numberOfUnits;
    }
}

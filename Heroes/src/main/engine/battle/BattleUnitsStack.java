package main.engine.battle;

import main.engine.campaign.UnitsStack;

public class BattleUnitsStack extends UnitsStack {
    private int numberOfAliveUnits;
    private int numberOfDeadUnits;
    private int healthPoints;
    private BattleSide battleSide;

    public BattleUnitsStack(UnitsStack unitsStack) {
        super(unitsStack);
        numberOfAliveUnits = getNumberOfUnits();
        numberOfDeadUnits = 0;
        healthPoints = numberOfAliveUnits * getUnit().getHealthPoints();
    }

    public int getNumberOfAliveUnits() {
        return numberOfAliveUnits;
    }

    public int getNumberOfDeadUnits() {
        return numberOfDeadUnits;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void takeDamage(int damage) {
        healthPoints -= damage;
        int newNumberOfAliveUnits = numberOfAliveUnitsAfterHPChange();
        numberOfDeadUnits += numberOfAliveUnits - newNumberOfAliveUnits;
        numberOfAliveUnits = newNumberOfAliveUnits;
    }

    public void heal(int healthPoints) {
        this.healthPoints += healthPoints;
        numberOfAliveUnits = numberOfAliveUnitsAfterHPChange();
    }

    private int numberOfAliveUnitsAfterHPChange() {
        return (int) Math.ceil((double) healthPoints/(double) getUnit().getHealthPoints());
    }

    public void setBattleSide(BattleSide battleSide) {
        this.battleSide = battleSide;
    }

    public BattleSide getBattleSide() {
        return battleSide;
    }

    @Override
    public String toString() {
        return "BattleUnitsStack of Unit: " + getUnit().getType() + "; "
                + "number of alive main.engine.units: " + numberOfAliveUnits + ", number of dead main.engine.units: "
                +  numberOfDeadUnits + ", total HP: " + healthPoints;
    }
}

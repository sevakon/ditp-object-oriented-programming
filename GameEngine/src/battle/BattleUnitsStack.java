package battle;

import campaign.UnitsStack;

public class BattleUnitsStack {
    private UnitsStack unitsStack;
    private int battleUnitsNumber;
    private int hitPoints;

    BattleUnitsStack(UnitsStack unitsStack) {
        this.unitsStack = unitsStack;
        this.battleUnitsNumber = unitsStack.getNumberOfUnits();
        this.hitPoints = battleUnitsNumber * unitsStack.getUnit().getHitPoints();
    }

}

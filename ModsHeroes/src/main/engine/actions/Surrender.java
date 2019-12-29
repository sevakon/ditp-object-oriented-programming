package main.engine.actions;

import main.engine.battle.*;

public class Surrender extends Action {

    public Surrender() {
        super("SURRENDER");
    }

    @Override
    public void perform(Battle battle, BattleUnitsStack performingStack, BattleUnitsStack targetStack) {
        if (performingStack.getBattleSide() == BattleSide.FIRST_ARMY)
            battle.setStatus(Status.SECOND_ARMY_WON);
        else
            battle.setStatus(Status.FIRST_ARMY_WON);
    }
}

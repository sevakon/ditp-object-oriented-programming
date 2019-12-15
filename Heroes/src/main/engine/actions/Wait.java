package main.engine.actions;

import main.engine.battle.Action;
import main.engine.battle.Battle;
import main.engine.battle.BattleUnitsStack;

public class Wait extends Action {

    public Wait() {
        super("WAIT");
    }

    @Override
    public void perform(Battle battle, BattleUnitsStack performingStack, BattleUnitsStack targetStack) {
        battle.getQueue().addToWaiting(performingStack);
    }
}

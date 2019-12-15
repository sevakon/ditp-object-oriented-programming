package main.engine.actions;

import main.engine.battle.Action;
import main.engine.battle.Battle;
import main.engine.battle.BattleUnitsStack;

public class Defend extends Action {

    public Defend() {
        super("DEFEND");
    }

    @Override
    public void perform(Battle battle, BattleUnitsStack performingStack, BattleUnitsStack targetStack) {
        int defenceToAdd = (int) (0.3 * targetStack.getBattleDefence());
        targetStack.addDefence(defenceToAdd);
    }
}

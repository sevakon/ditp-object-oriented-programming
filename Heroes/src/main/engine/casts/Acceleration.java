package main.engine.casts;

import main.engine.battle.Battle;
import main.engine.battle.BattleUnitsStack;
import main.engine.campaign.Cast;

public class Acceleration extends Cast {

    public Acceleration() {
        super("ACCELERATION");
    }

    @Override
    public void use(Battle battle, BattleUnitsStack castingStack, BattleUnitsStack targetStack) {
        targetStack.addInitiative(targetStack.getBattleInitiative() * 0.4);
    }
}

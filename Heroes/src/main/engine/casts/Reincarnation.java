package main.engine.casts;

import main.engine.battle.Battle;
import main.engine.battle.BattleUnitsStack;
import main.engine.campaign.Cast;

public class Reincarnation extends Cast {

    public Reincarnation() {
        super("REINCARNATION");
    }

    @Override
    public void use(Battle battle, BattleUnitsStack castingStack, BattleUnitsStack targetStack) {
        targetStack.addHealthPoints(castingStack.getNumberOfAliveUnits());
    }
}

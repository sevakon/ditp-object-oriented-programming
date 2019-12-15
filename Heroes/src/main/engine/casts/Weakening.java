package main.engine.casts;

import main.engine.battle.Battle;
import main.engine.battle.BattleUnitsStack;
import main.engine.campaign.Cast;

public class Weakening extends Cast {

    public Weakening() {
        super("WEAKENING");
    }

    @Override
    public void use(Battle battle, BattleUnitsStack castingStack, BattleUnitsStack targetStack) {
        targetStack.subtractDefence(12);
    }
}

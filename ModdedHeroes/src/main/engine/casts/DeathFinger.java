package main.engine.casts;

import main.engine.battle.Battle;
import main.engine.battle.BattleUnitsStack;
import main.engine.campaign.Cast;

public class DeathFinger extends Cast {

    public DeathFinger() {
        super("DEATH FINGER");
    }

    public void use(Battle battle, BattleUnitsStack castingStack, BattleUnitsStack targetStack) {
        targetStack.subtractHealthPoints(20);
    }
}

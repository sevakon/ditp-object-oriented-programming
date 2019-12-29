package main.engine.casts;

import main.engine.battle.Battle;
import main.engine.battle.BattleUnitsStack;
import main.engine.campaign.Cast;

public class PunishingShot extends Cast {

    public PunishingShot() {
        super("PUNISHING SHOT");
    }

    @Override
    public void use(Battle battle, BattleUnitsStack castingStack, BattleUnitsStack targetStack) {
        targetStack.addAttack(12);
    }
}

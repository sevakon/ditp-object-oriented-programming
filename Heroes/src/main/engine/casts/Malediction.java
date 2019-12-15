package main.engine.casts;

import main.engine.battle.Battle;
import main.engine.battle.BattleUnitsStack;
import main.engine.campaign.Cast;

public class Malediction extends Cast {

    public Malediction() {
        super("MALEDICTION");
    }

    @Override
    public void use(Battle battle, BattleUnitsStack castingStack, BattleUnitsStack targetStack) {
        targetStack.subtractAttack(12);
    }
}

package main.engine.actions;

import main.engine.battle.Action;
import main.engine.battle.Battle;
import main.engine.battle.BattleUnitsStack;

public class Attack extends Action {

    public Attack() {
        super("ATTACK");
    }

    @Override
    public void perform(Battle battle, BattleUnitsStack performingStack, BattleUnitsStack targetStack) {
        int attack = performingStack.getBattleAttack();
        int defence = targetStack.getBattleDefence();
        int damage = performingStack.getNumberOfAliveUnits() * performingStack.getUnit().getDamage().getRandomDamage();
        if (attack > defence)
            damage *= (int) (1 + 0.05 * (attack - defence));
        else
            damage /= (int) (1 + 0.05 * (defence - attack));
        targetStack.subtractHealthPoints(damage);
    }
}

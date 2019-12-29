package main.engine.skills;

import main.engine.battle.Battle;
import main.engine.battle.BattleUnitsStack;
import main.engine.campaign.Skill;
import main.engine.campaign.SkillType;

public class AccurateShot extends Skill {

    public AccurateShot() {
        super("ACCURATE SHOT", SkillType.ATTACK);
    }

    @Override
    public void activate(Battle battle, BattleUnitsStack holder, BattleUnitsStack target) {
        int attack = holder.getBattleAttack();
        int damage = holder.getNumberOfAliveUnits() * holder.getUnit().getDamage().getRandomDamage();
        damage *= (int) (1 + 0.05 * attack);
        target.subtractHealthPoints(damage);
    }
}

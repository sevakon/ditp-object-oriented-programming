package main.engine.skills;

import main.engine.battle.Battle;
import main.engine.battle.BattleUnitsStack;
import main.engine.campaign.Skill;
import main.engine.campaign.SkillType;

public class EnemyNoResist extends Skill {

    public EnemyNoResist() {
        super("ENEMY NO RESIST", SkillType.ALWAYS);
    }

    @Override
    public void activate(Battle battle, BattleUnitsStack holder, BattleUnitsStack target) {
        // TODO
    }
}

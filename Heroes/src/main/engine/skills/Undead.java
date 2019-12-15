package main.engine.skills;

import main.engine.battle.Battle;
import main.engine.battle.BattleUnitsStack;
import main.engine.campaign.Skill;
import main.engine.campaign.SkillType;

public class Undead extends Skill {

    public Undead() {
        super("UNDEAD", SkillType.ALWAYS);
    }

    @Override
    public void activate(Battle battle, BattleUnitsStack holder, BattleUnitsStack target) {
        // TODO
    }
}

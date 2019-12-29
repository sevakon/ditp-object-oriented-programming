package main.engine.skills;

import main.engine.actions.Attack;
import main.engine.battle.Battle;
import main.engine.battle.BattleUnitsStack;
import main.engine.campaign.Skill;
import main.engine.campaign.SkillType;

public class EndlessRebuff extends Skill {

    public EndlessRebuff() {
        super("ENDLESS REBUFF", SkillType.AFTER_DAMAGE);
    }

    @Override
    public void activate(Battle battle, BattleUnitsStack holder, BattleUnitsStack target) {
        new Attack().perform(battle, holder, target);
    }
}

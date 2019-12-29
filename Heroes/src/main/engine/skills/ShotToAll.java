package main.engine.skills;

import main.engine.actions.Attack;
import main.engine.battle.Battle;
import main.engine.battle.BattleSide;
import main.engine.battle.BattleUnitsStack;
import main.engine.campaign.Skill;
import main.engine.campaign.SkillType;

import java.util.ArrayList;

public class ShotToAll extends Skill {

    public ShotToAll() {
        super("SHOT TO ALL", SkillType.ATTACK);
    }

    @Override
    public void activate(Battle battle, BattleUnitsStack holder, BattleUnitsStack target) {
        ArrayList<BattleUnitsStack> targetStacks = new ArrayList<>();
        if (holder.getBattleSide() == BattleSide.FIRST_ARMY)
            targetStacks.addAll(battle.getSecondArmy().getStacks());
        else
            targetStacks.addAll(battle.getFirstArmy().getStacks());
        for (BattleUnitsStack stack : targetStacks)
            new Attack().perform(battle, holder, stack);
    }
}

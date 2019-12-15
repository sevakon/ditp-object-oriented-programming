package main.engine.campaign;


import main.engine.battle.Battle;
import main.engine.battle.BattleUnitsStack;

public abstract class Skill extends Specialty {
    protected SkillType type;

    public Skill(String skillName, SkillType type) {
        super(skillName);
        this.type = type;
    }

    public SkillType getType() {
        return type;
    }

    public abstract void activate(Battle battle, BattleUnitsStack holder, BattleUnitsStack target);

    @Override
    public boolean equals(Object o) {
        return (o instanceof Skill) && (this.getName() == ((Skill) o).getName());
    }
}

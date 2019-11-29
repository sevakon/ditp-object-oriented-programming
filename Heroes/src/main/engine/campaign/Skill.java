package main.engine.campaign;

import main.engine.specialties.SkillName;

public class Skill extends Specialty {

    public Skill(SkillName skillName) {
        super(skillName);
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Skill) && (this.getName() == ((Skill) o).getName());
    }
}

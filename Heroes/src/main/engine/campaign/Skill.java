package main.engine.campaign;


public class Skill extends Specialty {

    public Skill(String skillName) {
        super(skillName);
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Skill) && (this.getName() == ((Skill) o).getName());
    }
}

package main.engine.specialties;

public enum Skill implements Specialty {
    SHOOTER("Shooter"),
    ACCURATE_SHOT("Accurate Shot"),
    UNDEAD("Undead"),
    ENEMY_NO_RESIST("Enemy No Resist"),
    SHOT_TO_ALL("Shot To All"),
    ENDLESS_REBUFF("Endless Rebuff");

    String stringRepresentation;
    Skill(String stringRepresentation) {
        this.stringRepresentation = stringRepresentation;
    }

    public String getStringRepresentation() {
        return stringRepresentation;
    }
}

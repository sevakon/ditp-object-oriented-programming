package main.engine.campaign;

import java.util.ArrayList;

public class Unit {
    private String type;
    private int healthPoints;
    private int attack;
    private int defence;
    private Damage damage;
    private double initiative;
    private Specialty specialties[];

    public Unit(String type, int healthPoints, int attack, int defence,
                    Damage damage, double initiative, Specialty[] specialties) {
        this.type = type;
        this.attack = attack;
        this.defence = defence;
        this.healthPoints = healthPoints;
        this.initiative = initiative;
        this.damage = damage;
        this.specialties = specialties;
    }

    public String getType() {
        return type;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }

    public Damage getDamage() {
        return damage;
    }

    public double getInitiative() {
        return initiative;
    }

    public Specialty[] getSpecialties() {
        return specialties;
    }

    public ArrayList<Cast> getCasts() {
        ArrayList<Cast> casts = new ArrayList<>();
        for (Specialty specialty: specialties)
            if (specialty instanceof Cast)
                casts.add((Cast) specialty);

        return casts;
    }

    public ArrayList<Skill> getSkills() {
        ArrayList<Skill> skills = new ArrayList<>();
        for (Specialty specialty: specialties)
            if (specialty instanceof Skill)
                skills.add((Skill) specialty);

        return skills;
    }

    @Override
    public String toString() {
        return "type: " + type + ", HP: " + healthPoints + ", attack: " + attack + ", defence: " +
                defence + ", damage: " + damage.getLower() + "-" + damage.getUpper() + ", initiative " + initiative;
    }
}

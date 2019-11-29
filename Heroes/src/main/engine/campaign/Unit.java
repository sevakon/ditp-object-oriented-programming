package main.engine.campaign;

import main.engine.units.Type;

import java.util.ArrayList;

public class Unit {
    private Type type;
    private int healthPoints;
    private int attack;
    private int defence;
    private int lowerDamage;
    private int upperDamage;
    private double initiative;
    private Specialty specialties[];

    public Unit(Type type, int healthPoints, int attack, int defence, int lowerDamage,
                int upperDamage, double initiative, Specialty[] specialties) {
        this.type = type;
        this.attack = attack;
        this.defence = defence;
        this.healthPoints = healthPoints;
        this.initiative = initiative;
        this.lowerDamage = lowerDamage;
        this.upperDamage = upperDamage;
        this.specialties = specialties;
    }

    public Type getType() {
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

    public int getLowerDamage() {
        return lowerDamage;
    }

    public int getUpperDamage() {
        return upperDamage;
    }

    public double getInitiative() {
        return initiative;
    }

    public Specialty[] getSpecialties() {
        return specialties;
    }

    public ArrayList<Cast> getCastes() {
        ArrayList<Cast> castes = new ArrayList<>();
        for (Specialty specialty: specialties)
            if (specialty instanceof Cast)
                castes.add((Cast) specialty);

        return castes;
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
                defence + ", damage: " + lowerDamage + "-" + upperDamage + ", initiative " + initiative;
    }
}

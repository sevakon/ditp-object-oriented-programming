package campaign;

import specialties.*;
import units.Type;

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

    public ArrayList<Specialty> getCastes() {
        ArrayList<Specialty> castes = new ArrayList<>();
        for (Specialty specialty: specialties) {
            if (specialty instanceof Caste) {
                castes.add(specialty);
            }
        }
        return castes;
    }

    public ArrayList<Specialty> getSkills() {
        ArrayList<Specialty> skills = new ArrayList<>();
        for (Specialty specialty: specialties) {
            if (specialty instanceof Skill) {
                skills.add(specialty);
            }
        }
        return skills;
    }

    @Override
    public String toString() {
        return "type: " + type + ", HP: " + healthPoints + ", attack: " + attack + ", defence: " +
                defence + ", damage: " + lowerDamage + "-" + upperDamage + ", initiative " + initiative;
    }
}

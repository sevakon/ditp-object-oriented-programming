package units;

public class Unit {
    private String type;
    private int hitPoints;
    private int attack;
    private int defence;
    private int lowerDamage;
    private int upperDamage;
    private double initiative;

    public Unit(String type, int hitPoints, int attack, int defence,
                int lowerDamage, int upperDamage, double initiative) {
        this.type = type;
        this.attack = attack;
        this.defence = defence;
        this.hitPoints = hitPoints;
        this.initiative = initiative;
        this.lowerDamage = lowerDamage;
        this.upperDamage = upperDamage;
    }

    @Override
    public String toString() {
        return "type: " + type + ", attack: " + hitPoints + ", attack: " + attack + ", defence: " +
                defence + ", damage: " + lowerDamage + "-" + upperDamage + ", initiative " + initiative;
    }
}

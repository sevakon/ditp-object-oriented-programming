package main.engine.campaign;


public class Cast extends Specialty {
    private int attackToAdd;
    private int attackToSubtract;
    private double attackMultiplier;

    private int defenceToAdd;
    private int defenceToSubtract;
    private double defenceMultiplier;

    private double initiativeToAdd;
    private double initiativeToSubtract;
    private double initiativeMultiplier;

    private int healthPointsToAdd;

    public Cast(String castName, int attackToAdd, int attackToSubtract, double attackMultiplier,
                int defenceToAdd, int defenceToSubtract, double defenceMultiplier, double initiativeToAdd,
                double initiativeToSubtract, double initiativeMultiplier, int healthPointsToAdd) {
        super(castName);
        this.attackToAdd = attackToAdd;
        this.attackToSubtract = attackToSubtract;
        this.attackMultiplier = attackMultiplier;
        this.defenceToAdd = defenceToAdd;
        this.defenceToSubtract = defenceToSubtract;
        this.defenceMultiplier = defenceMultiplier;
        this.initiativeToAdd = initiativeToAdd;
        this.initiativeToSubtract = initiativeToSubtract;
        this.initiativeMultiplier = initiativeMultiplier;
        this.healthPointsToAdd = healthPointsToAdd;
    }

    public int getAttackToAdd() {
        return attackToAdd;
    }

    public int getAttackToSubtract() {
        return attackToSubtract;
    }

    public double getAttackMultiplier() {
        return attackMultiplier;
    }

    public int getDefenceToAdd() {
        return defenceToAdd;
    }

    public int getDefenceToSubtract() {
        return defenceToSubtract;
    }

    public double getDefenceMultiplier() {
        return defenceMultiplier;
    }

    public double getInitiativeToAdd() {
        return initiativeToAdd;
    }

    public double getInitiativeToSubtract() {
        return initiativeToSubtract;
    }

    public double getInitiativeMultiplier() {
        return initiativeMultiplier;
    }

    public int getHealthPointsToAdd() {
        return healthPointsToAdd;
    }

    public void multiplyHealthPointsToAdd(int multiplier) {
        healthPointsToAdd *= multiplier;
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Cast) && (this.getName() == ((Cast) o).getName());
    }

}

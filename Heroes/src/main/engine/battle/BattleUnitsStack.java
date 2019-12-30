package main.engine.battle;

import main.engine.campaign.Cast;
import main.engine.campaign.Skill;
import main.engine.campaign.UnitsStack;

import java.util.ArrayList;

public class BattleUnitsStack extends UnitsStack {
    private int numberOfAliveUnits;
    private int numberOfDeadUnits;
    private int healthPoints;
    private int maxHealthPoints;
    private int extraAttack = 0;
    private int extraDefence = 0;
    private double extraInitiative = 0.0;
    private ArrayList<Cast> availableCasts;
    private BattleSide battleSide;

    /**
     * BattleUnitsStack constructor
     * Takes unitsStack as an argument
     */
    public BattleUnitsStack(UnitsStack unitsStack) throws Exception {
        super(unitsStack);
        numberOfAliveUnits = getNumberOfUnits();
        numberOfDeadUnits = 0;
        healthPoints = numberOfAliveUnits * getUnit().getHealthPoints();
        maxHealthPoints = healthPoints;
        availableCasts = getUnit().getCasts();
    }

    /**
     * BattleUnitsStack Clone constructor
     */
    public BattleUnitsStack(BattleUnitsStack battleUnitsStack) throws Exception {
        super(battleUnitsStack.getUnit(), battleUnitsStack.getNumberOfUnits());
        numberOfAliveUnits = battleUnitsStack.numberOfAliveUnits;
        numberOfDeadUnits = battleUnitsStack.numberOfDeadUnits;
        healthPoints = battleUnitsStack.healthPoints;
        maxHealthPoints = battleUnitsStack.maxHealthPoints;
        availableCasts = battleUnitsStack.availableCasts;
    }

    /**
     * Health Points related methods:
     * increases or decreases health points,
     * recalculates number of dead and alive units
     */
    public void addHealthPoints(int healthPoints) {
        if (this.healthPoints + healthPoints > maxHealthPoints)
            healthPoints = maxHealthPoints - this.healthPoints;
        this.healthPoints += healthPoints;
        numberOfAliveUnits = numberOfAliveUnitsAfterHPChange();
    }

    public void subtractHealthPoints(int healthPoints) {
        this.healthPoints -= healthPoints;
        if (this.healthPoints < 0)
            this.healthPoints = 0;
        int newNumberOfAliveUnits = numberOfAliveUnitsAfterHPChange();
        numberOfDeadUnits += numberOfAliveUnits - newNumberOfAliveUnits;
        numberOfAliveUnits = newNumberOfAliveUnits;
    }

    private int numberOfAliveUnitsAfterHPChange() {
        return (int) Math.ceil((double) healthPoints/(double) getUnit().getHealthPoints());
    }

    /**
     * Getters for Battle Properties
     */
    public int getHealthPoints() {
        return healthPoints;
    }

    public int getNumberOfDeadUnits() {
        return numberOfDeadUnits;
    }

    public int getNumberOfAliveUnits() {
        return numberOfAliveUnits;
    }

    public int getExtraAttack() {
        return extraAttack;
    }

    public int getExtraDefence() {
        return extraDefence;
    }

    public double getExtraInitiative() {
        return extraInitiative;
    }

    public int getBaseAttack() {
        return getUnit().getAttack() * numberOfAliveUnits;
    }

    public int getBattleAttack() {
        return getBaseAttack() + extraAttack;
    }

    public int getBaseDefence() {
        return getUnit().getDefence() * numberOfAliveUnits;
    }

    public int getBattleDefence() {
        return getBaseDefence() + extraDefence;
    }

    public double getBaseInitiative() {
        return getUnit().getInitiative() * numberOfAliveUnits;
    }

    public double getBattleInitiative() {
        return getBaseInitiative() + extraInitiative;
    }

    public BattleSide getBattleSide() {
        return battleSide;
    }

    /**
     * Extra Attack, Defence, and Initiative related methods
     * Allows increasing and decreasing properties' values,
     * Doesn't let overall values be less than zero
     */
    public void addAttack(int attackToAdd) {
        this.extraAttack += attackToAdd;
    }

    public void subtractAttack(int attackToDecrease) {
        if (getBattleAttack() - attackToDecrease < 0)
            this.extraAttack = -(getBattleAttack() - this.extraAttack);
        else
            this.extraAttack -= attackToDecrease;
    }

    public void addDefence(int defenceToAdd) {
        this.extraDefence += defenceToAdd;
    }

    public void subtractDefence(int defenceToDecrease) {
        if (getBattleDefence() - defenceToDecrease < 0)
            this.extraDefence = -(getBattleDefence() - this.extraDefence);
        else
            this.extraDefence -= defenceToDecrease;
    }

    public void addInitiative(double initiativeToAdd) {
        this.extraInitiative += initiativeToAdd;
    }

    public void subtractInitiative(double initiativeToDecrease) {
        if (getBattleInitiative() - initiativeToDecrease < 0)
            this.extraInitiative = -(getBattleInitiative() - this.extraInitiative);
        else
            this.extraInitiative -= initiativeToDecrease;
    }

    /**
     * Skills and Castes related methods
     */
    public ArrayList<Skill> getAvailableSkills() {
        return getUnit().getSkills();
    }

    public ArrayList<Cast> getAvailableCasts() {
        return availableCasts;
    }

    public void removeCast(Cast cast) {
        availableCasts.remove(cast);
    }

    public boolean doesHaveCast(Cast targetStack) {
        for (Cast cast : getAvailableCasts())
            if (cast.equals(targetStack))
                return true;

        return false;
    }

    /**
     * Setters for Battle Properties
     */
    public void setBattleSide(BattleSide battleSide) {
        this.battleSide = battleSide;
    }

    public void setExtraAttack(int extraAttack) {
        this.extraAttack = extraAttack;
    }

    public void setExtraDefence(int extraDefence) {
        this.extraDefence = extraDefence;
    }

    public void setExtraInitiative(double extraInitiative) {
        this.extraInitiative = extraInitiative;
    }

    public void resetExtraProperties() {
        setExtraAttack(0);
        setExtraDefence(0);
        setExtraInitiative(0.0);
    }

    @Override
    public String toString() {
        return "BattleUnitsStack of Unit: " + getUnit().getType() +
                "\nNumber of alive units: " + numberOfAliveUnits +
                ", number of dead units: " + numberOfDeadUnits +
                "\nTotal HP: " + healthPoints + "\nAttack: " +
                getBattleAttack() + " = Base: " + getBaseAttack() +
                " + Extra: " + getExtraAttack() + "\nDefence: " +
                getBattleDefence() + " = Base: " + getBaseDefence() +
                " + Extra: " + getExtraDefence() + "\nInitiative: " +
                getBattleInitiative() + " = Base: " + getBaseInitiative() +
                " + Extra: " + getExtraInitiative() + "\nSkills: " +
                getAvailableSkills() + "\nCastes: " + getAvailableCasts() + "\n";
    }
}

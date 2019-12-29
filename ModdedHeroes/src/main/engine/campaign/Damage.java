package main.engine.campaign;

import java.util.Random;

public class Damage {
    private int lower;
    private int upper;

    public Damage(int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
    }

    public int getRandomDamage() {
        return new Random().nextInt((upper - lower) + 1) + lower;
    }

    public int getLower() {
        return lower;
    }

    public int getUpper() {
        return upper;
    }
}

package main.engine.units;

import main.engine.campaign.*;
import main.engine.skills.EnemyNoResist;


public class Fury extends Unit {

    public Fury() {
        super("FURY", 16, 5, 3, new Damage(5, 7), 16, new Specialty[]{new EnemyNoResist()});
    }
}
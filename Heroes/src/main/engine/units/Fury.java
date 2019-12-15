package main.engine.units;

import main.engine.campaign.*;
import main.engine.specialties.casts.*;
import main.engine.specialties.skills.*;

public class Fury extends Unit {

    public Fury() {
        super("FURY", 16, 5, 3, 5, 7, 16, new Specialty[]{new EnemyNoResist()});
    }
}
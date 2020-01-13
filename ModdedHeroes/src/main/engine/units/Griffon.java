package main.engine.units;

import main.engine.campaign.*;
import main.engine.skills.EndlessRebuff;

public class Griffon extends Unit {

    public Griffon() {
        super("GRIFFON", 30, 7, 5, new Damage(5, 10), 15, new Specialty[]{new EndlessRebuff()});
    }
}

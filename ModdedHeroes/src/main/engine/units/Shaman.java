package main.engine.units;

import main.engine.campaign.*;
import main.engine.casts.*;

public class Shaman extends Unit {

    public Shaman() {
        super("SHAMAN", 40, 12, 10, new Damage(7, 12), 10.5, new Specialty[]{new Acceleration()});
    }
}

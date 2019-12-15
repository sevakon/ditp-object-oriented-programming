package main.engine.units;

import main.engine.campaign.*;
import main.engine.skills.*;

public class Crossbowman extends Unit {

    public Crossbowman() {
        super("CROSSBOWMAN", 10, 4, 4, new Damage(2, 8), 8, new Specialty[]{new Shooter(), new AccurateShot()});
    }
}

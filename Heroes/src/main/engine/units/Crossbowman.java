package main.engine.units;

import main.engine.campaign.*;
import main.engine.specialties.casts.*;
import main.engine.specialties.skills.*;

public class Crossbowman extends Unit {

    public Crossbowman() {
        super(Type.CROSSBOWMAN, 10, 4, 4, 2, 8, 8, new Specialty[]{new Shooter(), new AccurateShot()});
    }
}

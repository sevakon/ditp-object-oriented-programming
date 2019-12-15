package main.engine.units;

import main.engine.campaign.*;
import main.engine.specialties.casts.*;
import main.engine.specialties.skills.*;

public class Cyclops extends Unit {

    public Cyclops() {
        super("CYCLOPS", 85, 20, 15, 18, 26, 10, new Specialty[]{new Shooter()});
    }
}

package main.engine.units;

import main.engine.campaign.*;
import main.engine.specialties.casts.*;
import main.engine.specialties.skills.*;

public class Devil extends Unit {

    public Devil() {
        super(Type.DEVIL, 166, 27, 55, 36, 66, 11, new Specialty[]{new Weakening()});
    }
}

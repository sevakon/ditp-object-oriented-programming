package main.engine.units;

import main.engine.campaign.*;
import main.engine.casts.*;

public class Devil extends Unit {

    public Devil() {
        super("DEVIL", 166, 27, 55, new Damage(36, 66), 11, new Specialty[]{new Weakening()});
    }
}

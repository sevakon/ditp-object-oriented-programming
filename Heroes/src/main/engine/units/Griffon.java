package main.engine.units;

import main.engine.campaign.*;
import main.engine.specialties.casts.*;
import main.engine.specialties.skills.*;

public class Griffon extends Unit {

    public Griffon() {
        super(Type.GRIFFON, 30, 7, 5, 5, 10, 15, new Specialty[]{new EndlessRebuff()});
    }
}

package main.engine.units;

import main.engine.campaign.*;
import main.engine.specialties.casts.*;
import main.engine.specialties.skills.*;

public class Lich extends Unit {

    public Lich() {
        super(Type.LICH, 50, 15, 15, 12, 17, 10, new Specialty[]{new Undead(), new Reincarnation(), new Shooter()});
    }
}

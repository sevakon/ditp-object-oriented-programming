package main.engine.units;

import main.engine.campaign.*;
import main.engine.specialties.casts.*;
import main.engine.specialties.skills.*;

public class BoneDragon extends Unit {

    public BoneDragon() {
        super(Type.BONEDRAGON, 150, 27, 28, 15, 30, 11, new Specialty[]{new Undead(), new Malediction()});
    }
}

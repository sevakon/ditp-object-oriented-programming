package main.engine.units;

import main.engine.campaign.*;
import main.engine.casts.*;
import main.engine.skills.Undead;

public class BoneDragon extends Unit {

    public BoneDragon() {
        super("BONEDRAGON", 150, 27, 28, new Damage(15, 30), 11, new Specialty[]{new Undead(), new Malediction()});
    }
}

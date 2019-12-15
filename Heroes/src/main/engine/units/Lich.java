package main.engine.units;

import main.engine.campaign.*;
import main.engine.casts.*;
import main.engine.skills.*;

public class Lich extends Unit {

    public Lich() {
        super("LICH", 50, 15, 15, new Damage(12, 17), 10, new Specialty[]{new Undead(), new Reincarnation(), new Shooter()});
    }
}

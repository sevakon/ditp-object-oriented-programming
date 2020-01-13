package main.engine.units;

import main.engine.campaign.*;
import main.engine.casts.*;

public class Angel extends Unit {

    public Angel() {
        super("ANGEL", 180, 27, 27, new Damage(45, 45), 11, new Specialty[]{new PunishingShot()});
    }
}

package main.engine.units;

import main.engine.campaign.*;
import main.engine.specialties.casts.*;
import main.engine.specialties.skills.*;

public class Angel extends Unit {

    public Angel() {
        super("ANGEL", 180, 27, 27, 45, 45, 11, new Specialty[]{new PunishingShot()});
    }
}

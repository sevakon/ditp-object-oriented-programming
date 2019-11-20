package main.engine.units;

import main.engine.specialties.*;
import main.engine.campaign.Unit;

public class Angel extends Unit {

    public Angel() {
        super(Type.ANGEL, 180, 27, 27, 45, 45, 11, new Specialty[]{Cast.PUNISHING_SHOT});
    }
}

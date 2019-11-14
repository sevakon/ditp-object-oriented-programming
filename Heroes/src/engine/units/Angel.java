package engine.units;

import engine.specialties.*;
import engine.campaign.Unit;

public class Angel extends Unit {

    public Angel() {
        super(Type.ANGEL, 180, 27, 27, 45, 45, 11, new Specialty[]{Caste.PUNISHING_SHOT});
    }
}

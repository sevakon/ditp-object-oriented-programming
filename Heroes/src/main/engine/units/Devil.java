package main.engine.units;

import main.engine.specialties.*;
import main.engine.campaign.Unit;

public class Devil extends Unit {

    public Devil() {
        super(Type.DEVIL, 166, 27, 55, 36, 66, 11, new Specialty[]{Caste.WEAKENING});
    }
}

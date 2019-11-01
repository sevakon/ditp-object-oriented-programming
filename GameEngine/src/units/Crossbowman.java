package units;

import specialties.*;
import campaign.Unit;

public class Crossbowman extends Unit {

    public Crossbowman() {
        super(Type.CROSSBOWMAN, 10, 4, 4, 2, 8, 8, new Specialty[]{Skill.SHOOTER, Skill.ACCURATE_SHOT});
    }
}

package units;

import specialties.*;
import campaign.Unit;

public class Griffon extends Unit {

    public Griffon() {
        super(Type.GRIFFON, 30, 7, 5, 5, 10, 15, new Specialty[]{Skill.ENDLESS_REBUFF});
    }
}

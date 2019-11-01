package units;

import specialties.*;
import campaign.Unit;

public class Shaman extends Unit {

    public Shaman() {
        super(Type.SHAMAN, 40, 12, 10, 7, 12, 10.5, new Specialty[]{Caste.ACCELERATION});
    }
}

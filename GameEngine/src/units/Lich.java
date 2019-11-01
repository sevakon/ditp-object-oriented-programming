package units;

import specialties.*;
import campaign.Unit;

public class Lich extends Unit {

    public Lich() {
        super(Type.LICH, 50, 15, 15, 12, 17, 10, new Specialty[]{Skill.UNDEAD, Caste.REINCARNATION, Skill.SHOOTER});
    }
}

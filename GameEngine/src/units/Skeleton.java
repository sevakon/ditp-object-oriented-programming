package units;

import specialties.*;
import campaign.Unit;

public class Skeleton extends Unit {

    public Skeleton() {
        super(Type.SKELETON, 5, 1, 2, 1, 1, 10, new Specialty[]{Skill.UNDEAD});
    }
}

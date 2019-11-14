package main.engine.units;

import main.engine.specialties.*;
import main.engine.campaign.Unit;

public class Skeleton extends Unit {

    public Skeleton() {
        super(Type.SKELETON, 5, 1, 2, 1, 1, 10, new Specialty[]{Skill.UNDEAD});
    }
}

package main.engine.units;

import main.engine.specialties.*;
import main.engine.campaign.Unit;

public class BoneDragon extends Unit {

    public BoneDragon() {
        super(Type.BONEDRAGON, 150, 27, 28, 15, 30, 11, new Specialty[]{Skill.UNDEAD, Caste.MALEDICTION});
    }
}

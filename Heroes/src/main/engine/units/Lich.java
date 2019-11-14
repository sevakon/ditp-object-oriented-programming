package main.engine.units;

import main.engine.specialties.*;
import main.engine.campaign.Unit;

public class Lich extends Unit {

    public Lich() {
        super(Type.LICH, 50, 15, 15, 12, 17, 10, new Specialty[]{Skill.UNDEAD, Caste.REINCARNATION, Skill.SHOOTER});
    }
}

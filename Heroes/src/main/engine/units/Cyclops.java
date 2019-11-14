package main.engine.units;

import main.engine.specialties.*;
import main.engine.campaign.Unit;

public class Cyclops extends Unit {

    public Cyclops() {
        super(Type.CYCLOPS, 85, 20, 15, 18, 26, 10, new Specialty[]{Skill.SHOOTER});
    }
}

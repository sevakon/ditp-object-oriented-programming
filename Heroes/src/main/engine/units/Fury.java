package main.engine.units;

import main.engine.specialties.*;
import main.engine.campaign.Unit;

public class Fury extends Unit {

    public Fury() {
        super(Type.FURY, 16, 5, 3, 5, 7, 16, new Specialty[]{Skill.ENEMY_NO_RESIST});
    }
}
package engine.units;

import engine.specialties.*;
import engine.campaign.Unit;

public class Hydra extends Unit {

    public Hydra() {
        super(Type.HYDRA, 80, 15, 12, 7, 14, 7, new Specialty[]{Skill.SHOT_TO_ALL, Skill.ENEMY_NO_RESIST});
    }
}

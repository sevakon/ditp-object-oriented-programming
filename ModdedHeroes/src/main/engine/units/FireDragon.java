package main.engine.units;

import main.engine.campaign.Damage;
import main.engine.campaign.Specialty;
import main.engine.campaign.Unit;
import main.engine.casts.Reincarnation;
import main.engine.casts.Weakening;

public class FireDragon extends Unit {

    public FireDragon() {
        super("FIRE DRAGON", 200, 10, 10, new Damage(90, 91), 11, new Specialty[]{new Reincarnation()});
    }
}

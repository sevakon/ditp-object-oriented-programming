package main.engine.units;

import main.engine.campaign.Damage;
import main.engine.campaign.Specialty;
import main.engine.campaign.Unit;
import main.engine.casts.DeathFinger;

public class Lion extends Unit {

    public Lion() {
        super("LION", 50, 30, 40, new Damage(40, 50), 20, new Specialty[]{new DeathFinger()});
    }
}

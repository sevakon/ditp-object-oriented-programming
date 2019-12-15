package main.engine.units;

import main.engine.campaign.*;
import main.engine.skills.*;

public class Cyclops extends Unit {

    public Cyclops() {
        super("CYCLOPS", 85, 20, 15, new Damage(18, 26), 10, new Specialty[]{new Shooter()});
    }
}

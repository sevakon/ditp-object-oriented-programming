package main.engine.units;

import main.engine.campaign.*;
import main.engine.specialties.casts.*;
import main.engine.specialties.skills.*;

public class Hydra extends Unit {

    public Hydra() {
        super("HYDRA", 80, 15, 12, 7, 14, 7, new Specialty[]{new ShotToAll(), new EnemyNoResist()});
    }
}

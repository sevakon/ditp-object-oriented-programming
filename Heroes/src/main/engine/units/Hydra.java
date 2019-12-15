package main.engine.units;

import main.engine.campaign.*;
import main.engine.skills.EnemyNoResist;
import main.engine.skills.ShotToAll;

public class Hydra extends Unit {

    public Hydra() {
        super("HYDRA", 80, 15, 12, new Damage(7, 14), 7, new Specialty[]{new ShotToAll(), new EnemyNoResist()});
    }
}

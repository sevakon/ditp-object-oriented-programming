package main.engine.units;

import main.engine.campaign.*;
import main.engine.skills.Undead;

public class Skeleton extends Unit {

    public Skeleton() {
        super("SKELETON", 5, 1, 2, new Damage(1, 1), 10, new Specialty[]{new Undead()});
    }
}

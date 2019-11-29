package main.engine.units;

import main.engine.campaign.*;
import main.engine.specialties.casts.*;
import main.engine.specialties.skills.*;

public class Skeleton extends Unit {

    public Skeleton() {
        super(Type.SKELETON, 5, 1, 2, 1, 1, 10, new Specialty[]{new Undead()});
    }
}

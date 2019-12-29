package main.engine.campaign;

import main.engine.Mods;
import main.engine.battle.Battle;
import main.engine.battle.BattleUnitsStack;

import java.util.ArrayList;

public abstract class Cast extends Specialty {

    public Cast(String castName) {
        super(castName);
    }

    public abstract void use(Battle battle, BattleUnitsStack castingStack, BattleUnitsStack targetStack);

    public static ArrayList<Cast> getAllTypeOfCasts() {
        return (ArrayList<Cast>)(ArrayList<?>) Mods.getObjectMods(Cast.class);
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Cast) && (this.getName() == ((Cast) o).getName());
    }

}

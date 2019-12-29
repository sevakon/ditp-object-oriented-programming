package main.engine.campaign;

import main.engine.battle.Battle;
import main.engine.battle.BattleUnitsStack;

public abstract class Cast extends Specialty {

    public Cast(String castName) {
        super(castName);
    }

    public abstract void use(Battle battle, BattleUnitsStack castingStack, BattleUnitsStack targetStack);

    @Override
    public boolean equals(Object o) {
        return (o instanceof Cast) && (this.getName() == ((Cast) o).getName());
    }

}

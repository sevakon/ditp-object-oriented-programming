package main.engine.battle;

public abstract class Action {
    private String name;

    public Action(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void perform(Battle battle, BattleUnitsStack performingStack, BattleUnitsStack targetStack);

    public boolean equals(Action o) {
        return o.getName() == this.getName();
    }
}

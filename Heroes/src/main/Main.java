package main;

import main.engine.battle.*;
import main.engine.campaign.*;

public class Main {

    public static void main(String[] args) {
        BattleUnitsStack firstUnit, secondUnit;
        BattleArmy firstArmy, secondArmy;
        try {
            firstUnit = new BattleUnitsStack(new UnitsStack(Unit.getAllTypeOfUnits().get(2), 1));
            secondUnit = new BattleUnitsStack(new UnitsStack(Unit.getAllTypeOfUnits().get(10), 1));
            firstArmy = new BattleArmy(new Army(firstUnit));
            secondArmy = new BattleArmy(new Army(secondUnit));
        } catch (Exception e) {
            System.out.println(e.toString());
            firstArmy = new BattleArmy();
            secondArmy = new BattleArmy();
        }

        Battle battle = new Battle(firstArmy, secondArmy);
        BattleUnitsStack nextStack;
        while (battle.getStatus() == Status.IN_ACTION) {
            try {
                nextStack = battle.getNextStack();
                System.out.println(nextStack);
                battle.performCast(battle.getFirstArmy().getStacks().get(0), nextStack.getAvailableCasts().get(0));
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        System.out.println(battle.getFirstArmy().getStacks().get(0));
    }

}

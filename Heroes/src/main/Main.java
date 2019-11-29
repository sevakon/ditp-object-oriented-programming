package main;

import main.engine.campaign.*;
import main.engine.exception.*;
import main.engine.specialties.*;
import main.engine.units.*;
import main.engine.battle.*;

public class Main {

    public static void main(String[] args) {
        // Creating main.engine.campaign instances
        Angel angel = new Angel();
        BoneDragon dragon = new BoneDragon();
        Cyclops cyclops = new Cyclops();
        Crossbowman crossbowman = new Crossbowman();
        Devil devil = new Devil();
        Fury fury =  new Fury();
        Griffon griffon = new Griffon();
        Hydra hydra = new Hydra();
        Lich lich = new Lich();
        Shaman shaman = new Shaman();
        Skeleton skeleton = new Skeleton();

        // UnitsStack
        UnitsStack angelStack = new UnitsStack(angel, 12);
        UnitsStack cyclopsStack = new UnitsStack(cyclops, 24);
        UnitsStack dragonStack = new UnitsStack(dragon, 5);
        UnitsStack crossbowStack = new UnitsStack(crossbowman, 3);
        UnitsStack devilStack = new UnitsStack(devil, 6);
        UnitsStack furyStack = new UnitsStack(fury, 2);
        UnitsStack griffonStack = new UnitsStack(griffon, 8);
        UnitsStack hydraStack = new UnitsStack(hydra, 9);
        UnitsStack lichStack = new UnitsStack(lich, 7);
        UnitsStack shamanStack = new UnitsStack(shaman, 1);
        UnitsStack skeletonStack = new UnitsStack(skeleton, 15);

        BattleUnitsStack skeletonBattleStack = new BattleUnitsStack(skeletonStack);
        BattleUnitsStack furyBattleStack = new BattleUnitsStack(furyStack);
        BattleUnitsStack angelBattleStack = new BattleUnitsStack(angelStack);
        BattleUnitsStack crossbowBattleStack = new BattleUnitsStack(crossbowStack);


        Army firstArmy;
        try {
            firstArmy = new Army(lichStack, devilStack, shamanStack);
        } catch(StackSizeExceededException e) {
            System.out.println(e);
            firstArmy = new Army();
        }

        Army secondArmy;
        try {
            secondArmy = new Army(griffonStack, hydraStack, crossbowStack, cyclopsStack);
        } catch(StackSizeExceededException e) {
            System.out.println(e);
            secondArmy = new Army();
        }

        BattleArmy firstBattleArmy = new BattleArmy(firstArmy);
        BattleArmy secondBattleArmy;
        try {
            secondBattleArmy = new BattleArmy(furyBattleStack, skeletonBattleStack);
        } catch (StackSizeExceededException e) {
            System.out.println(e);
            secondBattleArmy = new BattleArmy();
        }

        Battle battle = new Battle(firstBattleArmy, secondBattleArmy);
        BattleUnitsStack nextStack;
        try {
            nextStack = battle.getNextStack();
            System.out.println(nextStack);
            battle.performAttack(battle.getFirstArmy().getStacks().get(0));
            nextStack = battle.getNextStack();
            System.out.println(nextStack);
            battle.performCast(nextStack, nextStack.getAvailableCasts().get(0));
            System.out.println(nextStack);
        } catch(Exception e) {
            System.out.println(e);
        }
        System.out.println(battle.getStatus());

    }

}

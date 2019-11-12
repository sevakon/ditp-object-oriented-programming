import campaign.*;
import campaign.exception.*;
import units.*;
import battle.*;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Creating campaign instances
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

        Army firstArmy;
        try {
            firstArmy = new Army(lichStack, skeletonStack, devilStack, shamanStack);
        } catch(StackSizeExceededException e) {
            System.out.println(e);
            firstArmy = new Army();
        }

        Army secondArmy;
        try {
            secondArmy = new Army(griffonStack, hydraStack, skeletonStack, shamanStack);
        } catch(StackSizeExceededException e) {
            System.out.println(e);
            secondArmy = new Army();
        }

        BattleArmy firstBattleArmy = new BattleArmy(firstArmy);
        BattleArmy secondBattleArmy = new BattleArmy(secondArmy);

        Battle battle = new Battle(firstBattleArmy, secondBattleArmy);

        System.out.println(battle);
        battle.nextTurn();
    }

}

import campaign.*;
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

//        // Armies
        Army army = new Army(hydraStack, skeletonStack);
        System.out.println(army);

        ArrayList<Integer> l = new ArrayList<>(2);
        l.add(1);
        System.out.println(l);
        l.add(2);
        System.out.println(l);
        l.add(3);
        System.out.println(l);
        l.add(4);
        System.out.println(l);

//        BattleUnitsStack battleUnitsStack = new BattleUnitsStack(skeletonStack);
//        System.out.println(battleUnitsStack);
//        battleUnitsStack.takeDamage(8);
//        System.out.println(battleUnitsStack);
//        battleUnitsStack.takeDamage(8);
//        System.out.println(battleUnitsStack);
//        battleUnitsStack.heal(8);
//        System.out.println(battleUnitsStack);



//        //Get methods example
//        UnitsStack[] stacks = army.getStacks();
//        for (int i = 0; i < stacks.length; i++) {
//            if (stacks[i] != null) {
//                Unit unit = stacks[i].getUnit();
//                System.out.println(unit.getType());
//            }
//        }
//
//        System.out.print(skeleton.getSkills());
    }

}

package main.console;

import main.engine.battle.*;
import main.engine.campaign.*;
import main.engine.actions.*;
import main.engine.skills.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Play {
    private static final int firstPlayerId = 0;
    private static final int secondPlayerId = 1;

    public static void main(String[] args) {
        BattleArmy firstArmy = createArmy(firstPlayerId);
        BattleArmy secondArmy = createArmy(secondPlayerId);
        printBattleArmyInfo(firstArmy, firstPlayerId);
        printBattleArmyInfo(secondArmy, secondPlayerId);
        Battle battle = new Battle(firstArmy, secondArmy);
        controlBattle(battle);
    }

    private static BattleArmy createArmy(int playerId) {
        Scanner in = new Scanner(System.in);
        ArrayList<BattleUnitsStack> stacks = new ArrayList<>();
        BattleArmy battleArmy;
        System.out.println("Creating Battle Army for player #" + (playerId + 1) + "\n");
        printStackOptions();
        while (true) {
            System.out.println("Enter unit idx followed by number of units, to stop enter -1:");
            try {
                int unitIdx = in.nextInt();
                if (unitIdx == -1) {System.out.println(); break;}
                System.out.println("You chose " + Unit.getAllTypeOfUnits().get(unitIdx).getType() + "; Please enter number of units:");
                int unitNumber = in.nextInt();
                BattleUnitsStack stack = new BattleUnitsStack(new UnitsStack(Unit.getAllTypeOfUnits().get(unitIdx), unitNumber));
                stacks.add(stack);
                System.out.println("Created: " + stack);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        try {
            battleArmy = new BattleArmy(stacks);
        } catch (Exception e) {
            System.out.println(e.toString());
            battleArmy = new BattleArmy();
        }
        return battleArmy;
    }

    private static void controlBattle(Battle battle) {
        System.out.println("Battle Started");
        int numberOfTurnsPlayed = 0;
        while (battle.getStatus() == Status.IN_ACTION) {
            try {
                System.out.println("Turn #" + numberOfTurnsPlayed);
                System.out.println("---------------------------------");
                System.out.println(battle.getQueue());
                BattleUnitsStack nextStack = battle.getNextStack();
                askForAction(nextStack, battle);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
            numberOfTurnsPlayed++;
        }
        System.out.println("Battle Finished");
        System.out.println(battle.getStatus());
    }

    private static void askForAction(BattleUnitsStack stack, Battle battle) {
        int playerId = (stack.getBattleSide() == BattleSide.FIRST_ARMY) ? 0 : 1;
        System.out.println("Player #" + playerId + ", Choose action for stack: " + stack.getUnit().getType());

        int actionIndex = 0;
        System.out.println(actionIndex + ": Attack");
        System.out.println(++actionIndex + ": Defend");
        System.out.println(++actionIndex + ": Wait");
        System.out.println(++actionIndex + ": Surrender");
        for (Cast cast : stack.getAvailableCasts())
            System.out.println(++actionIndex + ": Use cast " + cast.getName());

        Scanner in = new Scanner(System.in);
        try {
            int chosenAction = in.nextInt();
            if (chosenAction > 3 && chosenAction < stack.getAvailableCasts().size() + 4) {
                System.out.println("You chose " + stack.getAvailableCasts().get(actionIndex - 4).getName() +
                        " for stack " + stack.getUnit().getType());
                BattleUnitsStack target = askForTarget(stack, battle, true);
                battle.performCast(target, stack.getAvailableCasts().get(actionIndex - 4));
            }
            switch (chosenAction) {
                case 0:
                    BattleUnitsStack target = askForTarget(stack, battle, false);
                    battle.performAttack(target);
                    break;
                case 1:
                    battle.performDefence();
                    break;
                case 2:
                    battle.performWait();
                    break;
                case 3:
                    battle.performSurrender();
                    break;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private static BattleUnitsStack askForTarget(BattleUnitsStack stack, Battle battle, boolean canBeUsedOnTeamMate) {
        System.out.println("Choose target: ");
        ArrayList<BattleUnitsStack> targetList = new ArrayList<>();
        if (canBeUsedOnTeamMate) {
            targetList.addAll(battle.getFirstArmy().getStacks());
            targetList.addAll(battle.getSecondArmy().getStacks());
        } else {
            if (stack.getBattleSide() == BattleSide.FIRST_ARMY) targetList.addAll(battle.getSecondArmy().getStacks());
            else targetList.addAll(battle.getFirstArmy().getStacks());
        }
        int chosenIndex = 0;
        for (BattleUnitsStack target : targetList)
            System.out.println(chosenIndex++ + ": " + target.getUnit().getType() + ", "+ target.getBattleSide());

        Scanner in = new Scanner(System.in);
        chosenIndex = in.nextInt();
        return targetList.get(chosenIndex);
    }

    private static void printStackOptions() {
        System.out.println("Available units:");
        int idx = 0;
        for (Unit unit: Unit.getAllTypeOfUnits()) {
            System.out.println("   " + unit + " idx: " + idx);
            idx++;
        }
        System.out.println();
    }

    private static void printBattleArmyInfo(BattleArmy battleArmy, int playerId) {
        System.out.println("Battle army #" + playerId+ " info:");
        for (BattleUnitsStack stack : battleArmy.getStacks())
            System.out.print(stack.getUnit().getType() + " #"+ stack.getNumberOfAliveUnits() + "; ");
        System.out.println("\n");
    }
}

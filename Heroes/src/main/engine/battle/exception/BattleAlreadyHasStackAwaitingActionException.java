package main.engine.battle.exception;

public class BattleAlreadyHasStackAwaitingActionException extends Exception {
    public BattleAlreadyHasStackAwaitingActionException() {
        super("Battle Already Has Stack waiting for Action");
    }
}

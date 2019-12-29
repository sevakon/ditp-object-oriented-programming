package main.engine.exception;

public class BattleAlreadyHasStackAwaitingActionException extends Exception {
    public BattleAlreadyHasStackAwaitingActionException() {
        super("Battle Already Has Stack waiting for Action");
    }
}

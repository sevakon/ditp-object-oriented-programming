package main.engine.battle.exception;

public class PerformingStackDoesNotMatchException extends Exception {
    public PerformingStackDoesNotMatchException() {
        super("Performing Action Stack does not match with Current Stack");
    }
}

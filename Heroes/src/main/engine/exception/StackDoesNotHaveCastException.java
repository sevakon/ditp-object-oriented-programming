package main.engine.exception;

import main.engine.campaign.Cast;

public class StackDoesNotHaveCastException extends Exception {
    public StackDoesNotHaveCastException(Cast cast) {
        super("Stack does not have " + cast + " cast");
    }
}

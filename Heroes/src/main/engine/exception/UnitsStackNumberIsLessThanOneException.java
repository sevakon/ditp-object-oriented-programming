package main.engine.exception;

public class UnitsStackNumberIsLessThanOneException extends Exception {
    public UnitsStackNumberIsLessThanOneException(int number) {
        super("Number of units in stack must be more than one, not " + number);
    }
}

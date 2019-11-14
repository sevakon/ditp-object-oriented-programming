package engine.exception;

public class StackSizeExceededException extends Exception {
    public StackSizeExceededException(String errorMessage) {
        super(errorMessage);
    }
}

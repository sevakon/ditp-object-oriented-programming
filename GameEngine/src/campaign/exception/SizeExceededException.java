package campaign.exception;

public class SizeExceededException extends Exception {
    public SizeExceededException(String errorMessage) {
        super(errorMessage);
    }
}

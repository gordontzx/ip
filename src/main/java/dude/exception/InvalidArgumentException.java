package dude.exception;

/**
 * Indicates commands being supplied with invalid arguments.
 */
public class InvalidArgumentException extends DudeException {
    public InvalidArgumentException(String message) {
        super(message);
    }
}

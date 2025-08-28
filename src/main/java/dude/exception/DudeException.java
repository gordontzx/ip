package dude.exception;

/**
 * Encapsulates most exceptions that can possibly happen during the runtime of the program.
 */
public class DudeException extends RuntimeException {
    public DudeException(String message) {
        super(message);
    }
}

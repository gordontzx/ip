package dude.exception;

/**
 * Exception indicating data being stored wrongly in save file.
 */
public class CorruptFileException extends DudeException {
    public CorruptFileException() {
        super("Corrupt file");
    }
}

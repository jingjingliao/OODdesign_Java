package onlineForms;

/**
 * Represents an InvalidInputException
 */
public class InvalidInputException extends Exception {
    /**
     * Constructs an InvalidInputException given the error message
     * @param message the error message
     */
    public InvalidInputException(String message) {
        super(message);
    }
}

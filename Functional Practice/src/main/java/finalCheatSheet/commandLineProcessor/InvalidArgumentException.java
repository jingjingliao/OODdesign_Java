package finalCheatSheet.commandLineProcessor;

/**
 * Represents an InvalidArgumentException thrown when the given command is not valid
 */
public class InvalidArgumentException extends Exception {
  /**
   * Constructs an InvalidArgumentException
   * @param message message to be printed
   */
  public InvalidArgumentException(String message) {
    super(message);
  }
}

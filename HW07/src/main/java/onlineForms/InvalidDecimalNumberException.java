package onlineForms;

/**
 * Represents InvalidDecimalNumberException with the specified detail message
 */
public class InvalidDecimalNumberException extends Exception {

  /**
   * @param message message that shows the input decimal number is invalid
   */
  public InvalidDecimalNumberException(String message) {
    super(message);
  }
}

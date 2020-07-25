package problem01;

/**
 * Create an exception if age is invalid
 */
public class InvalidAgeException extends Exception {
  public InvalidAgeException(){
    super("Invalid age exception");
  }

}

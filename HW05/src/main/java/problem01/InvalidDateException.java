package problem01;

/**
 * Invalid date exception, if the date is invalid, throw the exception
 */
public class InvalidDateException extends Exception {
  public InvalidDateException(){
    super("Date is invalid!");
  }

}

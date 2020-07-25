package problem02;

/**
 * Create exception to show that the element has already in the set
 */
public class ElementAlreadyExistedException extends Exception {
  public ElementAlreadyExistedException(){
    super("Element has already in the set");
  }

}

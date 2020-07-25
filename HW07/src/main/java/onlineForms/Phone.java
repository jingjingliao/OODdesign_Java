package onlineForms;
import java.util.Objects;

/**
 * Represents a Phone Validator.
 */
public class Phone implements IValidator<String>{
  private int requiredLength;

  /**
   * The constructor of the Phone class.
   * @param requiredLength the required length of the phone number, as an int.
   */
  public Phone(int requiredLength) {
    this.requiredLength = requiredLength;
  }

  /**
   * Determines if the provided input meets the requirements. A valid phone number is a String
   * that contains only digits and has a specified length supplied by client code. The length must
   * match exactly.
   * @param input the input, as a String.
   * @return true if the provide input contains only digits and match the required length
   */
  @Override
  public boolean isValid(String input){
    return (input.length() == this.requiredLength) && validateDigits(input);
  }

  /**
   * A helper method to validate if all characters are digits.
   * @param input the input as a String
   * @return true if the provide input only contains digits.
   */
  private boolean validateDigits(String input){
    for(char c : input.toCharArray()){ if(!Character.isDigit(c)) return false; }
    return true;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Phone)) {
      return false;
    }
    Phone phone = (Phone) o;
    return requiredLength == phone.requiredLength;
  }

  @Override
  public int hashCode() {
    return Objects.hash(requiredLength);
  }

  @Override
  public String toString() {
    return "Phone{" +
        "requiredLength=" + requiredLength +
        '}';
  }
}

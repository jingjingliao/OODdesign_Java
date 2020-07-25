package onlineForms;

import java.util.Objects;

/**
 * Represents a Number Validator.
 */
public class Number implements IValidator<String> {
  private double minValue, maxValue;
  private int maxNumOfDecimal;

  /**
   * The constructor of the Number class.
   * @param minValue the min value of the number
   * @param maxValue the max value of the number
   * @param maxNumOfDecimal the max decimal of the number
   * @throws InvalidDecimalNumberException throw exception if the max decimal is negative
   */
  public Number(double minValue, double maxValue, int maxNumOfDecimal)
      throws InvalidDecimalNumberException {
    this.minValue = minValue;
    this.maxValue = maxValue;
    this.maxNumOfDecimal = this.validNumOfDecimal(maxNumOfDecimal);
  }

  /**
   * Check whether the max number of decimal is valid or not
   * @param maxNumOfDecimal the max number of decimal
   * @return maxNumOfDecimal if it is valid, otherwise throw an exception
   * @throws InvalidDecimalNumberException throw the exception if max number of decimal is invalid
   */
  private int validNumOfDecimal (int maxNumOfDecimal) throws InvalidDecimalNumberException {
    if (maxNumOfDecimal >= 0)
      return maxNumOfDecimal;
    else
      throw new InvalidDecimalNumberException("Invalid decimal input");
  }

  /**
   * Determines if the provided input meets the requirements.
   * @param input the input as a String
   * @return true is it meets the requirement, otherwise false
   */
  @Override
  public boolean isValid(String input) {
    return this.isValidFirstLastChar(input) && this.isNumeric(input) &&
        this.isValidDecimalNum(input) && this.isValidValue(input);
  }

  /**
   * Check whether the first char and the last char is valid
   * The first char must be digit only, the last char cannot be dot '.'
   * @param input the input as a String
   * @return true if it meets the requirement, otherwise false
   */
  private boolean isValidFirstLastChar(String input){
    if (input == null || input.equals(""))
      return false;
    else if  (!Character.isDigit(input.charAt(0)))
      return false;
    else
      return input.charAt(input.length() - 1) != '.';
  }

  /**
   * Check whether the char are digits or dot '.'
   * @param input the input as a String
   * @return true if all chars in input are either digits or dot, otherwise false
   */
  private boolean isNumeric(String input) {
    for (int i = 0; i < input.length(); i++) {
      if (!Character.isDigit(input.charAt(i)) && input.charAt(i) != '.')
        return false;
      }
    return true;
  }


  /**
   * Check whether the value is between the min value and max value
   * @param input the input as a String
   * @return true if the value is between the min value and max value, otherwise false
   */
  private boolean isValidValue(String input){
    double newInput = Double.parseDouble(input);
    return Double.compare(newInput, this.minValue) >= 0 &&
        Double.compare(newInput, this.maxValue) <= 0;
  }

  /**
   * Check whether it meets the requirements of max decimal number
   * if the maxNumOfDecimal == 0, the string cannot contain dot, it should be an integer
   * if the maxNumOfDecimal > 0, the number of chars after the decimal should less than or equal
   * to the maxNumOfDecimal
   * @param input the input as a String
   * @return true if it meets the requirement, otherwise false
   */
  private boolean isValidDecimalNum(String input) {
    if (this.maxNumOfDecimal == 0)
      return !input.contains(".");
    else {
      int indexDot = 0;
      int countDot = 0;
      for (int i = 0; i < input.length(); i++)
        if (input.charAt(i) == '.') {
          indexDot = i;
          countDot += 1;
        }
      return this.isValidDecimal(input, indexDot, countDot);
    }
  }

  /**
   * Helper function that check whether the string contains more than one dot, and the number
   * of chars after the decimal should less than or equal to the maxNumOfDecimal
   * @param input the input as a String
   * @param indexDot the index of the dot in the string
   * @param countDot the number of dot in the string
   * @return false if countDot > 1 or the number of chars after the decimal larger than
   * the maxNumOfDecimal
   */
  private boolean isValidDecimal(String input, int indexDot, int countDot){
    if (countDot > 1)
      return false;
    else {
      int decimalNum = input.length() - indexDot - 1;
      return decimalNum <= this.maxNumOfDecimal;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Number number = (Number) o;
    return Double.compare(number.minValue, minValue) == 0 &&
           Double.compare(number.maxValue, maxValue) == 0 &&
           number.maxNumOfDecimal == maxNumOfDecimal;
  }

  @Override
  public int hashCode() {
    return Objects.hash(minValue, maxValue, maxNumOfDecimal);
  }

  @Override
  public String toString() {
    return "Number{" +
        "minValue=" + minValue +
        ", maxValue=" + maxValue +
        ", maxNumOfDecimal=" + maxNumOfDecimal +
        '}';
  }
}

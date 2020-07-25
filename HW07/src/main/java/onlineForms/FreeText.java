package onlineForms;

import java.util.Objects;

/**
 * Represents a FreeText Validator.
 */
public class FreeText implements IValidator<String> {

  private int maxNumOfLine;
  private int maxNumOfCharPerLine;

  /**
   * The constructor of the FreeText class.
   * @param maxNumOfLine the maximum number of line as an int
   * @param maxNumOfCharPerLine the maximum number of characters per line as an int
   */
  public FreeText(int maxNumOfLine, int maxNumOfCharPerLine) {
    this.maxNumOfLine = maxNumOfLine;
    this.maxNumOfCharPerLine = maxNumOfCharPerLine;
  }

  /**
   * Determines if the provided input meets the requirements. To be valid, the input must be no
   * longer than the number of lines multiplied by the number of characters allowed per line.
   * @param input the input as a String
   * @return true if the length of input is not longer than the required total length.
   */
  @Override
  public boolean isValid(String input) {
    return input.length() <= (this.maxNumOfCharPerLine * this.maxNumOfLine);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof FreeText)) {
      return false;
    }
    FreeText freeText = (FreeText) o;
    return maxNumOfLine == freeText.maxNumOfLine &&
        maxNumOfCharPerLine == freeText.maxNumOfCharPerLine;
  }

  @Override
  public int hashCode() {
    return Objects.hash(maxNumOfLine, maxNumOfCharPerLine);
  }

  @Override
  public String toString() {
    return "FreeText{" +
        "maxNumOfLine=" + maxNumOfLine +
        ", maxNumOfCharPerLine=" + maxNumOfCharPerLine +
        '}';
  }
}

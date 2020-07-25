package problem2;

/**
 * An immutable class represents a mail including the width, height and depth
 * of the mail the recipient of the mail
 */
public class Mail {
  private int width;
  private int height;
  private int depth;
  private Recipient recipient;
  private static final int MIN_SIZE = 1;

  /**
   * Constructs a mail object
   * @param width the width of a mail
   * @param height the height of a mail
   * @param depth the depth of a mail
   * @param recipient the recipient of a mail
   * @throws InvalidSizeException if the size of width, height and depth is smaller than
   * MIN_SIZE, then throw an exception
   */
  public Mail(int width, int height, int depth, Recipient recipient) throws InvalidSizeException{
    this.width = this.validWidth(width);
    this.height = this.validHeight(height);
    this.depth = this.validDepth(depth);
    this.recipient = recipient;
  }

  /**
   * Helper function that checks the width of the mail is valid
   * @param width the width of a mail
   * @return the width of a mail if it is valid, otherwise throw an exception
   * @throws InvalidSizeException if the size of width is less than MIN_SIZE,
   * then throw an exception
   */
  private int validWidth(int width) throws InvalidSizeException {
    if (width >= MIN_SIZE) {
      return width;
    }else{
      throw new InvalidSizeException();
    }
  }

  /**
   * Helper function that checks the height of the mail is valid
   * @param height the height of the mail
   * @return the height of the mail if it is valid, otherwise throw an exception
   * @throws InvalidSizeException if the size of height is less than MIN_SIZE,
   * then throw an exception
   */
  private int validHeight(int height) throws InvalidSizeException {
    if (height >= MIN_SIZE) {
      return height;
    }else{
      throw new InvalidSizeException();
    }
  }

  /**
   * Helper function that checks the depth of the mail is valid
   * @param depth the depth of the mail
   * @return the depth of the mail if it is valid, otherwise throw an exception
   * @throws InvalidSizeException if the size of depth is less than MIN_SIZE,
   * then throw an exception
   */
  private int validDepth(int depth) throws InvalidSizeException {
    if (depth >= MIN_SIZE) {
      return depth;
    }else{
      throw new InvalidSizeException();
    }
  }

  /**
   * Get width of the mail
   * @return width of the mail
   */
  public int getWidth(){
    return this.width;
  }

  /**
   * Get height of the mail
   * @return height of the mail
   */
  public int getHeight(){
    return this.height;
  }

  /**
   * Get depth of the mail
   * @return depth of the mail
   */
  public int getDepth(){
    return this.depth;
  }

  /**
   * Get recipient of a mail
   * @return recipient of a mail
   */
  public Recipient getRecipient(){
    return this.recipient;
  }
}

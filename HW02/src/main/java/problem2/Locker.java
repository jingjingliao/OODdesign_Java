package problem2;

public class Locker {

  private int lockerWidth;
  private int lockerHeight;
  private int lockerDepth;
  private Mail mail;
  private static final int MAX_SIZE = 1;


  public Locker(int lockerWidth, int lockerHeight, int lockerDepth) throws InvalidSizeException {
    this.lockerWidth = this.validLockerWidth(lockerWidth);
    this.lockerHeight = this.validLockerHeight(lockerHeight);
    this.lockerDepth = this.validLockerDepth(lockerDepth);
    this.mail = null;
  }

  private int validLockerWidth(int lockerWidth) throws InvalidSizeException {
    if (lockerWidth >= MAX_SIZE) {
      return lockerWidth;
    } else {
      throw new InvalidSizeException();
    }
  }

  private int validLockerHeight(int lockerHeight) throws InvalidSizeException {
    if (lockerHeight >= MAX_SIZE) {
      return lockerHeight;
    } else {
      throw new InvalidSizeException();
    }
  }

  private int validLockerDepth(int lockerDepth) throws InvalidSizeException {
    if (lockerDepth >= MAX_SIZE) {
      return lockerDepth;
    } else {
      throw new InvalidSizeException();
    }
  }

  public int getLockerWidth() {
    return this.lockerWidth;
  }

  public int getLockerHeight() {
    return this.lockerHeight;
  }

  public int getLockerDepth() {
    return this.lockerDepth;
  }

  public Mail getMail(){
    return this.mail;
  }

  private boolean validSize(Mail mail) {
    return mail.getWidth() <= this.lockerWidth && mail.getHeight() <= this.lockerHeight &&
        mail.getDepth() <= this.lockerDepth;
  }

  public void addMail(Mail mail1) {
    if (this.mail == null && this.validSize(mail1)) {
      this.mail = mail1;
    }
  }

  private boolean matchRecipient(Recipient recipient) {
    return this.mail.getRecipient().equals(recipient);
  }

  public Mail pickupMail(Recipient recipient) {
    Mail getMail;
    if (this.mail != null && this.matchRecipient(recipient)) {
      getMail = this.mail;
      this.mail = null;
      return getMail;
    }else{
      return null;
    }
  }
}
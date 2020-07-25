package model;

/**
 * Exception thrown if seat name is invalid.
 */
public class InvalidSeatName extends Exception {
  public InvalidSeatName(String message) {
    super(message);
  }
}
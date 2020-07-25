package controller;

/**
 * Exception thrown if invalid arguments are provided at the commandline.
 */
public class InvalidArgumentsException extends Exception {
  public InvalidArgumentsException(String message) {
    super(message);
  }
}
package controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CommandLineValidationTest {
  CommandLineValidation validation;

  @Before
  public void setUp() throws Exception {
  }

  @Test
  public void validateShow() {
    validation = new CommandLineValidation("show");
    assertTrue(validation.getAnswer().equals("show"));
  }

  @Test
  public void validateDone() {
    validation = new CommandLineValidation("done");
    assertTrue(validation.getAnswer().equals("done"));
  }

  @Test
  public void validateReserve() {
    validation = new CommandLineValidation("reserve 1");
    assertTrue(validation.getAnswer().equals("1"));
  }

  @Test (expected = NullPointerException.class)
  public void invalidLength() {
    validation = new CommandLineValidation("res res res");
    assertTrue(validation.getAnswer().equals("res res res"));
  }

  @Test (expected = NullPointerException.class)
  public void invalidInput() {
    validation = new CommandLineValidation("res");
    assertTrue(validation.getAnswer().equals("res"));
  }

  @Test (expected = NullPointerException.class)
  public void invalidReserveNum() {
    validation = new CommandLineValidation("reserve 13");
    assertTrue(validation.getAnswer().equals("13"));
  }

  @Test (expected = NullPointerException.class)
  public void notReserve() {
    validation = new CommandLineValidation("reser 13");
    assertTrue(validation.getAnswer().equals("13"));
  }

  @Test (expected = NullPointerException.class)
  public void notDigitReserveNum() {
    validation = new CommandLineValidation("reserve 13re");
    assertTrue(validation.getAnswer().equals("13re"));
  }

}
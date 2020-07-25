package onlineForms;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NumberTest {
  private Number number1;
  private Number sameNumber1;
  private Number number2;
  private Number number3;

  @Before
  public void setUp() throws Exception {
    number1 = new Number(1, 10, 2);
    sameNumber1 = new Number(1, 10, 2);
  }

  @Test
  public void isValid() throws InvalidDecimalNumberException{
    // Valid cases for parameters minValue = 1, maxValue = 10, maxNumOfDecimal = 2 (all inclusive)
    assertTrue(number1.isValid("1"));
    assertTrue(number1.isValid("10"));
    assertTrue(number1.isValid("1.00"));
    assertTrue(number1.isValid("1.2"));
    assertTrue(number1.isValid("5.9"));
    assertTrue(number1.isValid("5.90"));
    assertTrue(number1.isValid("10.00"));

    // Valid cases for parameters minValue = 1, maxValue = 100, maxNumOfDecimal = 0
    number1 = new Number(1,100, 0);
    assertTrue(number1.isValid("25"));
  }

  @Test
  public void isValidMoreOrLess() throws InvalidDecimalNumberException{
    // InValid cases for parameters minValue = 1, maxValue = 10, maxNumOfDecimal = 2
    assertFalse(number1.isValid("0"));
    assertFalse(number1.isValid("11"));
    assertFalse(number1.isValid("1.230"));

    // InValid cases for parameters minValue = 1, maxValue = 10, maxNumOfDecimal = 0
    number1 = new Number(1,10, 0);
    assertFalse(number1.isValid("1.0"));
  }

  @Test
  public void isValidIllegalChars() {
    // Invalid cases with illegal characters
    assertFalse(number1.isValid("!123"));
    assertFalse(number1.isValid("123!"));
    assertFalse(number1.isValid("1/23"));
    assertFalse(number1.isValid("1 23"));
    assertFalse(number1.isValid(" "));
    assertFalse(number1.isValid("-1"));
    assertFalse(number1.isValid(null));
    assertFalse(number1.isValid(""));
  }

  @Test (expected = InvalidDecimalNumberException.class)
  public void isValidInvalidDecimalNUmber() throws InvalidDecimalNumberException {
    // Invalid case with invalid decimal number assigned
    number2 = new Number(1,10, -2);
  }

  @Test
  public void isValidInvalidDots() {
    assertFalse(number1.isValid("1.2.3"));
    assertFalse(number1.isValid("1.2."));
    assertFalse(number1.isValid(".3"));
    assertFalse(number1.isValid("2."));
  }

  @Test
  public void testEquality() throws InvalidDecimalNumberException {
    assertTrue(number1.equals(number1));
    assertFalse(number1.equals(null));
    assertFalse(number1.equals("number1"));
    assertFalse(number1.equals(new Number(0, 10, 2)));
    assertFalse(number1.equals(new Number(1, 11, 2)));
    assertFalse(number1.equals(new Number(1, 10, 0)));
    assertFalse(number1.equals(new Number(0, 11, 2)));
    assertFalse(number1.equals(new Number(0, 10, 0)));
    assertFalse(number1.equals(new Number(5, 6, 7)));
    assertTrue(number1.equals(sameNumber1));
  }

  @Test
  public void testHashcode() {
    assertTrue(number1.hashCode() == sameNumber1.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("Number{minValue=1.0, maxValue=10.0, maxNumOfDecimal=2}", number1.toString());
    assertEquals(number1.toString(), sameNumber1.toString());
  }


}
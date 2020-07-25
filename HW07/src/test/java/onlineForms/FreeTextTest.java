package onlineForms;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FreeTextTest {

  FreeText freeText;

  @Before
  public void setUp() throws Exception {
    freeText = new FreeText(5, 6);
  }

  @Test
  public void isValid() {
    assertTrue(freeText.isValid(""));
    assertTrue(freeText.isValid("123"));
    assertTrue(freeText.isValid("abc"));
    assertTrue(freeText.isValid("123456789012345678901234567890"));
    assertFalse(freeText.isValid("1234567890123456789012345678901"));
  }

  @Test
  public void testEquals() {
    assertTrue(freeText.equals(freeText));
    assertTrue(freeText.equals(new FreeText(5,6)));
    assertFalse(freeText.equals(null));
    assertFalse(freeText.equals("phone"));
    assertFalse(freeText.equals(new FreeText(5, 0)));
    assertFalse(freeText.equals(new FreeText(0, 6)));
    assertFalse(freeText.equals(new FreeText(6, 5)));

  }

  @Test
  public void testHashCode() {
    assertEquals(freeText.hashCode(), freeText.hashCode());
    assertEquals(new FreeText(5, 6).hashCode(), freeText.hashCode());
    assertNotEquals(new FreeText(0,0).hashCode(), freeText.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("FreeText{maxNumOfLine=5, maxNumOfCharPerLine=6}", freeText.toString());
  }
}
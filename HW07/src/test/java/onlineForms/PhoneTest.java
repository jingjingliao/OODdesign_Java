package onlineForms;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PhoneTest {

  Phone phone;

  @Before
  public void setUp() throws Exception {
    phone = new Phone(10);
  }

  @Test
  public void isValid() {
    assertTrue(phone.isValid("1234567890"));
    assertFalse(phone.isValid("123"));
    assertFalse(phone.isValid("12345678900"));
    assertFalse(phone.isValid("123456789a"));
  }

  @Test
  public void testEquals() {
    assertTrue(phone.equals(phone));
    assertTrue(phone.equals(new Phone(10)));
    assertFalse(phone.equals(null));
    assertFalse(phone.equals("phone"));
    assertFalse(phone.equals(new Phone(1)));
  }

  @Test
  public void testHashCode() {
    assertEquals(phone.hashCode(), phone.hashCode());
    assertEquals(new Phone(10).hashCode(), phone.hashCode());
    assertNotEquals(new Phone(1).hashCode(), phone.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("Phone{requiredLength=10}", phone.toString());
  }
}
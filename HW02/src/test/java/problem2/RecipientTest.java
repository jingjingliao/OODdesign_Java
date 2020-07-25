package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RecipientTest {
  Recipient recipient;

  @Before
  public void setUp() throws Exception {
    recipient = new Recipient("Cherry", "Lee", "123@321.com");
  }

  @Test
  public void getFirstName() {
    assertEquals("Cherry", recipient.getFirstName());
  }

  @Test
  public void getLastName() {
    assertEquals("Lee", recipient.getLastName());
  }

  @Test
  public void getEmail() {
    assertEquals("123@321.com", recipient.getEmail());
  }
}
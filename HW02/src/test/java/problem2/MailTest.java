package problem2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MailTest {
  Recipient recipient;
  Mail mail;

  @Before
  public void setUp() throws Exception {
    mail = new Mail(2,4,8, recipient);
  }

  @Test
  public void getWidth() {
    assertEquals(2, mail.getWidth());
  }

  @Test
  public void getHeight() {
    assertEquals(4, mail.getHeight());
  }

  @Test
  public void getDepth() {
    assertEquals(8, mail.getDepth());
  }

  @Test (expected = InvalidSizeException.class)
  public void InvalidGetWidth() throws InvalidSizeException{
    Mail invalidMail = new Mail(-1, -1, -1, recipient);
  }

  @Test (expected = InvalidSizeException.class)
  public void InvalidGetHeight() throws InvalidSizeException {
    Mail invalidMail = new Mail(3, -1, 5, recipient);
  }

  @Test (expected = InvalidSizeException.class)
  public void InvalidGetDepth() throws InvalidSizeException {
    Mail invalidMail = new Mail(6, 6, -1, recipient);
  }

  @Test
  public void getRecipient() {
    assertEquals(recipient, mail.getRecipient());
  }
}
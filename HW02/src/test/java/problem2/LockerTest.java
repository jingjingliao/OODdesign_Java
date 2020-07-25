package problem2;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

import java.util.MissingFormatArgumentException;
import org.junit.Before;
import org.junit.Test;

public class LockerTest {
  Locker locker1;
  Recipient recipient1;
  Recipient recipient2;
  Mail mail1;
  Mail mail2;


  @Before
  public void setUp() throws Exception {
    locker1 = new Locker(2, 3, 4);
    recipient1 = new Recipient("Lili", "Lee", "123@12.com");
    recipient2 = new Recipient("Cheey", "Li", "123@1.com");
    mail1 = new Mail(2,2,2, recipient1);
    mail2 = new Mail(5,6,7, recipient2);
  }

  @Test (expected = InvalidSizeException.class)
  public void InvalidGetLockerWidth() throws InvalidSizeException {
    Locker unvalidLocker = new Locker(-1, 3, 6);
  }

  @Test (expected = InvalidSizeException.class)
  public void InvalidGetLockerHeight() throws InvalidSizeException {
    Locker unvalidLocker = new Locker(4, -3, 6);
  }

  @Test (expected = InvalidSizeException.class)
  public void InvalidGetLockerDepth() throws InvalidSizeException {
    Locker unvalidLocker = new Locker(7, 3, -6);
  }

  @Test
  public void getLockerWidth() {
    assertEquals(2, locker1.getLockerWidth());
  }

  @Test
  public void getLockerHeight() {
    assertEquals(3, locker1.getLockerHeight());
  }

  @Test
  public void getLockerDepth() {
    assertEquals(4, locker1.getLockerDepth());
  }

  @Test
  public void addMail() throws InvalidSizeException{
    Locker locker = new Locker(4,4,4);
    locker.addMail(mail1);
    assertEquals(locker.getMail(), mail1);
  }

  @Test
  public void AddInvalidWidthMail() throws InvalidSizeException{
    Locker locker = new Locker(4,4,4);
    Mail mail = new Mail(5,3,2, recipient1);
    locker.addMail(mail);
    assertNull(locker.getMail());
  }

  @Test
  public void AddInvalidHeightMail() throws InvalidSizeException{
    Locker locker = new Locker(4,4,4);
    Mail mail = new Mail(3,5,3, recipient1);
    locker.addMail(mail);
    assertNull(locker.getMail());
  }

  @Test
  public void AddInvalidDepthMail() throws InvalidSizeException{
    Locker locker = new Locker(4,4,4);
    Mail mail = new Mail(3,3,5, recipient1);
    locker.addMail(mail);
    assertNull(locker.getMail());
  }

  @Test
  public void AddWhenMailIsOccupied() throws InvalidSizeException{
    Locker locker = new Locker(4,4,4);
    Mail mail = new Mail(2,2,2, recipient1);
    locker.addMail(mail);
    Mail mail2 = new Mail(3,3,3, recipient2);
    locker.addMail(mail2);
    assertEquals(locker.getMail(), mail);
  }



  @Test
  public void pickupMailWhenLockEmpty() throws InvalidSizeException {
    Locker locker = new Locker(5,6,7);
    assertNull(locker.pickupMail(recipient1));
  }

  @Test
  public void pickupMailWhenRecipientNotMatch() throws InvalidSizeException {
    Locker locker = new Locker(5,6,7);
    locker.addMail(mail1);
    Mail returnMail = locker.pickupMail(recipient2);
    assertEquals(locker.getMail(), mail1);
    assertNull(returnMail);
  }

  @Test
  public void pickupMail() throws InvalidSizeException {
    Locker locker = new Locker(5,6,7);
    Mail mail = new Mail(2,2,2, recipient1);
    locker.addMail(mail);
    assertTrue(locker.pickupMail(recipient1).equals(mail));
  }
}
package problem01;

import static org.junit.Assert.*;

import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class PledgesDonationTest {
  PledgesDonation donation;
  PledgesDonation sameDonation;
  PledgesDonation anotherDonation;
  LocalDate date;
  LocalDate actualDonationDate;

  @Before
  public void setUp() throws Exception {
    date = LocalDate.of(2020, 4, 20);
    actualDonationDate = LocalDate.of(2020, 11, 20);
    donation = new PledgesDonation(1000, date, actualDonationDate);
    sameDonation = new PledgesDonation(1000, date, actualDonationDate);
    anotherDonation = new PledgesDonation(2000);
  }

  @Test
  public void getAmount() {
    assertEquals(1000, donation.getAmount(),0.01);
  }

  @Test
  public void getCreationTime() {
    assertEquals(date, donation.getCreationTime());

  }

  @Test
  public void getActualDonationDate() {
    assertEquals(actualDonationDate, donation.getActualDonationDate());
  }

  @Test
  public void getAnotherActualDonationDate() {
    assertNull(anotherDonation.getActualDonationDate());
  }

  @Test
  public void setActualDonationDate() throws InvalidDateException {
    LocalDate newDonationDate = LocalDate.of(2020, 5, 20);
    donation.setActualDonationDate(newDonationDate);
    assertEquals(newDonationDate, donation.getActualDonationDate());
  }

  @Test (expected = InvalidDateException.class)
  public void InvalidActualDonationDate() throws InvalidDateException {
    LocalDate newDonationDate = LocalDate.of(2019, 5, 20);
    donation.setActualDonationDate(newDonationDate);
  }

  @Test
  public void setAnotherActualDonationDate() throws InvalidDateException {
    LocalDate newDonationDate = LocalDate.of(2020, 12, 20);
    anotherDonation.setActualDonationDate(newDonationDate);
    assertEquals(newDonationDate, anotherDonation.getActualDonationDate());
  }

  @Test(expected = InvalidDateException.class)
  public void setAnotherInvalidActualDonationDate() throws InvalidDateException {
    LocalDate newDonationDate = LocalDate.of(2020, 1, 20);
    anotherDonation.setActualDonationDate(newDonationDate);
  }

  @Test
  public void getTotalAmount() {
    assertEquals(1000, donation.getTotalAmount(2020),0.01);
  }

  @Test
  public void getTotalAmountFutureYear() {
    assertEquals(0, donation.getTotalAmount(2030),0.01);
  }

  @Test
  public void testEquals() {
    assertTrue(donation.equals(sameDonation));
    assertFalse(donation.equals(anotherDonation));
    assertTrue(donation.equals(donation));
    assertFalse(donation.equals(null));
  }

  @Test
  public void testHashCode() {
    assertTrue(donation.hashCode() == sameDonation.hashCode());
  }

  @Test
  public void tostring() {
    assertEquals("PledgesDonation{amount='1000.0'creation time='2020-04-20'Actual DonationDate='2020-11-20'}", donation.toString());
  }

}

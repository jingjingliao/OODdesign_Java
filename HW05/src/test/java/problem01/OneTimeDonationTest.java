package problem01;

import static org.junit.Assert.*;

import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class OneTimeDonationTest {

  OneTimeDonation donation;
  OneTimeDonation sameDonation;
  OneTimeDonation anotherDonation;
  LocalDate date;


  @Before
  public void setUp() throws Exception {
    donation = new OneTimeDonation(1000);
    sameDonation = new OneTimeDonation(1000);
    date = LocalDate.of(2020, 4, 20);
    anotherDonation = new OneTimeDonation(1000, date);
  }

  @Test
  public void getAmount() {
    assertEquals(1000, donation.getAmount(), 0.01);
  }

  @Test
  public void getCreationTime() {
    assertEquals(date, anotherDonation.getCreationTime());
  }

  @Test
  public void getTotalAmount() {
    assertEquals(1000, donation.getTotalAmount(2020), 0.01);
  }

  @Test
  public void getNoTotalAmount() {
    assertEquals(0, donation.getTotalAmount(2030), 0.01);
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
    assertEquals("OneTimeDonation{amount='1000.0'creation time='2020-04-20'}", anotherDonation.toString());
  }
}
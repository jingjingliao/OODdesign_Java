package problem01;

import static org.junit.Assert.*;

import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class MonthlyDonationTest {
  MonthlyDonation donation;
  MonthlyDonation sameDonation;
  MonthlyDonation anotherDonation;
  LocalDate date;
  LocalDate cancelDate;

  @Before
  public void setUp() throws Exception {
    donation = new MonthlyDonation(1000);
    sameDonation = new MonthlyDonation(1000);
    date = LocalDate.of(2020, 4, 20);
    cancelDate = LocalDate.of(2021, 2, 20);
    anotherDonation = new MonthlyDonation(1000, date);
    donation.setCancellationDay(cancelDate);
    sameDonation.setCancellationDay(cancelDate);
  }

  @Test
  public void getAmount() {
    assertEquals(1000, donation.getAmount(),0.01);
  }

  @Test
  public void getCreationTime() {
    assertEquals(date, anotherDonation.getCreationTime());
  }

  @Test
  public void getCancellationDay() {
    assertEquals(cancelDate, donation.getCancellationDay());
  }

  @Test (expected = InvalidDateException.class)
  public void setCancellationDay() throws InvalidDateException {
    cancelDate = LocalDate.of(2019, 2, 20);
    donation.setCancellationDay(cancelDate);
  }

  @Test
  public void getTotalAmount() {
    assertEquals(11000, donation.getTotalAmount(2020), 0.01);
  }

  @Test
  public void getTotalAmountYear() throws InvalidDateException {
    LocalDate date = LocalDate.of(2019, 2, 20);
    MonthlyDonation newDonation = new MonthlyDonation(1000, date);
    LocalDate newCancelDate = LocalDate.of(2025, 9, 20);
    newDonation.setCancellationDay(newCancelDate);
    assertEquals(12000, newDonation.getTotalAmount(2020),0.01);
  }

  @Test
  public void getTotalAmountCreationYearPast() throws InvalidDateException {
    LocalDate date = LocalDate.of(2019, 2, 20);
    MonthlyDonation newDonation = new MonthlyDonation(1000, date);
    LocalDate newCancelDate = LocalDate.of(2020, 2, 20);
    newDonation.setCancellationDay(newCancelDate);
    assertEquals(2000, newDonation.getTotalAmount(2020),0.01);
  }

  @Test
  public void getTotalAmountNew() throws InvalidDateException {
    LocalDate date = LocalDate.of(2020, 2, 20);
    MonthlyDonation newDonation = new MonthlyDonation(1000, date);
    LocalDate newCancelDate = LocalDate.of(2030, 9, 20);
    newDonation.setCancellationDay(newCancelDate);
    assertEquals(11000, newDonation.getTotalAmount(2020),0.01);
  }

  @Test
  public void getTotalAmountCancellationYearFuture() throws InvalidDateException {
    LocalDate date = LocalDate.of(2020, 2, 20);
    MonthlyDonation newDonation = new MonthlyDonation(1000, date);
    LocalDate newCancelDate = LocalDate.of(2020, 9, 20);
    newDonation.setCancellationDay(newCancelDate);
    assertEquals(8000, newDonation.getTotalAmount(2020),0.01);
  }

  @Test
  public void getTotalAmountYearFuture() throws InvalidDateException {
    LocalDate date = LocalDate.of(2022, 2, 20);
    MonthlyDonation newDonation = new MonthlyDonation(1000, date);
    LocalDate newCancelDate = LocalDate.of(2025, 9, 20);
    newDonation.setCancellationDay(newCancelDate);
    assertEquals(0, newDonation.getTotalAmount(2020),0.01);
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
    assertEquals("MonthlyDonation{amount='1000.0'creation time='2020-04-20'cancellation time='null'}", anotherDonation.toString());
  }

}
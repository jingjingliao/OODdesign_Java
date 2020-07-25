package problem01;

import static org.junit.Assert.*;

import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

public class NonProfitTest {
  NonProfit oneOrganization;
  NonProfit theSameOneOrganization;
  NonProfit threeOrganization;
  OneTimeDonation onetimeDonate;
  MonthlyDonation monthlyDonate;
  PledgesDonation pledgesDonate;

  @Before
  public void setUp() throws Exception {
    onetimeDonate = new OneTimeDonation(1000);
    oneOrganization = new NonProfit("Red");
    oneOrganization.addDonationType(onetimeDonate);
    monthlyDonate = new MonthlyDonation(300);
    LocalDate date = LocalDate.of(2020,11,1);
    pledgesDonate = new PledgesDonation(2000, date);
    threeOrganization = new NonProfit("Multiple");
    threeOrganization.addDonationType(onetimeDonate);
    threeOrganization.addDonationType(monthlyDonate);
    threeOrganization.addDonationType(pledgesDonate);

    theSameOneOrganization = new NonProfit("Red");
    theSameOneOrganization.addDonationType(onetimeDonate);
  }

  @Test
  public void getOrganizationName() {
    assertEquals("Red", oneOrganization.getOrganizationName());
  }

  @Test
  public void getDonationTypes() {
    NonProfit newType = new NonProfit("Red");
    newType.addDonationType(onetimeDonate);
    assertEquals(newType.getDonationTypes(), oneOrganization.getDonationTypes());
  }

  @Test
  public void getTotalDonationsForYear() {
    assertEquals(0, oneOrganization.getTotalDonationsForYear(2022),0.01);
  }

  @Test
  public void getTotalDonationsForYearThreeOrgan() {
    assertEquals(6300, threeOrganization.getTotalDonationsForYear(2020),0.01);
  }

  @Test
  public void testEquals() {
    assertTrue(oneOrganization.equals(theSameOneOrganization));
    assertFalse(oneOrganization.equals(threeOrganization));
    assertTrue(oneOrganization.equals(oneOrganization));
    assertFalse(oneOrganization.equals(null));
  }

  @Test
  public void testHashCode() {
    assertTrue(oneOrganization.hashCode() == theSameOneOrganization.hashCode());
  }

  @Test
  public void tostring() {
    assertEquals("NonProfit{organizationName='Red'}", oneOrganization.toString());
  }

}
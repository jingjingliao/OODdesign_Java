package problem01;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ElectricalServiceTest {
  ElectricalService service;
  ElectricalService sameService;
  ElectricalService diffService;

  @Before
  public void setUp() throws Exception {
    service = new ElectricalService("555 Ave, NE", PropertySize.MEDIUM,
        true, 5, 1, true);

    sameService = new ElectricalService("555 Ave, NE", PropertySize.MEDIUM,
        true, 5, 1, true);

    diffService = new ElectricalService("555 Ave, NE", PropertySize.LARGE,
        true, 5, 1, false);
  }

  @Test
  public void getNumberOfLicensedEmployee() throws OutOfMaximumException {
    assertEquals(2, service.getNumberOfLicensedEmployee());
  }

  @Test (expected = OutOfMaximumException.class)
  public void invalidNumberOfLicensedEmployee() throws OutOfMaximumException {
    ElectricalService invalidNumberOfEmployee = new ElectricalService("555 Ave, NE",
        PropertySize.SMALL, false, 1,
        10, true);
  }


  @Test
  public void isComplex() {
    assertTrue(service.isComplex());
  }

  @Test
  public void beforeDiscountCalculatePrice() {
    assertEquals(400, service.beforeDiscountCalculatePrice(), 0.01);
  }

  @Test
  public void calculatePrice() {
    assertEquals(450, service.calculatePrice(),0.01);
  }

  @Test
  public void getPropertyAddress() {
    assertEquals("555 Ave, NE", service.getPropertyAddress());
  }

  @Test
  public void getPropertySize() {
    assertEquals(PropertySize.valueOf("MEDIUM"), service.getPropertySize());
  }

  @Test
  public void getPreviouslyNumberOfService() {
    assertEquals(5, service.getPreviouslyNumberOfService());
  }

  @Test
  public void testEquality() {
    assertEquals(service, service);
    assertNotEquals(null, service);
    assertEquals(service, sameService);
    assertNotEquals(service, diffService);
    assertFalse(service.equals("string"));
  }

  @Test
  public void testHashcode() {
    assertEquals(service.hashCode(), sameService.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("ElectricalService{numberOfLicensedEmployee=2, "
        + "isComplex=true, "
        + "permittingFee=50, "
        + "propertyAddress='555 Ave, NE', "
        + "propertySize=MEDIUM, "
        + "hasMonthlyService=true, "
        + "previouslyNumberOfService=5, "
        + "SPECIALIST_BASE_RATE=200, "
        + "Before Discount Calculate Price = 400.00, "
        + "Total Price = 450.00}", service.toString());
    assertEquals(service.toString(), sameService.toString());
  }

}
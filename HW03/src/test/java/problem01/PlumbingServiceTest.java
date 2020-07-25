package problem01;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlumbingServiceTest {
  PlumbingService service;
  PlumbingService sameService;
  PlumbingService diffService;
  PlumbingService diffService1;

  @Before
  public void setUp() throws Exception {
    service = new PlumbingService("987 Ave NE", PropertySize.SMALL,
        true, 2, 3, false);

    sameService = new PlumbingService("987 Ave NE", PropertySize.SMALL,
        true, 2, 3, false);

    diffService = new PlumbingService("987 Ave NE", PropertySize.LARGE,
        true, 2, 3, true);

    diffService1 = new PlumbingService("987 Ave NE", PropertySize.SMALL,
        true, 2, 1, false);
  }

  @Test
  public void getNumberOfLicensedEmployee() {
    assertEquals(3, service.getNumberOfLicensedEmployee());
  }

  @Test
  public void isComplex() {
    assertFalse(service.isComplex());
  }

  @Test
  public void beforeDiscountCalculatePrice() {
    assertEquals(600, service.beforeDiscountCalculatePrice(),0.01);
  }

  @Test
  public void calculatePrice() {
    assertEquals(620, service.calculatePrice(),0.01);
  }

  @Test
  public void getPropertyAddress() {
    assertEquals("987 Ave NE", service.getPropertyAddress());
  }

  @Test
  public void getPropertySize() {
    assertEquals(PropertySize.valueOf("SMALL"), service.getPropertySize());
  }

  @Test
  public void getPreviouslyNumberOfService() {
    assertEquals(2, service.getPreviouslyNumberOfService());
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
    assertEquals("PlumbingService{numberOfLicensedEmployee=3, "
        + "isComplex=false, "
        + "permittingFee=20, "
        + "propertyAddress='987 Ave NE', "
        + "propertySize=SMALL, "
        + "hasMonthlyService=true, "
        + "previouslyNumberOfService=2, "
        + "Before Discount Calculate Price = 600.00, "
        + "Total Price = 620.00}", service.toString());
    assertEquals(service.toString(), sameService.toString());
  }

}
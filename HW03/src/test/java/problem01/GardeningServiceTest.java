package problem01;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GardeningServiceTest {
  GardeningService service;
  GardeningService service1;
  GardeningService sameService;

  @Before
  public void setUp() throws Exception {
    service = new GardeningService("12345, AVE", PropertySize.LARGE,
        true, 9);

    sameService = new GardeningService("12345, AVE", PropertySize.LARGE,
        true, 9);

    service1 = new GardeningService("12345, AVE", PropertySize.LARGE,
        false, 9);
  }

  @Test
  public void getCompleteTime() {
    assertEquals(4, service.getCompleteTime());
  }

  @Test
  public void getPropertyAddress() {
    assertEquals("12345, AVE", service.getPropertyAddress());
  }

  @Test
  public void getPropertySize() {
    assertEquals(PropertySize.valueOf("LARGE"), service.getPropertySize());
  }

  @Test
  public void getPreviouslyNumberOfService() {
    assertEquals(9, service.getPreviouslyNumberOfService());
  }

  @Test
  public void beforeDiscountCalculatePrice() {
    assertEquals(340, service.beforeDiscountCalculatePrice(), 0.01);
  }

  @Test
  public void calculatePrice() {
    assertEquals(170, service.calculatePrice(), 0.01);
  }

  @Test
  public void testEquality() {
    assertEquals(service, service);
    assertNotEquals(null, service);
    assertEquals(service, sameService);
    assertNotEquals(service, service1);
    assertFalse(service.equals("string"));
  }

  @Test
  public void testHashcode() {
    assertEquals(service.hashCode(), sameService.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("GardeningService{propertyAddress='12345, AVE', "
        + "propertySize=LARGE, "
        + "hasMonthlyService=true, "
        + "previouslyNumberOfService=9, "
        + "BASE_RATE=80, "
        + "every10thDiscount=0.5, "
        + "monthlyServiceDiscount=0.9, "
        + "wasteRemovalFee=20, "
        + "Before Discount Calculate Price = 340.00, "
        + "Total Price = 170.00}", service.toString());
    assertEquals(service.toString(), sameService.toString());
  }

}
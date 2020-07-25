package problem01;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WindowCleaningServiceTest {
  WindowCleaningService service;
  WindowCleaningService sameService;
  WindowCleaningService noAdditionalService;


  @Before
  public void setUp() throws Exception {
    service = new WindowCleaningService("345th Ave, SW, 90087", PropertySize.SMALL,
        true, 5, 2);

    sameService = new WindowCleaningService("345th Ave, SW, 90087", PropertySize.SMALL,
        true, 5, 2);

    noAdditionalService = new WindowCleaningService("4545 SW, 97065",
        PropertySize.MEDIUM, false, 9, 1);
  }

  @Test
  public void getCompleteTime() {
    assertEquals(1, service.getCompleteTime());
  }

  @Test
  public void getPropertyAddress() {
    assertEquals("345th Ave, SW, 90087", service.getPropertyAddress());
  }

  @Test
  public void getPropertySize() {
    assertEquals(PropertySize.valueOf("SMALL"), service.getPropertySize());
  }

  @Test
  public void getPreviouslyNumberOfService() {
    assertEquals(5, service.getPreviouslyNumberOfService());
  }

  @Test
  public void beforeDiscountCalculatePrice() {
    assertEquals(84, service.beforeDiscountCalculatePrice(),0.01);
  }

  @Test
  public void calculatePrice() {
    assertEquals(75.6, service.calculatePrice(),0.01);
  }

  @Test
  public void getNumberOfFloor() {
    assertEquals(2, service.getNumberOfFloor());
  }

  @Test (expected = OutOfMaximumException.class)
  public void invalidNumberOfFloor() throws OutOfMaximumException{
    WindowCleaningService invalidService = new WindowCleaningService("666", PropertySize.MEDIUM,
        false, 1, 5);
  }

  @Test (expected = OutOfMaximumException.class)
  public void FloorNumBelowZero() throws OutOfMaximumException{
    WindowCleaningService invalidService = new WindowCleaningService("666", PropertySize.MEDIUM,
        false, 1, -5);
  }

  @Test
  public void getAdditionalFee() {
    assertEquals(0.05, service.getAdditionalFee(), 0.01);
  }

  @Test
  public void noAdditionalService() {
    assertEquals(0, noAdditionalService.getAdditionalFee(), 0.01);
  }

  @Test (expected = OutOfMaximumException.class)
  public void invalidAdditionalFee() throws OutOfMaximumException{
    WindowCleaningService invalidAdditionalFeeService = new WindowCleaningService(
        "666", PropertySize.MEDIUM,
        false, 1, 5);
  }

  @Test
  public void testEquality() {
    assertEquals(service, service);
    assertNotEquals(null, service);
    assertEquals(service, sameService);
    assertNotEquals(service, noAdditionalService);
    assertFalse(service.equals("string"));
  }

  @Test
  public void testHashcode() {
    assertEquals(service.hashCode(), sameService.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("WindowCleaningService{numberOfFloor=2, "
        + "propertyAddress='345th Ave, SW, 90087', "
        + "propertySize=SMALL, "
        + "hasMonthlyService=true, "
        + "previouslyNumberOfService=5, "
        + "BASE_RATE=80, "
        + "SPECIALIST_BASE_RATE=200, "
        + "every10thDiscount=0.5, "
        + "monthlyServiceDiscount=0.9, "
        + "Before Discount Calculate Price = 84.00, "
        + "Total Price = 75.60}", service.toString());
    assertEquals(service.toString(), sameService.toString());
  }

}
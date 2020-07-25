package problem01;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CleanningServiceTest {
  CleanningService service;
  CleanningService service1;
  CleanningService service2;
  CleanningService service3;
  CleanningService sameService;
  CleanningService diffService1;
  CleanningService diffService2;

  @Before
  public void setUp() throws Exception {
    service = new CleanningService("123 Ave, 98052", PropertySize.MEDIUM,
        true, 8, 2);

    sameService = new CleanningService("123 Ave, 98052", PropertySize.MEDIUM,
        true, 8, 2);

    service1 = new CleanningService("123 Ave, 98052", PropertySize.SMALL,
        true, 8, 1);

    diffService1 = new CleanningService("4511th Ave NE", PropertySize.SMALL,
        true, 8, 1);

    service2 = new CleanningService("123 Ave, 98052", PropertySize.LARGE,
        true, 8, 3);

    diffService2 = new CleanningService("123 Ave, 98052", PropertySize.LARGE,
        true, 8, 5);

    service3 = new CleanningService("123 Ave, 98052", PropertySize.MEDIUM,
        true, 8, 0);
  }

  @Test
  public void getNumberOfPets() {
    assertEquals(2, service.numberOfPets);
  }

  @Test
  public void oneNumberOfPets() {
    assertEquals(1, service1.numberOfPets);
  }

  @Test
  public void threeNumberOfPets() {
    assertEquals(3, service2.numberOfPets);
  }

  @Test
  public void zeroNumberOfPets() {
    assertEquals(0, service3.numberOfPets);
  }

  @Test
  public void getCompleteTime() {
    assertEquals(2, service.getCompleteTime());
  }

  @Test
  public void smallPropertyllCompleteTime() {
    assertEquals(1, service1.getCompleteTime());
  }

  @Test
  public void largePropertyllCompleteTime() {
    assertEquals(4, service2.getCompleteTime());
  }

  @Test
  public void getAdditionalFee() {
    assertEquals(0.05, service.getAdditionalFee(), 0.01);
  }

  @Test
  public void onePetAdditionalFee() {
    assertEquals(0.05, service1.getAdditionalFee(), 0.01);
  }

  @Test
  public void threePetAdditionalFee() {
    assertEquals(0.07, service2.getAdditionalFee(), 0.01);
  }

  @Test
  public void zeroPetAdditionalFee() {
    assertEquals(1.0, service3.getAdditionalFee(), 0.01);
  }

  @Test
  public void beforeDiscountCalculatePrice() {
    assertEquals(168, service.beforeDiscountCalculatePrice(), 0.01);
  }

  @Test
  public void calculatePrice() {
    assertEquals(151.2, service.calculatePrice(), 0.01);
  }

  @Test
  public void getPropertyAddress() {
    assertEquals("123 Ave, 98052", service.getPropertyAddress());
  }

  @Test
  public void getPropertySize() {
    assertEquals(PropertySize.valueOf("MEDIUM"), service.getPropertySize());
  }

  @Test
  public void getPreviouslyNumberOfService() {
    assertEquals(8, service.getPreviouslyNumberOfService());
  }

  @Test
  public void setPreviouslyNumberOfService() {
    service.setPreviouslyNumberOfService(9);
    assertEquals(9, service.getPreviouslyNumberOfService());
  }

  @Test
  public void testEquality() {
    assertEquals(service, service);
    assertNotEquals(null, service);
    assertEquals(service, sameService);
    assertNotEquals(service, service1);
    assertNotEquals(service1, diffService1);
    assertNotEquals(service2, diffService2);
    assertFalse(service.equals("string"));
  }

  @Test
  public void testHashcode() {
    assertEquals(service.hashCode(), sameService.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("CleanningService{numberOfPets=2, "
            + "propertyAddress='123 Ave, 98052', "
            + "propertySize=MEDIUM, "
            + "hasMonthlyService=true, "
            + "previouslyNumberOfService=8, "
            + "BASE_RATE=80, "
            + "every10thDiscount=0.5, "
            + "monthlyServiceDiscount=0.9, "
            + "Before Discount Calculate Price = 168.00, "
            + "Total Price = 151.20}", service.toString());
    assertEquals(service.toString(), sameService.toString());
  }
}
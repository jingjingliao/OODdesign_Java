package problem01;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PaintingServiceTest {
  PaintingService service;
  PaintingService service1;
  PaintingService service2;
  PaintingService service3;
  PaintingService sameService;

  @Before
  public void setUp() throws Exception {
    service = new PaintingService("123 Ave, 98052", PropertySize.MEDIUM,
        true, 8, 2);

    sameService = new PaintingService("123 Ave, 98052", PropertySize.MEDIUM,
        true, 8, 2);

    service1 = new PaintingService("123 Ave, 98052", PropertySize.SMALL,
        true, 8, 1);

    service2 = new PaintingService("123 Ave, 98052", PropertySize.LARGE,
        true, 8, 3);

    service3 = new PaintingService("123 Ave, 98052", PropertySize.MEDIUM,
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
    assertEquals(16, service.getCompleteTime());
  }

  @Test
  public void smallPropertyllCompleteTime() {
    assertEquals(16, service1.getCompleteTime());
  }

  @Test
  public void largePropertyllCompleteTime() {
    assertEquals(24, service2.getCompleteTime());
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
    assertEquals(1344, service.beforeDiscountCalculatePrice(), 0.01);
  }

  @Test
  public void calculatePrice() {
    assertEquals(1209.6, service.calculatePrice(), 0.01);
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
    assertEquals("PaintingService{numberOfPets=2, "
            + "propertyAddress='123 Ave, 98052', "
            + "propertySize=MEDIUM, "
            + "hasMonthlyService=true, "
            + "previouslyNumberOfService=8, "
            + "BASE_RATE=80, "
            + "every10thDiscount=0.5, "
            + "monthlyServiceDiscount=0.9, "
            + "Before Discount Calculate Price = 1344.00, "
            + "Total Price = 1209.60}", service.toString());
    assertEquals(service.toString(), sameService.toString());
  }
}
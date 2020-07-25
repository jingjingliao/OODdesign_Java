package problem01;

import java.util.Objects;

/**
 *  Representing a cleaning service, including propertyAddress, propertySize, hasMonthlyService,
 *  previouslyNumberOfService, numberOfPets
 */
public class PaintingService extends AbstractInteriorService {
  private static final int NON_LARGE_PROPERTY_COMPLETING_TIME = 16;
  private static final int LARGE_PROPERTY_COMPLETING_TIME = 24;

  /**
   * Contructs a painting service
   * @param propertyAddress - property address
   * @param propertySize - property size, (small, medium and large)
   * @param hasMonthlyService - whether it has monthly service
   * @param previouslyNumberOfService - the number of previous service
   * @param numberOfPets - the number of pets
   */
  public PaintingService(String propertyAddress, PropertySize propertySize, boolean hasMonthlyService,
      int previouslyNumberOfService, int numberOfPets){
    super(propertyAddress, propertySize, hasMonthlyService, previouslyNumberOfService, numberOfPets);
  }

  /**
   * Get complete time
   * @return complete time
   */
  @Override
  public int getCompleteTime() {
    switch (propertySize) {
      case SMALL:
      case MEDIUM:
        return NON_LARGE_PROPERTY_COMPLETING_TIME;
      default:
        return LARGE_PROPERTY_COMPLETING_TIME;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    PaintingService service = (PaintingService) o;
    return Objects.equals(getPropertyAddress(), service.getPropertyAddress()) &&
        Objects.equals(getPropertySize(), service.getPropertySize()) &&
        hasMonthlyService == service.hasMonthlyService &&
        getPreviouslyNumberOfService() == service.getPreviouslyNumberOfService() &&
        getNumberOfPets() == service.getNumberOfPets();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getPropertyAddress(), getPropertySize(), hasMonthlyService,
        getPreviouslyNumberOfService(), getNumberOfPets());
  }

  @Override
  public String toString() {
    return "PaintingService{" +
        "numberOfPets=" + numberOfPets +
        ", propertyAddress='" + propertyAddress + '\'' +
        ", propertySize=" + propertySize +
        ", hasMonthlyService=" + hasMonthlyService +
        ", previouslyNumberOfService=" + previouslyNumberOfService +
        ", BASE_RATE=" + BASE_RATE +
        ", every10thDiscount=" + every10thDiscount +
        ", monthlyServiceDiscount=" + monthlyServiceDiscount +
        ", Before Discount Calculate Price = " +
        String.format("%.2f", this.beforeDiscountCalculatePrice()) +
        ", Total Price = " + String.format("%.2f", this.calculatePrice()) +
        '}';
  }
}

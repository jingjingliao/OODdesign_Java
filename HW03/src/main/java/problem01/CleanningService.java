package problem01;

import java.util.Objects;

/**
 * Representing a cleaning service, including propertyAddress, propertySize, hasMonthlyService,
 * previouslyNumberOfService, numberOfPets
 */
public class CleanningService extends AbstractInteriorService {
  private static final int ONE_HOUR_COMPLETING_TIME = 1;
  private static final int TWO_HOURS_COMPLETING_TIME = 2;
  private static final int FOUR_HOURS_COMPLETING_TIME = 4;

  /**
   * Contructs a cleanning service
   * @param propertyAddress - property address
   * @param propertySize - property size, (small, medium and large)
   * @param hasMonthlyService - whether it has monthly service
   * @param previouslyNumberOfService - the number of previous service
   * @param numberOfPets - the number of pets
   */
  public CleanningService(String propertyAddress, PropertySize propertySize,
      boolean hasMonthlyService, int previouslyNumberOfService, int numberOfPets){
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
        return ONE_HOUR_COMPLETING_TIME;
      case MEDIUM:
        return TWO_HOURS_COMPLETING_TIME;
      default:
        return FOUR_HOURS_COMPLETING_TIME;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    CleanningService service = (CleanningService) o;
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
    return "CleanningService{" +
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

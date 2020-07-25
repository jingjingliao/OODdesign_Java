package problem01;

import java.util.Objects;

/**
 * Representing a gardening service, including propertyAddress, propertySize, hasMonthlyService,
 * and previouslyNumberOfService
 */
public class GardeningService extends AbstractExteriorService {
  private final static int WASTE_REMOVAL_FEE = 20;

  /**
   * Constructs a gardening service
   * @param propertyAddress - property address
   * @param propertySize - property size, (small, medium and large)
   * @param hasMonthlyService - whether it has monthly service
   * @param previouslyNumberOfService - the number of previous service
   */
  public GardeningService(String propertyAddress, PropertySize propertySize,
      boolean hasMonthlyService, int previouslyNumberOfService) {
    super(propertyAddress, propertySize, hasMonthlyService, previouslyNumberOfService);
  }

  /**
   * Calculate price before discount
   * @return price before discount
   */
  @Override
  public double beforeDiscountCalculatePrice() {
    int completeTime = this.getCompleteTime();
    return this.BASE_RATE * completeTime + WASTE_REMOVAL_FEE;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    GardeningService service = (GardeningService) o;
    return Objects.equals(getPropertyAddress(), service.getPropertyAddress()) &&
        Objects.equals(getPropertySize(), service.getPropertySize()) &&
        getPreviouslyNumberOfService() == service.getPreviouslyNumberOfService() &&
        hasMonthlyService == service.hasMonthlyService;
  }

  @Override
  public int hashCode() {
    return Objects.hash(getPropertyAddress(), getPropertySize(), hasMonthlyService,
        getPreviouslyNumberOfService());
  }

  @Override
  public String toString() {
    return "GardeningService{" +
        "propertyAddress='" + propertyAddress + '\'' +
        ", propertySize=" + propertySize +
        ", hasMonthlyService=" + hasMonthlyService +
        ", previouslyNumberOfService=" + previouslyNumberOfService +
        ", BASE_RATE=" + BASE_RATE +
        ", every10thDiscount=" + every10thDiscount +
        ", monthlyServiceDiscount=" + monthlyServiceDiscount +
        ", wasteRemovalFee=" + WASTE_REMOVAL_FEE +
        ", Before Discount Calculate Price = " +
        String.format("%.2f", this.beforeDiscountCalculatePrice()) +
        ", Total Price = " + String.format("%.2f", this.calculatePrice()) +
        '}';
  }
}

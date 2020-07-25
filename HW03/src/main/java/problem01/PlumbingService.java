package problem01;

import java.util.Objects;

/**
 * Representing a plumbing service, including propertyAddress, propertySize, hasMonthlyService,
 *  * previouslyNumberOfService, numberOfLicensedEmployee, whether work is complex
 */
public class PlumbingService extends AbstractSpecialistService {
  private static final int PERMIT_FEE = 20;

  /**
   * Contructs a plumbing service
   * @param propertyAddress - property address
   * @param propertySize - property size, (small, medium and large)
   * @param hasMonthlyService - whether it has monthly service
   * @param previouslyNumberOfService - the number of previous service
   * @param numberOfLicensedEmployee - the number of licensed employee
   * @param isComplex - whether the work is complex or not
   * @throws OutOfMaximumException throw an exception
   */
  public PlumbingService(String propertyAddress, PropertySize propertySize,
      boolean hasMonthlyService, int previouslyNumberOfService, int numberOfLicensedEmployee,
      boolean isComplex) throws OutOfMaximumException {
    super(propertyAddress, propertySize, hasMonthlyService, previouslyNumberOfService,
        numberOfLicensedEmployee, isComplex);
    this.permittingFee = PERMIT_FEE;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    PlumbingService service = (PlumbingService) o;
    return Objects.equals(getPropertyAddress(), service.getPropertyAddress()) &&
        Objects.equals(getPropertySize(), service.getPropertySize()) &&
        hasMonthlyService == service.hasMonthlyService &&
        previouslyNumberOfService == service.getPreviouslyNumberOfService() &&
        isComplex == service.isComplex() &&
        numberOfLicensedEmployee == service.getNumberOfLicensedEmployee();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getPropertyAddress(), getPropertySize(), hasMonthlyService,
        getPreviouslyNumberOfService(), isComplex, getNumberOfLicensedEmployee());
  }

  @Override
  public String toString() {
    return "PlumbingService{" +
        "numberOfLicensedEmployee=" + numberOfLicensedEmployee +
        ", isComplex=" + isComplex +
        ", permittingFee=" + permittingFee +
        ", propertyAddress='" + propertyAddress + '\'' +
        ", propertySize=" + propertySize +
        ", hasMonthlyService=" + hasMonthlyService +
        ", previouslyNumberOfService=" + previouslyNumberOfService +
        ", Before Discount Calculate Price = " +
        String.format("%.2f", this.beforeDiscountCalculatePrice()) +
        ", Total Price = " + String.format("%.2f", this.calculatePrice()) +
        '}';
  }
}

package problem01;

import java.util.Objects;

/**
 * Representing an electrical service, including propertyAddress, propertySize, hasMonthlyService,
 * previouslyNumberOfService, numberOfLicensedEmployee, whether work is complex
 */
public class ElectricalService extends AbstractSpecialistService {
  private static final int PERMIT_FEE = 50;
  private static final int MAX_EMPLOYEE = 4;

  /**
   * Contructs an electrical service
   * @param propertyAddress - property address
   * @param propertySize - property size, (small, medium and large)
   * @param hasMonthlyService - whether it has monthly service
   * @param previouslyNumberOfService - the number of previous service
   * @param numberOfLicensedEmployee - the number of licensed employee
   * @param isComplex - whether the work is complex or not
   * @throws OutOfMaximumException throw an exception
   */
  public ElectricalService(String propertyAddress, PropertySize propertySize,
      boolean hasMonthlyService, int previouslyNumberOfService, int numberOfLicensedEmployee,
      boolean isComplex) throws OutOfMaximumException {
    super(propertyAddress, propertySize, hasMonthlyService, previouslyNumberOfService,
        numberOfLicensedEmployee, isComplex);
    this.permittingFee = PERMIT_FEE;
  }

  /**
   * Set the number of licensed employee, if it is more than maximum number, throw an exception
   * @param numberOfLicensedEmployee Set the number of licensed employee
   * @return the number of licensed employee if it is valid, otherwise throw an exception
   * @throws OutOfMaximumException throw an exception
   */
  @Override
  protected int setNumberOfLicensedEmployee(int numberOfLicensedEmployee)
      throws OutOfMaximumException {
    this.numberOfLicensedEmployee = super.setNumberOfLicensedEmployee(numberOfLicensedEmployee);
    if (this.validNumberOfLicensedEmployee()) {
      throw new OutOfMaximumException();
    }else{
      return this.numberOfLicensedEmployee;
  }
  }

  /**
   * check the number of licensed employee is valid or not
   * @return true if it is valid, otherwise false
   */
  private boolean validNumberOfLicensedEmployee(){
  return this.numberOfLicensedEmployee >= MAX_EMPLOYEE;
 }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    ElectricalService service = (ElectricalService) o;
    return Objects.equals(getPropertyAddress(), service.getPropertyAddress()) &&
        Objects.equals(getPropertySize(), service.getPropertySize()) &&
        hasMonthlyService == service.hasMonthlyService &&
        previouslyNumberOfService == service.getPreviouslyNumberOfService() &&
        numberOfLicensedEmployee == service.getNumberOfLicensedEmployee() &&
        isComplex == service.isComplex();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getPropertyAddress(), getPropertySize(), hasMonthlyService,
        getPreviouslyNumberOfService(), getNumberOfLicensedEmployee(), isComplex());
  }

  @Override
  public String toString() {
    return "ElectricalService{" +
        "numberOfLicensedEmployee=" + numberOfLicensedEmployee +
        ", isComplex=" + isComplex +
        ", permittingFee=" + permittingFee +
        ", propertyAddress='" + propertyAddress + '\'' +
        ", propertySize=" + propertySize +
        ", hasMonthlyService=" + hasMonthlyService +
        ", previouslyNumberOfService=" + previouslyNumberOfService +
        ", SPECIALIST_BASE_RATE=" + SPECIALIST_BASE_RATE +
        ", Before Discount Calculate Price = " +
        String.format("%.2f", this.beforeDiscountCalculatePrice()) +
        ", Total Price = " + String.format("%.2f", this.calculatePrice()) +
        '}';
  }
}

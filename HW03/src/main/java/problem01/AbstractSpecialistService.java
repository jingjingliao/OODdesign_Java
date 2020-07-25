package problem01;

/**
 * Abstract class representing the shared fields and behavior of specialists services
 */
public class AbstractSpecialistService extends AbstractBasicService {
  protected int numberOfLicensedEmployee;
  protected boolean isComplex;
  protected int permittingFee;

  private static final int  MIN_EMPLOYEE = 1;
  private static final int  MIN_EMPLOYEE_FOR_SMALL_PROPERTY = 2;
  private static final int  MAX_EMPLOYEE_FOR_LARGE_PROPERTY = 3;

  /**
   * @param propertyAddress - property address
   * @param propertySize - property size, (small, medium and large)
   * @param hasMonthlyService - whether it has monthly service
   * @param previouslyNumberOfService - the number of previous service
   * @param numberOfLicensedEmployee - the number of licensed employee
   * @param isComplex - whether the work is complex
   * @throws OutOfMaximumException throw out of max exception
   */
  public AbstractSpecialistService(String propertyAddress, PropertySize propertySize,
      boolean hasMonthlyService, int previouslyNumberOfService,
      int numberOfLicensedEmployee, boolean isComplex) throws OutOfMaximumException {
    super(propertyAddress, propertySize, hasMonthlyService, previouslyNumberOfService);
    this.isComplex = isComplex;
    this.numberOfLicensedEmployee = this.setNumberOfLicensedEmployee(numberOfLicensedEmployee);
    this.permittingFee = 0;
  }

  /**
   * If it is not complex work, set the number of licensed employee
   * @param numberOfLicensedEmployee Set the number of licensed employee
   * @return the number of licensed employee
   * @throws OutOfMaximumException throw out of max exception
   */
  protected int setNumberOfLicensedEmployee(int numberOfLicensedEmployee)
      throws OutOfMaximumException {
    if (!isComplex) {
      return Math.max(numberOfLicensedEmployee, MIN_EMPLOYEE);
    }else {
      return this.complexLicensedEmplyee(numberOfLicensedEmployee);
    }
  }

  /**
   * if it is complex work, set the number of licensed employee
   * @param numberOfLicensedEmployee the number of licensed employee
   * @return the number of licensed employee
   */
  private int complexLicensedEmplyee(int numberOfLicensedEmployee) {
    if (this.propertySize == PropertySize.SMALL || this.propertySize == PropertySize.MEDIUM){
      return Math.max(numberOfLicensedEmployee, MIN_EMPLOYEE_FOR_SMALL_PROPERTY);
    }else{
      return Math.max(numberOfLicensedEmployee, MAX_EMPLOYEE_FOR_LARGE_PROPERTY);
      }
    }

  /**
   * Get the number of licensed Employee
   * @return the number of licensed employee
   */
  public int getNumberOfLicensedEmployee() {
    return this.numberOfLicensedEmployee;
  }

  /**
   * Whether the work is complex
   * @return true if the work is complex, otherwise false
   */
  public boolean isComplex(){
    return this.isComplex;
  }

  /**
   * Calculate price before discount
   * @return price before discount
   */
  @Override
  public double beforeDiscountCalculatePrice() {
    return SPECIALIST_BASE_RATE * this.numberOfLicensedEmployee;
  }

  /**
   * Calculate price after discount
   * @return price after discount
   */
  @Override
  public double calculatePrice() {
    double totalPrice = this.beforeDiscountCalculatePrice();
    return totalPrice + this.permittingFee;
    }
}

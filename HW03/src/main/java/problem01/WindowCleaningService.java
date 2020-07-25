package problem01;


import java.util.Objects;

/**
 *  Representing a window cleaning service, including propertyAddress, propertySize, hasMonthlyService,
 *  and previouslyNumberOfService and number of floor
 */
public class WindowCleaningService extends AbstractExteriorService {
  private int numberOfFloor;
  private static final int MAX_FLOOR = 3;
  private static final int MIN_FLOOR = 1;
  private static final double ADDITIONAL_FEE = 0.05;
  private static final double NO_ADDITIONAL_FEE = 0;

  /**
   * Constructs a Window Cleaning Service
   * @param propertyAddress - property address
   * @param propertySize - property size, (small, medium and large)
   * @param hasMonthlyService - whether it has monthly service
   * @param previouslyNumberOfService - the number of previous service
   * @param numberOfFloor - the number of floor
   * @throws OutOfMaximumException throw an exception
   */
  public WindowCleaningService (String propertyAddress, PropertySize propertySize,
      boolean hasMonthlyService, int previouslyNumberOfService, int numberOfFloor)
      throws OutOfMaximumException {
    super(propertyAddress, propertySize, hasMonthlyService, previouslyNumberOfService);
    this.numberOfFloor = this.validNumberOfFloor(numberOfFloor);
  }

  /**
   * check the number of floor
   * @param numberOfFloor  the number of floor
   * @return the number of floor if it is valid, otherwise throw an exception
   * @throws OutOfMaximumException throw an exception
   */
  private int validNumberOfFloor(int numberOfFloor) throws OutOfMaximumException{
    if (numberOfFloor <= MAX_FLOOR && numberOfFloor >= MIN_FLOOR){
      return numberOfFloor;
    }else{
      throw new OutOfMaximumException();
    }
  }

  /**
   * get the number of floor
   * @return the number of floor
   */
  public int getNumberOfFloor(){
    return this.numberOfFloor;
  }

  /**
   * get additional fee
   * @return addtional fee
   */
  public double getAdditionalFee() {
    if (this.numberOfFloor > MIN_FLOOR) {
      return ADDITIONAL_FEE;
    } else {
      return NO_ADDITIONAL_FEE;
    }
  }

  /**
   * Calculate price before discount
   * @return price before discount
   */
  @Override
  public double beforeDiscountCalculatePrice() {
    int completeTime = this.getCompleteTime();
    double additionalFee = this.getAdditionalFee();
    return this.BASE_RATE * completeTime * (RATE + additionalFee);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    WindowCleaningService service = (WindowCleaningService) o;
    return Objects.equals(getPropertyAddress(), service.getPropertyAddress()) &&
        Objects.equals(getPropertySize(), service.getPropertySize()) &&
        hasMonthlyService == service.hasMonthlyService &&
        getNumberOfFloor() == service.getNumberOfFloor() &&
        getAdditionalFee() == service.getAdditionalFee();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getPropertyAddress(), getPropertySize(), hasMonthlyService,
        getPreviouslyNumberOfService(), getNumberOfFloor(), getAdditionalFee());
  }

  @Override
  public String toString() {
    return "WindowCleaningService{" +
        "numberOfFloor=" + numberOfFloor +
        ", propertyAddress='" + propertyAddress + '\'' +
        ", propertySize=" + propertySize +
        ", hasMonthlyService=" + hasMonthlyService +
        ", previouslyNumberOfService=" + previouslyNumberOfService +
        ", BASE_RATE=" + BASE_RATE +
        ", SPECIALIST_BASE_RATE=" + SPECIALIST_BASE_RATE +
        ", every10thDiscount=" + every10thDiscount +
        ", monthlyServiceDiscount=" + monthlyServiceDiscount +
        ", Before Discount Calculate Price = " +
        String.format("%.2f", this.beforeDiscountCalculatePrice()) +
        ", Total Price = " + String.format("%.2f", this.calculatePrice()) +
        '}';
  }
}

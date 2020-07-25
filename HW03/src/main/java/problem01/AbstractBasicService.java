package problem01;

/**
 * Abstract class representing the shared fields and behavior of common services
 */
public abstract class AbstractBasicService implements TotalPrice{
  protected String propertyAddress;
  protected PropertySize propertySize;
  protected boolean hasMonthlyService;
  protected int previouslyNumberOfService;

  protected final int BASE_RATE = 80;
  protected final int SPECIALIST_BASE_RATE = 200;
  protected final double every10thDiscount = 0.5;
  protected final double monthlyServiceDiscount = 0.9;

  protected final int RATE = 1;

  private static final int ONE_MORE_SERVICE = 1;
  private static final int DIVISOR = 10;


  /**
   * Construct for abstract basic service
   * @param propertyAddress - property address
   * @param propertySize -- property size, (small, medium and large)
   * @param hasMonthlyService - whether it has monthly service
   * @param previouslyNumberOfService - the number of previous service
   */
  public AbstractBasicService(String propertyAddress, PropertySize propertySize,
      boolean hasMonthlyService, int previouslyNumberOfService) {
    this.propertyAddress = propertyAddress;
    this.propertySize = propertySize;
    this.hasMonthlyService = hasMonthlyService;
    this.previouslyNumberOfService = previouslyNumberOfService;
  }

  /**
   * get the property address
   * @return property address
   */
  public String getPropertyAddress(){
    return this.propertyAddress;
  }

  /**
   * get property size
   * @return property size
   */
  public PropertySize getPropertySize(){
    return this.propertySize;
  }

  /**
   * get previous number of service
   * @return previously number of service
   */
  public int getPreviouslyNumberOfService(){
    return this.previouslyNumberOfService;
  }

  /**
   * set previous number of service
   * @param previouslyNumberOfService new previous number of service
   */
  public void setPreviouslyNumberOfService(int previouslyNumberOfService){
    this.previouslyNumberOfService = previouslyNumberOfService;
  }

  /**
   * calculate the total price based on the different conditions
   * @return total price
   */
  public double calculatePrice() {
    double totalPrice = this.beforeDiscountCalculatePrice();
    if ((this.previouslyNumberOfService + ONE_MORE_SERVICE) % DIVISOR == 0) {
      return totalPrice * this.every10thDiscount;
    } else if (this.hasMonthlyService) {
      return totalPrice * this.monthlyServiceDiscount;
    }
    return totalPrice;
  }
}

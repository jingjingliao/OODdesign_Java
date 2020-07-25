package problem01;

/**
 * Abstract class representing the shared fields and behavior of exterior services
 */
public abstract class AbstractExteriorService extends AbstractBasicService {
  private static final int COMPLETE_IN_ONE_HOUR = 1;
  private static final int COMPLETE_IN_TWO_HOURS = 2;
  private static final int COMPLETE_IN_FOUR_HOURS = 4;

  /**
   * Construct for abstract basic service
   * @param propertyAddress - property address
   * @param propertySize - property size, (small, medium and large)
   * @param hasMonthlyService - whether it has monthly service
   * @param previouslyNumberOfService - the number of previous service
   */
  public AbstractExteriorService(String propertyAddress, PropertySize propertySize,
      boolean hasMonthlyService, int previouslyNumberOfService) {
    super(propertyAddress, propertySize, hasMonthlyService, previouslyNumberOfService);
  }

  /**
   * Get complete time
   * @return the complete time
   */
  public int getCompleteTime(){
    switch (propertySize) {
      case SMALL:
        return COMPLETE_IN_ONE_HOUR;
      case MEDIUM:
        return COMPLETE_IN_TWO_HOURS;
      default:
        return COMPLETE_IN_FOUR_HOURS;
    }
  }

}

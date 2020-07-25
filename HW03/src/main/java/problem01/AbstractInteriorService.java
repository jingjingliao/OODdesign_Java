package problem01;

import java.util.Objects;

/**
 * Abstract class representing the shared fields and behavior of interior services
 */
public abstract class AbstractInteriorService extends AbstractBasicService {

  protected int numberOfPets;
  private static final int ONE_PET = 1;
  private static final int TWO_PETS = 2;
  private static final int THREE_PETS = 3;

  private static final double LOW_ADDITIONAL_FEE = 0.05;
  private static final double HIGH_ADDITIONAL_FEE = 0.07;
  private static final double NO_ADDITIONAL_FEE = 1;

  /**
   * Construct for abstract interior service
   * @param propertyAddress - property address
   * @param propertySize - property size, (small, medium and large)
   * @param hasMonthlyService - whether it has monthly service
   * @param previouslyNumberOfService - the number of previous service
   * @param numberOfPets - number of pets
   */
  public AbstractInteriorService(String propertyAddress, PropertySize propertySize,
      boolean hasMonthlyService, int previouslyNumberOfService, int numberOfPets) {
    super(propertyAddress, propertySize, hasMonthlyService, previouslyNumberOfService);
    this.numberOfPets = numberOfPets;
  }

  /**
   * Get number of pets
   * @return number of pets
   */
  public int getNumberOfPets() {
    return this.numberOfPets;
  }

  /**
   * Get complete time
   * @return complete time
   */
  public abstract int getCompleteTime();

  /**
   * Get addtional fee
   * @return addtional fee
   */
  public double getAdditionalFee() {
    if (this.numberOfPets == ONE_PET || this.numberOfPets == TWO_PETS) {
      return LOW_ADDITIONAL_FEE;
    } else if (this.numberOfPets >= THREE_PETS) {
      return HIGH_ADDITIONAL_FEE;
    } else {
      return NO_ADDITIONAL_FEE;
    }
  }

  /**
   * Calculate price without discount
   * @return price without discount
   */
  @Override
  public double beforeDiscountCalculatePrice() {
    int completeTime = this.getCompleteTime();
    double additionalFee = this.getAdditionalFee();
    return this.BASE_RATE * completeTime * (RATE + additionalFee);
  }

}

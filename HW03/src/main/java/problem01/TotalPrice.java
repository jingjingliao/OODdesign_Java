package problem01;

/**
 * An interface specifying price calculating for services.
 */
public interface TotalPrice {

  /**
   * Calculate the price before discount
   * @return the price before discount
   */
  double beforeDiscountCalculatePrice();

  /**
   * Calculate the final price
   * @return the final price
   */
  double calculatePrice();

}

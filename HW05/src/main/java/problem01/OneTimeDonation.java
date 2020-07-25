package problem01;

import java.time.LocalDate;
import java.util.Objects;

/**
 * One time donation class represents one time donation, including amount and creation time
 */
public class OneTimeDonation extends AbstractDonation {


  /**
   * Create a constructor with amount and creation time
   *
   * @param amount       amount
   * @param creationTime creation time
   */
  public OneTimeDonation(int amount, LocalDate creationTime) {
    super(amount, creationTime);
  }

  /**
   * Create a constructor with amount
   *
   * @param amount amount
   */
  public OneTimeDonation(int amount) {
    super(amount);
  }

  /**
   * Get total amount
   *
   * @param year calculate the total amount in a specific year
   * @return total amount
   */
  @Override
  public double getTotalAmount(int year) {
    double amount = 0;
    if (year == this.getCreationTime().getYear()) {
      amount += this.getAmount();
      return amount;
    } else {
      return amount;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    OneTimeDonation oneTimeDonation = (OneTimeDonation) o;
    return Objects.equals(getCreationTime(), oneTimeDonation.getCreationTime()) &&
        Double.compare(getAmount(), oneTimeDonation.getAmount()) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(getCreationTime(), getAmount());
  }

  @Override
  public String toString() {
    return "OneTimeDonation{" +
        "amount='" + this.getAmount() + '\'' +
        "creation time='" + this.getCreationTime() + '\'' +
        '}';
  }
}

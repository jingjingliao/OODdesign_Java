package problem01;

import java.time.LocalDate;

/**
 * Abstract class represents a donation including amount and creation time
 */
public abstract class AbstractDonation {
  private double amount;
  private LocalDate creationTime;

  /**
   * Create a constructor with amount and creation time
   * @param amount amount
   * @param creationTime creation time
   */
  public AbstractDonation(double amount, LocalDate creationTime) {
    this.amount = amount;
    this.creationTime = creationTime;
  }

  /**
   * Create a constructor with amount
   * @param amount amount
   */
  public AbstractDonation(double amount) {
    this.amount = amount;
    this.creationTime = LocalDate.now();
  }

  /**
   * Get amount
   * @return amount
   */
  public double getAmount() {
    return amount;
  }

  /**
   * Get creation time
   * @return creation time
   */
  public LocalDate getCreationTime() {
    return creationTime;
  }

  /**
   * Get total amount
   * @param year calculate the total amount in a specific year
   * @return total amount
   */
  public abstract double getTotalAmount(int year);
}

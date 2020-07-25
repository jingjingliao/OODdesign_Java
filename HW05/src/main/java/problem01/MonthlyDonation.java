package problem01;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.Objects;

/**
 * Monthly donation class
 */
public class MonthlyDonation extends AbstractDonation {
  private LocalDate cancellationDay;
  private static final int ZERO_AMOUNT = 0;
  private static final int MAX_MONTH = 12;
  private static final int ONE_MORE_MONTH = 1;

  /**
   * Create a constructor with amount and creation time
   * @param amount  amount
   * @param creationTime creation time
   */
  public MonthlyDonation(int amount, LocalDate creationTime) {
    super(amount, creationTime);
    this.cancellationDay = null;
  }

  /**
   * Create a constructor with amount and creation time
   * @param amount amount
   */
  public MonthlyDonation(int amount) {
    super(amount);
    this.cancellationDay = null;
  }

  /**
   * Get the cancellation day
   * @return cancellation day
   */
  public LocalDate getCancellationDay() {
    return this.cancellationDay;
  }

  /**
   * Set cancellation day
   * @param cancellationDay cancellation day
   * @throws InvalidDateException if the date is invalid, throw an exception
   */
  public void setCancellationDay(LocalDate cancellationDay) throws InvalidDateException {
    this.cancellationDay = this.setValidCancellationDay(cancellationDay);
  }

  /**
   * Helper function that check the cancellation day is valid or not
   * @param cancellationDay cancellation date
   * @return true if it is valid, otherwise false
   */
  private boolean isValidCancellationDay(LocalDate cancellationDay){
    return  cancellationDay.isAfter(this.getCreationTime());
  }

  /**
   * Helper function that help to set the cancellation date
   * @param cancellationDay cancellation date
   * @return cancellation date if date is valid, otherwise throw an exception
   * @throws InvalidDateException if the date is invalid, throw an exception
   */
  private  LocalDate setValidCancellationDay(LocalDate cancellationDay)
      throws InvalidDateException {
    if (this.isValidCancellationDay(cancellationDay)){
      return cancellationDay;
    }else{
      throw new InvalidDateException();
    }
  }

  /**
   * Get total amount
   * @param year calculate the total amount in a specific year
   * @return total amount in a specific year
   */
  @Override
  public double getTotalAmount(int year) {
    int totalMonths = this.calculateMonth(year);
    return totalMonths * this.getAmount();
  }

  /**
   * Get months
   * @param date1 date1
   * @param date2 date2
   * @return months
   */
  private int months(LocalDate date1, LocalDate date2){
    Period period = Period.between(date1, date2);
    return period.getMonths() + ONE_MORE_MONTH;
  }

  /**
   * Helper function that get the total month
   * @param year a given specific year
   * @return valid total month
   */
  private int calculateMonth(int year){
    int creationYear = this.getCreationTime().getYear();
    if (this.getCancellationDay() != null){
      int cancellationYear = this.getCancellationDay().getYear();
      if (creationYear < year && cancellationYear > year){
        return MAX_MONTH;
      }else if (creationYear < year && cancellationYear == year){
        return this.getCancellationDay().getMonthValue();
      }else if (creationYear == year && cancellationYear > year){
        return MAX_MONTH - this.getCreationTime().getMonthValue() + ONE_MORE_MONTH;
      }else if (creationYear == year & cancellationYear == year){
        return this.months(this.getCreationTime(), this.getCancellationDay());
      }else{
        return ZERO_AMOUNT;
      }
    } else{
      if (creationYear < year){
        return MAX_MONTH;
      }else{
        return MAX_MONTH - this.getCreationTime().getMonthValue() + ONE_MORE_MONTH;
      }
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    MonthlyDonation monthlyDonation = (MonthlyDonation) o;
    return Objects.equals(getCreationTime(), monthlyDonation.getCreationTime()) &&
        Objects.equals(getCancellationDay(), monthlyDonation.getCancellationDay()) &&
        Double.compare(getAmount(), monthlyDonation.getAmount()) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(getCreationTime(), getAmount(), getCancellationDay());
  }

  @Override
  public String toString() {
    return "MonthlyDonation{" +
        "amount='" + this.getAmount() + '\'' +
        "creation time='" + this.getCreationTime() + '\'' +
        "cancellation time='" + this.getCancellationDay() + '\'' +
        '}';
  }

}

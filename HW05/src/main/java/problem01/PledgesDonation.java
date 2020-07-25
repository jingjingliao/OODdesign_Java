package problem01;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Pledge donation class records pledge donation
 */
public class PledgesDonation extends AbstractDonation {
  private LocalDate actualDonationDate;
  private static final double ZERO_AMOUNT = 0;

  /**
   * Create a constructor with amount, actualDonationDate is null
   * @param amount amount
   */
  public PledgesDonation(double amount) {
    super(amount);
    this.actualDonationDate = null;
  }

  /**
   * Create a constructor with amount, creation time and actualDonationDate
   * @param amount amount
   * @param creationTime creation time
   * @param actualDonationDate actualDonationDate
   * @throws InvalidDateException if date is invalid throw an exception
   */
  public PledgesDonation(double amount, LocalDate creationTime, LocalDate actualDonationDate)
      throws InvalidDateException {
    super(amount, creationTime);
    this.actualDonationDate = this.validDonationDate(actualDonationDate);
  }

  /**
   * Create a constructor with amount and actualDonationDate, creation time is current time
   * @param amount amount
   * @param actualDonationDate actualDonationDate
   * @throws InvalidDateException if date is invalid throw an exception
   */
  public PledgesDonation(double amount, LocalDate actualDonationDate) throws InvalidDateException {
    super(amount);
    this.actualDonationDate = this.validDonationDate(actualDonationDate);
  }

  /**
   * Get actual donation date
   * @return actual donation date
   */
  public LocalDate getActualDonationDate() {
    return actualDonationDate;
  }

  /**
   * Set actual donation date
   * @param actualDonationDate new actual donation date
   * @throws InvalidDateException if date is invalid throw an exception
   */
  public void setActualDonationDate(LocalDate actualDonationDate) throws InvalidDateException {
    this.actualDonationDate = this.validChangeDonationDay(actualDonationDate);
  }

  /**
   * Helper function that check whether the date is valid
   * @param actualDonationDate actualDonationDate
   * @return actualDonationDate if it is valid, otherwise throw an exception
   * @throws InvalidDateException if date is invalid throw an exception
   */
  private LocalDate validDonationDate(LocalDate actualDonationDate) throws InvalidDateException {
    LocalDate now = LocalDate.now();
    if (actualDonationDate.isAfter(now)){
      return actualDonationDate;
    }else{
      throw new InvalidDateException();
    }
  }


  /**
   * Helper function that check whether the change date is valid
   * @return true if it is valid, otherwise false
   */
  private boolean isValidTochangeTheDate(){
    LocalDate now = LocalDate.now();
    if (this.getActualDonationDate() != null){
      return now.isBefore(this.getActualDonationDate());
    } else {
      return true;
    }
  }


  /**
   * Helper function that check whether the change date is valid
   * @param newDonationDay  newDonationDay
   * @return new donation date if it is valid, otherwise throw an exception
   * @throws InvalidDateException if date is invalid throw an exception
   */
  private LocalDate validChangeDonationDay(LocalDate newDonationDay) throws InvalidDateException {
    LocalDate now = LocalDate.now();
    if (this.isValidTochangeTheDate()){
      if (newDonationDay.isAfter(now)){
        return newDonationDay;
      }else{
        throw new InvalidDateException();
      }
    } else{
      throw new InvalidDateException();
    }
  }

  /**
   * Calculate the total amount
   * @param year calculate the total amount in a specific year
   * @return total amount in a specific year
   */
  @Override
  public double getTotalAmount(int year) {
    if (year == this.getActualDonationDate().getYear()){
      return this.getAmount();
    }else{
      return ZERO_AMOUNT;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    PledgesDonation pledgesDonation = (PledgesDonation) o;
    return Objects.equals(getCreationTime(), pledgesDonation.getCreationTime()) &&
        Objects.equals(getActualDonationDate(), pledgesDonation.getActualDonationDate()) &&
        Double.compare(getAmount(), pledgesDonation.getAmount()) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(getCreationTime(), getAmount(), getActualDonationDate());
  }

  @Override
  public String toString() {
    return "PledgesDonation{" +
        "amount='" + this.getAmount() + '\'' +
        "creation time='" + this.getCreationTime() + '\'' +
        "Actual DonationDate='" + this.getActualDonationDate() + '\'' +
        '}';
  }

}

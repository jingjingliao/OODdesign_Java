package problem01;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Non profit class
 */
public class NonProfit {
  String organizationName;
  List<AbstractDonation> donationTypes;

  /**
   * Create a constructor with organizationName and donation types
   * @param organizationName organizationName
   */
  public NonProfit(String organizationName) {
    this.organizationName = organizationName;
    this.donationTypes = new ArrayList<>();
  }

  /**
   * Get organization name
   * @return organization name
   */
  public String getOrganizationName() {
    return organizationName;
  }

  /**
   * Get donation types
   * @return donation types
   */
  public List<AbstractDonation> getDonationTypes() {
    return donationTypes;
  }

  /**
   * Add donation types
   * @param donation donation types
   */
  public void addDonationType(AbstractDonation donation){
    this.donationTypes.add(donation);
  }

  /**
   * Get total amount
   * @param year a specifit year
   * @return total amount
   */
  public double getTotalDonationsForYear(int year){
    double amount = 0;
    for (AbstractDonation donation: donationTypes) {
      amount += donation.getTotalAmount(year);
    } return amount;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    NonProfit nonProfit = (NonProfit) o;
    return Objects.equals(getOrganizationName(), nonProfit.getOrganizationName()) &&
        this.donationTypes.equals(nonProfit.getDonationTypes());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getOrganizationName(), getDonationTypes());
  }

  @Override
  public String toString() {

    return "NonProfit{" +
        "organizationName='" + organizationName + '\'' +
        '}';
  }
}





package p1;

import java.util.List;
import java.util.Objects;

/**
 * Class represents a customer. The customer has a first name, last name and a
 * list of items they bought in the last year.
 */
class Customer {
    private String firstName;
    private String lastName;
    private List<Item> boughtItems;


    /**
     * Constructs a Customer object and initializes it
     * to the given first name, last name and the list of bought products
     * @param firstName the first name of this person
     * @param lastName the last name of this person
     * @param boughtItems list of items they bought in the last year.
     */

    public Customer(String firstName, String lastName, List<Item> boughtItems) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.boughtItems = boughtItems;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return this.getFirstName() + " " + this.getLastName();
    }

    public List<Item> getBoughtItems() {
        return boughtItems;
    }

    @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
    return
        Objects.equals(getFirstName(), customer.getFirstName()) &&
        Objects.equals(getLastName(), customer.getLastName()) &&
            Objects.equals(getName(), customer.getName()) &&
            Objects.equals(getBoughtItems(), customer.getBoughtItems()) ;
  }

  @Override
  public int hashCode() {
    return Objects.hash(getFirstName(), getLastName(), getName(), getBoughtItems());
  }

    @Override
    public String toString() {
        return "Customer{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", boughtItems=" + boughtItems +
            '}';
    }
}

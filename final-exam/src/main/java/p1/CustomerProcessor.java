package p1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function; import java.util.stream.Collectors;

public class CustomerProcessor {

  private List<Customer> customers = new ArrayList<>();
  private static final int MIN_ITEMS = 15;

  public CustomerProcessor(List<Customer> customers){this.customers = customers;}

  public CustomerProcessor(Customer customer1, Customer customer2){
    this.customers.add(customer1);
    this.customers.add(customer2);
  }

  /**
   * Count the number of customers
   * @param customers a list of customers
   * @return a hashmap, key is the Customer, value is the number of customers
   */
  public static Map<Customer, Long> countCustomers(List<Customer> customers) {
    return customers.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
  }

  /**
   * Print out the customers' first name and last name if they bought more than 15 items
   */
  public void printCustomersWithAFewItems(){
    customers.stream().filter(this::filterCustomer).map(Customer::getName).forEach(System.out::println);
  }

  /**
   * Helper method to filter out the customer which the items is not item and also more than 15
   * @param customer customers
   * @return true if the customers' item is more than 15, otherwise false
   */
  private boolean filterCustomer(Customer customer){
    return customer.getBoughtItems() != null && customer.getBoughtItems().size() <= MIN_ITEMS;
  }

  public List<Customer> getCustomers() {
    return customers;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CustomerProcessor processor = (CustomerProcessor) o;
    return
        Objects.equals(getCustomers(), processor.getCustomers());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getCustomers());
  }

  @Override
  public String toString() {
    return "CustomerProcessor{" +
        "customers=" + customers +
        '}';
  }

}

package p1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class CustomerProcessorTest {
  Customer c1;
  Item i1, i11;
  List<Item> items1;

  Customer c2;
  Item i2;
  List<Item> items2;

  List<Customer> customers;

  @Before
  public void setUp() throws Exception {
    i1 = new Item("eggs", 1.2f);
    i11 = new Item("apple", 1.5f);
    items1 = new ArrayList<>(Arrays.asList(i1, i11));
    c1 = new Customer("Emily", "Jessy", items1);

    i2 = new Item("pear", 2.2f);
    items2 = new ArrayList<>(Arrays.asList(i2));
    c2 = new Customer("Josh", "Chen", items2);

    customers = new ArrayList<>(Arrays.asList(c1, c2));
  }

  @Test
  public void countCustomers() {
    Map<Customer, Long> res = new HashMap<>();
    res.put(c1, 1L);
    res.put(c2, 1L);
    assertEquals(CustomerProcessor.countCustomers(customers), res);
  }

  @Test
  public void noCustomers() {
    Map<Customer, Long> res = new HashMap<>();
    List<Customer> customers = new ArrayList<>();
    assertEquals(CustomerProcessor.countCustomers(customers), res);
  }

  @Test
  public void moreThanOneCustomers() {
    Map<Customer, Long> res = new HashMap<>();
    res.put(c1, 1L);
    res.put(c2, 1L);
    res.put(c2, 1L);
    List<Customer> newCustomers = new ArrayList<>(Arrays.asList(c1, c2, c2));
    assertEquals(CustomerProcessor.countCustomers(customers), res);
  }

}
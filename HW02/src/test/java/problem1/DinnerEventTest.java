package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DinnerEventTest {
  DinnerEvent dinnerEvent;
  DinnerEvent illegalDinnerEvent;
  DinnerEvent illegalDinnerEvent1;

  @Before
  public void setUp() throws Exception {
    dinnerEvent = new DinnerEvent("Jackie", 33);
  }

  @Test
  public void getNumberOfPeople() {
    assertEquals(33, dinnerEvent.getNumberOfPeople());
  }

  @Test (expected = InvalidNumberException.class)
  public void getLowNumberOfPeople() throws InvalidNumberException {
    DinnerEvent lowNumberOfPeople = new DinnerEvent("Tracy", -1);
  }

  @Test (expected = InvalidNumberException.class)
  public void getHighNumberOfPeople() throws InvalidNumberException {
    DinnerEvent highNumberOfPeople = new DinnerEvent("Tracy", 300);
  }

  @Test
  public void getNonVegetarian() {
    assertEquals(26, dinnerEvent.getNonVegetarian());
  }

  @Test (expected = InvalidNumberException.class)
  public void illegalGetNonVegetarian() throws InvalidNumberException {
    illegalDinnerEvent = new DinnerEvent("Jackie", 1);
    illegalDinnerEvent1 = new DinnerEvent("Key", 100);
  }

  @Test
  public void getVegetarian() {
    assertEquals(7, dinnerEvent.getVegetarian());
  }

  @Test (expected = InvalidNumberException.class)
  public void illegalgetVegetarian() throws InvalidNumberException {
    illegalDinnerEvent = new DinnerEvent("Jackie", 1);
    illegalDinnerEvent1 = new DinnerEvent("Key", 100);
  }

}
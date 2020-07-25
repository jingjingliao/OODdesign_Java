package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LunchEventTest {
  LunchEvent lunchEvent1;

  @Before
  public void setUp() throws Exception {
    lunchEvent1 = new LunchEvent("Jack", 15);
  }

  @Test
  public void GetNumberOfPeople(){
    assertEquals(15, lunchEvent1.getNumberOfPeople());
  }

  @Test
  public void getNumberOfSandwiches() {
    assertEquals(16, lunchEvent1.getNumberOfSandwiches());
  }

  @Test (expected = InvalidNumberException.class)
  public void getLowNumberOfPeople() throws InvalidNumberException {
    LunchEvent lowNumberOfPeople = new LunchEvent("Jessie", 5);
  }

  @Test (expected = InvalidNumberException.class)
  public void getHighNumberOfPeople() throws InvalidNumberException {
    LunchEvent highNumberOfPeople = new LunchEvent("Jessie", 155);
  }

  @Test (expected = InvalidNumberException.class)
  public void invalidGetNumberOfSandwiches() throws InvalidNumberException {
    LunchEvent illegalLunchEvent = new LunchEvent("Jessie", 5);
  }
}
package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EventTest {
  Event event;

  @Before
  public void setUp() throws Exception {
    event = new Event("Jason", 16);
  }

  @Test
  public void getClientName() {
    assertEquals("Jason", event.getClientName());
  }

  @Test
  public void getNumberOfPeople() {
    assertEquals(16, event.getNumberOfPeople());
  }
}
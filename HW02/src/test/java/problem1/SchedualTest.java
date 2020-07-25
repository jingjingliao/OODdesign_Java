package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SchedualTest {
  Schedual addEvent;
  LunchEvent lunchEvent;
  LunchEvent lunchEvent1;

  DinnerEvent dinnerEvent;
  DinnerEvent dinnerEvent1;

  @Before
  public void setUp() throws Exception {

    addEvent = new Schedual(null, null);
  }

  @Test
  public void bookingLunchEvent() throws InvalidNumberException {
    lunchEvent = new LunchEvent("Lee", 25);
    addEvent.bookingLunchEvent(lunchEvent);
    assertEquals(lunchEvent, addEvent.getLunchEvent());

    lunchEvent1 = new LunchEvent("Moris", 35);
    addEvent.bookingLunchEvent(lunchEvent1);
    assertNotEquals(lunchEvent1, addEvent.getLunchEvent());
    assertEquals(lunchEvent, addEvent.getLunchEvent());
  }

  @Test
  public void bookingDinnerEvent() throws InvalidNumberException {
    dinnerEvent = new DinnerEvent("Katie", 40);
    addEvent.bookingDinnerEvent(dinnerEvent);
    assertEquals(dinnerEvent, addEvent.getDinnerEvent());

    dinnerEvent1 = new DinnerEvent("Kelly", 12);
    addEvent.bookingDinnerEvent(dinnerEvent1);
    assertNotEquals(dinnerEvent1, addEvent.getDinnerEvent());
    assertEquals(dinnerEvent, addEvent.getDinnerEvent());
  }
}

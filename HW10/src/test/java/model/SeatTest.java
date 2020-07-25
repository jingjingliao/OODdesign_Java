package model;

import static org.junit.Assert.*;

import controller.InvalidArgumentsException;
import org.junit.Before;
import org.junit.Test;

public class SeatTest {
  Seat seat;
  Seat sameSeat;
  Seat invalidSeat;

  @Before
  public void setUp() throws Exception {
    seat = new Seat("AA");
    sameSeat = new Seat("AA");
  }

  @Test
  public void getSeatName() {
    assertEquals(seat.getSeatName(), "AA");
  }

  @Test
  public void getReserveFor() {
    assertNull(seat.getReserveFor());
  }

  @Test
  public void setReserveFor() {
    seat.setReserveFor("www");
    assertEquals(seat.getReserveFor(), "www");
  }

  @Test (expected = InvalidArgumentsException.class)
  public void invalidName() throws InvalidArgumentsException {
    invalidSeat = new Seat("aa");
  }

  @Test
  public void testEquals() throws InvalidArgumentsException {
    assertTrue(seat.equals(sameSeat));
    assertFalse(seat.equals(new Seat("BB")));
    assertTrue(seat.equals(seat));
    assertFalse(seat.equals(null));
  }

  @Test
  public void testHashCode() {
    assertTrue(seat.hashCode() == sameSeat.hashCode());
  }

  @Test
  public void tostring() {
    assertEquals("Seat{seatName='AA', reserveFor='null'}", seat.toString());
  }

}
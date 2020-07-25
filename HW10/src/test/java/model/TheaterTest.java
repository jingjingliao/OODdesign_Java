package model;

import static org.junit.Assert.*;

import controller.InvalidArgumentsException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class TheaterTest {
  Theater theater, sameTheater;
  ArrayList<Integer> wheelChairRow;
  Seat[] seats1;
  Seat seat1, seat2;
  Row row1;
  List<Row> rows;


  @Before
  public void setUp() throws Exception {
    wheelChairRow = new ArrayList<>(Arrays.asList(1));
    seat1 = new Seat("AA");
    seat2 = new Seat("BB");
    seats1 = new Seat[]{seat1, seat2};

    row1 = new Row(seats1, 1, false);

    rows = new ArrayList<>(Arrays.asList(row1));
    theater = Theater.createTheater("Roxy", rows, wheelChairRow);
    sameTheater = Theater.createTheater("Roxy", rows, wheelChairRow);
  }

  @Test
  public void getTheaterName() {
    assertEquals(theater.getTheaterName(), "Roxy");
  }

  @Test
  public void getRows() {
    assertEquals(theater.getRows(), rows);
  }

  @Test
  public void getWheelChairRow() {
    assertEquals(theater.getWheelChairRow(), wheelChairRow);
  }

  @Test
  public void testEquals() throws InvalidArgumentsException {
    assertTrue(theater.equals(sameTheater));
    assertFalse(theater.equals(new Seat("BB")));
    assertTrue(theater.equals(theater));
    assertFalse(theater.equals(null));
  }

  @Test
  public void testHashCode() {
    assertTrue(theater.hashCode() == sameTheater.hashCode());
  }

  @Test
  public void tostring() {
    assertEquals("Theater{theaterName='Roxy', rows=[Row{seats=[Seat{seatName='AA', reserveFor='null'}, Seat{seatName='BB', reserveFor='null'}], rowNum=1, isWheelchairRow=false}], wheelChairRow=[1]}", theater.toString());
  }
}
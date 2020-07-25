package model;

import static org.junit.Assert.*;

import controller.InvalidArgumentsException;
import org.junit.Before;
import org.junit.Test;

public class RowTest {
  Row row;
  Row sameRow;
  Seat seat1;
  Seat seat2;
  Seat[] seats;

  @Before
  public void setUp() throws Exception {
    seat1 = new Seat("AA");
    seat2 = new Seat("BB");
    seats = new Seat[]{seat1, seat2};
    row = new Row(seats, 1, false);
    sameRow = new Row(seats, 1, false);
  }

  @Test
  public void getSeats() {
    assertTrue(row.getSeats().equals(seats));
  }

  @Test
  public void getRowNum() {
    assertTrue(row.getRowNum()==1);
  }

  @Test
  public void isWheelchairRow() {
    assertFalse(row.isWheelchairRow());
  }

  @Test
  public void setRowNum() {
    row.setRowNum(3);
    assertTrue(row.getRowNum()==3);
  }

  @Test
  public void setSeat() throws InvalidArgumentsException {
    Seat newSeat1 = new Seat("AAA");
    Seat newSeat2 = new Seat("BBB");
    Seat[] newSeats = new Seat[]{newSeat1, newSeat2};

    row.setSeats(newSeats);
    assertTrue(row.getSeats().equals(newSeats));
  }


  @Test
  public void testEquals() {
    assertTrue(row.equals(sameRow));
    assertFalse(row.equals(new Row(seats, 5, false)));
    assertTrue(row.equals(row));
    assertFalse(row.equals(null));
  }

  @Test
  public void testHashCode() {
    assertTrue(row.hashCode() == sameRow.hashCode());
  }

  @Test
  public void tostring() {
    assertEquals("Row{seats=[Seat{seatName='AA', reserveFor='null'}, Seat{seatName='BB', reserveFor='null'}], rowNum=1, isWheelchairRow=false}", row.toString());
  }

}
package view;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.Row;
import model.Seat;
import org.junit.Before;
import org.junit.Test;

public class ShowSeatsTest {
  ShowSeats seats;
  Seat[][] allSeats;
  List<Row> rows;

  @Before
  public void setUp() throws Exception {
    allSeats = new Seat[15][10];
    for (int i = 0; i < 15; i++) {
      for (int j = 0; j < 10; j++) {
        allSeats[i][j] = new Seat(String.valueOf((char) (i + 65)) + String
            .valueOf((char) (j + 65)));
      }
    }
    allSeats[1][2].setReserveFor("Jingjing");

    rows = new ArrayList<>();
    for (int i = 0; i < 15; i++) {
      if (i == 3 || i == 5)
        rows.add(new Row(allSeats[i], i + 1, true));
      else
        rows.add(new Row(allSeats[i], i + 1, false));
    }
    seats = new ShowSeats();
  }

  @Test
  public void showSeats() {
    seats.showSeats(rows);
  }

  @Test
  public void noSeatsAvailable() {
    seats.noSeatsAvailable();
  }

  @Test
  public void sucessfullyReserveSeat() {
    seats.sucessfullyReserveSeat(5, "jingjing", 3, "Nori");
  }
}
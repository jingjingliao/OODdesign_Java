package controller;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.Row;
import model.Seat;
import model.Theater;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import view.ShowSeats;

public class ReservationServiceTest {
  private ByteArrayInputStream inputStream;
  private ByteArrayInputStream inputStream2;
  private ByteArrayOutputStream outStream;

  ReservationService service;
  Theater theater;
  ShowSeats seats;
  Seat[][] allSeats;
  List<Row> rows;
  ArrayList<Integer> wheelChairRow;

  @Before
  public void setUp() throws Exception {
    outStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outStream));

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

    wheelChairRow = new ArrayList<>(Arrays.asList(2, 5));
    theater = Theater.createTheater("Jing", rows, wheelChairRow);

  }

  @After
  public void tearDown() throws Exception {
    System.setIn(System.in);
    System.setOut(System.out);
  }

  @Test
  public void showService() {
    service.service(theater, "show");
  }

  @Test
  public void reserveService() {

  }

}
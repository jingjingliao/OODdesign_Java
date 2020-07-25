package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import model.InvalidSeatName;
import model.Row;
import model.Seat;
import model.Theater;

public class ReservationSystem {

  private static final int wheelChairRow1 = 5;
  private static final int wheelChairRow2 = 11;

  private static final int MAX_ROW = 15;
  private static final int MAX_COLUMN = 10;
  private static final int NUM_TO_STRING = 65;

  private static String TODO_QUERY = "What would you like to do?";
  private static String RESERVE_OVER = "Have a nice day!";

  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws InvalidSeatName {
    ArrayList<Integer> wheelChairRow = new ArrayList<>(
        Arrays.asList(wheelChairRow1, wheelChairRow2));
    List<Seat> allSeats = creatSeats();
    List<Row> rows = creatRows();
    List<Row> allRows = assignSeats(allSeats, rows);
    Theater theater = Theater.createTheater("Roxy", rows, wheelChairRow);

    while (true) {
      System.out.println(TODO_QUERY);
      String answer = scanner.nextLine();
      CommandLineValidation validation = new CommandLineValidation(answer);
      String command = validation.getAnswer();

      if (command != null && command.equals("done")) {
        System.out.println(RESERVE_OVER);
        break;
      }
      if (command != null) {
        reserveSeats(theater, command);
        System.out.println("");
      }
    }
  }

  /**
   * Reserve seats
   * @param theater theater
   * @param answer answer
   */
  private static void reserveSeats (Theater theater, String answer) {
    ReservationService.service(theater, answer);
  }

  private static List<Seat> creatSeats () throws InvalidSeatName {
    List<Seat> allSeats = new ArrayList<>();

    for (int i = 0; i < MAX_ROW; i++) {
      for (int j = 0; j < MAX_COLUMN; j++) {
        allSeats.add(new Seat(String.valueOf((char) (i + NUM_TO_STRING)) + String
            .valueOf((char) (j + NUM_TO_STRING))));
      }
    }
    return allSeats;
  }

  private static List<Row> creatRows () {
    List<Row> rows = new ArrayList<>();
    for (int i = 0; i < 15; i++){
      if (i == wheelChairRow1 - 1 || i == wheelChairRow2 - 1){
        Row row = new Row(MAX_COLUMN, true);
        row.setRowNum(i+1);
        rows.add(row);
      } else {
        Row row = new Row(MAX_COLUMN, false);
        row.setRowNum(i+1);
        rows.add(row);
      }
    }
    return rows;
  }

  private static List<Row> assignSeats (List<Seat> allSeats, List<Row> rows){
    for (Row row: rows){
      for (int i = 0; i < 10; i++)
        row.add(allSeats.get(i));
    }
    return rows;
  }
//    List<Row> rows = new Row[15];
//    for (int i = 0; i < 15; i++) {
//      rows[i].setRowNum(i + 1);
//      setWheelChair(rows, i);
//      for (int j = 0; j < 10; j++) {
//        rows[i].add(allSeats.get(j));
//      }
//    }
//    return rows;
//  }

  private static void setWheelChair(Row[] rows, int i){
    if (i == wheelChairRow1 - 1 || i == wheelChairRow2 - 1)
      rows[i].setWheelchairRow(true);
    else
      rows[i].setWheelchairRow(false);
  }

}

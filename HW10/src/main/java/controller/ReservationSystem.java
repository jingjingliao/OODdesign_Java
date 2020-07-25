package controller;

import controller.CommandLineValidation;
import controller.InvalidArgumentsException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import controller.ReservationService;
import model.Row;
import model.Seat;
import model.Theater;

/**
 * Reservation system to reserve seats
 */
public class ReservationSystem {

  private static final int wheelChairRow1 = 5;
  private static final int wheelChairRow2 = 11;

  private static final int MIN_ROW = 15;
  private static final int MIN_COLUMN = 10;
  private static final int NUM_TO_STRING = 65;

  private static String TODO_QUERY = "What would you like to do?";
  private static String RESERVE_OVER = "Have a nice day!";

  private static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) throws InvalidArgumentsException {
    ArrayList<Integer> wheelChairRow = new ArrayList<>(Arrays.asList(wheelChairRow1, wheelChairRow2));
    Seat[][] allSeats = creatSeats();
    List<Row> rows = creatRows(allSeats);
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

  /**
   * Create seats
   * @return a list of seats
   * @throws InvalidArgumentsException if seat name is not valid, throw exception
   */
  private static Seat[][] creatSeats () throws InvalidArgumentsException {
        Seat[][] allSeats = new Seat[MIN_ROW][MIN_COLUMN];
        for (int i = 0; i < MIN_ROW; i++) {
          for (int j = 0; j < MIN_COLUMN; j++) {
            allSeats[i][j] = new Seat(String.valueOf((char) (i + NUM_TO_STRING)) + String
                .valueOf((char) (j + NUM_TO_STRING)));
          }
        }
        return allSeats;
  }

  /**
   * Create Rows
   * @param allSeats allSeats
   * @return a list of rows
   * @throws InvalidArgumentsException if seats's name are invalid
   */
  private static List<Row> creatRows (Seat[][]allSeats) throws InvalidArgumentsException {
    List<Row> rows = new ArrayList<>();
    for (int i = 0; i < MIN_ROW; i++) {
      if (i == wheelChairRow1 - 1 || i == wheelChairRow2 - 1)
        rows.add(new Row(allSeats[i], i + 1, true));
      else
        rows.add(new Row(allSeats[i], i + 1, false));
    }
    return rows;
  }
}


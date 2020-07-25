package controller;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.StrictMath.abs;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.Row;
import model.Theater;
import view.ShowSeats;


/**
 * Reservation service class
 */
public class ReservationService {
  private  static String WHEELCHAIR_QUERY = "Do you need wheelchair accessible seats?";
  private static String NAME_QUERY = "What's your name?";
  private static boolean needWheelChairSeat;
  private static String validName;
  private static Scanner scanner = new Scanner(System.in);
  private static int reserveNum;

  /**
   * Reservation method
   * @param theater reserve seats in this specific theater
   * @param reserveInfo reservation information
   */
  public static void service(Theater theater, String reserveInfo){
    if (reserveInfo.equals("show"))
        ShowSeats.showSeats(theater.getRows());
    else {
      reserveNum =  Integer.parseInt(reserveInfo);
      System.out.println(NAME_QUERY);
      String customerName = scanner.nextLine();
      checkCustomerName(customerName);

      System.out.println(WHEELCHAIR_QUERY);
      String wheelChairAnswer = scanner.nextLine();
      isValidwheelChairAnswer(wheelChairAnswer);
      reserveSeats(validName, needWheelChairSeat, reserveNum, theater);
    }
  }

  /**
   * Check whether the customer's name is valid
   * @param customerName customer's name
   */
  private static void checkCustomerName(String customerName){
      String newName = "";
      Pattern p = Pattern.compile("([\\w\\s]+)");
      Matcher m = p.matcher(customerName);
      while (m.find())
        newName += m.group(1);
      if (newName.equals(""))
        validName = "Anonymous Name";
      else
       validName = newName;
    }


  /**
   * Check whether the answer for wheelchair seat is valid or not
   * @param wheelChairAnswer the answer for wheelchair seat
   */
  private static void isValidwheelChairAnswer(String wheelChairAnswer){
    if (wheelChairAnswer.toUpperCase().equals("YES"))
      needWheelChairSeat = true;
    else if (wheelChairAnswer.toUpperCase().equals("NO"))
      needWheelChairSeat = false;
    else {
      System.out.println("Unkown command, please enter 'YES' or 'NO'");
    }
  }

  /**
   * Reserve seats
   * @param customerName customerName
   * @param needWheelChairSeat needWheelChairSeat
   * @param reserveNum reserveNum
   * @param theater theater
   */
  private static void reserveSeats(String customerName, boolean needWheelChairSeat, int reserveNum, Theater theater) {
    List<Row> rows = theater.getRows();
    boolean mustReserveWheelChairSeat = needWheelChairSeat || nomarlChairFull(rows);
    Row bestRow = getBestRow(rows, reserveNum, mustReserveWheelChairSeat, theater);
    if (bestRow == null)
      ShowSeats.noSeatsAvailable();
    else {
      int count = reserveNum;
      for (int i = 0; i < bestRow.getSeats().length && count > 0; i++)
        if (bestRow.getSeats()[i].getReserveFor() == null){
          bestRow.getSeats()[i].setReserveFor(customerName);
          count -= 1;
        }
      ShowSeats.sucessfullyReserveSeat(reserveNum, customerName, bestRow.getRowNum(), theater.getTheaterName());
    }
  }

  /**
   * Check whether the normal chairs are full
   * @param rows the rows in the theater
   * @return true if it is full, otherwise false
   */
  private static boolean nomarlChairFull(List<Row> rows){
    for (int i = 0; i < rows.size(); i++){
      if (!rows.get(i).isWheelchairRow()){
        if (rows.get(i).getSeats()[i].getReserveFor() == null)
          return false;
      }
    }
    return true;
  }

  /**
   * Get the best row
   * @param rows rows
   * @param reserveNum reserveNum
   * @param mustReserveWheelChairSeat boolean whether it must reserve wheelchair seat
   * @param theater theater
   * @return the best row
   */
  private static Row getBestRow(List<Row> rows, int reserveNum, boolean mustReserveWheelChairSeat, Theater theater) {
    int mid = rows.size() / 2 + 1;
    if (mustReserveWheelChairSeat)
      return getBestRowForWheelChair(rows, mid);
    else
      return getBestRowForNormalChair(rows, mid);
  }

  /**
   * Get the best row for wheelChair
   * @param rows rows
   * @param mid the mid row
   * @return the best row for wheel chair
   */
  private static Row getBestRowForWheelChair(List<Row> rows, int mid) {
    int bestInt = MAX_VALUE;
    Row bestRow = null;
    for (Row row : rows) {
      if (row.isWheelchairRow() && abs(row.getRowNum() - mid) <= bestInt && isRowReservable(row, reserveNum)) {
        bestInt = abs(row.getRowNum() - mid);
        bestRow = row;
      }
    }
    return bestRow;
  }

  /**
   * Get the best row for normal chair
   * @param rows rows
   * @param mid the mid row
   * @return the best row for normal chair
   */
  private static Row getBestRowForNormalChair(List<Row> rows, int mid){
    int bestInt = MAX_VALUE;
    Row bestRow = null;
    for (Row row : rows) {
      if (abs(row.getRowNum() - mid) <= bestInt && isRowReservable(row, reserveNum) && !row.isWheelchairRow()) {
        bestInt = abs(row.getRowNum() - mid);
        bestRow = row;
      }
    }
      return bestRow;
  }


  /**
   * Check whether the row can be reserved
   * @param row row
   * @param reserveNum reserveNum
   * @return true if we can reserve this row
   */
  private static boolean isRowReservable(Row row, int reserveNum){
    int count = 0;
    for (int i = 0; i < row.getSeats().length; i++){
      if (row.getSeats()[i].getReserveFor() == null)
        count += 1;
    }
    return reserveNum <= count;
  }
}

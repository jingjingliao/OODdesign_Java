package view;

import java.util.List;
import model.Row;
import model.Seat;

/**
 * Show seats class
 */
public class ShowSeats {

  private static final int MAX_ROW = 15;
  private static final int MAX_COLUMN = 10;

  /**
   * show the seats on the screen
   * @param rows rows
   */
  public static void showSeats(List<Row> rows) {
    StringBuilder sb = new StringBuilder();
    printTheater(sb, rows);
    System.out.println(sb.toString());

  }

  /**
   * print number of rows
   * @param sb StringBuilder
   * @param rows rows
   */
  private static void printTheater(StringBuilder sb, List<Row> rows) {
    for (int i = 0; i < MAX_ROW; i++) {
      if (i < MAX_COLUMN - 1) {
        sb.append(i + 1).append("   ");
        printSeats(sb, rows, i);
        sb.append(System.lineSeparator());
      } else if (i < MAX_ROW - 1) {
        sb.append(i + 1).append("  ");
        printSeats(sb, rows, i);
        sb.append(System.lineSeparator());
      } else{
        sb.append(i + 1).append("  ");
        printSeats(sb, rows, i);
      }
    }
  }

  /**
   * print seats
   * @param sb StringBuilder
   * @param rows rows
   * @param i num
   */
  private static void printSeats(StringBuilder sb, List<Row> rows, int i) {
    Row row = rows.get(i);
    for (int k = 0; k < MAX_COLUMN; k++) {
      if (row.isWheelchairRow() && row.get(k).getReserveFor() == null)
        sb.append("=").append(" ");
      else if (!row.isWheelchairRow() && row.get(k).getReserveFor() == null)
        sb.append("_").append(" ");
      else
        sb.append("X").append(" ");
    }
  }

  /**
   * no seats are available
   */
  public static void noSeatsAvailable(){
    System.out.println("No seats are available now!");
  }

  /**
   * Reserve seats
   * @param reserveNum reserveNum
   * @param customerName customerName
   * @param rowNum rowNum
   * @param theaterName theaterName
   */
  public static void sucessfullyReserveSeat(int reserveNum, String customerName, int rowNum, String theaterName){
    System.out.println("I've reserved " + reserveNum + " seats for you at the " + theaterName + " in row " + rowNum + ", " + customerName);
  }
}






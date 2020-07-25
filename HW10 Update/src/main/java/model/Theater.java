package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Theater class
 */
public class Theater {

  private String theaterName;
  private List<Row> rows;
  private ArrayList<Integer> wheelChairRow;
  private static Theater instance;

  /**
   * Construct a theater
   *
   * @param theaterName   theaterName
   * @param rows          rows
   * @param wheelChairRow wheelChairRow
   */
  private Theater(String theaterName, List<Row> rows, ArrayList<Integer> wheelChairRow) {
    this.theaterName = theaterName;
    this.rows = rows;
    this.wheelChairRow = wheelChairRow;
  }

  /**
   * getTheaterName
   *
   * @return TheaterName
   */
  public String getTheaterName() {
    return theaterName;
  }

  /**
   * getRows
   *
   * @return Rows
   */
  public List<Row> getRows() {
    return rows;
  }

  /**
   * getWheelChairRow
   *
   * @return WheelChairRow
   */
  public ArrayList<Integer> getWheelChairRow() {
    return wheelChairRow;
  }

  /**
   * CreateTheater
   *
   * @param theaterName   theaterName
   * @param rows          rows
   * @param wheelChairRow wheelChairRow
   * @return a new Theater if it is not created, if it is created, then don't need to creat it
   */
  public static Theater createTheater(String theaterName, List<Row> rows,
      ArrayList<Integer> wheelChairRow) {
    if (instance == null) {
      return new Theater(theaterName, rows, wheelChairRow);
    }
    return instance;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Theater theater = (Theater) o;
    return Objects.equals(getTheaterName(), theater.getTheaterName()) &&
        Objects.equals(getRows(), theater.getRows()) &&
        Objects.equals(getWheelChairRow(), theater.getWheelChairRow());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getTheaterName(), getRows(), getWheelChairRow());
  }

  @Override
  public String toString() {
    return "Theater{" +
        "theaterName='" + theaterName + '\'' +
        ", rows=" + rows +
        ", wheelChairRow=" + wheelChairRow +
        '}';
  }
}

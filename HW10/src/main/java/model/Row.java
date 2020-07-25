package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * Row Class
 */
public class Row extends ArrayList<Seat>{
  private Seat[] seats;
  private int rowNum;
  private boolean isWheelchairRow;

  /**
   * Constructs a row
   * @param seats seats
   * @param rowNum rowNum
   * @param isWheelchairRow isWheelchairRow
   */
  public Row(Seat[] seats, int rowNum, boolean isWheelchairRow){
    this.seats = seats;
    this.rowNum = rowNum;
    this.isWheelchairRow = isWheelchairRow;
  }

  /**
   * Get seats
   * @return a list of seats
   */
  public Seat[] getSeats() {
    return seats;
  }

  /**
   * Get row Number
   * @return row Number
   */
  public int getRowNum() {
    return rowNum;
  }

  /**
   * Check whether isWheelchairRow
   * @return true if it is isWheelchairRow
   */
  public boolean isWheelchairRow() {
    return isWheelchairRow;
  }

  /**
   * Set row number
   * @param rowNum rowNum
   */
  public void setRowNum(int rowNum) {
    this.rowNum = rowNum;
  }

  /**
   * Set seats
   * @param seats seats
   */
  public void setSeats(Seat[] seats) {
    this.seats = seats;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Row row = (Row) o;
    return Objects.equals(getSeats(), row.getSeats()) &&
        getRowNum() == row.getRowNum() &&
        isWheelchairRow == row.isWheelchairRow;
  }

  @Override
  public int hashCode() {
    return Objects.hash(getSeats(), getRowNum(), isWheelchairRow());
  }

  @Override
  public String toString() {
    return "Row{" +
        "seats=" + Arrays.toString(seats) +
        ", rowNum=" + rowNum +
        ", isWheelchairRow=" + isWheelchairRow +
        '}';
  }
}

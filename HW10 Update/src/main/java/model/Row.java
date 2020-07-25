package model;

import java.util.ArrayList;

/**
 * Row Class
 */
public class Row extends ArrayList<Seat> {
  private int rowNum;
  private boolean isWheelchairRow;
  int seatNums;

  public Row(int seatNums, boolean isWheelchairRow){
    this.seatNums = seatNums;
    this.isWheelchairRow = isWheelchairRow;
  }

  public int getRowNum() {
    return rowNum;
  }

  public boolean isWheelchairRow() {
    return isWheelchairRow;
  }

  public int getSeatNums() {
    return seatNums;
  }

  public void setRowNum(int rowNum) {
    this.rowNum = rowNum;
  }

  public void setWheelchairRow(boolean wheelchairRow) {
    isWheelchairRow = wheelchairRow;
  }

  public void setSeatNums(int seatNums) {
    this.seatNums = seatNums;
  }
}

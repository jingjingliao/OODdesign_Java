package problem3;

import java.awt.Point;

/**
 * This class represents a rectangle. It defines all the operations mandated by
 * the shape interface
 */

public class Rectangle extends AbstractShape {
  private double width, height;
  private static final int MIN_WIDTH_AND_HEIGHT = 0;

  /**
   * @param x
   * @param y
   * @param width
   * @param height
   * @throws IllegalArgumentException
   */
  public Rectangle(double x, double y, double width, double height)
      throws IllegalArgumentException {
    super(new Point2D(x, y));

    if (this.isvalidWidth(width) && this.isvalidHeight(height)){
      this.width = width;
      this.height = height;
    }else{
      throw new IllegalArgumentException();
    }
  }

  /**
   * @param width
   * @return true if width > 0 otherwise false
   */
  private boolean isvalidWidth(double width){
    return width > MIN_WIDTH_AND_HEIGHT;
  }

  /**
   * @param height
   * @return true if height > 0 otherwise false
   */
  private boolean isvalidHeight(double height){
    return height > MIN_WIDTH_AND_HEIGHT;
  }

  /**
   * @return the area
   */
  @Override
  public double area(){
    return this.width * this.height;
    }

  /**
   * @return the perimeter
   */
  @Override
  public double perimeter(){
    return 2 * (this.width + this.height);
  }
}

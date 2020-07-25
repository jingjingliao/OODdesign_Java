package problem3;

import java.awt.Point;

/**
 * This class represents a abstract shape
 */
public class AbstractShape{
  private Point2D point2D;

  /**
   * @param point2D
   */
  public AbstractShape(Point2D point2D){
    this.point2D = point2D;
  }

  /**
   * @return the area
   */
  public double area(){
    return point2D.getX() * point2D.getY();
  }

  /**
   * @return the perimeter
   */
  public double perimeter(){
    return point2D.getX() + point2D.getY();
  }

}

package problem3;

/**
 * This class represent a 2D point. This point is denoted in Cartesian
 * coordinates as (x, y)
 */
public class Point2D {
  private double x;
  private double y;

  /**
   * Construct a 2D point with the given coordinates
   * @param x the x-coordinate of this point
   * @param y the y-coordinate of this point
   */
  public Point2D(double x, double y){
    this.x = x;
    this.y = y;
  }

  /**
   * @return the x-coordinate of this point
   */
  public double getX(){
    return this.x;
  }

  /**
   * @return the y-coordinate of this point
   */
  public double getY(){
    return this.y;
  }
  /**
   * Compute and return the Euclidean distance of this point to the origin
   * @return the euclidean distance
   */
  public double distToOrigin(){
    return Math.sqrt(x * x + y * y);
  }

}

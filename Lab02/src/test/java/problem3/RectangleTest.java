package problem3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RectangleTest {
  Rectangle rectangle;
  Rectangle illegal1;
  Rectangle illegal2;

  @Before
  public void setUp() throws Exception {
    rectangle = new Rectangle(1.0, 2.0, 3.0, 4.0);
  }

  @Test
  public void area() {
    assertEquals(12.0, rectangle.area(), .01);
  }

  @Test (expected = IllegalArgumentException.class)
  public void invalidWidth(){
    illegal1 = new Rectangle(2.0, 3.0, -1, 9);
  }

  @Test (expected = IllegalArgumentException.class)
  public void invalidHeight(){
    illegal1 = new Rectangle(2.0, 3.0, 1, -9);
  }

  @Test
  public void perimeter() {
    assertEquals(14.0, rectangle.perimeter(), .01);
  }
}
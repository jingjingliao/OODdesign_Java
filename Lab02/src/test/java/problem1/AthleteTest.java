package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AthleteTest {
  Athlete athlete1;
  Athlete athlete2;
  Name name1;
  Name name2;
  Double height1;
  Double height2;
  Double weight1;
  Double weight2;


  @Before
  public void setUp() throws Exception {
    name1 = new Name("Lucy", "B", "White");
    name2 = new Name("David", "P", "Black");
    height1 = 187.96;
    height2 = 177.77;
    weight1 = 200.0;
    weight2 = 190.0;
    athlete1 = new Athlete(name1, height1, weight1, "Tiger");
    athlete2 = new Athlete(name2, height2, weight2);
  }

  @Test
  public void getAthletesName() {
    assertEquals(name1, athlete1.getAthletesName());
    assertEquals(name2, athlete2.getAthletesName());
  }

  @Test
  public void getHeight() {
    assertEquals(height1, athlete1.getHeight());
    assertEquals(height2, athlete2.getHeight());
  }

  @Test
  public void getWeight() {
    assertEquals(weight1, athlete1.getWeight());
    assertEquals(weight2, athlete2.getWeight());
  }

  @Test
  public void getLeague() {
    assertEquals("Tiger", athlete1.getLeague());
    assertNull(null, athlete2.getLeague());
  }
}
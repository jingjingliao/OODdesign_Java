package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RunnerTest {
  Runner runner1;
  Runner runner2;
  Name name1;
  Name name2;
  Double best5KTime1;
  Double best5KTime2;
  Double bestHalfMarathonTime1;
  Double bestHalfMarathonTime2;


  @Before
  public void setUp() throws Exception {
    name1 = new Name("Lucy", "B", "White");
    name2 = new Name("David", "P", "Black");
    best5KTime1 = 6.7;
    best5KTime2 = 10.2;
    bestHalfMarathonTime1 = 12.3;
    bestHalfMarathonTime2 = 20.0;
    runner1 = new Runner(name1, 174.4, 66.6, "Tiger",
        best5KTime1, bestHalfMarathonTime1, "Marathon");
    runner2 = new Runner(name2, 188.9, 79.6,
        best5KTime2, bestHalfMarathonTime2, "GoGo");

  }

  @Test
  public void getBest5KTime() {
    assertEquals(best5KTime1, runner1.getBest5KTime());
    assertEquals(best5KTime2, runner2.getBest5KTime());
  }

  @Test
  public void getBestHalfMarathonTime() {
    assertEquals(bestHalfMarathonTime1, runner1.getBestHalfMarathonTime());
    assertEquals(bestHalfMarathonTime2, runner2.getBestHalfMarathonTime());
  }

  @Test
  public void getFavouriteRunningEvent() {
    assertEquals("Marathon", runner1.getFavouriteRunningEvent());
    assertEquals("GoGo", runner2.getFavouriteRunningEvent());
  }
}
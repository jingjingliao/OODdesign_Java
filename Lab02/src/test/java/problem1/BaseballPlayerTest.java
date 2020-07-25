package problem1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BaseballPlayerTest {
  BaseballPlayer player1;
  BaseballPlayer player2;
  Name name1;
  Name name2;
  Double averageBatting1;
  Double averageBatting2;
  Integer seasonHomeRuns1;
  Integer seasonHomeRuns2;

  @Before
  public void setUp() throws Exception {
    name1 = new Name("Lucy", "B", "White");
    name2 = new Name("David", "P", "Black");
    averageBatting1 = 6.7;
    averageBatting2 = 10.2;
    seasonHomeRuns1 = 12;
    seasonHomeRuns2 = 20;
    player1 = new BaseballPlayer(name1, 174.4, 66.6, "Tiger", "BBB",
        averageBatting1, seasonHomeRuns1);
    player2 = new BaseballPlayer(name2, 188.9, 79.6, "AAA",
        averageBatting2, seasonHomeRuns2);
  }

  @Test
  public void getTeam() {
    assertEquals("BBB", player1.getTeam());
    assertEquals("AAA", player2.getTeam());
  }

  @Test
  public void getAverageBatting() {
    assertEquals(averageBatting1, player1.getAverageBatting());
    assertEquals(averageBatting2, player2.getAverageBatting());
  }

  @Test
  public void getSeasonHomeRuns() {
    assertEquals(seasonHomeRuns1, player1.getSeasonHomeRuns());
    assertEquals(seasonHomeRuns2, player2.getSeasonHomeRuns());
  }

}
package problem01;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class PoemTest {
  Poem poem;
  Name name;
  ArrayList<String> genres;
  ArrayList<String> awards;

  @Before
  public void setUp() throws Exception {
    name = new Name("Right", "Lee");
    genres = new ArrayList<>(10);
    genres.add("Grass");
    awards = new ArrayList<>(10);
    awards.add("Silver");

    poem = new Poem(name, 23, genres, awards,
        "Rock", "Moon");

  }

  @Test
  public void getName() {
    assertEquals(name, poem.getName());
  }

  @Test
  public void getAge() {
    assertEquals(23, poem.getAge());
  }

  @Test
  public void getGenres() {
    assertEquals(genres, poem.getGenres());
  }

  @Test
  public void getAwards() {
    assertEquals(awards, poem.getAwards());
  }

  @Test
  public void artistReceivedAward() {
    poem.artistReceivedAward("Red Jack");
    assertEquals(awards, poem.getAwards());
  }

  @Test
  public void getPublishingCompany() {
    assertEquals("Rock", poem.getPublishingCompany());
  }

  @Test
  public void getLastPublishedCollection() {
    assertEquals("Moon", poem.getLastPublishedCollection());
  }
}
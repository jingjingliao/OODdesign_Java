package problem01;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class PainterPhotographerTest {
  PainterPhotographer artist;
  Name name;
  ArrayList<String> genres;
  ArrayList<String> awards;
  ArrayList<String> exhibits;


  @Before
  public void setUp() throws Exception {
    name = new Name("Blue", "Bright");
    genres = new ArrayList<>();
    genres.add("Ex");
    awards = new ArrayList<>();
    awards.add("OOO");
    exhibits = new ArrayList<>();
    exhibits.add("Red Sum");
    artist = new PainterPhotographer(name, 56, genres, awards, exhibits);
  }

  @Test
  public void getName() {
    assertEquals(name, artist.getName());
  }

  @Test
  public void getAge() {
    assertEquals(56, artist.getAge());
  }

  @Test
  public void getGenres() {
    assertEquals(genres, artist.getGenres());
  }

  @Test
  public void getAwards() {
    assertEquals(awards, artist.getAwards());
  }

  @Test
  public void artistReceivedAward() {
    artist.artistReceivedAward("Top One");
    assertEquals(awards, artist.getAwards());
  }

  @Test
  public void getExhibits() {
    assertEquals(exhibits, artist.getExhibits());
  }
}
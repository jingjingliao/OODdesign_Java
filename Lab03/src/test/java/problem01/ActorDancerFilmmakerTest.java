package problem01;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class ActorDancerFilmmakerTest {
  ActorDancerFilmmaker artist;
  Name name;
  ArrayList<String> genres;
  ArrayList<String> awards;
  ArrayList<String> movies;
  ArrayList<String> multimedia;

  @Before
  public void setUp() throws Exception {
    name = new Name("Cherry", "Tom");
    genres = new ArrayList<>();
    genres.add("123");
    awards = new ArrayList<>();
    awards.add("OOO");
    movies = new ArrayList<>();
    movies.add("Tang");
    multimedia = new ArrayList<>();
    multimedia.add("TV");
    artist = new ActorDancerFilmmaker(name, 44, genres, awards, movies,
        "3", multimedia);
  }

  @Test
  public void getName() {
    assertEquals(name, artist.getName());
  }

  @Test
  public void getAge() {
    assertEquals(44, artist.getAge());
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
    artist.artistReceivedAward("new");
    assertEquals(awards, artist.getAwards());
  }

  @Test
  public void getMovies() {
    assertEquals(movies, artist.getMovies());
  }

  @Test
  public void getSeries() {
    assertEquals("3", artist.getSeries());
  }

  @Test
  public void getMultimedia() {
    assertEquals(multimedia, artist.getMultimedia());
  }
}
package problem01;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class MusicianTest {
  Musician musician;
  Musician invalidAge;
  Musician invalidAge2;
  Name name;
  ArrayList<String> genres;
  ArrayList<String> awards;


  @Before
  public void setUp() throws Exception {
    name = new Name("Alicia", "Lee");
    genres = new ArrayList<>(10);
    genres.add("Dynamic");
    awards = new ArrayList<>(10);
    awards.add("Best");
    musician = new Musician(name, 32, genres, awards, "ABC",
        "Peets" );
  }

  @Test
  public void getName() {
    assertEquals(name, musician.getName());
  }

  @Test
  public void getAge() {
    assertEquals(32, musician.getAge());
  }

  @Test (expected = InvalidAgeException.class)
  public void invalidAge() throws InvalidAgeException {
    invalidAge = new Musician(name, -5, genres, awards, "ABC",
        "Peets" );
  }

  @Test (expected = InvalidAgeException.class)
  public void invalidAge2() throws InvalidAgeException {
    invalidAge = new Musician(name, 300, genres, awards, "ABC",
        "Peets" );
  }


  @Test
  public void getGenres() {
    assertEquals(genres, musician.getGenres());
  }

  @Test
  public void getAwards() {
    assertEquals(awards, musician.getAwards());
  }

  @Test
  public void artistReceivedAward() {
    musician.artistReceivedAward("Gold");
    assertEquals(awards, musician.getAwards());
  }

  @Test
  public void getRecordingCompany() {
    assertEquals("ABC", musician.getRecordingCompany());
  }

  @Test
  public void getLastRecordAlbum() {
    assertEquals("Peets", musician.getLastRecordAlbum());
  }
}
package problem02;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RecordingArtistTest {
  Name name;
  Name diffname;
  RecordingArtist artist;

  RecordingArtist sameArtist;
  RecordingArtist diffArtist;

  @Before
  public void setUp() throws Exception {
    name = new Name("Jingjing", "Lee");
    diffname = new Name("Jingjing", "White");
    artist = new RecordingArtist(name);
    sameArtist = new RecordingArtist(name);
    diffArtist = new RecordingArtist(diffname);
  }

  @Test
  public void getName() {
    assertEquals(name, artist.getName());
  }

  @Test
  public void testEquals() {
    assertEquals(artist, sameArtist);
    assertNotEquals(artist, diffArtist);
    assertEquals(artist, artist);
    assertNotEquals(null, artist);
  }

  @Test
  public void isInBand(){
    assertTrue(artist.isInBand(artist));
  }

  @Test
  public void isNotInBand(){
    assertFalse(artist.isInBand(diffArtist));
  }


  @Test
  public void testHashCode() {
    assertEquals(artist.hashCode(), sameArtist.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("IndividualPeroson{name=JingjingLee}", artist.toString());
  }

}
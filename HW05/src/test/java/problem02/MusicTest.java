package problem02;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MusicTest {
  Name name;
  Name newName;

  RecordingArtist artist;
  RecordingArtist newArtist;
  RecordingArtist anotherArtist;

  Music music;
  Music newMusic;

  Author author;
  Band band;

  @Before
  public void setUp() throws Exception {
    name = new Name("Jingjing", "Lee");
    newName = new Name("Sophie", "Lee");

    artist = new RecordingArtist(name);
    newArtist = new RecordingArtist(newName);
    anotherArtist = new RecordingArtist(newName);

    music = new Music(artist, "Perfect", 2000);
    newMusic = new Music(newArtist, "Good", 1999);

    author = new Author(name);


  }

  @Test
  public void getAbstractCreator() {
    assertEquals(artist, music.getAbstractCreator());
  }

  @Test
  public void getTitle() {
    assertEquals("Perfect", music.getTitle());
  }

  @Test
  public void getYear() {
    assertEquals(2000, music.getYear());
  }

  @Test
  public void isMatch() {
    assertFalse(music.isMatch(author));
  }

  @Test
  public void testIsMatchArtists() {
    assertTrue(music.isMatch(artist));
  }

  @Test
  public void testIsMatchArtistsBand() {
    Name newName = new Name("Lee", "J");
    RecordingArtist newArtist = new RecordingArtist(newName);
    Band newband = new Band("Yoyo");
    newband.addRecordingArtist(newArtist);
    Music anotherMusic = new Music(newband, "Perfect", 2000);
    assertTrue(anotherMusic.isMatch(newArtist));
  }

  @Test
  public void testIsNotMatchArtists() {
    Name newName = new Name("Lee", "J");
    RecordingArtist newArtist = new RecordingArtist(newName);
    Band newband = new Band("Yoyo");
    newband.addRecordingArtist(newArtist);
    Music anotherMusic = new Music(newband, "Perfect", 2000);
    assertFalse(anotherMusic.isMatch(artist));
  }
}
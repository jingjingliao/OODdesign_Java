package problem02;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BandTest {
  Name name;
  RecordingArtist artist;
  Band band;
  Band sameBand;

  Name newName;
  RecordingArtist newArtist;
  Band newBand;

  @Before
  public void setUp() throws Exception {
    name = new Name("Jingjing", "Lee");
    artist = new RecordingArtist(name);
    band = new Band("Lala");
    band.addRecordingArtist(artist);

    sameBand = new Band("Lala");
    sameBand.addRecordingArtist(artist);

    newName = new Name("Sophie", "Lee");
    newArtist = new RecordingArtist(newName);
    newBand = new Band("Huhu");



  }

  @Test
  public void getName() {
    assertEquals("Lala", band.getName());
  }

  @Test
  public void getRecordingArtist() {
    assertEquals(artist, band.getRecordingArtist().get(0));
  }

  @Test
  public void addRecordingArtist() {
    band.addRecordingArtist(newArtist);
    assertEquals(newArtist, band.getRecordingArtist().get(1));
  }

  @Test
  public void artistInBand() {
    assertTrue(band.artistInBand(artist));
  }

  @Test
  public void artistNotInBand() {
    assertFalse(band.artistInBand(newArtist));
  }

  @Test
  public void testEquals() {
    assertEquals(band, sameBand);
    assertNotEquals(band, newBand);
    assertEquals(band, band);
    assertNotEquals(null, band);
  }

  @Test
  public void testHashCode() {
    assertEquals(band.hashCode(), sameBand.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("Band{name='Lala'}", band.toString());
  }
}
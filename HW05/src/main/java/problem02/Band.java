package problem02;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Band class representing the name of this band and a list of recording artists
 */
public class Band extends AbstractGroup {
  private String name;
  private List<RecordingArtist> recordingArtist;

  /**
   * Construct a band with its name
   * @param name name
   */
  public Band(String name) {
    this.name = name;
    this.recordingArtist = new ArrayList<>();
  }

  /**
   * Get the name of this band
   * @return the name of this band
   */
  public String getName() {
    return name;
  }

  /**
   * Get the collection of artists
   * @return the collection of artists
   */
  public List<RecordingArtist> getRecordingArtist() {
    return recordingArtist;
  }

  /**
   * Add artists into the collection
   * @param artist artists
   */
  public void addRecordingArtist(RecordingArtist artist){
    this.recordingArtist.add(artist);
  }

  /**
   * Check whether the given artists is in the collection
   * @param artist artists
   * @return true if in the collection, otherwise false
   */
  public boolean artistInBand(RecordingArtist artist){
    for (RecordingArtist artists: recordingArtist){
      if (artists.equals(artist)){
        return true;
      }
    } return false;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Band band = (Band) o;
    return Objects.equals(getName(), band.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName());
  }

  @Override
  public String toString() {
    return "Band{" +
        "name='" + name + '\'' +
        '}';
  }
}

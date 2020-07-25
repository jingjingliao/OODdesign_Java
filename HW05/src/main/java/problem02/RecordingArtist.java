package problem02;

/**
 * RecordingArtist class
 */
public class RecordingArtist extends AbstractIndividualPeroson {

  /**
   * Construct RecordingArtist with name
   * @param name name
   */
  public RecordingArtist(Name name) {
    super(name);
  }

  /**
   * Check whether the given artist is in the band
   * @param artist artist
   * @return true if in the band, otherwise false
   */
  public boolean isInBand(RecordingArtist artist){
    return this.equals(artist);
  }
}

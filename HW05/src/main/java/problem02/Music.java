package problem02;

/**
 * Music class
 */
public class Music extends AbstractItems {

  /**
   * Construct a music class including artists, title and year
   * @param recordingArtist  artists
   * @param title title
   * @param year year
   */
  public Music(RecordingArtist recordingArtist, String title, int year) {
    super(recordingArtist, title, year);
  }

  /**
   * Construct a music class including band, title and year
   * @param band  band
   * @param title title
   * @param year year
   */
  public Music(Band band, String title, int year) {
    super(band, title, year);
  }

  /**
   * Check whether the author matches the given author
   * @param author author
   * @return always false, no author in music object
   */
  @Override
  public boolean isMatch(Author author) {
    return false;
  }

  /**
   * Check whether the artist matches the given artist
   * @param artist artist
   * @return true if matches, otherwise false
   */
  @Override
  public boolean isMatch(RecordingArtist artist) {
    if (this.getAbstractCreator() instanceof RecordingArtist){
      return ((RecordingArtist) this.getAbstractCreator()).isInBand(artist);
    } if (this.getAbstractCreator() instanceof Band){
      return ((Band) this.getAbstractCreator()).artistInBand(artist);
    }else{
      return false;
    }
  }
}

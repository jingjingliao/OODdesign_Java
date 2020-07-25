package problem01;

import java.util.ArrayList;

/**
 * An immutable class representing the information of musician
 */
public class Musician extends ArtistsBasicInfo{
  private String recordingCompany;
  private String lastRecordAlbum;

  /**
   * Constructs for musician class
   * @param name name
   * @param age age
   * @param genres genres
   * @param awards awards
   * @param recordingCompany recording company
   * @param lastRecordAlbum last record album
   * @throws InvalidAgeException if age is invalid, throw an exception
   */
  public Musician(Name name, int age, ArrayList<String> genres,
      ArrayList<String> awards, String recordingCompany, String lastRecordAlbum)
      throws InvalidAgeException {
    super(name, age, genres, awards);
    this.recordingCompany = recordingCompany;
    this.lastRecordAlbum = lastRecordAlbum;
  }

  /**
   * Get recording company
   * @return recording company
   */
  public String getRecordingCompany() {
    return recordingCompany;
  }

  /**
   * Get last record album
   * @return  last record album
   */
  public String getLastRecordAlbum() {
    return lastRecordAlbum;
  }
}

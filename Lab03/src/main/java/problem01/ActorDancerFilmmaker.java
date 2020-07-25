package problem01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * An immutable class representing the information of actor, dancer and film maker
 */
public class ActorDancerFilmmaker extends ArtistsBasicInfo {
  private ArrayList<String> movies;
  private String series;
  private ArrayList<String> multimedia;

  /**
   * Constructs for ActorDancerFilmmaker class
   * @param name name
   * @param age age
   * @param genres genres
   * @param awards awards
   * @param movies movies
   * @param series series
   * @param multimedia multimedia
   * @throws InvalidAgeException if age is invalid, throw an exception
   */
  public ActorDancerFilmmaker(Name name, int age, ArrayList<String> genres,
      ArrayList<String> awards, ArrayList<String> movies,
      String series, ArrayList<String> multimedia) throws InvalidAgeException {
    super(name, age, genres, awards);
    this.movies = movies;
    this.series = series;
    this.multimedia = multimedia;
  }

  /**
   * Get movies
   * @return a list of movies
   */
  public ArrayList<String> getMovies(){
    return this.movies;
  }

  /**
   * Get series
   * @return series
   */
  public String getSeries() {
    return series;
  }

  /**
   * Get multimedia
   * @return a list of multimedia
   */
  public ArrayList<String> getMultimedia() {
    return multimedia;
  }

}

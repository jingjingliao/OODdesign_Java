package finalPractice7.problem02;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User extends Person {
  private List<GeoData> visitedLocations = new ArrayList<>();

  public User(String firstName, String lastName, int yearOfBirth, List<GeoData> visitedLocations) {
    super(firstName, lastName, yearOfBirth);
    this.visitedLocations = visitedLocations;
  }

  public List<GeoData> getVisitedLocations() {
    return visitedLocations;
  }

  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof User)) return false;
    User user = (User) o;
    return Objects.equals(getVisitedLocations(), user.getVisitedLocations());
  }
  @Override
  public int hashCode() {
    return Objects.hash(getVisitedLocations()); }

}

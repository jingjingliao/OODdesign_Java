package finalPractice4.problem01;

import java.util.Objects;

public class Player {
    private String name;
    private Integer age;
    private Double height;
    private String club;

  public Player(String name, Integer age, Double height, String club) {
    this.name = name;
    this.age = age;
    this.height = height;
    this.club = club;
  }

  public String getName() {
    return name;
  }

  public Integer getAge() {
    return age;
  }

  public Double getHeight() {
    return height;
  }

  public String getClub() {
    return club;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null || getClass() != other.getClass()) return false; Player player = (Player) other;
    return Objects.equals(name, player.name)
        && Objects.equals(age, player.age)
        && Objects.equals(height, player.height)
        && Objects.equals(club, player.club);
  }
  @Override
  public int hashCode() {
    return Objects.hash(name, age, height, club); }

  @Override
  public String toString() {
    return "Player{" +
        "name='" + name + '\'' +
        ", age=" + age +
        ", height=" + height +
        ", club='" + club + '\'' +
        '}';
  }

}

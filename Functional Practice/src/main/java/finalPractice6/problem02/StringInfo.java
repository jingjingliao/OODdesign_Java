package finalPractice6.problem02;

import finalPractice7.problem02.SaltedString;
import java.util.Objects;

public class StringInfo {
  private Integer length;
  private Integer occurences;

  public StringInfo(Integer length, Integer occurences){
    this.length = length;
    this.occurences = occurences;
  }

  public Integer getLength() {
    return length;
  }

  public Integer getOccurences() {
    return occurences;
  }

  public void setOccurences(Integer occurences) {
    this.occurences = occurences;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof StringInfo)) return false;
    StringInfo that = (StringInfo) o;
    return Objects.equals(getLength(), that.getLength()) &&
        Objects.equals(getOccurences(), that.getOccurences());
  }
  @Override
  public int hashCode() {
    return Objects.hash(getLength(), getOccurences()); }

  @Override
  public String toString() {
    return "StringInfo{" +
        "length=" + length +
        ", occurences=" + occurences +
        '}';
  }
}

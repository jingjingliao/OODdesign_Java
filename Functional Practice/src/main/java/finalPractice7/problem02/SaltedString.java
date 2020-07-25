package finalPractice7.problem02;

import java.util.Objects;

public class SaltedString {

  private String saltedString;
  private Integer length;

  public SaltedString(String originalString) {
    StringBuilder builder = new StringBuilder();
    builder.append(originalString).append(originalString.hashCode());
    this.saltedString = builder.toString();
    this.length = originalString.length();
  }

  public String getSaltedString() {
    return saltedString;
  }

  public Integer getLength() {
    return length;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof SaltedString)) return false;
    SaltedString that = (SaltedString) o;
    return Objects.equals(getSaltedString(), that.getSaltedString()) &&
        Objects.equals(getLength(), that.getLength());
  }
  @Override
  public int hashCode() {
    return Objects.hash(getSaltedString(), getLength()); }

  @Override
  public String toString() {
    return "SaltedString{" +
        "saltedString='" + saltedString + '\'' +
        ", length=" + length +
        '}';
  }
}


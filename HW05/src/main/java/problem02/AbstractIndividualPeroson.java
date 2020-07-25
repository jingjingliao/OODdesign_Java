package problem02;

import java.util.Objects;

/**
 * Abstract individual person class
 */
public abstract class AbstractIndividualPeroson extends AbstractCreator {
  private Name name;

  /**
   * Creat a constructor with name
   * @param name name
   */
  public AbstractIndividualPeroson(Name name) {
    this.name = name;
  }

  /**
   * Get name
   * @return name
   */
  public Name getName() {
    return name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AbstractIndividualPeroson peroson = (AbstractIndividualPeroson) o;
    return Objects.equals(getName(), peroson.getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName());
  }

  @Override
  public String toString() {
    return "IndividualPeroson{" +
        "name=" + name.getFirstName() + name.getLastName() +
        '}';
  }
}

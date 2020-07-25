package problem01;

/**
 * Represents the empty list of integers.
 */


public class Empty implements List {

  @Override
  public Integer size() {
    return 0;
  }

  @Override
  public Boolean isEmpty() {
    return true;
  }

  @Override
  public List add(Integer element) {
    return new Cons(element, this);
  }

  @Override
  public Integer last() throws InvalidCallException {
    throw new InvalidCallException("Called last() on empty!");
  }

  @Override
  public boolean contain(Integer element) {
    return false;
  }

  @Override
  public Integer elementAt(Integer index) {
    return null;
  }

  @Override
  public List delete(Integer elem) {
    return this;
  }


  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    else return true;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode() {
    return 42;
  }

  @Override
  public String toString() {
    return "Empty{}";
  }

}

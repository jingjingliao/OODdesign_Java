package problem01;

/**
 * Empty node
 */
public class EmptyNode implements ILinkedList {

  /**
   * Gets the number of elements in the list.
   *
   * @return THe number of elements in the list.
   */
  @Override
  public Integer count() {
    return 0;
  }

  /**
   * Get the item at the head of the list.
   *
   * @return The integer at the head of the list or null if the list is empty.
   */
  @Override
  public Integer getItem() {
    return null;
  }

  /**
   * Get the rest of the list.
   *
   * @return The rest of the list or null if the list is empty.
   */
  @Override
  public ILinkedList getRest() {
    return null;
  }

  /**
   * Get the value at the head of the list.
   *
   * @return The String at the head of the list or null if the list is empty.
   */
  @Override
  public String getValue() {
    return null;
  }

  /**
   * Inserts an element at the head of the list.
   * @param priority the priority item to insert
   * @param value    the value item to insert
   * @return a new linkedlist with a new item in the front
   */
  @Override
  public ILinkedList insert(Integer priority, String value) {
    return new ElementNode(priority, value, this);
  }

  @Override
  public int hashCode() {
    return 31; // No fields so we have to make something up!
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    return true;
  }

  @Override
  public String toString() {
    return "EmptyNode";
  }

}
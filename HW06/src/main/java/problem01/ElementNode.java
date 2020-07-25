package problem01;

import java.util.Objects;

/**
 * The element node which includes Integer item, String value and the rest
 */
public class ElementNode implements ILinkedList {
  private Integer item;
  private String value;
  private ILinkedList rest;

  /**
   * @param item Integer item
   * @param value String value
   * @param rest the rest of linkedlist
   */
  public ElementNode(Integer item, String value, ILinkedList rest){
    this.item = item;
    this.value = value;
    this.rest = rest;
  }

  /**
   * Gets the number of elements in the list.
   *
   * @return THe number of elements in the list.
   */
  @Override
  public Integer count() {
    return 1 + this.rest.count();
  }

  /**
   * Get the item at the head of the list.
   *
   * @return The integer at the head of the list or null if the list is empty.
   */
  @Override
  public Integer getItem() {
    return this.item;
  }

  /**
   * Get the value at the head of the list.
   *
   * @return The String at the head of the list or null if the list is empty.
   */
  @Override
  public String getValue() {
    return this.value;
  }

  /**
   * Get the rest of the list.
   *
   * @return The rest of the list or null if the list is empty.
   */
  @Override
  public ILinkedList getRest() {
    return this.rest;
  }


  /**
   * insert an element into the list and make it a non-increasing linkedlist. If the inserted elements that have
   * the same priority with the first element, insert it to the head of the list
   * @param priority the priority item to insert
   * @param value    the value item to insert
   * @return a new linkedlist
   */
  @Override
  public ILinkedList insert(Integer priority, String value) {
    if (this.getItem() <= priority){
      ILinkedList thisCopy = new ElementNode(this.item, this.value, this.rest);
      return new ElementNode(priority, value, thisCopy);
    } else {
      return new ElementNode(this.item, this.value, this.rest.insert(priority, value));
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ElementNode that = (ElementNode) o;
    return Objects.equals(item, that.item) &&
        Objects.equals(value, that.value) &&
        Objects.equals(rest, that.rest);
  }

  @Override
  public int hashCode() {
    return Objects.hash(item, value, rest);
  }

  @Override
  public String toString() {
    return "ElementNode{" +
        "item=" + item +
        "value=" + value +
        ", rest=" + rest +
        '}';
  }

}

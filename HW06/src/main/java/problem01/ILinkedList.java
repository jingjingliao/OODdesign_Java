package problem01;

/**
 * Required operations for a linked list of Integer and Strings
 */
public interface ILinkedList {

  /**
   * Gets the number of elements in the list.
   * @return THe number of elements in the list.
   */
  Integer count();

  /**
   * Get the item at the head of the list.
   * @return The integer at the head of the list or null if the list is empty.
   */
  Integer getItem();

  /**
   * Get the rest of the list.
   * @return The rest of the list or null if the list is empty.
   */
  ILinkedList getRest();

  /**
   * Get the value at the head of the list.
   * @return The String at the head of the list or null if the list is empty.
   */
  String getValue();

  /** Inserts an element into the list.
   * @param priority the priority item to insert
   * @param value the value item to insert
   * @return The linked list with the new item in the list.
   */
  ILinkedList insert(Integer priority, String value);

}

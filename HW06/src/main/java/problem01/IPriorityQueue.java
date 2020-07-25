package problem01;

/**
 * An immutable Priority Queue ADT. This Queue will contain Integer priority and String value.
 * It is a non-increasing order linkedlist) data structure.
 */
public interface IPriorityQueue {

  /**
   * Check whether the priority queue is empty
   * @return true if it is empty, otherwise false
   */
  Boolean isEmpty();

  /**
   * Add a priority and value into a list
   * @param priority priority to add to the priority queue
   * @param value value to add to the priority queue
   * @return a new priority queue with new priority and value
   */
  IPriorityQueue add(Integer priority, String value);

  /**
   * Gets the number of items in the priority queue.
   * @return The number of items in the priority queue.
   */
  Integer size();

  /**
   * returns the String at the front of the priority queue if the Queue is not empty.
   * @return The String at the front of the priority queue, if the Queue is not empty.
   * @throws EmptyPriorityQueueException EmptyPriorityQueueException if the priority queue is empty.
   */
  String peek() throws EmptyPriorityQueueException;

  /**
   * Removes and returns the String at the front of the priority queue if the priority queue is not empty.
   * @return A copy of the priority queue without the removed item..
   * @throws EmptyPriorityQueueException EmptyPriorityQueueException if the priority queue is empty.
   */
  IPriorityQueue pop() throws EmptyPriorityQueueException;

}

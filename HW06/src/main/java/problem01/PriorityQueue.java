package problem01;

import java.util.Objects;

/**
 * An immutable Priority Queue
 */
public class PriorityQueue implements IPriorityQueue {
  private final ILinkedList pq;

  /**
   * Private constructor for an empty Priority Queue.
   */
  private PriorityQueue(){
    this.pq = new EmptyNode();
  }

  /**
   * Private constructor for an Priority Queue that contains elements.
   * @param element The elements in the Priority Queue.
   */
  private PriorityQueue(ILinkedList element){
    this.pq = element;
  }

  /**
   * Creat an empty Priority Queue
   * @return an empty Priority Queue
   */
  public static PriorityQueue creatEmpty(){
    return new PriorityQueue();
  }

  /**
   * Check whether the priority queue is empty
   * @return true if it is empty, otherwise false
   */
  @Override
  public Boolean isEmpty() {
    return this.pq.count().equals(0);
  }

  /**
   * Gets the number of items in the priority queue.
   * @return The number of items in the priority queue.
   */
  @Override
  public Integer size() {
    return this.pq.count();
  }

  /**
   * Add a priority and value into a list, make it a non-increasing priority queue. If the inserted elements that have
   * the same priority with the first element, insert it to the head of the list
   * @param priority priority to add to the priority queue
   * @param value value to add to the priority queue
   * @return a new priority queue with new priority and value
   */
  @Override
  public IPriorityQueue add(Integer priority, String value) {
    ILinkedList element = this.pq.insert(priority, value);
    return new PriorityQueue(element);
  }

  /**
   * returns the String at the front of the priority queue if the Queue is not empty.
   * @return The String at the front of the priority queue, if the Queue is not empty.
   * @throws EmptyPriorityQueueException EmptyPriorityQueueException if the priority queue is empty.
   */
  @Override
  public String peek() throws EmptyPriorityQueueException {
    if (this.isEmpty()){
      throw new EmptyPriorityQueueException();
    }
    return this.pq.getValue();
  }

  /**
   * Removes and returns the String at the front of the priority queue if the priority queue is not empty.
   * @return A copy of the priority queue without the removed item..
   * @throws EmptyPriorityQueueException EmptyPriorityQueueException if the priority queue is empty.
   */
  @Override
  public IPriorityQueue pop() throws EmptyPriorityQueueException {
    if (this.isEmpty()){
      throw new EmptyPriorityQueueException();
    } else {
      return new PriorityQueue(this.pq.getRest());
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    PriorityQueue that = (PriorityQueue) o;
    return Objects.equals(pq, that.pq);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pq);
  }

  @Override
  public String toString() {
    return "PriorityQueue{" +
        "pq=" + pq +
        '}';
  }

}

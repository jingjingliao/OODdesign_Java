package problem01;

  /**
   * Exception to throw if client code attempts to access items in an empty Priority Queue.
   */

  public class EmptyPriorityQueueException extends Exception {
    public EmptyPriorityQueueException(){
      super("Priority Queue is empty");
    }

}

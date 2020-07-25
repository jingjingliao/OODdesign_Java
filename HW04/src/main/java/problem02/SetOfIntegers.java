package problem02;

import javax.security.sasl.SaslServer;
import java.util.Objects;

/**
 * Create a SetOfIntegers class
 */
public class SetOfIntegers implements ISetOfIntegers {
  private static final int NUM_SLOTS = 1;
  private Integer[] items;
  private int size;

  /**
   * Construct for a set of integers
   */
  public SetOfIntegers(){
    this.items = new Integer[NUM_SLOTS];
    this.size = 0;
  }


  /**
   * Construct for a set of integers
   * @param items Integer[]
   * @param size the size of the set
   */
  public SetOfIntegers(Integer[] items, int size){
    this.items = items;
    this.size = size;
  }

  /**
   * Create an empty set
   * @return an empty set
   */
  @Override
  public ISetOfIntegers emptySet() {
    return new SetOfIntegers();
  }

  /**
   * Check the set is empty or not
   * @return true if the set is empty, otherwise false
   */
  @Override
  public Boolean isEmpty() {
    return this.size == 0;
  }

  /**
   * Add an item to the set
   * @param n the item to add
   * @throws ElementAlreadyExistedException if the element has already in the set,
   * throw an exception
   */
  @Override
  public void add(Integer n) throws ElementAlreadyExistedException{
    if (!this.contains(n)){
      if (!this.inSizeRange()){
        this.resize();
      }this.items[this.size] = n;
      this.size++;
    }else{
      throw new ElementAlreadyExistedException();
    }
  }

  /**
   * Helper function that checks if there is room in the set to add a new item to the set
   * @return true if there is space available, false otherwise
   */
  private boolean inSizeRange() {
    return (this.size + 1 <= this.items.length);
  }

  /**
   * Increase the size of the array. This involves creating a temporary new array, adding the
   * existing data to the new array, then setting the data array to the new array.
   */
  private void resize() {
    int newSize = this.size + NUM_SLOTS;
    Integer[] newItems = new Integer[newSize];
    this.copyItems(this.items, newItems);
    this.items = newItems;
  }

  /**
   * Helper function used by add methods. Copies the items from one array to another.
   * @param from The array to copy from.
   * @param to The array to copy to.
   * @param fromStart The index in the "from" array to start copying from.
   * @param fromEnd The index in the "from" array to end at (exclusive).
   * @param toStart The index in the "to" array to start copying to.
   */
  private void copyItems(Integer[] from, Integer[] to, int fromStart, int fromEnd, int toStart) {
    if (toStart >= 0) {
      for (int i = fromStart; i < fromEnd; i++) {
        to[toStart] = from[i];
        toStart++;
      }
    }
  }

  /**
   * Shortcut version of the helper method above. Will copy the entirety of the "from" array
   * to the "to" array.
   * @param from The array to copy from.
   * @param to The array to copy to.
   */
  private void copyItems(Integer[] from, Integer[] to) {
    this.copyItems(from, to, 0, from.length, 0);
  }


  /**
   * check whether n is in the set
   * @param n check whether n is in the set
   * @return true if n is in the set otherwise false
   */
  @Override
  public Boolean contains(Integer n) {
    for (int i = 0; i < this.size; i++){
      if (this.items[i].equals(n)){
        return true;
      }
    }
      return false;
  }

  /**
   * Remove an element in the set
   * @param n remove n in the set
   */
  @Override
  public SetOfIntegers remove(Integer n) {
    if (this.contains(n)) {
      int newSize = this.size - NUM_SLOTS;
      int idx = 0;
      Integer[] newItems = new Integer[newSize];
      for (int i = 0; i < this.size; i++){
        if (!this.items[i].equals(n)){
          newItems[i] = this.items[i];
        }else{
          idx = i;
          break;
        }
      }
      for (int j = idx; j < this.size - idx - 1; j++){
        newItems[j] = this.items[j+1];
      }
      this.items = newItems;
      this.size--;
      return new SetOfIntegers(this.items, this.size);
    }
    else{
      return this;
    }
  }

  /**
   * The number of items in the set
   * @return the number of items in the set
   */
  @Override
  public int size() {
    return this.size;
  }

  /**
   * Check whether two sets are the same
   * @param set another set
   * @return true if two sets are the same, otherwise false
   */
  private boolean sameItems(SetOfIntegers set){
    for (int i = 0; i < this.size; i++){
      if (!set.contains(this.items[i]) || i >= set.items.length)
        return false;
    }
    return true;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    SetOfIntegers that = (SetOfIntegers) o;
    return size == that.size && this.sameItems(that);
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(size);
    result = 31 * result;
    for (int i = 0; i < this.size; i++)
      result += Objects.hash(this.items[i]);
    return result;
  }
}

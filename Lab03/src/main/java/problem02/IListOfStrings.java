package problem02;

/**
 * A List represents an ordered, mutable collection of Strings
 */
public interface IListOfStrings {
  boolean isEmpty();
  int size();
  String contains(String item);
  String containsAll();
  boolean hasDuplicates();
  void removeDuplicates();



}

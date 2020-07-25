package problem02;

import problem01.List;

public interface ISet {

  Boolean isEmpty();

  void add(Integer n);

  Boolean contains(Integer n);

  List remove(Integer n);

  Integer size();

}

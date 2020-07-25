package problem02;

import jdk.nashorn.internal.ir.EmptyNode;
import problem01.Cons;
import problem01.Empty;
import problem01.List;

public class Set implements ISet {
  private List front;

  private Set(){
    this.front = new Empty();
  }

  public static Set creatEmpty(){
    return new Set();
  }

  @Override
  public Boolean isEmpty() {
    return this.front.size() == 0;
  }

  @Override
  public void add(Integer n) {
    if (!this.contains(n)){
      this.front = this.front.add(n);
    }
  }

  @Override
  public Boolean contains(Integer n) {
    return this.front.contain(n);
  }

  @Override
  public List remove(Integer n) {
    return this.front.delete(n);
  }

  @Override
  public Integer size() {
    return this.front.size();
  }
}

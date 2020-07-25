package problem03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import problem02.Swimmer;

public class SwimmerIterator implements Iterator<Swimmer>  {

  private List<Swimmer> swimmers;
  private int current;

  public SwimmerIterator(List<Swimmer> swimmers) {
    this.swimmers = swimmers;
    this.current = 0;
  }

  private List<Swimmer> filter(List<Swimmer> list) {
    List<Swimmer> filteredList = new ArrayList<>();
    for (Swimmer swimmer : list) {
      if (swimmer.getButterfly50mTimes().size() >= 5) {
        for (Double record : swimmer.getFreestyle50mTimes()) {
          if (record < 26.17) {
            filteredList.add(swimmer);
            break;
          }
        }
      }
    }
    return filteredList;
  }

  @Override
  public boolean hasNext() {
    return this.current < this.swimmers.size();
  }

  @Override
  public Swimmer next() {
    if (!hasNext())
      throw new NoSuchElementException();
    else
      return swimmers.get(current++);
  }
}

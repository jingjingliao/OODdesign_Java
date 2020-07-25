package finalPractice05.problem04;


import finalCheatSheet.compatatorAndIterator.Swimmer;
import finalCheatSheet.compatatorAndIterator.SwimmerIterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DestinationiIterator implements Iterator<DestinationList> {
  private DestinationList lists;
  private int current;

//  public DestinationiIterator (DestinationList lists){
//    this.lists = this.filter(lists);
//    this.current = 0;
//  }

//  private DestinationList filter(DestinationList lists){
//    DestinationNode node;
//    while  (!lists.getStartingPoint().isEmpty()){
//
//    }
//  }

  @Override
  public boolean hasNext() {
    return false;
  }

  @Override
  public DestinationList next() {
    return null;
  }

  public static void main(String[] args) throws Exception {
    Destination d1 = new Destination("Honolulu, HI", "USA", "HNL", 2678f);
    Destination d2 = new Destination("Paris, France", "France", "CDG", 4994f);
    DestinationNode node = new DestinationNode(d1, new DestinationNode(d2, null));

    DestinationList list = new DestinationList(node);

//    Iterator<DestinationList> itr = new DestinationiIterator(list);
//    while (itr.hasNext()) {
//      DestinationList destination = itr.next();
//      System.out.println();
    }
  }


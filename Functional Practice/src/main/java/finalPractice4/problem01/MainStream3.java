package finalPractice4.problem01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MainStream3 {
  public static void main(String[] arg) {
    List<Player> players = new ArrayList<>();
    players.add(new Player("LeBron James", 33, 6.8, "Cleveland Cavaliers"));
    players.add(new Player("Kevin Durant", 29, 6.9, "Golden State Warriors"));
    players.add(new Player("Stephen Curry", 30, 6.3, "Golden State Warriors"));

    Comparator<Player> name = new Comparator<Player>() {
      @Override
      public int compare(Player o1, Player o2) {
        return o1.getName().compareTo(o2.getName());
      }
    };

    System.out.println("Players:" + players);
    players.sort(name);
    System.out.println("Players again" + players.stream().map(Player::getClub).collect(
        Collectors.toList()));

    List<String> resultingPlayers = players.stream().filter((Player val) -> val.getHeight() > 6.3)
        .map(Player::getName)
        .collect(Collectors.toList());
  }
}

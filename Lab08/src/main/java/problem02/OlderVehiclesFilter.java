package problem02;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OlderVehiclesFilter {

  private List<Vehicle> vehicles = new ArrayList<>();

  public OlderVehiclesFilter(List<Vehicle> vehicles) {
    this.vehicles = vehicles;
  }

  public OlderVehiclesFilter(Vehicle vehicle1, Vehicle vehicle2, Vehicle vehicle3) {
    this.vehicles.add(vehicle1);
    this.vehicles.add(vehicle2);
    this.vehicles.add(vehicle3);
  }

//  public List<String> filterVWvehicles1() {
//    List<Vehicle> filterVehicles = new ArrayList<>();
//    filterVehicles = vehicles.stream().filter(vehicle -> vehicle.getYear() > 1999)
//        .collect(Collectors.toList());
//    for (Vehicle v : filterVehicles) {
//      System.out.println(v.toString());
//    }
//    return null;
//  }

  public List<String> filterVWvehicles() {
    return vehicles.stream().filter(vehicle -> vehicle.getYear() > 1999).map(this::generateInfo).collect((Collectors.toList()));
  }

  public void filterVWvehicles1() {
    vehicles.stream().filter(vehicle -> vehicle.getYear() > 1999).map(this::generateInfo).forEach(System.out::println);
  }

  private String generateInfo(Vehicle vehicle){
    return vehicle.toString();
  }

}

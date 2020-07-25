package finalPractice6.problem01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MainStream3 {
  public static void main(String[] args) {
    List<Vehicle> vehicles = new ArrayList<>();
    vehicles.add(new Vehicle("Tesla", "Model S", 2017, "ABC1234"));
    vehicles.add(new Vehicle("Honda", "CRV", 2018, "BCD4567"));
    vehicles.add(new Vehicle("Audi", "A8", 2019, "MYRIDE8"));
    vehicles.add(new Vehicle("Toyota", "Prius", 2014, "CLEANCAR5"));
    vehicles.add(new Vehicle("BMW", "i3", 2016, "CZ56A56"));

    Comparator<Vehicle> model = new Comparator<Vehicle>(){
      @Override
      public int compare(Vehicle v1, Vehicle v2) {
        return v1.getModel().compareTo(v2.getModel()); }
    };

    Comparator<Vehicle> licensePlate = new Comparator<Vehicle>(){
      @Override
      public int compare(Vehicle v1, Vehicle v2) {
        return v1.getLicensePlate().compareTo(v2.getLicensePlate()); }
    };

    //prints out on the console the number of "Honda" and "Toyota" vehicles, produced after 2015.
    System.out.println(vehicles.stream().filter(vehicle -> vehicle.getMake().equals("Honda")
        || vehicle.getMake().equals("Toyota")).filter(vehicle -> vehicle.getYear() > 2015).count());
  } }

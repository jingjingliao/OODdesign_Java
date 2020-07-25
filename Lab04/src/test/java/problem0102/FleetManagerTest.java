package problem0102;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FleetManagerTest {
  FleetManager manager;
  Vehicle vehicle1;
  Vehicle vehicle2;

  TripReport report;
  TripReport report2;

  TripReport sameReport;
  TripReport diffReport;

  @Before
  public void setUp() throws Exception {
    vehicle1 = new Bus("111", 10f, 20f);
    vehicle2 = new Boat("222", 10f, 20f);
    manager = new FleetManager();

    report = new TripReport(vehicle1, 10f, 20f, 2);
    report2 = new TripReport(vehicle2, 10f, 20f, 2);

    sameReport = new TripReport(vehicle1, 10f, 20f, 2);
    diffReport = new TripReport(vehicle1, 10f, 20f, 4);
  }

  @Test
  public void busDrive() {
    TripReport report = new TripReport(vehicle1, 10f, 20f, 2);
    assertEquals(manager.drive(20f, vehicle1), report);
  }

  @Test
  public void BoatDrive() {
    TripReport report = new TripReport(vehicle2, 10f, 20f, 2);
    assertEquals(manager.drive(20f, vehicle2), report);
  }

  @Test
  public void overloadingBoatDrive1() {
    TripReport report = new TripReport(vehicle2, 10f, 20f, 2);
    assertEquals(manager.drive(20f, vehicle2, 10f), report);
  }

  @Test
  public void overspeedBoatDrive1() {
    TripReport report = new TripReport(vehicle2, 20f, 20f, 1);
    assertEquals(manager.drive(20f, vehicle2, 100f), report);
  }

  @Test
  public void overspeedBoatDrive2() {
    TripReport report = new TripReport(vehicle2, 20f, 20f, 1);
    assertEquals(manager.drive(100f, vehicle2, 1), report);
  }

  @Test
  public void equals() {
    assertFalse(report.equals(null));
    assertTrue(report.equals(sameReport));
    TripReport diffReport = new TripReport(vehicle2, 10f, 20f, 2);
    assertFalse(report.equals(diffReport));
  }

  @Test
  public void hashcode() {
    assertTrue(report.hashCode() == sameReport.hashCode());
  }

}
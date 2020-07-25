package problem1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VehicleTest {
    Vehicle vehicle1;
    Owner owner1;

    @Before
    public void setUp() throws Exception {
        owner1 = new Owner("Lisa", "White", "1112223334");
        vehicle1 = new Vehicle(123, "ABC", owner1 );
    }

    @Test
    public void getVIN() {
        assertEquals(123, vehicle1.getVIN());
    }

    @Test
    public void getLicensePlate() {
        assertEquals("ABC", vehicle1.getLicensePlate());
    }

    @Test
    public void getOwner(){
        assertEquals(owner1, vehicle1.getOwner());
    }

    @Test
    public void setVIN() {
        vehicle1.setVIN(333);
        assertEquals(333, vehicle1.getVIN());
    }

    @Test
    public void setLicensePlate() {
        vehicle1.setLicensePlate("AAA");
        assertEquals("AAA", vehicle1.getLicensePlate());
    }

    @Test
    public void setOwner(){
        Owner newOwner = new Owner("Lisa", "White", "1112223334");
        vehicle1.setOwner(newOwner);
        assertEquals(newOwner, vehicle1.getOwner());
    }
}
package problem1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class OwnerTest {
    Owner owner1;
    Owner owner2;


    @Before
    public void setUp() throws Exception {
        owner1 = new Owner("Jingjing", "Liao", "2222222222");
        owner2 = new Owner("Alicia", "Wang", "111111");
    }

    @Test
    public void getFirstName() {
        assertEquals("Jingjing", owner1.getFirstName());
    }

    @Test
    public void getLastName() {
        assertEquals("Liao", owner1.getLastName());
    }

    @Test
    public void getPhoneNumber(){
        assertEquals("2222222222", owner1.getPhoneNumber());
    }

    @Test
    public void setFirstName() {
        owner1.setFirstName("A");
        assertEquals("A", owner1.getFirstName());
    }

    @Test
    public void setLastName() {
        owner1.setLastName("Owner");
        assertEquals("Owner", owner1.getLastName());
    }

    @Test
    public void invalidPhoneNumber() {
        assertEquals("Invalid phone number", owner2.getPhoneNumber());
    }

    @Test
    public void setPhoneNumber(){
        owner1.setPhoneNumber("1234567890");
        assertEquals("1234567890", owner1.getPhoneNumber());

        owner2.setPhoneNumber("00000");
        assertEquals("Invalid phone number", owner2.getPhoneNumber());
    }
}
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddressTest {
    Address address1;
    Address address2;

    @Before
    public void setUp() throws Exception {
        address1 = new Address("123", "Fenghua", "Zhejiang", "ZJ", "35042", "CHN");
        address2 = new Address("401", "Terry", "Seattle", "WA", "98052", "USA");
    }


    @Test
    public void getStreetNumber() {
        assertEquals("123", address1.getStreetNumber());
        assertEquals("401", address2.getStreetNumber());
    }

    @Test
    public void getStreetName() {
        assertEquals("Fenghua", address1.getStreetName());
        assertEquals("Terry", address2.getStreetName());
    }

    @Test
    public void getCityName() {
        assertEquals("Zhejiang", address1.getCityName());
        assertEquals("Seattle", address2.getCityName());

    }

    @Test
    public void getStateAcronym() {
        assertEquals("ZJ", address1.getStateAcronym());
        assertEquals("WA", address2.getStateAcronym());
    }

    @Test
    public void getZipCode() {
        assertEquals("35042", address1.getZipCode());
        assertEquals("98052", address2.getZipCode());
    }

    @Test
    public void getCountryName() {
        assertEquals("CHN", address1.getCountryName());
        assertEquals("USA", address2.getCountryName());
    }
}
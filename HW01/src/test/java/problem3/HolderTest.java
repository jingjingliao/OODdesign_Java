package problem3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HolderTest {
    Holder jingjing;

    @Before
    public void setUp() throws Exception {
        jingjing = new Holder("Jingjing", "Ken");
    }

    @Test
    public void getFirstName() {
        assertEquals("Jingjing", jingjing.getFirstName());
    }

    @Test
    public void getLastName() {
        assertEquals("Ken", jingjing.getLastName());
    }

    @Test
    public void setFirstName() {
        jingjing.setFirstName("Moor");
        assertEquals("Moor", jingjing.getFirstName());
    }

    @Test
    public void setLastName() {
        jingjing.setLastName("Woor");
        assertEquals("Woor", jingjing.getLastName());
    }
}
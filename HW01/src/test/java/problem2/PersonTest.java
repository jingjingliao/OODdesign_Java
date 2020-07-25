package problem2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {
    Person jingjing;

    @Before
    public void setUp() throws Exception {
        jingjing = new Person("Jingjing", "White");
    }

    @Test
    public void getFirstName() {
        assertEquals("Jingjing", jingjing.getFirstName());
    }

    @Test
    public void getLastName() {
        assertEquals("White", jingjing.getLastName());
    }

    @Test
    public void setFirstName() {
        jingjing.setFirstName("Sophie");
        assertEquals("Sophie", jingjing.getFirstName());
    }

    @Test
    public void setLastName() {
        jingjing.setLastName("Black");
        assertEquals("Black", jingjing.getLastName());
    }
}
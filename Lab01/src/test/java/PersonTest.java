import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonTest {
    Person Jingjing;
    Person Alicia;

    @Before
    public void setUp() throws Exception {
        Jingjing = new Person("Jingjing", "Liao");
        Alicia = new Person("Alicia", "Zeng");
    }

    @Test
    public void getFirstName() {
        assertEquals("Jingjing", Jingjing.getFirstName());
        assertEquals("Alicia", Alicia.getFirstName());
    }

    @Test
    public void getLastName() {
        assertEquals("Liao", Jingjing.getLastName());
        assertEquals("Zeng", Alicia.getLastName());
    }
}
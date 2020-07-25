package onlineForms;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RadioButtonTest {
    IValidator rb;
    @Before
    public void setUp() throws Exception {
        rb = new RadioButton();
    }

    @Test
    public void isValid() {
        assertTrue(rb.isValid(true));
        assertTrue(rb.isValid(false));
        assertTrue(!rb.isValid(null));
    }

    @Test
    public void testEquals() {
        assertTrue(rb.equals(rb));
        assertTrue(!rb.equals(null));
        assertTrue(!rb.equals("string"));
        assertTrue(rb.equals(new RadioButton()));
    }

    @Test
    public void testHashCode() {
        assertEquals(new RadioButton().hashCode(), rb.hashCode());
    }

    @Test
    public void testToString() {
        assertEquals("RadioButton{}", rb.toString());
    }
}
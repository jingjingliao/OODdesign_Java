package onlineForms;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CheckBoxTest {
    IValidator checkBox;

    @Before
    public void setUp() throws Exception {
        checkBox = new CheckBox();
    }

    @Test
    public void isValid() {
        assertTrue(checkBox.isValid(true));
        assertTrue(checkBox.isValid(false));
        assertTrue(checkBox.isValid(null));
    }

    @Test
    public void testHashCode() {
        assertEquals(42, checkBox.hashCode());
    }

    @Test
    public void testEquals() {
        assertTrue(checkBox.equals(checkBox));
        assertFalse(checkBox.equals(null));
        assertFalse(checkBox.equals(1));
        assertTrue(checkBox.equals(new CheckBox()));
    }

    @Test
    public void testToString() {
        assertEquals("CheckBox{}", checkBox.toString());
    }
}
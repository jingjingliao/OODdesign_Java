package onlineForms;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PasswordTest {
    IValidator pwDefault;
    IValidator pwCustom;
    @Before
    public void setUp() throws Exception {
        pwDefault = new Password(3,10);
        pwCustom = new Password(3, 10, 1, 1,1);
    }

    @Test
    public void isValid() {
        assertFalse(pwDefault.isValid("d"));
        assertFalse(pwDefault.isValid("Seven7ElevenTooLong"));
        assertTrue(pwDefault.isValid("valid"));
        assertFalse(pwDefault.isValid("not valid"));
        assertFalse(pwCustom.isValid("d"));
        assertFalse(pwCustom.isValid("Seven7ElevenTooLong"));
        assertFalse(pwCustom.isValid("ALL9UPPER"));
        assertFalse(pwCustom.isValid("all9lower"));
        assertFalse(pwCustom.isValid("NoDigits"));
        assertTrue(pwCustom.isValid("validP12"));
    }

    @Test
    public void testEquals() {
        assertTrue(pwCustom.equals(pwCustom));
        assertTrue(!pwCustom.equals(null));
        assertTrue(!pwCustom.equals("pwCustom"));
        assertTrue(pwCustom.equals(new Password(3, 10, 1, 1, 1)));
        assertTrue(!pwCustom.equals(new Password(2, 10, 1, 1, 1)));
        assertTrue(!pwCustom.equals(new Password(3, 9, 1, 1, 1)));
        assertTrue(!pwCustom.equals(new Password(3, 10, 0, 1, 1)));
        assertTrue(!pwCustom.equals(new Password(3, 10, 1, 0, 1)));
        assertTrue(!pwCustom.equals(new Password(3, 10, 1, 1, 0)));



    }

    @Test
    public void testHashCode() {
        assertEquals(new Password(3, 10).hashCode(), pwDefault.hashCode());
    }

    @Test
    public void testToString() {
        assertEquals("Password{minLength=3, maxLength=10, minNumLowerCase=0, minNumUpperCase=0, minDigits=0}",
                pwDefault.toString());
    }
}
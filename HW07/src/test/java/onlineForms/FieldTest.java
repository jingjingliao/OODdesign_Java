package onlineForms;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FieldTest {
    Field f;
    IValidator password;

    @Before
    public void setUp() throws Exception {
        password = new Password(3, 10, 0, 1, 1);
        f = new Field<>("password", true, password);
    }

    @Test
    public void updateValue() throws InvalidInputException{
        f.updateValue("0123Valid");
        assertEquals("0123Valid", f.getValue());
    }

    @Test(expected=InvalidInputException.class)
    public void invalidUpdateValue() throws InvalidInputException{
        f.updateValue("0 notValid");
    }

    @Test
    public void isFilled() throws InvalidInputException{
        f.updateValue("0123Valid");
        assertTrue(f.isFilled());
        IValidator rb = new RadioButton();
        f = new Field<>("RadioButton", false, rb);
        assertTrue(f.isFilled());
    }

    @Test
    public void testEquals() throws InvalidInputException{
        assertTrue(f.equals(f));
        assertTrue(!f.equals(null));
        assertTrue(!f.equals(""));
        Field f2 = new Field<>("password", true, password);
        assertTrue(f.equals(f2));
        f.updateValue("0123Valid");
        f2.updateValue("0123Valid");
        assertTrue(f.equals(f2));
        f = new Field<>("password", true, password);
        assertTrue(!f.equals(f2));
        assertTrue(!f.equals(new Field<>("label", true, password)));
        assertTrue(!f.equals(new Field<>("password", false, password)));
        f2 = new Field<>("password", true, new CheckBox());
        f = new Field<>("password", true, password);
        assertTrue(!f.equals(f2));
    }

    @Test
    public void testHashCode() {
        assertEquals(new Field<>("password", true, password).hashCode(), f.hashCode());
    }

    @Test
    public void testToString() {
        assertEquals("Field{label='password', value=null, required=true, validator=Password{minLength=3, " +
                "maxLength=10, minNumLowerCase=0, minNumUpperCase=1, minDigits=1}}", f.toString());
    }
}
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AuthorTest {
    Author author1;
    Person jingjing;
    Email email;
    Address address;

    @Before
    public void setUp() throws Exception {
        jingjing = new Person("Jingjing", "Liao");
        email = new Email("jingjing", "gmail.com");
        address = new Address("123", "Jerry", "Bellevue", "WA",
                "80008", "USA");
        author1 = new Author(jingjing, email, address);
    }

    @Test
    public void getName() {
        assertEquals("Jingjing Liao", author1.getName());
    }

    @Test
    public void getEmail() {
        assertEquals("jingjing@gmail.com", author1.getEmail());

    }

    @Test
    public void getAddress() {
        assertEquals("123 Jerry, Bellevue, WA 80008, USA", author1.getAddress());

    }
}
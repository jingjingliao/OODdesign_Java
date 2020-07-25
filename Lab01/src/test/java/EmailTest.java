import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmailTest {
    Email googleEmail;
    Email qqEmail;


    @Before
    public void setUp() throws Exception {
        googleEmail = new Email("joe", "google.com");
        qqEmail = new Email("Sophie", "qq.com");

    }

    @Test
    public void getLoginName() {
        assertEquals("joe", googleEmail.getLoginName());
        assertEquals("Sophie", qqEmail.getLoginName());
    }

    @Test
    public void getDomainName() {
        assertEquals("google.com", googleEmail.getDomainName());
        assertEquals("qq.com", qqEmail.getDomainName());
    }
}
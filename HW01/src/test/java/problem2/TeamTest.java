package problem2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TeamTest {
    Team team;

    @Before
    public void setUp() throws Exception {
        team = new Team("Eagle");
    }

    @Test
    public void getName() {
        assertEquals("Eagle", team.getName());
    }

    @Test
    public void setName() {
        team.setName("Spider");
        assertEquals("Spider", team.getName());
    }
}
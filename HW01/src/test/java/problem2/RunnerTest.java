package problem2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RunnerTest {
    Runner runner;
    Person andy;
    Team team;
    Time startTime;
    Time endTime;


    @Before
    public void setUp() throws Exception {
        andy = new Person("Andy", "Wang");
        team = new Team ("Tiger Team");
        startTime = new Time(3,50,20);
        endTime = new Time(7,25,10);
        runner = new Runner(andy, team, startTime, endTime);
    }

    @Test
    public void getName() {
        assertEquals(andy, runner.getName());
    }

    @Test
    public void getTeam() {
        assertEquals(team, runner.getTeam());
    }

    @Test
    public void getStartTime() {
        assertEquals(startTime, runner.getStartTime());
    }

    @Test
    public void getEndTime() {
        assertEquals(endTime, runner.getEndTime());
    }

    @Test
    public void setName() {
        Person collin = new Person("Collin", "Smith");
        runner.setName(collin);
        assertEquals(collin, runner.getName());
    }

    @Test
    public void setTeam() {
        Team team000 = new Team("Forest");
        runner.setTeam(team000);
        assertEquals(team000, runner.getTeam());
    }

    @Test
    public void setStartTime() {
        Time newStartTime = new Time(1,1,1);
        runner.setStartTime(newStartTime);
        assertEquals(newStartTime, runner.getStartTime());
    }

    @Test
    public void setEndTime() {
        Time newEndTime = new Time(5,5,5);
        runner.setEndTime(newEndTime);
        assertEquals(newEndTime, runner.getEndTime());
    }

    @Test
    public void getDuration() {
        Time time = runner.getDuration();
        assertEquals(3,time.getHour());
        assertEquals(34, time.getMinutes());
        assertEquals(50, time.getSeconds());
    }
}
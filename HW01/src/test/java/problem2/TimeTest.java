package problem2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TimeTest {
    Time time1;
    Time invalidTime1;
    Time invalidTime2;

    @Before
    public void setUp() throws Exception {
        time1 = new Time(4,25,30);
        invalidTime1 = new Time(-100, -5, -10);
        invalidTime2 = new Time(200, 300, 400);
    }

    @Test
    public void getHour() {
        assertEquals(4, time1.getHour());
    }

    @Test
    public void getMinutes() {
        assertEquals(25, time1.getMinutes());
    }

    @Test
    public void getSeconds() {
        assertEquals(30, time1.getSeconds());
    }

    @Test
    public void setHour() {
        time1.setHour(10);
        assertEquals(10, time1.getHour());
    }

    @Test
    public void setMinutes() {
        time1.setMinutes(2);
        assertEquals(2, time1.getMinutes());
    }

    @Test
    public void setSeconds() {
        time1.setSeconds(45);
        assertEquals(45, time1.getSeconds());
    }

    @Test
    public void invalidHour() {
        assertEquals(-1, invalidTime1.getHour());
        assertEquals(-1, invalidTime2.getHour());
    }

    @Test
    public void invalidMinutes() {
        assertEquals(-1, invalidTime1.getMinutes());
        assertEquals(-1, invalidTime2.getMinutes());
    }

    @Test
    public void invalidSeconds() {
        assertEquals(-1, invalidTime1.getSeconds());
        assertEquals(-1, invalidTime2.getSeconds());
    }


    @Test
    public void convertToSeconds() {
        assertEquals(15930, time1.convertToSeconds());
    }

    @Test
    public void convertToTime() {
        int totaTime = time1.convertToSeconds();
        Time time = Time.convertToTime(totaTime);
        assertEquals(time1.getSeconds(), time.getSeconds());
        assertEquals(time1.getMinutes(), time.getMinutes());
        assertEquals(time1.getHour(), time.getHour());
    }
}
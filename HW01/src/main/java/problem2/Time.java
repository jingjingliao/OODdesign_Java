package problem2;

/**
 * This class represents the time which has hour, minutes and seconds
 */
public class Time {
    private int hour;
    private int minutes;
    private int seconds;
    private static final int MIN_TIME = 0;
    private static final int MAX_HOUR = 23;
    private static final int MAX_MINUTES_SECONDS = 59;
    private static final int INVALID_TIME = -1;
    private static final int HOUR_TO_SECOND = 3600;
    private static final int HOUR_TO_MINUTES = 60;

    /**
     * Constructs a Time object and initializes it with the given hour, minutes and seconds
     * @param hour hour of the time
     * @param minutes minutes of the time
     * @param seconds seconds of the time
     */
    public Time(int hour, int minutes, int seconds){
        this.hour = this.validHour(hour);
        this.minutes = this.validMinutes(minutes);
        this.seconds = this.validSeconds(seconds);
    }

    /**
     * Helper method that ensures the hour is valid (within 0 and 23),
     * if it is invalid, return -1
     * @param hour hour of the time
     * @return hour if it is valid, otherwise return -1
     */
    private int validHour(int hour) {
        if (hour >= MIN_TIME && hour <= MAX_HOUR) {
            return hour;
        } else {
            return INVALID_TIME;
        }
    }

    /**
     * Helper method that ensures the minutes is valid (within 0 and 59),
     * if it is invalid, return -1
     * @param minutes minutes of the time
     * @return minutes if it is valid, otherwise return -1
     */
    private int validMinutes(int minutes) {
        if (minutes >= MIN_TIME && minutes <= MAX_MINUTES_SECONDS) {
            return minutes;
        } else {
            return INVALID_TIME;
        }
    }

    /**
     * Helper method that ensures the seconds is valid (within 0 and 59),
     * if it is invalid, return -1
     * @param seconds seconds of the time
     * @return seconds if it is valid, otherwise return -1
     */
    private int validSeconds(int seconds) {
        if (seconds >= MIN_TIME && seconds <= MAX_MINUTES_SECONDS) {
            return seconds;
        } else {
            return INVALID_TIME;
        }
    }

    /**
     * Get the hour of the time
     * @return the hour of the time
     */
    public int getHour(){
        return this.hour;
    }

    /**
     * Get the minutes of the time
     * @return the minutes of the time
     */
    public int getMinutes(){
        return this.minutes;
    }

    /**
     * Get the seconds of the time
     * @return the seconds of the time
     */
    public int getSeconds(){
        return this.seconds;
    }

    /**
     * Set the hour
     * @param hour new hour
     */
    public void setHour(int hour){
        this.hour = hour;
    }

    /**
     * Set the minutes
     * @param minutes new minutes
     */
    public void setMinutes(int minutes){
        this.minutes = minutes;
    }

    /**
     * Set the seconds
     * @param seconds new seconds
     */
    public void setSeconds(int seconds){
        this.seconds = seconds;
    }

    /**
     * Helper function to convert the hour, minutes to seconds
     * @return the total seconds
     */
    public int convertToSeconds(){
        return this.hour * HOUR_TO_SECOND + this.minutes * HOUR_TO_MINUTES + this.seconds;
    }

    /**
     * The function to convert the total seconds to hour, minutes and seconds
     * @param totalTime the total seconds
     * @return time object with hour, minutes and seconds
     */
    public static Time convertToTime(int totalTime){
        int hour = totalTime / HOUR_TO_SECOND;
        int minutes = (totalTime % HOUR_TO_SECOND) / HOUR_TO_MINUTES;
        int seconds = (totalTime % HOUR_TO_SECOND) % HOUR_TO_MINUTES;
        return new Time(hour, minutes, seconds);
    }
}

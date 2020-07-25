package problem2;

/**
 * This class represents the runner who has the name, the team's name,
 * start time and end time
 */
public class Runner {
    private Person name;
    private Team team;
    private Time startTime;
    private Time endTime;

    /**
     * Constructs a runner object and initializes it with the given name, team's name
     * start time and end time
     * @param name the name of the runner
     * @param team the team's name of the runner
     * @param startTime the start time of marathon of this runner
     * @param endTime the end time of marathon of this runner
     */
    public Runner(Person name, Team team, Time startTime, Time endTime){
        this.name = name;
        this.team = team;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * Get the name of this runner
     * @return the name of this runner
     */
    public Person getName(){
        return this.name;
    }

    /**
     * Get the team's name of this runner
     * @return the team's name
     */
    public Team getTeam(){
        return this.team;
    }

    /**
     * Get the start time of this runner
     * @return the start time of this runner
     */
    public Time getStartTime(){
        return this.startTime;
    }

    /**
     * Get the end time of this runner
     * @return the end time of this runner
     */
    public Time getEndTime(){
        return this.endTime;
    }

    /**
     * Set the name of the runner
     * @param name set the new name
     */
    public void setName(Person name){
        this.name = name;
    }

    /**
     * Set the team's name of this runner
     * @param team set the new team name
     */
    public void setTeam(Team team){
        this.team = team;
    }

    /**
     * Set the start time of this runner
     * @param startTime set the new start time
     */
    public void setStartTime(Time startTime){
        this.startTime = startTime;
    }

    /**
     * Set the end time of this runner
     * @param endTime set the new end time
     */
    public void setEndTime(Time endTime){
        this.endTime = endTime;
    }

    /**
     * Get the total time the runner took to complete marathon
     * @return time object for the total time to complete marathon
     */
    public Time getDuration(){
        int totalTime = this.endTime.convertToSeconds() - this.startTime.convertToSeconds();
        return Time.convertToTime(totalTime);
    }
}

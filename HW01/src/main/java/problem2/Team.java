package problem2;

/**
 * This class represents a team which has a team name
 */
public class Team {
    private String name;

    /**
     * Constructs a Team object and initializes it with the given team name
     * @param name the name of this team
     */
    public Team(String name){
        this.name = name;
    }

    /**
     * Get the name of this team
     * @return the name of this team
     */
    public String getName(){
        return this.name;
    }

    /**
     * Set the name of this team
     * @param name set the name of this team
     */
    public void setName(String name){
        this.name = name;
    }
}

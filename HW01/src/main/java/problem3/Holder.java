package problem3;

/**
 * This class represents the holder which has first name and last name
 */
public class Holder {
    private String firstName;
    private String lastName;

    /**
     * Constructs a holder object and initializes it with the given first name and last name
     * @param firstName first name of the holder
     * @param lastName last name of the holder
     */
    public Holder(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Get the first name
     * @return the first name
     */
    public String getFirstName(){
        return this.firstName;
    }

    /**
     * Get the last name
     * @return the last name
     */
    public String getLastName(){
        return this.lastName;
    }

    /**
     * Set the first name
     * @param firstName new first name
     */
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    /**
     * Set the last name
     * @param lastName new last name
     */
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
}

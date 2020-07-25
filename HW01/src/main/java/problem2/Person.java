package problem2;

/**
 * This class represents a person which has a first name and last name
 */
public class Person {
    private String firstName;
    private String lastName;

    /**
     * Constructs an Person object and initializes it with the given first
     * name, and last name
     * @param firstName the first name of this person
     * @param lastName the last name of this person
     */
    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Get the first name of this person
     * @return the first name of this person
     */
    public String getFirstName(){
        return this.firstName;
    }

    /**
     * Get the last name of this person
     * @return the last name of this person
     */
    public String getLastName(){
        return this.lastName;
    }

    /**
     * Set the first name of this person
     * @param firstName the new first name
     */
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    /**
     * Set the last name of this person
     * @param lastName the new last Name
     */
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
}

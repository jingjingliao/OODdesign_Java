/**
 * Represents an Person with their details--first name and last name *
 * @author jingjing
 *
 */
public class Person {
    private String firstName;
    private String lastName;

    /**
     * @param firstName the person's first name
     * @param lastName the person's last name
     */
    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * @return the first name
     */
    public String getFirstName(){
        return this.firstName;
    }

    /**
     * @return the last name
     */
    public String getLastName(){
        return this.lastName;
    }
}

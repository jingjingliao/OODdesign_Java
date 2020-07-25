package problem1;

/**
 * This class represnts an owner. The owner has a first name, last name and phone number
 */
public class Owner {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private static final int VALID_PHONE_LENGTH = 10;

    /**
     * Constructs an Owner object and initializes it with the given first name, last name,
     * and the phone number
     * @param firstName the first name of the owner
     * @param lastName the last name of the owner
     * @param phoneNumber the phone number of the owner
     */
    public Owner(String firstName, String lastName, String phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = this.validPhoneNumber(phoneNumber);
    }

    /** Helper method that ensures the length of the phone number is valid, if the number if valid
     * the invalid phone message will be returned
     * @param phoneNumber the phone number
     * @return the phone number if it is valid, otherwise return invalid phone message
     */
    private String validPhoneNumber(String phoneNumber){
        if (phoneNumber.length() == VALID_PHONE_LENGTH){
            return phoneNumber;
        }else{
            return "Invalid phone number";
        }
    }

    /**
     * get the first name of this owner
     * @return the first name of this owner
     */
    public String getFirstName(){
        return this.firstName;
    }

    /**
     * get the last name of this owner
     * @return the last name of this owner
     */
    public String getLastName(){
        return this.lastName;
    }

    /**
     * return the phone number of this owner
     * @return the phone number of this owner
     */
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    /**
     * Sets the owner's first name
     * @param firstName firstName the new first name
     */
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    /**
     * Sets the owner's last name
     * @param lastName lastName the new last name
     */
    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = this.validPhoneNumber(phoneNumber);
    }
}

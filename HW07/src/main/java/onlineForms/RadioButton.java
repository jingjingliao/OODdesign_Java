package onlineForms;

/**
 * Represents a RadioButton Validator
 */
public class RadioButton implements IValidator<Boolean>{
    /**
     * Validates the input value. The input value is valid if it's either true of false, but not null
     * @param input the user input to be validated
     * @return true if the input meets the above requirement, false otherwise
     */
    @Override
    public boolean isValid(Boolean input) {
        return input != null;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        return o != null && o.getClass() == getClass();

    }

    @Override
    public int hashCode() {
        return 47;
    }

    @Override
    public String toString() {
        return "RadioButton{}";
    }
}

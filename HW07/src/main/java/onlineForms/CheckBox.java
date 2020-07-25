package onlineForms;

/**
 * Represents a  CheckBox Validator
 */
public class CheckBox implements IValidator<Boolean> {
    /**
     * Validates the input value. The input is valid if it's true, false or a null value.
     * @param input the user input to be validated
     * @return true if the input meets the above requirement, false otherwise
     */
    @Override
    public boolean isValid(Boolean input) {
        return true;
    }

    @Override
    public int hashCode() {
        return 42;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        return o != null && o.getClass() == getClass();
    }

    @Override
    public String toString() {
        return "CheckBox{}";
    }
}

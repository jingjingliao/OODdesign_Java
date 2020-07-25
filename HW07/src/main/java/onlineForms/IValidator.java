package onlineForms;

/**
 * An interface for Validator
 * @param <T> The object type of input value corresponding to different types of validator
 */
public interface IValidator<T> {
    /**
     * Checks if the input is valid
     * @param input the user input to be validated
     * @return true if the input is valid, false otherwise
     */
    boolean isValid(T input);
}

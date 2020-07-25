package onlineForms;

import java.util.Objects;

/**
 * Represents a Field class
 * @param <T> The object type of Field's value corresponding to Field's validator
 */
public class Field<T> {
    /**
     * Field's label
     */
    private String label;
    /**
     * Field's value
     */
    private T value;
    /**
     * Indicates if this Field is required
     */
    private boolean required;
    /**
     * Field's validator
     */
    private IValidator validator;

    /**
     * Constructs a Field given its label, if it is required and its validator; Field's value is set to null by default
     * @param label Field's label
     * @param required Indicates if this Field is required
     * @param validator Field's validator
     */
    public Field(String label, boolean required, IValidator validator) {
        this.label = label;
        this.value = null;
        this.required = required;
        this.validator = validator;
    }

    /**
     * Update the ​Field​’s ​value​ if the ​input​ is valid according to the ​validator​
     * @param value the value to be updated
     * @throws InvalidInputException thrown if ​input​ is not valid
     */
    public void updateValue(T value) throws InvalidInputException{
        if(!validator.isValid(value)) throw new InvalidInputException("Invalid input!");
        this.value = value;
    }

    /**
     * Returns this Field's value
     * @return this Field's value
     */
    public T getValue() {
        return this.value;
    }

    /**
     * Checks if the ​Field​ has been filled out
     * @return true if the ​Field​ is required and its value meets the requirements specified by its validator, or the ​
     * Field​ is optional (it does not matter what the ​Field​’s value is in this case; false otherwise
     */
    public boolean isFilled(){
        return (this.required && this.validator.isValid(value)) || !this.required;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Field<?> field = (Field<?>) o;
        return required == field.required &&
                label.equals(field.label) &&
                Objects.equals(value, field.value) &&
                validator.equals(field.validator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, value, required, validator);
    }

    @Override
    public String toString() {
        return "Field{" +
                "label='" + label + '\'' +
                ", value=" + value +
                ", required=" + required +
                ", validator=" + validator +
                '}';
    }
}

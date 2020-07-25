package onlineForms;

import java.util.Objects;

/**
 * Represents a Password Validator
 */
public class Password implements IValidator<String> {
    /**
     * Minimum length of the password
     */
    private int minLength;
    /**
     * Maximum length of the password
     */
    private int maxLength;
    /**
     * Minimum number of lowercase letters in the password
     */
    private int minNumLowerCase;
    /**
     * Minimum number of uppercase letters in the password
     */
    private int minNumUpperCase;
    /**
     * Minimum number of digits in the password
     */
    private int minDigits;

    /**
     * Constructs a Password Validator given the password required minimum length and maximum length; other requirements
     * are set to be 0 by default
     * @param minLength Minimum length of the password
     * @param maxLength Maximum length of the password
     */
    public Password(int minLength, int maxLength) {
        this.minLength = minLength;
        this.maxLength = maxLength;
        this.minNumLowerCase = 0;
        this.minNumUpperCase = 0;
        this.minDigits = 0;
    }

    /**
     * Constructs a Password Validator given the password required minimum length, maximum length, minimum number of
     * lowercase letters, minimum number of uppercase letters, minimum number of digits
     * @param minLength Minimum length of the password
     * @param maxLength Maximum length of the password
     * @param minNumLowerCase  Minimum number of lowercase letters in the password
     * @param minNumUpperCase Minimum number of uppercase letters in the password
     * @param minDigits Minimum number of digits in the password
     */
    public Password(int minLength, int maxLength, int minNumLowerCase, int minNumUpperCase, int minDigits) {
        this.minLength = minLength;
        this.maxLength = maxLength;
        this.minNumLowerCase = minNumLowerCase;
        this.minNumUpperCase = minNumUpperCase;
        this.minDigits = minDigits;
    }
    /**
     * Checks if the input is valid; the input is valid if the password is longer or equal to minimum length and
     * does not exceed the maximum length, contains more or equal to the minimum number of lowercase/uppercase letters and
     * minimum of digits, and does not contain any space.
     * @param input the user input to be validated
     * @return true if the input meets the above requirement, false otherwise
     */
    @Override
    public boolean isValid(String input) {
        if (input.length() < this.minLength || input.length() > this.maxLength) return false;
        if (input.contains(" ")) return false;
        char[] characters = input.toCharArray();
        if(!validateNumLowerCase(characters) || !validateNumUpperCase(characters)) return false;
        if(!validateNumDigits(characters)) return false;
        return true;

    }

    /**
     * Validates if the number of lowercase letters in password are more or equal to the minimum required number
     * @param input the password to be validated
     * @return true if the lowercase letters in password meet the requirement, false otherwise
     */
    private boolean validateNumLowerCase(char[] input){
        int count = 0;
        for(char c : input){ if(Character.isLowerCase(c)) count++; }
        return count >= this.minNumLowerCase;
    }

    /**
     * Validates if the number of uppercase letters in password are more or equal to the minimum required number
     * @param input the password to be validated
     * @return true if the uppercase letters in password meet the requirement, false otherwise
     */
    private boolean validateNumUpperCase(char[] input){
        int count = 0;
        for(char c : input){ if(Character.isUpperCase(c)) count++; }
        return count >= this.minNumUpperCase;
    }

    /**
     * Validates if the number of digits in password is more or equal to the minimum required number
     * @param input the password to be validated
     * @return true if the digits in password meet the requirement, false otherwise
     */
    private boolean validateNumDigits(char[] input){
        int count = 0;
        for(char c : input){ if(Character.isDigit(c)) count++; }
        return count >= this.minDigits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Password password = (Password) o;
        return minLength == password.minLength &&
                maxLength == password.maxLength &&
                minNumLowerCase == password.minNumLowerCase &&
                minNumUpperCase == password.minNumUpperCase &&
                minDigits == password.minDigits;
    }

    @Override
    public int hashCode() {
        return Objects.hash(minLength, maxLength, minNumLowerCase, minNumUpperCase, minDigits);
    }

    @Override
    public String toString() {
        return "Password{" +
                "minLength=" + minLength +
                ", maxLength=" + maxLength +
                ", minNumLowerCase=" + minNumLowerCase +
                ", minNumUpperCase=" + minNumUpperCase +
                ", minDigits=" + minDigits +
                '}';
    }
}

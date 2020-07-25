package problem3;

/**
 * This class represents the amount which has dollar and cents
 */
public class Amount {
    private int dollar;
    private int cent;
    private static final int DOLLAR_TO_CENTS = 100;
    private static final int ZERO_AMOUNT = 0;
    private static final int MAX_CENT = 99;

    /**
     * Constructs an amount object and initializes it with the given dollar and cent
     * @param dollar dollar of the amount
     * @param cent cents of the amount
     */
    public Amount(int dollar, int cent){
        this.dollar = this.validDollar(dollar);
        this.cent = this.validCent(cent);
    }

    /**
     * Helper function to check whether the input dollar is valid
     * if it is not valid, return zero
     * @param dollar dollar of the amount
     * @return the dollar if it is valid, otherwise zero
     */
    private int validDollar(int dollar){
        if (dollar >= ZERO_AMOUNT){
            return dollar;
        }else{
            return ZERO_AMOUNT;
        }
    }

    /**
     * Helper function to check whether the input cents is valid
     * @param cent cents of the amount
     * @return cents if it valid, otherwise zero
     */
    private int validCent(int cent){
        if (cent >= ZERO_AMOUNT && cent <= MAX_CENT){
            return cent;
        }else{
            return ZERO_AMOUNT;
        }
    }

    /**
     * Get dollar of the amount
     * @return dollar of the amount
     */
    public int getDollar(){
        return this.dollar;
    }

    /**
     * Get cents of the amount
     * @return cents of the amount
     */
    public int getCent(){
        return this.cent;
    }

    /**
     * Create an amount object with the different dollar, but the same cent
     * @param dollar the new dollar
     * @return a new amount object
     */
    public Amount changeDollar(int dollar){
        return new Amount(dollar, this.cent);
    }

    /**
     * Create an amount object with the different cents, but the same dollar
     * @param cents the new cents
     * @return a new amount object
     */
    public Amount changeCents(int cents){
        return new Amount(this.dollar, cents);
    }

    /**
     * Convert dollars to cents
     * @return the total cents
     */
    public int dollarToCents(){
        return this.dollar * DOLLAR_TO_CENTS + this.cent;
    }

    /**
     * Convert total cents to dollar and cents
     * @param totalCents total cents
     * @return the new amount object with dollar and cents
     */
    public static Amount convertToDollars(int totalCents){
        int dollar = totalCents / DOLLAR_TO_CENTS;
        int cents = totalCents % DOLLAR_TO_CENTS;
        return new Amount(dollar, cents);
    }
}

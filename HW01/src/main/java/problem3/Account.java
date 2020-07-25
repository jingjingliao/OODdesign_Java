package problem3;

/**
 * This class represents the account which has holder's name and amount
 */
public class Account {
    private Holder name;
    private Amount amount;

    /**
     * Constructs an account object and initializes it with the given name and amount
     * @param name the name of the account
     * @param amount the amount of the account
     */
    public Account(Holder name, Amount amount){
        this.name = name;
        this.amount = amount;
    }

    /**
     * Get the name of the account
     * @return the name of the account
     */
    public Holder getName(){
        return this.name;
    }

    /**
     * Get the amount of the account
     * @return the amount of the account
     */
    public Amount getAmount(){
        return this.amount;
    }

    /**
     * Create an account object with the different holder's name, but the same amount
     * @param name the new name of the account
     * @return a new account object
     */
    public Account changeName(Holder name){
        return new Account(name, this.amount);
    }

    /**
     * Create an account object with the different amount, but the same name
     * @param amount the new amount
     * @return a new account object
     */
    public Account changeAmount(Amount amount){
        return new Account(this.name, amount);
    }

    /**
     * @param deposit put the deposit into account
     * @return an amount object which has the total dollar and cents
     */
    public Amount deposit(Amount deposit){
        int totalAmount = amount.dollarToCents() + deposit.dollarToCents();
        return Amount.convertToDollars(totalAmount);
    }

    /**
     * @param withdraw withdraw some money out of the account
     * @return  an amount object shows how much dollars and cents left after withdrawing from account
     */
    public Amount withdraw(Amount withdraw){
        int totalAmount = amount.dollarToCents() - withdraw.dollarToCents();
        return Amount.convertToDollars(totalAmount);
    }
}


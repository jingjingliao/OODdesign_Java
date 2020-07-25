package problem3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {
    Account account;
    Holder name;
    Amount amount;

    @Before
    public void setUp() throws Exception {
        name = new Holder("A", "B");
        amount = new Amount(20, 20);
        account = new Account(name, amount);
    }

    @Test
    public void getName() {
        assertEquals(name, account.getName());
    }

    @Test
    public void getAmount() {
        assertEquals(amount, account.getAmount());
    }

    @Test
    public void changeName() {
        Holder newName = new Holder("Mark", "Twen");
        Account newAccount = account.changeName(newName);
        assertEquals(newName, newAccount.getName());
        assertEquals(name, account.getName());
    }

    @Test
    public void changeAmount() {
        Amount newAmount = new Amount(33, 66);
        Account newAccount = account.changeAmount(newAmount);
        assertEquals(newAmount, newAccount.getAmount());
        assertEquals(amount, account.getAmount());
    }

    @Test
    public void deposit() {
        Amount deposit = new Amount(10, 10);
        Amount total = account.deposit(deposit);
        assertEquals(30, total.getDollar());
        assertEquals(30, total.getCent());
    }

    @Test
    public void withdraw() {
        Amount withdraw = new Amount (15, 15);
        Amount total = account.withdraw(withdraw);
        assertEquals(5, total.getDollar());
        assertEquals(5, total.getCent());

    }
}
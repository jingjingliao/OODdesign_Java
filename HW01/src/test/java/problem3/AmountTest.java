package problem3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AmountTest {
    Amount amount;
    Amount invalidAmount;
    Amount invalidAmount1;
    Amount invalidAmount2;

    @Before
    public void setUp() throws Exception {
        amount = new Amount(20, 50);
        invalidAmount = new Amount(-20, -200);
        invalidAmount1 = new Amount(30, 500);
        invalidAmount2 = new Amount(-1, 25);

    }

    @Test
    public void getDollar() {
        assertEquals(20, amount.getDollar());
    }

    @Test
    public void getCent() {
        assertEquals(50, amount.getCent());
    }

    @Test
    public void changeDollar() {
        Amount newDollar = amount.changeDollar(111);
        assertEquals(111, newDollar.getDollar());
        assertEquals(20, amount.getDollar());
    }

    @Test
    public void changeCents() {
        Amount newCents = amount.changeCents(55);
        assertEquals(55, newCents.getCent());
        assertEquals(50, amount.getCent());
    }

    @Test
    public void invalidDollar(){
        assertEquals(0, invalidAmount.getDollar());
        assertEquals(30, invalidAmount1.getDollar());
        assertEquals(0, invalidAmount2.getDollar());
    }

    @Test
    public void invalidCents(){
        assertEquals(0, invalidAmount.getCent());
        assertEquals(0, invalidAmount1.getCent());
        assertEquals(25, invalidAmount2.getCent());
    }


    @Test
    public void dollarToCents() {
        assertEquals(2050, amount.dollarToCents());
    }

    @Test
    public void convertToDollars() {
        int totalCents = amount.dollarToCents();
        Amount newAmount = Amount.convertToDollars(totalCents);
        assertEquals(newAmount.getDollar(), amount.getDollar());
        assertEquals(newAmount.getCent(), amount.getCent());
    }
}
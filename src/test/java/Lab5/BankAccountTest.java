package Lab5;

import org.example.Lab5.BankAccount;
import org.example.Lab5.InsufficientFundsException;
import org.example.Lab5.NegativeAmountException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {
    private BankAccount account;

    @BeforeEach
    public void setup() {
        account = new BankAccount(1, "Oleksandr", 1000);
    }

    @Test
    public void testDeposit() throws NegativeAmountException {
        account.deposit(300);
        assertEquals(1300, account.getBalance());
    }

    @Test
    public void testWithdraw() throws InsufficientFundsException, NegativeAmountException {
        account.withdraw(800);
        assertEquals(200, account.getBalance());
    }

    @Test
    void testNegativeAmount() {
        double negativeAmount = -50;

        assertThrows(NegativeAmountException.class, () -> account.deposit(negativeAmount));
    }

    @Test
    void testBigAmount() {
        double bigAmount = 100000;

        assertThrows(InsufficientFundsException.class, () -> account.withdraw(bigAmount));
    }
}
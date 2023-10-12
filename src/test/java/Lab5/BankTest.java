package Lab5;

import org.example.Lab5.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankTest {
    @Test
    public void testCreateAccount() {
        Bank bank = new Bank();
        BankAccount account = bank.createAccount("Peter", 1280);
        assertNotNull(account);
    }

    @Test
    public void testFindAccount() throws AccountNotFoundException {
        Bank bank = new Bank();
        BankAccount account = bank.createAccount("Peter", 1280);
        BankAccount foundAccount = bank.findAccount(account.getAccountNumber());
        assertEquals(account, foundAccount);
    }

    @Test
    public void testTransferMoney() throws AccountNotFoundException, InsufficientFundsException, NegativeAmountException {
        Bank bank = new Bank();
        BankAccount account1 = bank.createAccount("Peter", 1280);
        BankAccount account2 = bank.createAccount("Den", 530);
        bank.transferMoney(account1.getAccountNumber(), account2.getAccountNumber(), 200);
        assertEquals(1080, account1.getBalance());
        assertEquals(730, account2.getBalance());
    }
}

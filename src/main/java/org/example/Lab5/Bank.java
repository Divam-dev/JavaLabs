package org.example.Lab5;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private final List<BankAccount> accounts = new ArrayList<>();

    public BankAccount createAccount(String accountName, double initialDeposit) {
        int accountNumber = accounts.size() + 1;
        BankAccount account = new BankAccount(accountNumber, accountName, initialDeposit);
        accounts.add(account);
        return account;
    }

    public BankAccount findAccount(int accountNumber) throws AccountNotFoundException {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        throw new AccountNotFoundException("Account not found with the given account number.");
    }

    public void transferMoney(int fromAccountNumber, int toAccountNumber, double amount)
            throws AccountNotFoundException, InsufficientFundsException, NegativeAmountException {
        BankAccount fromAccount = findAccount(fromAccountNumber);
        BankAccount toAccount = findAccount(toAccountNumber);

        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
    }
}
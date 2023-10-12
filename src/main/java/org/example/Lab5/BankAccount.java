package org.example.Lab5;

public class BankAccount {

    private final int accountNumber;
    private final String accountName;
    private double balance;

    public BankAccount(int accountNumber, String accountName, double balance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
    }

    public void deposit(double amount) throws NegativeAmountException {
        if (amount < 0) {
            throw new NegativeAmountException("Cannot deposit a negative amount.");
        }
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException, NegativeAmountException {
        if (amount < 0) {
            throw new NegativeAmountException("Cannot withdraw a negative amount.");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal.");
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountSummary() {
        return "Account Number: " + accountNumber + ", Account Name: " + accountName + ", Balance: " + balance;
    }

}

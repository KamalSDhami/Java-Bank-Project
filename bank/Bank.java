package bank;

import account.Account;
import account.InvalidAmountException;
import account.InsufficientFundsException;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<String, Account> accounts;

    public Bank() {
        accounts = new HashMap<>();
    }

    public void addAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public void deposit(String accountNumber, double amount) throws InvalidAmountException {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            account.deposit(amount);
        }
    }

    public void withdraw(String accountNumber, double amount) throws InvalidAmountException, InsufficientFundsException {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            account.withdraw(amount);
        }
    }
}
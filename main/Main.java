package main;

import account.Account;
import account.InvalidAmountException;
import account.InsufficientFundsException;
import bank.Bank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();

        while (true) {
            System.out.println("\n--- Bank Management System ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. View Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                if (choice == 1) {
                    System.out.print("Enter Account Number: ");
                    String accNo = scanner.nextLine();
                    System.out.print("Enter Account Holder Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    double balance = scanner.nextDouble();
                    Account account = new Account(accNo, name, balance);
                    bank.addAccount(account);
                    System.out.println("Account created successfully!");
                } else if (choice == 2) {
                    System.out.print("Enter Account Number: ");
                    String accNo = scanner.nextLine();
                    System.out.print("Enter Deposit Amount: ");
                    double amount = scanner.nextDouble();
                    bank.deposit(accNo, amount);
                    System.out.println("Amount deposited successfully!");
                } else if (choice == 3) {
                    System.out.print("Enter Account Number: ");
                    String accNo = scanner.nextLine();
                    System.out.print("Enter Withdrawal Amount: ");
                    double amount = scanner.nextDouble();
                    bank.withdraw(accNo, amount);
                    System.out.println("Amount withdrawn successfully!");
                } else if (choice == 4) {
                    System.out.print("Enter Account Number: ");
                    String accNo = scanner.nextLine();
                    Account account = bank.getAccount(accNo);
                    if (account != null) {
                        System.out.println("Account Holder: " + account.getAccountHolderName());
                        System.out.println("Balance: " + account.getBalance());
                    } else {
                        System.out.println("Account not found!");
                    }
                } else if (choice == 5) {
                    System.out.println("Thank you for using the Bank Management System.");
                    break;
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            } catch (InvalidAmountException | InsufficientFundsException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
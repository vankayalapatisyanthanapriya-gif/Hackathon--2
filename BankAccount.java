import java.util.Scanner;

public class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    // Parameterized constructor to initialize account details
    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: $" + amount);
        } else {
            System.out.println("Deposit amount must be greater than zero.");
        }
    }

    // Method to withdraw money with balance check
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew: $" + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance! Withdrawal failed.");
        } else {
            System.out.println("Withdrawal amount must be greater than zero.");
        }
    }

    // Method to return current balance
    public double checkBalance() {
        return balance;
    }

    // Method to display account details and balance
    public void displayAccount() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolderName);
        System.out.println("Current Balance: $" + checkBalance());
        System.out.println("-----------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input account details
        System.out.print("Enter Account Number: ");
        String accNumber = scanner.nextLine();

        System.out.print("Enter Account Holder Name: ");
        String holderName = scanner.nextLine();

        System.out.print("Enter Initial Balance: ");
        double initialBalance = scanner.nextDouble();

        // Create object using parameterized constructor
        BankAccount account = new BankAccount(accNumber, holderName, initialBalance);

        // Perform deposit operation
        System.out.print("\nEnter amount to deposit: ");
        double depositAmt = scanner.nextDouble();
        account.deposit(depositAmt);

        // Perform withdrawal operation
        System.out.print("Enter amount to withdraw: ");
        double withdrawAmt = scanner.nextDouble();
        account.withdraw(withdrawAmt);

        // Display final account details
        account.displayAccount();

        scanner.close();
    }
}
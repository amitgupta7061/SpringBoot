/**
 * 12_OOP_Encapsulation.java - Access Modifiers and Getters/Setters
 */

class OOP_Encapsulation {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("12345", 1000);

        // Cannot access private directly
        // account.balance = 5000; // Error!

        // Use getters/setters
        account.deposit(500);
        account.withdraw(200);
        System.out.println("Balance: " + account.getBalance());
        System.out.println("Account: " + account.getAccountNumber());
    }
}

class BankAccount {
    // Private - accessible only within this class
    private String accountNumber;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    // Getter - read access
    public double getBalance() {
        return balance;
    }

    // No setter for balance - controlled through methods

    // Getter only (read-only)
    public String getAccountNumber() {
        return accountNumber;
    }

    // Controlled methods instead of setter
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
            return true;
        }
        return false;
    }
}

/*
 * ACCESS MODIFIERS:
 * 
 * public - Accessible from anywhere
 * private - Accessible only within same class
 * protected - Accessible within package and subclasses
 * default - Accessible only within same package (no keyword)
 * 
 * | Modifier | Class | Package | Subclass | World |
 * |-----------|-------|---------|----------|-------|
 * | public | Yes | Yes | Yes | Yes |
 * | protected | Yes | Yes | Yes | No |
 * | default | Yes | Yes | No | No |
 * | private | Yes | No | No | No |
 */

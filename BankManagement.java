import java.util.*;

class BankAccount {
    private String accountNumber;
    private double balance;
    private List<String> transactionHistory;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with balance: " + initialBalance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            String log = "Deposited: " + amount + ", New balance: " + balance;
            System.out.println(log);
            transactionHistory.add(log);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            String log = "Withdrew: " + amount + ", New balance: " + balance;
            System.out.println(log);
            transactionHistory.add(log);
        } else {
            String log = "Failed to withdraw: " + amount + " (Insufficient balance)";
            System.out.println(log);
            transactionHistory.add(log);
        }
    }

    public void transfer(BankAccount target, double amount) {
        if (target == null) {
            System.out.println("Transfer failed: Target account is null.");
            return;
        }
        if (amount > 0 && balance >= amount) {
            this.withdraw(amount);
            target.deposit(amount);
            String log = "Transferred: " + amount + " to " + target.getAccountNumber();
            System.out.println(log);
            transactionHistory.add(log);
            target.transactionHistory.add("Received: " + amount + " from " + this.accountNumber);
        } else {
            String log = "Failed to transfer: " + amount + " (Insufficient balance)";
            System.out.println(log);
            transactionHistory.add(log);
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void printTransactionHistory() {
        System.out.println("\n--- Transaction History for Account: " + accountNumber + " ---");
        for (String log : transactionHistory) {
            System.out.println(log);
        }
    }
}

public class BankManagement{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Initialize bank accounts
        Map<String, BankAccount> accounts = new HashMap<>();
        accounts.put("A001", new BankAccount("A001", 5000));
        accounts.put("A002", new BankAccount("A002", 3000));
        accounts.put("A003", new BankAccount("A003", 10000));

        while (true) {
            System.out.println("\n--- BANK MENU ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Transfer");
            System.out.println("4. Show Balance");
            System.out.println("5. Show Transaction History");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (choice == 6) break;

            System.out.print("Enter your account number (A001, A002, A003): ");
            String accNum = sc.nextLine().toUpperCase();
            BankAccount source = accounts.get(accNum);

            if (source == null) {
                System.out.println("Invalid account number!");
                continue;
            }

            switch (choice) {
                case 1: // Deposit
                    System.out.print("Enter amount to deposit: ");
                    double depAmount = sc.nextDouble();
                    source.deposit(depAmount);
                    break;

                case 2: // Withdraw
                    System.out.print("Enter amount to withdraw: ");
                    double withAmount = sc.nextDouble();
                    source.withdraw(withAmount);
                    break;

                case 3: // Transfer
                    System.out.print("Enter target account number: ");
                    String targetAccNum = sc.next().toUpperCase();
                    BankAccount target = accounts.get(targetAccNum);
                    if (target == null) {
                        System.out.println("Invalid target account number!");
                        break;
                    }
                    System.out.print("Enter amount to transfer: ");
                    double transAmount = sc.nextDouble();
                    source.transfer(target, transAmount);
                    break;

                case 4: // Show balance of current account
                    System.out.println("Account " + source.getAccountNumber() + " => Balance: " + source.getBalance());
                    break;

                case 5: // Show transaction history of current account
                    source.printTransactionHistory();
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }

        System.out.println("\nThank you for using the bank system!");
        sc.close();
    }
}

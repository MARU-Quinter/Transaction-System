import java.util.*;

// Transaction Interface
interface TransactionInterface {
    double getAmount();

    Calendar getDate();

    String getTransactionID();

    void printTransactionDetails();

    void apply(BankAccount ba);
}

// Abstract BaseTransaction Class
abstract class BaseTransaction implements TransactionInterface {
    protected double amount;
    protected Calendar date;
    protected String transactionID;

    public BaseTransaction(double amount) {
        this.amount = amount;
        this.date = Calendar.getInstance();
        this.transactionID = UUID.randomUUID().toString();
    }

    @Override
    public double getAmount() {
        return amount;
    }

    @Override
    public Calendar getDate() {
        return date;
    }

    @Override
    public String getTransactionID() {
        return transactionID;
    }

    @Override
    public void printTransactionDetails() {
        System.out.println("Transaction ID: " + transactionID);
        System.out.println("Date: " + date.getTime());
        System.out.println("Amount: " + amount);
    }
}

// DepositTransaction Class
class DepositTransaction extends BaseTransaction {
    public DepositTransaction(double amount) {
        super(amount);
    }

    @Override
    public void apply(BankAccount ba) {
        ba.deposit(amount);
        System.out.println("Deposit applied: " + amount);
    }
}

// WithdrawalTransaction Class
class WithdrawalTransaction extends BaseTransaction {
    public WithdrawalTransaction(double amount) {
        super(amount);
    }

    @Override
    public void apply(BankAccount ba) {
        try {
            ba.withdraw(amount);
            System.out.println("Withdrawal applied: " + amount);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean reverse(BankAccount ba) {
        ba.deposit(amount);
        System.out.println("Withdrawal reversed: " + amount);
        return true;
    }
}

// Custom Exception Class
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

// BankAccount Class
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (balance < amount) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal. Available balance: " + balance);
        }
        balance -= amount;
        System.out.println("Withdrawn: " + amount);
    }
}

// Main Class to Test Functionality
public class TransactionSystem {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(500.0);

        // Test DepositTransaction
        DepositTransaction deposit = new DepositTransaction(200.0);
        deposit.apply(account);
        deposit.printTransactionDetails();
        System.out.println("Balance after deposit: " + account.getBalance());

        // Test WithdrawalTransaction
        WithdrawalTransaction withdrawal = new WithdrawalTransaction(100.0);
        withdrawal.apply(account);
        withdrawal.printTransactionDetails();
        System.out.println("Balance after withdrawal: " + account.getBalance());

        // Test InsufficientFundsException
        WithdrawalTransaction largeWithdrawal = new WithdrawalTransaction(700.0);
        largeWithdrawal.apply(account);
        System.out.println("Balance after large withdrawal attempt: " + account.getBalance());

        // Test Withdrawal Reversal
        withdrawal.reverse(account);
        System.out.println("Balance after reversal: " + account.getBalance());
    }
}

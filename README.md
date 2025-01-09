# Transaction System

## Overview
This project is a simple Java-based transaction management system that processes financial transactions such as deposits and withdrawals. It demonstrates key object-oriented programming concepts such as interfaces, inheritance, polymorphism, and exception handling.

## Features
- **Single File:** All classes are included within one file for easy management.
- **Modularity:** Logically separated classes that work seamlessly together.
- **Key Functionalities:**
  - Deposit and withdrawal functionalities.
  - Exception handling for insufficient funds.
  - Ability to reverse a withdrawal.

## Key Concepts Demonstrated
1. Implementation of Java interfaces and abstract classes.
2. Polymorphism through overridden methods.
3. Exception handling using custom exceptions.
4. Transaction logging with unique IDs and timestamps.

## Project Structure
The project includes the following components:

### Classes
1. **TransactionInterface**: Defines methods to be implemented by all transaction types.
2. **BaseTransaction**: Abstract class implementing `TransactionInterface` and providing common functionality for transactions.
3. **DepositTransaction**: Subclass of `BaseTransaction` for deposits.
4. **WithdrawalTransaction**: Subclass of `BaseTransaction` for withdrawals.
5. **InsufficientFundsException**: Custom exception for handling insufficient funds.
6. **BankAccount**: Represents a bank account with basic deposit and withdrawal capabilities.
7. **TransactionSystem**: The main class to test the functionalities of the transaction system.

### Methods
- `apply()`: Applies a transaction to a bank account.
- `reverse()`: Reverses a withdrawal transaction.
- `printTransactionDetails()`: Prints transaction details.
- `getAmount()`, `getDate()`, `getTransactionID()`: Accessors for transaction properties.
- `withdraw()`, `deposit()`: Bank account operations with exception handling.

## How to Run
1. Save the code into a file named `TransactionSystem.java`.
2. Compile the file:
   ```bash
   javac TransactionSystem.java
   ```
3. Run the program:
   ```bash
   java TransactionSystem
   ```
4. Observe the outputs for deposits, withdrawals, and exception handling in the console.

## Example Output
```
Deposited: 200.0
Transaction ID: <unique-id>
Date: <timestamp>
Amount: 200.0
Balance after deposit: 700.0
Withdrawn: 100.0
Transaction ID: <unique-id>
Date: <timestamp>
Amount: 100.0
Balance after withdrawal: 600.0
Insufficient funds for withdrawal. Available balance: 600.0
Balance after large withdrawal attempt: 600.0
Withdrawal reversed: 100.0
Balance after reversal: 700.0
```

## Use Cases
1. Demonstrates implementation of abstract data types (ADTs) in Java.
2. Useful as a template for understanding OOP concepts like inheritance, polymorphism, and exception handling.
3. Can be extended into a full-fledged banking application.


---
By: MARU-Quinter
Feel free to reach out if you have questions or suggestions for improvement!


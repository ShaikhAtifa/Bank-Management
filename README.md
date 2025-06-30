# Bank-Management
A console-based Java bank system that enables users to carry out basic bank operations such as deposit, withdrawal, and transferring money between accounts. Every account has a comprehensive transaction history. The system utilizes a HashMap to handle multiple bank accounts and supports command line input.

## Features

- Create and manage multiple bank accounts
- Deposit and withdraw money
- Transfer funds between accounts
- Transaction history for each account
- Balance inquiry (for selected account only)
- Simple command-line interface (CLI)
- No multithreading — purely sequential logic

## Technologies Used

- Java (JDK 8+)
- Java Collections (`HashMap`, `ArrayList`)
- Scanner for input handling

How to RUN the code:
javac BankUserInput.java
java BankUserInput

Sample Accounts
Account Number	Initial Balance
A001	          5000.0
A002	          3000.0
A003	          10000.0

SAMPLE OUTPUT:
--- BANK MENU ---
1. Deposit
2. Withdraw
3. Transfer
4. Show Balance
5. Show Transaction History
6. Exit
Enter your choice: 4
Enter your account number (A001, A002, A003): A003
Account A003 => Balance: 10000.0

--- BANK MENU ---
1. Deposit
2. Withdraw
3. Transfer
4. Show Balance
5. Show Transaction History
6. Exit
Enter your choice: 



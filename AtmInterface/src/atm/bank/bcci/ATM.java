package atm.bank.bcci;

import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a user for testing
        User user = new User("Root", "Root123");

        // Simulate login
        System.out.println("Enter User ID:");
        String userIdInput = scanner.nextLine();

        System.out.println("Enter User PIN:");
        String userPinInput = scanner.nextLine();

        if (userIdInput.equals(user.getUserId()) && userPinInput.equals(user.getUserPin())) {
            System.out.println("Login successful!");

            // Unlock ATM functionalities
            boolean isRunning = true;

            while (isRunning) {
                System.out.println("\nChoose an option:");
                System.out.println("1. View Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Transfer");
                System.out.println("5. View Transaction History");
                System.out.println("6. Quit");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("Balance : RS" + user.getBalance());
                        break;
                    case 2:
                        System.out.println("Enter deposit amount:");
                        double depositAmount = scanner.nextDouble();
                        user.deposit(depositAmount);
                        System.out.println("Rs "+depositAmount+" Deposited successful!");
                        break;
                    case 3:
                        System.out.println("Enter withdrawal amount:");
                        double withdrawAmount = scanner.nextDouble();
                        user.withdraw(withdrawAmount);
                        break;
                    case 4:
                        System.out.println("Enter recipient's User ID:");
                        String recipientId = scanner.next();
                        System.out.println("Enter transfer amount:");
                        double transferAmount = scanner.nextDouble();
                       
                        // For simplicity, assume the recipient is another instance of the User class
                        User recipient = new User(recipientId, "dummy");
                        user.transfer(recipient, transferAmount);
                       
                        break;
                    case 5:
                        user.printTransactionHistory();
                        break;
                    case 6:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Login failed. Incorrect User ID or PIN.");
        }

        // Close the scanner
        scanner.close();
    }
}

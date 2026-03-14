import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    static double income = 0;
    static double expenses = 0;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int choice;

            do {
                System.out.println("\n--- Student Budget Tracker ---");
                System.out.println("1. Add Income");
                System.out.println("2. Add Expense");
                System.out.println("3. View Balance");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");

                try {
                    choice = scanner.nextInt();
                    
                    switch (choice) {
                        case 1:
                            addIncome(scanner);
                            break;

                        case 2:
                            addExpense(scanner);
                            break;

                        case 3:
                            viewBalance();
                            break;

                        case 4:
                            System.out.println("Exiting program...");
                            break;

                        default:
                            System.out.println("Invalid option. Please choose 1-4.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Error: Please enter a valid number.");
                    scanner.nextLine(); // Clear invalid input
                    choice = 0; // Continue loop
                }

            } while (choice != 4);

            double finalBalance = income - expenses;
            System.out.println("\nYour final balance is: $" + String.format("%.2f", finalBalance));
        }
    }

    private static void addIncome(Scanner scanner) {
        System.out.print("Enter income amount: $");
        try {
            double amount = scanner.nextDouble();
            if (amount < 0) {
                System.out.println("Error: Income cannot be negative.");
            } else if (amount == 0) {
                System.out.println("Error: Income amount must be greater than 0.");
            } else {
                income += amount;
                System.out.println("Income added successfully.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter a valid number.");
            scanner.nextLine(); // Clear invalid input
        }
    }

    private static void addExpense(Scanner scanner) {
        System.out.print("Enter expense amount: $");
        try {
            double amount = scanner.nextDouble();
            if (amount < 0) {
                System.out.println("Error: Expense cannot be negative.");
            } else if (amount == 0) {
                System.out.println("Error: Expense amount must be greater than 0.");
            } else {
                expenses += amount;
                System.out.println("Expense added successfully.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Please enter a valid number.");
            scanner.nextLine(); // Clear invalid input
        }
    }

    private static void viewBalance() {
        double balance = income - expenses;
        System.out.println("\n--- Balance Summary ---");
        System.out.println("Total Income: $" + String.format("%.2f", income));
        System.out.println("Total Expenses: $" + String.format("%.2f", expenses));
        System.out.println("Current Balance: $" + String.format("%.2f", balance));
    }
}
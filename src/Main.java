import java.util.Scanner;

public class Main {

    static double income = 0;
    static double expenses = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Student Budget Tracker ---");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter income amount: ");
                    income += scanner.nextDouble();
                    break;

                case 2:
                    System.out.print("Enter expense amount: ");
                    expenses += scanner.nextDouble();
                    break;

                case 3:
                    double balance = income - expenses;
                    System.out.println("Current Balance: " + balance);
                    break;

                case 4:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid option.");
            }

        } while (choice != 4);

        double finalBalance = income - expenses;
        System.out.println("Your final balance is: " + finalBalance);

        scanner.close();
    }
}

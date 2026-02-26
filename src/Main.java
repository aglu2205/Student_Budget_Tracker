import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter income: ");
        double income = scanner.nextDouble();

        System.out.print("Enter expense: ");
        double expense = scanner.nextDouble();

        double balance = income - expense;

        System.out.println("Your balance is: " + balance);
    }
}

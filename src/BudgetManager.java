public class BudgetManager {

    private double income;
    private double expenses;

    public BudgetManager() {
        income = 0;
        expenses = 0;
    }

    public void addIncome(double amount) {
        income += amount;
    }

    public void addExpense(double amount) {
        expenses += amount;
    }

    public double getBalance() {
        return income - expenses;
    }

    public double getIncome() {
        return income;
    }

    public double getExpenses() {
        return expenses;
    }

    public void setData(double income, double expenses) {
        this.income = income;
        this.expenses = expenses;
    }
}

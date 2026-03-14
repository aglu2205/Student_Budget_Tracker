import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BudgetManagerTest {

    private BudgetManager budgetManager;

    @Before
    public void setUp() {
        budgetManager = new BudgetManager();
    }

    // Test Constructor
    @Test
    public void testConstructor() {
        assertEquals(0, budgetManager.getIncome(), 0.01);
        assertEquals(0, budgetManager.getExpenses(), 0.01);
        assertEquals(0, budgetManager.getBalance(), 0.01);
    }

    // Test addIncome
    @Test
    public void testAddIncome() {
        budgetManager.addIncome(100);
        assertEquals(100, budgetManager.getIncome(), 0.01);
    }

    @Test
    public void testAddMultipleIncomes() {
        budgetManager.addIncome(100);
        budgetManager.addIncome(50);
        budgetManager.addIncome(25);
        assertEquals(175, budgetManager.getIncome(), 0.01);
    }

    @Test
    public void testAddNegativeIncome() {
        budgetManager.addIncome(-50);
        assertEquals(-50, budgetManager.getIncome(), 0.01);
    }

    // Test addExpense
    @Test
    public void testAddExpense() {
        budgetManager.addExpense(50);
        assertEquals(50, budgetManager.getExpenses(), 0.01);
    }

    @Test
    public void testAddMultipleExpenses() {
        budgetManager.addExpense(20);
        budgetManager.addExpense(30);
        budgetManager.addExpense(15);
        assertEquals(65, budgetManager.getExpenses(), 0.01);
    }

    @Test
    public void testAddNegativeExpense() {
        budgetManager.addExpense(-25);
        assertEquals(-25, budgetManager.getExpenses(), 0.01);
    }

    // Test getBalance
    @Test
    public void testGetBalance_Positive() {
        budgetManager.addIncome(200);
        budgetManager.addExpense(50);
        assertEquals(150, budgetManager.getBalance(), 0.01);
    }

    @Test
    public void testGetBalance_Negative() {
        budgetManager.addIncome(50);
        budgetManager.addExpense(200);
        assertEquals(-150, budgetManager.getBalance(), 0.01);
    }

    @Test
    public void testGetBalance_Zero() {
        budgetManager.addIncome(100);
        budgetManager.addExpense(100);
        assertEquals(0, budgetManager.getBalance(), 0.01);
    }

    @Test
    public void testGetBalance_NoTransactions() {
        assertEquals(0, budgetManager.getBalance(), 0.01);
    }

    // Test setData
    @Test
    public void testSetData() {
        budgetManager.setData(500, 200);
        assertEquals(500, budgetManager.getIncome(), 0.01);
        assertEquals(200, budgetManager.getExpenses(), 0.01);
        assertEquals(300, budgetManager.getBalance(), 0.01);
    }

    @Test
    public void testSetData_Overwrites() {
        budgetManager.addIncome(100);
        budgetManager.addExpense(50);
        budgetManager.setData(1000, 600);
        assertEquals(1000, budgetManager.getIncome(), 0.01);
        assertEquals(600, budgetManager.getExpenses(), 0.01);
        assertEquals(400, budgetManager.getBalance(), 0.01);
    }

    @Test
    public void testSetData_ZeroValues() {
        budgetManager.setData(0, 0);
        assertEquals(0, budgetManager.getIncome(), 0.01);
        assertEquals(0, budgetManager.getExpenses(), 0.01);
    }

    // Test edge cases
    @Test
    public void testLargeNumbers() {
        budgetManager.addIncome(1000000);
        budgetManager.addExpense(500000);
        assertEquals(500000, budgetManager.getBalance(), 0.01);
    }

    @Test
    public void testDecimalValues() {
        budgetManager.addIncome(99.99);
        budgetManager.addExpense(49.99);
        assertEquals(50.00, budgetManager.getBalance(), 0.01);
    }
}
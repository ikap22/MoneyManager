import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseCalculator {
    private ArrayList<Double> monthlyExpenses;
    private Scanner scanner;

    public ExpenseCalculator() {
        monthlyExpenses = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addExpenses(String expenses) {
        String[] expenseArray = expenses.split(" ");
        for (String expense : expenseArray) {
            try {
                double expenseAmount = Double.parseDouble(expense.trim());
                addExpense(expenseAmount);
            } catch (NumberFormatException e) {
                System.out.println("Invalid expense: " + expense);
            }
        }
    }

    public void addExpense(double expenseAmount) {
        monthlyExpenses.add(expenseAmount);
    }

    public double calculateTotalExpenses() {
        double totalExpenses = 0;
        for (Double expense : monthlyExpenses) {
            totalExpenses += expense;
        }
        return totalExpenses;
    }

    public void displayTotalExpense() {
        double totalExpense = calculateTotalExpenses();
        System.out.println("\nYour total expense for the transaction is $" + totalExpense);
    }

    public static double getDoubleInput(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
}

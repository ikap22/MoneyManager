import java.util.Scanner;

public class UserInterface {
    private ExpenseCalculator expenseCalculator;
    private SubscriptionManager subscriptionManager;

    public UserInterface() {
        expenseCalculator = new ExpenseCalculator();
        subscriptionManager = new SubscriptionManager();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nMoney Management System Menu");
            System.out.println("1. Manage Expenses");
            System.out.println("2. Manage Subscriptions");
            System.out.println("3. Exit");

            int choice = getIntInput(scanner, "Enter your choice: ");

            switch (choice) {
                case 1:
                    manageExpenses(scanner);
                    break;
                case 2:
                    subscriptionManager.manageSubscriptions(scanner);
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("\nInvalid choice. Please select a valid option.");
            }
        }
    }

    public void manageExpenses(Scanner scanner) {
        System.out.print("Enter expenses separated by spaces: ");
        String expenses = scanner.nextLine();
        expenseCalculator.addExpenses(expenses);
        double totalExpenses = expenseCalculator.calculateTotalExpenses();
        System.out.println("Total expenses for the transaction: $" + totalExpenses);
    }

    public static int getIntInput(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.start();
    }
}

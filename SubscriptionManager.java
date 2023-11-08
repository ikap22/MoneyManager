import java.util.ArrayList;
import java.util.Scanner;

public class SubscriptionManager {
    private ArrayList<Subscription> subscriptions;
    private Scanner scanner;

    public SubscriptionManager() {
        subscriptions = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void manageSubscriptions(Scanner scanner) {
        boolean exit = false;

        while (!exit) {
            System.out.println("\nSubscription Management Menu");
            System.out.println("1. Add Subscription");
            System.out.println("2. Calculate Individual Subscription Cost");
            System.out.println("3. Calculate Total Subscription Cost");
            System.out.println("4. View Subscriptions");
            System.out.println("5. Return to the main menu");

            int choice = getIntInput(scanner, "Enter your choice: ");

            switch (choice) {
                case 1:
                    addSubscription();
                    break;
                case 2:
                    calculateSubscriptionCost();
                    break;
                case 3:
                    calculateTotalSubscriptionCost();
                    break;
                case 4:
                    viewSubscriptions();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    public void addSubscription() {
        System.out.print("\nEnter the subscription name: ");
        String name = scanner.nextLine();
        double cost = getDoubleInput(scanner, "Enter the monthly cost: ");
        double taxRate = getDoubleInput(scanner, "Enter the tax rate (in percentage): ");
        int months = getIntInput(scanner, "Enter the number of months: ");

        Subscription subscription = new Subscription(name, cost, taxRate, months);
        subscriptions.add(subscription);
        System.out.println("Subscription added: " + subscription);
    }

    public void calculateSubscriptionCost() {
        viewSubscriptions();

        if (!subscriptions.isEmpty()) {
            int userInput = getIntInput(scanner, "\nEnter the subscription number to calculate cost: ");
            int index = userInput - 1;  // Adjust for 0-based index
            if (index >= 0 && index < subscriptions.size()) {
                Subscription subscription = subscriptions.get(index);
                double totalCost = subscription.calculateTotalCost();
                System.out.println("Total cost over the subscription period: $" + totalCost);
            } else {
                System.out.println("Invalid subscription number. No cost calculation performed.");
            }
        }
    }

    public void calculateTotalSubscriptionCost() {
        if (subscriptions.isEmpty()) {
            System.out.println("No subscriptions added.");
        } else {
            double totalCost = 0;
            for (Subscription subscription : subscriptions) {
                totalCost += subscription.calculateTotalCost();
            }
            System.out.println("Total cost for all subscriptions: $" + totalCost);
        }
    }

    public void viewSubscriptions() {
        if (subscriptions.isEmpty()) {
            System.out.println("\nNo subscriptions added.");
        } else {
            System.out.println("Subscriptions:");
            for (int i = 0; i < subscriptions.size(); i++) {
                System.out.println((i + 1) + ". " + subscriptions.get(i));
            }
        }
    }

    public static double getDoubleInput(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input. Please enter a valid number.");
            }
        }
    }

    public static int getIntInput(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input. Please enter a valid number.");
            }
        }
    }
}

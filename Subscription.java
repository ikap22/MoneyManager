public class Subscription {
    private String name;
    private double cost;
    private double taxRate;
    private int months;

    public Subscription(String name, double cost, double taxRate, int months) {
        this.name = name;
        this.cost = cost;
        this.taxRate = taxRate;
        this.months = months;
    }

    public double calculateTotalCost() {
        // Implement logic to calculate the total cost over the subscription period,
        // considering the cost, tax rate, and number of months.
        return cost * (1 + taxRate / 100) * months;
    }

    @Override
    public String toString() {
        return "Subscription[name=" + name + ", cost=" + cost + ", taxRate=" + taxRate + "%, months=" + months + "]";
    }
}


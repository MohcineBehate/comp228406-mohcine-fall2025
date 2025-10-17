package exercise1;

public class Health extends Insurance {

    public Health() { super("Health"); }

    @Override
    public void setInsuranceCost(double monthlyCost) { this.monthlyCost = monthlyCost; }

    @Override
    public void displayInfo() {
        System.out.println("=== Health Insurance ===");
        System.out.printf("Type: %s%n", getInsuranceType());
        System.out.printf("Monthly Cost: $%.2f%n", getMonthlyCost());
        System.out.println();
    }
}

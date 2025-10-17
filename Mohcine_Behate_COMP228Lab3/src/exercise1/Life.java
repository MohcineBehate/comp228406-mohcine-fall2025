package exercise1;

public class Life extends Insurance {

    public Life() { super("Life"); }

    @Override
    public void setInsuranceCost(double monthlyCost) { this.monthlyCost = monthlyCost; }

    @Override
    public void displayInfo() {
        System.out.println("=== Life Insurance ===");
        System.out.printf("Type: %s%n", getInsuranceType());
        System.out.printf("Monthly Cost: $%.2f%n", getMonthlyCost());
        System.out.println();
    }
}

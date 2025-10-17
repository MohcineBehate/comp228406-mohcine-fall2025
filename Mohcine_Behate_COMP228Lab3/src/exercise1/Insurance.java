package exercise1;

public abstract class Insurance {
    protected String insuranceType;
    protected double monthlyCost;

    public Insurance(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public String getInsuranceType() { return insuranceType; }
    public double getMonthlyCost() { return monthlyCost; }

    public abstract void setInsuranceCost(double monthlyCost);
    public abstract void displayInfo();
}

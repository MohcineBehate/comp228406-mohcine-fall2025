package exercise3;

public abstract class Mortgage implements MortgageConstants {
    protected String mortgageNumber;
    protected String customerName;
    protected double mortgageAmount;
    protected double interestRateAnnual;
    protected int termYears;

    public Mortgage(String number, String name, double amount, double prime, int term) {
        if (amount > MAX_MORTGAGE_AMOUNT) throw new IllegalArgumentException("Exceeds limit");
        this.mortgageNumber = number;
        this.customerName = name;
        this.mortgageAmount = amount;
        this.termYears = (term == 1 || term == 3 || term == 5) ? term : SHORT_TERM_YEARS;
        setInterestRateFromPrime(prime);
    }

    protected abstract void setInterestRateFromPrime(double primeRate);

    public double totalOwed() {
        return mortgageAmount + (mortgageAmount * interestRateAnnual * termYears);
    }

    public String getMortgageInfo() {
        return String.format("%s\nCustomer: %s\nAmount: $%.2f\nInterest: %.2f%%\nTerm: %d years\nTotal Owed: $%.2f\n", 
            BANK_NAME, customerName, mortgageAmount, interestRateAnnual * 100, termYears, totalOwed());
    }
}

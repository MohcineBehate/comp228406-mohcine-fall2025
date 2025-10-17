package exercise3;

public class BusinessMortgage extends Mortgage {
    public BusinessMortgage(String num, String name, double amt, double prime, int term) {
        super(num, name, amt, prime, term);
    }

    @Override
    protected void setInterestRateFromPrime(double primeRate) {
        this.interestRateAnnual = primeRate + 0.01;
    }
}

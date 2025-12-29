package model;

public class FixedDeposit {
    public Double principalAmount;
    public int tenure;
    public double rate;
    public FDType fdType;

    // Default constructor
    public FixedDeposit() {}

    // Parameterized constructor
    public FixedDeposit(Double principalAmount, int tenure, double rate, FDType fdType) {
        this.principalAmount = principalAmount;
        this.tenure = tenure;
        this.rate = rate;
        this.fdType = fdType;
    }

    public double calculateInterest() {
        if (fdType == FDType.COMPOUND) {
            return principalAmount * Math.pow(1 + rate / 100, tenure) - principalAmount;
        }
        return (principalAmount * rate * tenure) / 100;
    }

    public Double calculateMaturityAmount() {
        return principalAmount + calculateInterest();
    }
}

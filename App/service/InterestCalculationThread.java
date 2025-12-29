package service;

import model.FixedDeposit;

public class InterestCalculationThread extends Thread {
    FixedDeposit deposit;

    public InterestCalculationThread(FixedDeposit deposit) {
        this.deposit = deposit;
    }
    @Override
    public void run() {
        System.out.println("\n[Interest Calculation Thread Started]");
        double interest = deposit.calculateInterest();
    System.out.printf("Interest Earned: %.2f%n", interest);
    }
}

package service;

import model.Customer;
import model.FixedDeposit;

public class ReportGenerationThread extends Thread {
    Customer customer;
    FixedDeposit deposit;

    public ReportGenerationThread(Customer customer, FixedDeposit deposit) {
        this.customer = customer;
        this.deposit = deposit;
    }
    @Override
    public void run() {
        System.out.println("\n[Report Generation Thread Started]");
        System.out.println("Customer ID : " + customer.accountId);
        System.out.println("Customer Name : " + customer.name);
        System.out.println("Principal Amount : " + deposit.principalAmount);
        System.out.println("Tenure : " + deposit.tenure + " years");
        System.out.println("FD Type : " + deposit.fdType);
        System.out.println("Maturity Amount : " + deposit.calculateMaturityAmount());
    }
}


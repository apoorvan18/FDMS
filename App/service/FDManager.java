package service;

import exception.InvalidDepositAmountException;
import java.util.Scanner;
import model.*;

public class FDManager implements FDOperations {

    Customer customer;
    FixedDeposit deposit;
    Scanner sc = new Scanner(System.in);

    public void validateDeposit(Double amount) throws InvalidDepositAmountException {
        if (amount <= 0) {
            throw new InvalidDepositAmountException("Invalid Deposit Amount!");
        }
    }

    public void createFD() {
        try {
            System.out.print("Enter Customer ID: ");
            int id = sc.nextInt();

            System.out.print("Enter Customer Name: ");
            String name = sc.next();

            System.out.print("Enter Deposit Amount: ");
            Double amount = sc.nextDouble();
            validateDeposit(amount);

            System.out.print("Enter Tenure (years): ");
            int tenure = sc.nextInt();

            System.out.print("Enter Interest Rate: ");
            double rate = sc.nextDouble();

            System.out.print("FD Type (1-SIMPLE, 2-COMPOUND): ");
            int choice = sc.nextInt();
            FDType fdType = (choice == 2) ? FDType.COMPOUND : FDType.SIMPLE;

            customer = new Customer(id, name);
            deposit = new FixedDeposit(amount, tenure, rate, fdType);

            System.out.println("Fixed Deposit Created Successfully!");

        } catch (InvalidDepositAmountException e) {
            System.out.println("Exception: " + e.getMessage());
        } finally {
            System.out.println("[Deposit Creation Attempt Completed]");
        }
    }

    @Override
    public void calculateInterest() {
        if (deposit == null) {
            System.out.println("No Fixed Deposit Found!");
            return;
        }
        Thread t1 = new InterestCalculationThread(deposit);
        t1.start();
        try {
        t1.join(); // waits till thread completes
    } catch (InterruptedException e) {
        System.out.println("Thread interrupted");
    }
    }

    @Override
    public void generateReport() {
        if (deposit == null || customer == null) {
            System.out.println("No Fixed Deposit Found!");
            return;
        }
        Thread t2 = new ReportGenerationThread(customer, deposit);
        t2.start();
         try {
        t2.join(); // Synchronizes output
    } catch (InterruptedException e) {
        System.out.println("Report thread interrupted");
    }

    }

    // Polymorphism support
    public void displayFDDetails() {
        generateReport();
    }
}


package app;

import java.util.Scanner;
import service.*;

public class FDMSApp {

    static Scanner sc = new Scanner(System.in);
    static FDOperations fd = new FDManager(); // Polymorphism

    static void showMenu() {
        System.out.println("\n===== FIXED DEPOSIT MANAGEMENT SYSTEM =====");
        System.out.println("1. Create Fixed Deposit");
        System.out.println("2. Calculate Interest (Thread)");
        System.out.println("3. Generate Report (Thread)");
        System.out.println("4. Exit");
        System.out.print("Enter choice: ");
    }

    static void handleMenuChoice(int choice) {
        switch (choice) {
            case 1 -> ((FDManager) fd).createFD();
            case 2 -> fd.calculateInterest();
            case 3 -> ((FDManager) fd).displayFDDetails();
            case 4 -> {
                System.out.println("Thank You!");
                System.exit(0);
            }
            default -> System.out.println("Invalid Choice!");
        }
    }

    public static void main(String[] args) {
        while (true) {
            showMenu();
            handleMenuChoice(sc.nextInt());
        }
    }
}

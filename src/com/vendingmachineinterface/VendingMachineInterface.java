package com.vendingmachineinterface;

import java.util.*;

import com.regularvendingmachine.RegularVendingMachine;

public class VendingMachineInterface {
    Scanner scan = new Scanner(System.in);
    RegularVendingMachine CRegularVendingMachine = new RegularVendingMachine();
    private RegularVendingMachine regularVendingMachine;
    private int nChoice;

    public void displayMainMenu() {
        System.out.println();
        System.out.println("\t  MAIN MENU\n");
        System.out.println("[1] Create a Vending Machine");
        System.out.println("[2] Test a Vending Machine");
        System.out.println("[3] Exit");
        System.out.println();

        System.out.print("Enter choice: ");
        nChoice = scan.nextInt();
        System.out.println();
        System.out.println();

        switch (this.nChoice) {
            case 1:
                createVendingMachine();
                break;
            case 2:
                testVendingMachine();
                break;
            case 3:
                System.exit(0);
                break;
            default:
                System.out.println("\t!! INVALID INPUT !!");
                displayMainMenu();
        }
        scan.close();
    }

    public void createVendingMachine() {
        if (regularVendingMachine != null) {
            System.out.println("A vending machine has been created already");
        }

        System.out.println();
        System.out.println("  CREATE A VENDING MACHINE\n");
        System.out.println("[1] Regular Vending Machine");
        System.out.println("[2] Special Vending Machine");
        System.out.println("[3] Return to Main Menu");
        System.out.println();

        System.out.print("Enter choice: ");
        nChoice = scan.nextInt();
        System.out.println();
        System.out.println();

        switch (this.nChoice) {
            case 1:
                System.out.println("------------------------------------------------------");
                System.out.println("|    Regular Vending Machine successfully created!   |");
                System.out.println("------------------------------------------------------");

                displayMainMenu();
                break;
            case 2:
                System.out.println("------------------------------------------------------");
                System.out.println("| Special Vending Machine is currently not available |");
                System.out.println("------------------------------------------------------");
                createVendingMachine();
                break;
            case 3:
                displayMainMenu();
                break;
            default:
                System.out.println("\t!! INVALID INPUT !!");
                displayMainMenu();
        }

        scan.close();
    }

    public void testVendingMachine() {
        System.out.println();
        System.out.println("  TEST A VENDING MACHINE\n");
        System.out.println("[1] Vending Features");
        System.out.println("[2] Maintenance Features");
        System.out.println("[3] Return to Main Menu");
        System.out.println();

        System.out.print("Enter choice: ");
        nChoice = scan.nextInt();
        System.out.println();
        System.out.println();

        switch (this.nChoice) {
            case 1:
                createVendingMachine();
                break;
            case 2:
                testVendingMachine();
                break;
            case 3:
                displayMainMenu();
                break;
            default:
                System.out.println("\t!! INVALID INPUT !!");
                displayMainMenu();
        }
        scan.close();
    }

    public void displayVendingFeatures() {
        System.out.println();
        System.out.println("  VENDING FEATURES\n");
        System.out.println("[1] Show available items");
        System.out.println("[2] ");
        System.out.println("[3] Exit Vending Features");
        System.out.println();

        System.out.print("Enter choice: ");
        nChoice = scan.nextInt();
        System.out.println();
        System.out.println();

        switch (this.nChoice) {
            case 1:
                createVendingMachine();
                break;
            case 2:

                break;
            case 3:
                testVendingMachine();
                break;
            default:
                System.out.println("\t!! INVALID INPUT !!");
                displayVendingFeatures();
        }
        scan.close();
    }

}
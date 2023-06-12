package com.vendingmachineinterface;

import java.util.Scanner;

public class VendingMachineInterface {
    Scanner scan = new Scanner(System.in);
    private int nChoice;

    public void displayMainMenu() {
        System.out.println();
        System.out.println("\t MAIN MENU \t\n" +
                "\n[1] Create a Vending Machine" +
                "\n[2] Test a Vending Machine" +
                "\n[3] Exit\n");
    }

    public void selectVendingMachine(int nChoice) {

        System.out.println();
        System.out.println("\t CREATE A VENDING MACHINE\t\n" +
                "\n[1] Regualar Vending Machine" +
                "\n[2] Special Vending Machine\n");

        System.out.print("Enter choice: ");
        nChoice = scan.nextInt();
        System.out.println();

        switch (nChoice) {
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            default:

        }

        scan.close();
    }
}
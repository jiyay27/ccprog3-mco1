package com.main;

import com.vendingmachineinterface.VendingMachineInterface;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        VendingMachineInterface CVendingMachineInterface = new VendingMachineInterface();

        Scanner scan = new Scanner(System.in);
        int nChoice;
        boolean bStop = false;

        while (!bStop) {
            CVendingMachineInterface.displayMainMenu();

            System.out.print("Enter choice: ");
            nChoice = scan.nextInt();
            System.out.println();

            switch (nChoice) {
                case 1:
<<<<<<< HEAD
                    CVendingMachineInterface.selectVendingMachine(nChoice);
=======
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
>>>>>>> 6d9b29f95340b29bfff5ea1aae29fc424f3e4e4b
                    break;
                case 2:

                    break;
                case 3:
                    bStop = true;
                    break;
                default:
                    System.out.println("!!! INVALID INPUT !!!\n\n");

<<<<<<< HEAD
                    CVendingMachineInterface.displayMainMenu();
=======
                    System.out.println();
                    System.out.println("\t MAIN MENU \t\n" +
                            "\n[1] Create a Vending Machine" +
                            "\n[2] Test a Vending Machine" +
                            "\n[3] Exit\n");
>>>>>>> 6d9b29f95340b29bfff5ea1aae29fc424f3e4e4b

                    System.out.print("Enter choice: ");
                    nChoice = scan.nextInt();
                    System.out.println();
            }
        }

        scan.close();
    }

}
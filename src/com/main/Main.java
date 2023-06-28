package com.main;

import java.util.Scanner;

import com.itemslot.ItemSlot;
//import com.machineinterface.MachineInterface;
import com.regularvendingmachine.RegularVendingMachine;

public class Main {
    public static void main(String[] args) {
        int nChoice = -1;
        int bFlag = -1;
        int initialBalance = 0;
        RegularVendingMachine regularVendingMachine = null;
        Scanner scan = new Scanner(System.in);
        // MachineInterface CMachineInterface = new MachineInterface();

        // ! MAIN MENU LOOP
        do {
            System.out.println();
            System.out.println("--------------------------------");
            System.out.println("|           MAIN MENU          |");
            System.out.println("|                              |");
            System.out.println("| [1] Create a Vending Machine |");
            System.out.println("| [2] Test a Vending Machine   |");
            System.out.println("| [3] Exit                     |");
            System.out.println("--------------------------------");
            System.out.println();

            System.out.print("Enter choice: ");
            nChoice = scan.nextInt();
            System.out.println();
            System.out.println();

            switch (nChoice) {
                // ! MAIN MENU SWITCH CASE
                case 1:
                    // ! CREATE A VENDING MACHINE LOOP
                    while (bFlag != 3) {
                        if (regularVendingMachine != null) {
                            System.out.println("------------------------------------------------------");
                            System.out.println("| !!! A vending machine has been created already !!! |");
                            System.out.println("------------------------------------------------------");
                            break;
                        }

                        System.out.println();
                        System.out.println("--------------------------------");
                        System.out.println("|   CREATE A VENDING MACHINE   |");
                        System.out.println("|                              |");
                        System.out.println("| [1] Regular Vending Machine  |");
                        System.out.println("| [2] Special Vending Machine  |");
                        System.out.println("| [3] Return to Main Menu      |");
                        System.out.println("--------------------------------");
                        System.out.println();

                        System.out.print("Enter choice: ");
                        nChoice = scan.nextInt();
                        System.out.println();
                        System.out.println();

                        switch (nChoice) {
                            // ! CREATE A VENDING MACHINE SWITCH CASE
                            case 1:
                                System.out.println("------------------------------------------------------");
                                System.out.println("|    Regular Vending Machine successfully created!   |");
                                System.out.println("------------------------------------------------------");
                                regularVendingMachine = new RegularVendingMachine();
                                regularVendingMachine.setupVendingMachine();
                                System.out.println();
                                break;
                            // ! CREATE A VENDING MACHINE SWITCH CASE
                            case 2:
                                System.out.println("------------------------------------------------------");
                                System.out.println("| Special Vending Machine is currently not available |");
                                System.out.println("------------------------------------------------------");
                                break;
                            // ! CREATE A VENDING MACHINE SWITCH CASE
                            case 3:
                                bFlag = 3;
                                break;
                            default:
                                System.out.println("\t!! INVALID INPUT !!");
                        }
                    }
                    break;
                // ! MAIN MENU SWITCH CASE
                case 2:
                    // ! TEST VENDING MACHINE LOOP
                    do {
                        System.out.println();
                        System.out.println("--------------------------------");
                        System.out.println("|    TEST A VENDING MACHINE    |");
                        System.out.println("|                              |");
                        System.out.println("| [1] Vending Features         |");
                        System.out.println("| [2] Maintenance Features     |");
                        System.out.println("| [3] Return to Main Menu      |");
                        System.out.println("--------------------------------");
                        System.out.println();

                        System.out.print("Enter choice: ");
                        nChoice = scan.nextInt();
                        System.out.println();
                        System.out.println();

                        switch (nChoice) {
                            // ! TEST VENDING MACHINE SWITCH CASE
                            case 1:
                                do {
                                    System.out.println();
                                    System.out.println("--------------------------------");
                                    System.out.println("|       VENDING FEATURES       |");
                                    System.out.println("|                              |");
                                    System.out.println("| [1] Insert Cash              |");
                                    System.out.println("| [2] Display Items            |");
                                    System.out.println("| [3] Exit Vending Features    |");
                                    System.out.println("--------------------------------");
                                    System.out.println();

                                    System.out.print("Enter choice: ");
                                    nChoice = scan.nextInt();
                                    System.out.println();
                                    System.out.println();

                                    switch (nChoice) {
                                        // ! VENDING FEATURES SWITCH CASE
                                        case 1:
                                            for (ItemSlot slot : regularVendingMachine.getVendingSlot()) {
                                                System.out.println(
                                                        "-------------" + slot.getslotIndex() + "------------");
                                                System.out.println("Item Name: \t" + slot.getItem().getItemName());
                                                System.out.println("Item Price: \t" + slot.getItem().getItemPrice());
                                                System.out.println(
                                                        "Item Calories: \t" + slot.getItem().getItemCalories());
                                                System.out.println(
                                                        "Item Quantity: \t" + slot.getItem().getItemQuantity());

                                            }
                                            System.out.println("--------------------------");
                                            System.out.println(
                                                    "\nMachine only accepts denominations of 200, 100, 50, 20, 10, 5, 1");
                                            System.out.println("Enter [0] to finish inserting Money...\n");
                                            int nAmount;

                                            // ! TAKE IN AMOUNT FOR PURCHASE
                                            do {
                                                System.out.print("Insert Amount: ");
                                                nAmount = scan.nextInt();
                                                if (regularVendingMachine.insertPayment(nAmount))
                                                    initialBalance += nAmount;
                                            } while (nAmount != 0);

                                            // ! TAKE IN ITEM FOR PURCHASE
                                            System.out.print("\nEnter Item No. [1 - "
                                                    + regularVendingMachine.getVendingSlot().size() + "]: ");
                                            nChoice = scan.nextInt();
                                            System.out.println();
                                            System.out.print("Enter Quantity: ");
                                            int nQuantity = scan.nextInt();
                                            regularVendingMachine.displayToPurchase(nChoice - 1, nQuantity);
                                            System.out.println("Balance: " + initialBalance);

                                            // ! CHECK IF TRANSACTION IS POSSIBLE
                                            int nConfirm;
                                            boolean invalidInput = true;
                                            do {
                                                System.out.print("Confirm transaction? [1/0]:");
                                                nConfirm = scan.nextInt();
                                                if (nConfirm == 1) {
                                                    if (initialBalance >= (regularVendingMachine.getVendingSlot()
                                                            .get(nChoice - 1)
                                                            .getItem().getItemPrice() * nQuantity)) {
                                                        regularVendingMachine.purchaseItem(nChoice - 1, nQuantity);
                                                        System.out.println("Item successfully purchased.");
                                                        initialBalance = 0;
                                                        invalidInput = false;
                                                    } else {
                                                        System.out.println(
                                                                "\nTransaction Cancelled.");
                                                        System.out.println(
                                                                "Not enough balance for purchase.\n");
                                                        invalidInput = false;
                                                        initialBalance = 0;
                                                    }
                                                } else if (nConfirm == 0) {
                                                    System.out.println(
                                                            "Transaction Cancelled.\n");
                                                    invalidInput = false;
                                                } else
                                                    System.out.println("!! INVALID INPUT !!");
                                            } while (invalidInput);
                                            bFlag = 1;
                                            break;
                                        // ! VENDING FEATURES SWITCH CASE
                                        case 2:
                                            for (ItemSlot slot : regularVendingMachine.getVendingSlot()) {
                                                System.out.println(
                                                        "-------------" + slot.getslotIndex() + "------------");
                                                System.out.println("Item Name: \t" + slot.getItem().getItemName());
                                                System.out.println("Item Price: \t" + slot.getItem().getItemPrice());
                                                System.out.println(
                                                        "Item Calories: \t" + slot.getItem().getItemCalories());
                                                System.out.println(
                                                        "Item Quantity: \t" + slot.getItem().getItemQuantity());
                                            }
                                            bFlag = 1;
                                            break;
                                        // ! VENDING FEATURES SWITCH CASE
                                        case 3:
                                            bFlag = 3;
                                            break;
                                        default:
                                            System.out.println("\t!! INVALID INPUT !!");
                                    }
                                } while (bFlag != 3);
                                break;
                            // ! TEST VENDING MACHINE SWITCH CASE
                            case 2:
                                break;
                            // ! TEST VENDING MACHINE SWITCH CASE
                            case 3:
                                bFlag = 3;
                                break;
                            default:
                                System.out.println("\t!! INVALID INPUT !!");
                        }
                    } while (bFlag != 3);
                    break;
                // ! MAIN MENU SWITCH CASE
                case 3:
                    bFlag = 3;
                    break;
                default:
                    System.out.println("\t!! INVALID INPUT !!");

            }
        } while (bFlag != 3);

        scan.close();
    }
}
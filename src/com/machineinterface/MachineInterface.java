package com.machineinterface;

import java.util.*;

import com.item.Item;
import com.itemslot.ItemSlot;
import com.regularvendingmachine.RegularVendingMachine;

public class MachineInterface {
    private RegularVendingMachine regularVendingMachine;
    private int nChoice;
    Scanner scan = new Scanner(System.in);

    public int displayMainMenu() {
        System.out.println();
        System.out.println("--------------------------------");
        System.out.println("|    VENDING MACHINE FACTORY   |");
        System.out.println("--------------------------------");
        System.out.println("|\t    MAIN MENU          |");
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
        return nChoice;
    }

    public void createVendingMachine() {
        if (regularVendingMachine != null) {
            System.out.println("------------------------------------------------------");
            System.out.println("| !!! A vending machine has been created already !!! |");
            System.out.println("------------------------------------------------------");

            displayMainMenu();
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

        switch (this.nChoice) {
            case 1:
                System.out.println("------------------------------------------------------");
                System.out.println("|    Regular Vending Machine successfully created!   |");
                System.out.println("------------------------------------------------------");
                this.regularVendingMachine = new RegularVendingMachine();

                System.out.println();

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

        switch (this.nChoice) {
            case 1:
                displayVendingFeatures();
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
        System.out.println("--------------------------------");
        System.out.println("|       VENDING FEATURES       |");
        System.out.println("|                              |");
        System.out.println("| [1] Show available items     |");
        System.out.println("| [2] Purchase an item         |");
        System.out.println("| [3] Exit Vending Features    |");
        System.out.println("--------------------------------");
        System.out.println();

        System.out.print("Enter choice: ");
        nChoice = scan.nextInt();
        System.out.println();
        System.out.println();

        switch (this.nChoice) {
            case 1:
                System.out.println("--------------------------");
                // for (ItemSlot slot : regularVendingMachine.getVendingSlot()) {

                // System.out.println("Slot Name: " + slotName);
                // System.out.println("Item Name: " + item.getItemName());
                // System.out.println("Item Price: " + item.getItemPrice());
                // System.out.println("Item Calories: " + item.getItemCalories());
                // System.out.println("Item Quantity: " + item.getItemQuantity());
                System.out.println("--------------------------");
                // }
                System.out.println();
                displayVendingFeatures();
                break;
            case 2:
                System.out.print("Enter the item index: ");
                int nItemIndex = scan.nextInt();

                System.out.print("Enter the item quantity: ");
                int nItemQuantity = scan.nextInt();
                System.out.println();

                Item itemBeforePurchase = regularVendingMachine.getVendingSlot().get(nItemIndex).getItem();

                // purchase
                regularVendingMachine.purchaseItem(nItemIndex, nItemQuantity);

                Item itemAfterPurchase = regularVendingMachine.getVendingSlot().get(nItemIndex).getItem();

                // print selected item details
                System.out.println("------------ITEM SUMMARY-------------");
                System.out.println("Item: \t\t" + itemAfterPurchase.getItemName());
                System.out.println("Price: \t\t" + itemAfterPurchase.getItemPrice());
                System.out.println("Calories: \t" + itemAfterPurchase.getItemCalories());
                System.out.println("Quantity: \t" + nItemQuantity);
                System.out.println("-------------------------------------");
                System.out.println();

                System.out.println("Proceed to payment?");
                System.out.println("[1] Yes");
                System.out.println("[2] No\n"); // go back to displayVendingFeatures

                System.out.print("Input choice: ");
                int nProceed = scan.nextInt();
                System.out.println();

                switch (nProceed) {
                    case 1:
                        System.out.println("Enter amount to pay (1, 5, 10, 20, 50, 100, 200):");
                        int nPayment = scan.nextInt();
                        scan.close();
                        System.out.println();
                        regularVendingMachine.insertPayment(nPayment);
                        regularVendingMachine.calculateChange(nPayment, nItemIndex,
                                itemBeforePurchase.getItemQuantity());
                        System.out.println();
                        System.out.println("------------------------");
                        System.out.println("|  Purchase Complete!  |");
                        System.out.println("------------------------\n");
                        System.exit(0);
                        break;
                    case 2:
                        displayVendingFeatures();
                        break;
                }

                this.nChoice = scan.nextInt();

                scan.close();
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
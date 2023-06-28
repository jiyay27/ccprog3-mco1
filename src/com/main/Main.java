package com.main;

import java.util.Scanner;

import com.item.Item;
import com.itemslot.ItemSlot;
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
                    while (bFlag != 4) {
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
                                if (regularVendingMachine == null) {
                                    System.out.println("------------------------------------------------------");
                                    System.out.println("|    Regular Vending Machine successfully created!   |");
                                    System.out.println("------------------------------------------------------");
                                    regularVendingMachine = new RegularVendingMachine();
                                    regularVendingMachine.setupVendingMachine();
                                    System.out.println();
                                } else {
                                    System.out
                                            .println("--------------------------------------------------------------");
                                    System.out
                                            .println("| !!! A regular vending machine has been created already !!! |");
                                    System.out
                                            .println("--------------------------------------------------------------");
                                }
                                break;

                            // ! CREATE A VENDING MACHINE SWITCH CASE
                            case 2:
                                System.out.println("------------------------------------------------------");
                                System.out.println("| Special Vending Machine is currently not available |");
                                System.out.println("------------------------------------------------------");
                                break;

                            // ! CREATE A VENDING MACHINE SWITCH CASE
                            case 3:
                                bFlag = 4;
                                break;
                            default:
                                System.out.println("\t!! INVALID INPUT !!");
                        }
                    }
                    break;

                // ! MAIN MENU SWITCH CASE
                case 2:

                    // ! TEST VENDING MACHINE LOOP
                    if (regularVendingMachine != null)
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
                                                    System.out
                                                            .println("Item Price: \t" + slot.getItem().getItemPrice());
                                                    System.out.println(
                                                            "Item Calories: \t" + slot.getItem().getItemCalories());
                                                    System.out.println(
                                                            "Item Quantity: \t" + slot.getItem().getItemQuantity());

                                                }
                                                System.out.println("--------------------------");
                                                System.out.println(
                                                        "\nNOTE: Machine only accepts denominations \n\tof 200, 100, 50, 20, 10, 5, 1\n");
                                                System.out.println("Enter [0] to finish inserting Money...\n");
                                                int nAmount;

                                                // ! TAKE IN AMOUNT FOR PURCHASE
                                                do {
                                                    System.out.print("Insert Amount: ");
                                                    nAmount = scan.nextInt();
                                                    if (regularVendingMachine.insertPayment(nAmount))
                                                        initialBalance += nAmount;
                                                    else
                                                        System.out.println("INVALID BILL.");

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

                                                            int nChange = regularVendingMachine.calculateChange(
                                                                    initialBalance,
                                                                    nChoice - 1, nQuantity);

                                                            regularVendingMachine.getMoneyBox()
                                                                    .addEarnings(initialBalance, nChange);
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
                                                break;
                                            // ! VENDING FEATURES SWITCH CASE
                                            case 2:
                                                for (ItemSlot slot : regularVendingMachine.getVendingSlot()) {
                                                    System.out.println(
                                                            "-------------" + slot.getslotIndex() + "------------");
                                                    System.out.println("Item Name: \t" + slot.getItem().getItemName());
                                                    System.out
                                                            .println("Item Price: \t" + slot.getItem().getItemPrice());
                                                    System.out.println(
                                                            "Item Calories: \t" + slot.getItem().getItemCalories());
                                                    System.out.println(
                                                            "Item Quantity: \t" + slot.getItem().getItemQuantity());
                                                }
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
                                // ! MAINTENANCE SWITCH CASE LOOP
                                case 2:
                                    do {
                                        System.out.println();
                                        System.out.println("--------------------------------");
                                        System.out.println("|          MAINTENANCE         |");
                                        System.out.println("|                              |");
                                        System.out.println("| [1] Stock New Items          |");
                                        System.out.println("| [2] Restock Items            |");
                                        System.out.println("| [3] Set Item Prices          |");
                                        System.out.println("| [4] Collect Earnings         |");
                                        System.out.println("| [5] Replenish Change         |");
                                        System.out.println("| [6] Display Transactions     |");
                                        System.out.println("| [7] Exit Maintenance         |");
                                        System.out.println("--------------------------------");
                                        System.out.println();

                                        System.out.print("Enter choice: ");
                                        nChoice = scan.nextInt();
                                        System.out.println();
                                        System.out.println();
                                        switch (nChoice) {
                                            // ! MAINTENANCE SWITCH CASE
                                            case 1:
                                                String newItemName;
                                                int newItemPrice;
                                                int newItemCalories;
                                                int newItemQuantity;

                                                System.out.println("------- ADD NEW ITEM -------");
                                                System.out.println();
                                                System.out.print("Enter Name: ");
                                                newItemName = scan.next();
                                                if (newItemName == "0") {
                                                    System.out.print("Enter Price: ");
                                                    newItemPrice = scan.nextInt();

                                                    System.out.print("Enter Calories: ");
                                                    newItemCalories = scan.nextInt();

                                                    do {
                                                        System.out.print("Enter Quantity: ");
                                                        newItemQuantity = scan.nextInt();
                                                        if (regularVendingMachine.findItem(newItemName) == false
                                                                && newItemQuantity <= 15) {
                                                            regularVendingMachine.getVendingSlot()
                                                                    .add(new ItemSlot(
                                                                            regularVendingMachine.getVendingSlot()
                                                                                    .size(),
                                                                            new Item(newItemName, newItemPrice,
                                                                                    newItemCalories,
                                                                                    newItemQuantity)));
                                                            System.out.print("\nNew Item Added!");
                                                        } else
                                                            System.out.println(
                                                                    "\nItem Capacity Exceed.\nMAX CAPACITY - 15\n");
                                                    } while (newItemQuantity > 15);
                                                }
                                                break;

                                            // ! MAINTENANCE SWITCH CASE
                                            case 2:
                                                System.out.println("------- RESTOCK ITEM -------");
                                                System.out.println();

                                                for (ItemSlot slot : regularVendingMachine.getVendingSlot()) {
                                                    System.out.println(
                                                            "-------------" + slot.getslotIndex() + "------------");
                                                    System.out.println("Item Name: \t" + slot.getItem().getItemName());
                                                    System.out
                                                            .println("Item Qty: \t" + slot.getItem().getItemQuantity());
                                                }

                                                System.out.println("\nEnter [0] to exit...");
                                                System.out.print("Choose Item: ");
                                                int nItemIndex = scan.nextInt();
                                                nItemIndex--;
                                                int nItemQuantity;
                                                if (nItemIndex + 1 != 0)
                                                    do {
                                                        System.out.print("Add Amount: ");
                                                        nItemQuantity = scan.nextInt();
                                                        if (regularVendingMachine.getVendingSlot().get(nItemIndex)
                                                                .getItem()
                                                                .canRestock(nItemQuantity)) {
                                                            regularVendingMachine.getVendingSlot().get(nItemIndex)
                                                                    .getItem()
                                                                    .restockItem(nItemQuantity);
                                                            System.out.println("Item Successfully Restocked.");
                                                            bFlag = 1;
                                                        }

                                                        else {
                                                            System.out.println("\nCannot restock.");
                                                            System.out.println("MAX CAPACTIY - 15\n");
                                                        }
                                                    } while (bFlag != 1);
                                                else
                                                    System.out.println("Restock cancelled...");
                                                break;

                                            // ! MAINTENANCE SWITCH CASE
                                            case 3:
                                                System.out.println("------- SET PRICE -------");
                                                System.out.println();
                                                for (ItemSlot slot : regularVendingMachine.getVendingSlot()) {
                                                    System.out.println(
                                                            "-------------" + slot.getslotIndex() + "------------");
                                                    System.out.println("Item Name: \t" + slot.getItem().getItemName());
                                                    System.out
                                                            .println("Item Qty: \t" + slot.getItem().getItemPrice());
                                                }
                                                System.out.println("\nEnter [0] to exit...");
                                                System.out.print("Choose Item: ");
                                                nItemIndex = scan.nextInt();
                                                nItemIndex--;
                                                if (nItemIndex + 1 != 0) {
                                                    System.out.print("Enter Price: ");
                                                    newItemPrice = scan.nextInt();
                                                    regularVendingMachine.getVendingSlot().get(nItemIndex).getItem()
                                                            .setItemPrice(newItemPrice);
                                                    System.out.println("\nItem price changed.");
                                                } else
                                                    System.out.println("Price change cancelled...");
                                                break;

                                            // ! MAINTENANCE SWITCH CASE
                                            case 4:
                                                System.out.println("------- TOTAL EARNINGS -------");
                                                System.out.println();
                                                System.out.println(
                                                        "Total: " + regularVendingMachine.getMoneyBox()
                                                                .getTotalEarnings());
                                                int initialEarnings = regularVendingMachine.getMoneyBox()
                                                        .getTotalEarnings();

                                                System.out.print("\n");
                                                System.out.print("Collect Earnings [1/0]: ");
                                                nChoice = scan.nextInt();
                                                if (nChoice == 1) {
                                                    regularVendingMachine.getMoneyBox().collectEarnings();
                                                    System.out.println("\nPhp "
                                                            + initialEarnings
                                                            + " collected from earnings...");
                                                } else
                                                    System.out.println("\nCollection cancelled...");

                                                break;

                                            // ! MAINTENANCE SWITCH CASE
                                            case 5:
                                                System.out.println("------- REPLENISH CHANGE -------");
                                                System.out.println();
                                                System.out.println("Total Change: Php "
                                                        + regularVendingMachine.getMoneyBox().getTotalMoney());
                                                System.out.println();
                                                System.out.println("Replenish Change [1/0]: ");
                                                nChoice = scan.nextInt();
                                                int nAmount;
                                                if (nChoice == 1) {
                                                    nAmount = scan.nextInt();
                                                    regularVendingMachine.getMoneyBox().addMoney(nAmount);
                                                } else
                                                    System.out.println("\nReplenish cancelled...\n");
                                                break;

                                            // ! MAINTENANCE SWITCH CASE
                                            case 6:
                                                System.out.println("------- TRANSACTIONS -------");
                                                System.out.println();
                                                System.out.println();
                                                regularVendingMachine.displayTransactions();
                                                break;

                                            // ! MAINTENANCE SWITCH CASE
                                            case 7:
                                                bFlag = 3;
                                                break;

                                        }
                                    } while (bFlag != 3);
                                    break;
                                // ! TEST VENDING MACHINE SWITCH CASE
                                case 3:
                                    bFlag = 4;
                                    break;
                                default:
                                    System.out.println("\t!! INVALID INPUT !!");
                            }
                        } while (bFlag != 4);
                    else
                        System.out.print("Please first create a new vending machine!");
                    break;
                // ! MAIN MENU SWITCH CASE
                case 3:
                    bFlag = 5;
                    break;
                default:
                    System.out.println("\t!! INVALID INPUT !!");

            }
        } while (bFlag != 5);

        scan.close();
    }
}
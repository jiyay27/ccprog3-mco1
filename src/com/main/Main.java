/*********************************************************************************************************************
This is to certify that this project is our own work, based on our personal efforts in studying and applying the 
concepts learned. We have constructed the methods and their respective algorithms and corresponding code by 
ourselves. The program was run, tested, and debugged by our own efforts. We further certify that we have not copied in 
part or whole or otherwise plagiarized the work of other students and/or persons.
                                                                        
                                                                ARCEGA BEA ALEXIS ADJIE,        DLSU ID# 12209173
                                                                DONATO JOHN JOSEPH DEL ROSARIO, DLSU ID# 12206482
**********************************************************************************************************************/

package com.main;

import java.util.Scanner;

import com.vendingmodel.item.Item;
import com.vendingmodel.itemslot.ItemSlot;
import com.vendingmodel.regularvendingmachine.RegularVendingMachine;

// serves as a driver for the whole program
public class Main {
    public static void main(String[] args) {
        int nChoice = -1;
        int bFlag = -1;
        int initialBalance = 0;
        RegularVendingMachine regularVendingMachine = null;
        Scanner scan = new Scanner(System.in);

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
                    do {
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
                                // checks if vending machine already exists
                                if (regularVendingMachine == null) {
                                    System.out.println("------------------------------------------------------");
                                    System.out.println("|    Regular Vending Machine successfully created!   |");
                                    System.out.println("------------------------------------------------------");
                                    regularVendingMachine = new RegularVendingMachine();
                                    regularVendingMachine.setupVendingMachine();
                                    System.out.println();
                                    bFlag = 1;
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
                                bFlag = 1;
                                break;
                            default:
                                System.out.println("\t!! INVALID INPUT !!");
                        }
                    } while (bFlag != 1);
                    break;

                // ! MAIN MENU SWITCH CASE
                case 2:
                    // ! TEST VENDING MACHINE LOOP
                    // if vending machine object exists
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
                                                // displays item slot objects and its items
                                                for (ItemSlot slot : regularVendingMachine.getVendingSlot()) {
                                                    System.out.println(
                                                            "-------------" + slot.getSlotIndex() + "------------");
                                                    System.out.println("Name: \t\t" + slot.getItem().getItemName());
                                                    System.out
                                                            .println("Price: \t\t" + slot.getItem().getItemPrice());
                                                    System.out.println(
                                                            "Calories: \t" + slot.getItem().getItemCalories());
                                                    System.out.println(
                                                            "Quantity: \t" + slot.getItem().getItemQuantity());

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
                                                    else {
                                                        System.out.println("\n-----------------");
                                                        System.out.println("| INVALID BILL. |");
                                                        System.out.println("-----------------\n");
                                                    }

                                                } while (nAmount != 0);

                                                // ! TAKE IN ITEM FOR PURCHASE
                                                // checks for valid input for item index
                                                do {
                                                    System.out.print("\nEnter Item No. [1 - "
                                                            + regularVendingMachine.getVendingSlot().size() + "]: ");
                                                    nChoice = scan.nextInt();
                                                    if (nChoice >= 1
                                                            && nChoice <= regularVendingMachine.getVendingSlot().size())
                                                        break;
                                                    else
                                                        System.out.println("\n!! INVALID INPUT !!");
                                                } while (nChoice < 1
                                                        || nChoice > regularVendingMachine.getVendingSlot().size());
                                                System.out.println();

                                                System.out.print("Enter Quantity: ");
                                                int nQuantity = scan.nextInt();
                                                regularVendingMachine.displayToPurchase(nChoice - 1, nQuantity);
                                                System.out.println("Balance: " + initialBalance);

                                                // ! CHECK IF TRANSACTION IS POSSIBLE
                                                int nConfirm;
                                                boolean invalidInput = true;
                                                do {
                                                    System.out.print("\nConfirm transaction [1/0]: ");
                                                    nConfirm = scan.nextInt();
                                                    if (nConfirm == 1) {
                                                        if (initialBalance >= (regularVendingMachine.getVendingSlot()
                                                                .get(nChoice - 1)
                                                                .getItem().getItemPrice() * nQuantity)) {
                                                            regularVendingMachine.purchaseItem(nChoice - 1, nQuantity);
                                                            System.out.println("\n--------------------------------");
                                                            System.out.println("| Item successfully purchased. |");
                                                            System.out.println("--------------------------------");

                                                            int nChange = regularVendingMachine.calculateChange(
                                                                    initialBalance,
                                                                    nChoice - 1, nQuantity);

                                                            regularVendingMachine.getMoneyBox()
                                                                    .addEarnings(nChange);
                                                            initialBalance = 0;
                                                            invalidInput = false;

                                                        } else {
                                                            System.out.println(
                                                                    "\n------------------------------------");
                                                            System.out.println(
                                                                    "| Transaction cancelled...         |");
                                                            System.out.println(
                                                                    "| Not enough balance for purchase. |");
                                                            System.out.println(
                                                                    "------------------------------------\n");
                                                            invalidInput = false;
                                                            initialBalance = 0;
                                                        }
                                                    } else if (nConfirm == 0) {
                                                        System.out.println(
                                                                "\n------------------------------------");
                                                        System.out.println(
                                                                "| Transaction cancelled...         |");
                                                        System.out.println(
                                                                "| Balance returned.                |");
                                                        System.out.println(
                                                                "------------------------------------\n");
                                                        invalidInput = false;
                                                        initialBalance = 0;
                                                    } else
                                                        System.out.println("!! INVALID INPUT !!");
                                                } while (invalidInput);
                                                break;
                                            // ! VENDING FEATURES SWITCH CASE
                                            case 2:
                                                // displays items
                                                for (ItemSlot slot : regularVendingMachine.getVendingSlot()) {
                                                    System.out.println(
                                                            "-------------" + slot.getSlotIndex() + "------------");
                                                    System.out.println("Name: \t\t" + slot.getItem().getItemName());
                                                    System.out
                                                            .println("Price: \t\t" + slot.getItem().getItemPrice());
                                                    System.out.println(
                                                            "Calories: \t" + slot.getItem().getItemCalories());
                                                    System.out.println(
                                                            "Quantity: \t" + slot.getItem().getItemQuantity());

                                                }
                                                System.out.println(
                                                        "--------------------------");
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
                                                // variables to be used for new items
                                                String newItemName;
                                                String newItemPrice;
                                                String newItemCalories;
                                                String newItemQuantity;

                                                System.out.println("------- ADD NEW ITEM -------");
                                                System.out.println();
                                                System.out.println(" NOTE: Slot Capacity: 15    ");
                                                System.out.println();
                                                System.out.println("----------------------------");

                                                System.out.println("\nEnter [0] to exit...");
                                                System.out.print("Enter Name: ");
                                                newItemName = scan.nextLine();
                                                newItemName = scan.nextLine(); // to clear input buffer

                                                if (newItemName == "0") {
                                                    System.out.println("\n---------------------------");
                                                    System.out.println("| Process cancelled...    |");
                                                    System.out.println("---------------------------\n");
                                                    break;
                                                }
                                                if (regularVendingMachine.findItem(newItemName) == false) {
                                                    System.out.print("Enter Price: ");
                                                    newItemPrice = scan.nextLine();

                                                    System.out.print("Enter Calories: ");
                                                    newItemCalories = scan.nextLine();

                                                    do {
                                                        System.out.print("Enter Quantity: ");
                                                        newItemQuantity = scan.nextLine();

                                                        // checks if item already exists
                                                        if (regularVendingMachine.findItem(newItemName) == false
                                                                && Integer.valueOf(newItemQuantity) <= 15) {
                                                            regularVendingMachine.getVendingSlot()
                                                                    .add(new ItemSlot(
                                                                            regularVendingMachine.getVendingSlot()
                                                                                    .size() + 1,
                                                                            new Item(newItemName,
                                                                                    Integer.valueOf(newItemPrice),
                                                                                    Integer.valueOf(newItemCalories),
                                                                                    Integer.valueOf(newItemQuantity))));
                                                            System.out.println("\n-------------------");
                                                            System.out.println("| New Item Added. |");
                                                            System.out.println("-------------------\n");
                                                        } else {
                                                            System.out.println("\n-----------------------------");
                                                            System.out.println("| Item capacity exceeded... |");
                                                            System.out.println("| MAX CAPACITY: 15          |");
                                                            System.out.println("-----------------------------\n");
                                                        }
                                                    } while (Integer.valueOf(newItemQuantity) > 15);
                                                } else {
                                                    System.out.println("\n-----------------------------");
                                                    System.out.println("| Item already exists...    |");
                                                    System.out.println("| Process cancelled.        |");
                                                    System.out.println("-----------------------------\n");
                                                }

                                                break;

                                            // ! MAINTENANCE SWITCH CASE
                                            case 2:
                                                System.out.println("------- RESTOCK ITEM -------");
                                                System.out.println();

                                                for (ItemSlot slot : regularVendingMachine.getVendingSlot()) {
                                                    System.out.println(
                                                            "-------------" + slot.getSlotIndex() + "------------");
                                                    System.out.println("Item Name: \t" + slot.getItem().getItemName());
                                                    System.out
                                                            .println("Item Qty: \t" + slot.getItem().getItemQuantity());
                                                }
                                                System.out.println();
                                                System.out.println("----------------------------");
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
                                                            System.out.println("\n--------------------------------");
                                                            System.out.println("| Item successfully restocked. |");
                                                            System.out.println("--------------------------------\n");
                                                            bFlag = 1;
                                                        }

                                                        else {
                                                            System.out.println("\nCannot restock.");
                                                            System.out.println("MAX CAPACTIY - 15\n");
                                                        }
                                                    } while (bFlag != 1);
                                                else {
                                                    System.out.println("\n-----------------------------");
                                                    System.out.println("| Restock cancelled...      |");
                                                    System.out.println("-----------------------------\n");
                                                }
                                                break;

                                            // ! MAINTENANCE SWITCH CASE
                                            case 3:
                                                System.out.println("------- SET PRICE -------");
                                                System.out.println();
                                                for (ItemSlot slot : regularVendingMachine.getVendingSlot()) {
                                                    System.out.println(
                                                            "-------------" + slot.getSlotIndex() + "------------");
                                                    System.out.println("Item Name: \t" + slot.getItem().getItemName());
                                                    System.out
                                                            .println("Item Price: \t" + slot.getItem().getItemPrice());
                                                }
                                                System.out.print("-------------------------\n");
                                                System.out.println("\nEnter [0] to exit...");
                                                System.out.print("Choose Item: ");
                                                nItemIndex = scan.nextInt();
                                                nItemIndex--;
                                                if (nItemIndex + 1 != 0) {
                                                    System.out.print("Enter Price: ");
                                                    newItemPrice = scan.nextLine();
                                                    newItemPrice = scan.nextLine();
                                                    regularVendingMachine.getVendingSlot().get(nItemIndex).getItem()
                                                            .setItemPrice(Integer.valueOf(newItemPrice));
                                                    System.out.println("\nItem price changed.");
                                                } else {
                                                    System.out.println("\n-----------------------------");
                                                    System.out.println("| Price change cancelled... |");
                                                    System.out.println("-----------------------------\n");
                                                }
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
                                                System.out.println();
                                                System.out.println("------------------------------");
                                                System.out.print("\n");
                                                System.out.print("Collect Earnings [1/0]: ");
                                                nChoice = scan.nextInt();
                                                if (nChoice == 1) {
                                                    regularVendingMachine.getMoneyBox().collectEarnings();
                                                    System.out.println("\nPhp "
                                                            + initialEarnings
                                                            + " collected from earnings...");
                                                } else {
                                                    System.out.println("\n-----------------------------");
                                                    System.out.println("| Collection cancelled...   |");
                                                    System.out.println("-----------------------------\n");
                                                }
                                                break;

                                            // ! MAINTENANCE SWITCH CASE
                                            case 5:
                                                System.out.println("------- REPLENISH CHANGE -------");
                                                System.out.println();
                                                System.out.println("Total Change: Php "
                                                        + regularVendingMachine.getMoneyBox().getTotalMoney());
                                                System.out.println();
                                                System.out.println("--------------------------------\n");
                                                System.out.print("Replenish Change [1/0]: ");
                                                nChoice = scan.nextInt();
                                                int nAmount;
                                                if (nChoice == 1) {
                                                    System.out.print("Amount: ");
                                                    nAmount = scan.nextInt();
                                                    regularVendingMachine.getMoneyBox().addMoney(nAmount);

                                                    System.out.println("\n--------------------------");
                                                    System.out.println("| Change replenished!    |");
                                                    System.out.println("--------------------------\n");
                                                } else {
                                                    System.out.println("\n-----------------------------");
                                                    System.out.println("| Replenish cancelled...    |");
                                                    System.out.println("-----------------------------\n");
                                                }
                                                break;

                                            // ! MAINTENANCE SWITCH CASE
                                            case 6:
                                                System.out.println("------- TRANSACTIONS -------");
                                                System.out.println();
                                                regularVendingMachine.displayTransactions();
                                                System.out.println();
                                                System.out.println("----------- END ------------");
                                                break;

                                            // ! MAINTENANCE SWITCH CASE
                                            case 7:
                                                bFlag = 2;
                                                break;

                                        }
                                    } while (bFlag != 2);
                                    break;
                                // ! TEST VENDING MACHINE SWITCH CASE
                                case 3:
                                    bFlag = 4;
                                    break;
                                default:
                                    System.out.println("\t!! INVALID INPUT !!");
                                    break;
                            }

                        } while (bFlag != 4);
                    else {
                        System.out.println("----------------------------------------------");
                        System.out.println("| Please first create a new vending machine! |");
                        System.out.println("----------------------------------------------");
                        break;
                    }
                    break;
                // ! MAIN MENU SWITCH CASE
                case 3:
                    bFlag = 5;
                    break;
                default:
                    System.out.println("\t!! INVALID INPUT !!");
                    break;
            }
        } while (bFlag != 5);
        scan.close();
    }
}
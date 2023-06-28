package com.machineinterface;

import java.util.*;

import com.item.Item;
import com.itemslot.ItemSlot;
import com.regularvendingmachine.RegularVendingMachine;

public class MachineInterface {
    private RegularVendingMachine regularVendingMachine;
    private int nChoice;
    Scanner scan = new Scanner(System.in);
    RegularVendingMachine CRegularVendingMachine = new RegularVendingMachine();

    public int displayMainMenu() {
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
        return nChoice;
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
                RegularVendingMachine cVendingMachine = new RegularVendingMachine();
                cVendingMachine.getVendingSlot()
                        .add(new ItemSlot("Garlic Rice Slot",
                                new Item("Garlic Fried Rice", 25, 366, 15)));
                cVendingMachine.getVendingSlot()
                        .add(new ItemSlot("Fried Egg Slot", new Item("Fried Egg", 15, 92, 15)));
                cVendingMachine.getVendingSlot()
                        .add(new ItemSlot("Beef Tapa Slot", new Item("Beef Tapa", 40, 120, 10)));
                cVendingMachine.getVendingSlot()
                        .add(new ItemSlot("Longganisa Slot", new Item("Longganisa", 30, 136, 15)));
                cVendingMachine.getVendingSlot()
                        .add(new ItemSlot("Tocino Slot", new Item("Tocino", 30, 230, 15)));
                cVendingMachine.getVendingSlot()
                        .add(new ItemSlot("Hotdog Slot", new Item("Hotdog", 20, 247, 15)));
                cVendingMachine.getVendingSlot()
                        .add(new ItemSlot("Shanghai Slot", new Item("Lumpiang Shanghai", 35, 215, 15)));
                cVendingMachine.getVendingSlot()
                        .add(new ItemSlot("Bangus Slot", new Item("Bangus", 30, 178, 15)));
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
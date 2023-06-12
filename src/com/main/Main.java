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
                    CVendingMachineInterface.selectVendingMachine(nChoice);
                    break;
                case 2:

                    break;
                case 3:
                    bStop = true;
                    break;
                default:
                    System.out.println("!!! INVALID INPUT !!!\n\n");

                    CVendingMachineInterface.displayMainMenu();

                    System.out.print("Enter choice: ");
                    nChoice = scan.nextInt();
                    System.out.println();
            }
        }

        scan.close();
    }
}
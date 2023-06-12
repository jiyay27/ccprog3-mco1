package com.main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int nChoice;
        boolean bStop = false;

        while (!bStop) {
            System.out.println();
            System.out.println("\t MAIN MENU \t\n" +
                    "\n[1] Create a Vending Machine" +
                    "\n[2] Test a Vending Machine" +
                    "\n[3] Exit\n");

            System.out.print("Enter choice: ");
            nChoice = scan.nextInt();
            System.out.println();

            switch (nChoice) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:
                    bStop = true;
                    break;
            }
        }

        scan.close();
    }
}
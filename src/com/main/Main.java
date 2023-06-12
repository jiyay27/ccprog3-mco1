package com.main;

// import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int nChoice;

        System.out.println();
        System.out.println("\t MAIN MENU \t\n" +
                "\n[1] Create a Vending Machine" +
                "\n[2] Test a Vending Machine" +
                "\n[3] Exit\n");
        nChoice = scan.nextInt();

        scan.close();
    }
}
package com.main;

// import java.util.Scanner;

import com.machineinterface.MachineInterface;
import com.regularvendingmachine.RegularVendingMachine;

public class Main {
    public static void main(String[] args) {

        RegularVendingMachine CVendingMachine = new RegularVendingMachine();
        MachineInterface CMachineInterface = new MachineInterface();
        int nBalance = 0;
        CVendingMachine.setupVendingMachine();
        // for (int i = 0; i < vendingMachine.getVendingSlot().size(); i++)
        CVendingMachine.getVendingSlot().get(1).listSlotInfo();

        System.out.println();

        System.out.println("Balance: " + nBalance);

        System.out.println("Earnings: " + CVendingMachine.getMoneyBox().getTotalEarnings());

        nBalance = nBalance + CVendingMachine.insertPayment(200);

        System.out.println("Balance: " + nBalance);

        System.out.println("Earnings: " + CVendingMachine.getMoneyBox().getTotalEarnings());

        CVendingMachine.calculateChange(nBalance, 1, 5);

        CVendingMachine.purchaseItem(1, 5);

        CVendingMachine.getVendingSlot().get(1).listSlotInfo();

        CVendingMachine.displayTransactions();

        CMachineInterface.displayMainMenu();
    }
}
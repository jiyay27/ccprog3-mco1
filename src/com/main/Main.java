package com.main;

import java.util.Scanner;

// import com.item.Item;
// import com.itemslot.ItemSlot;
// import com.machineinterface.MachineInterface;
import com.regularvendingmachine.RegularVendingMachine;
// import com.item.Item;
// import com.itemslot.ItemSlot;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        RegularVendingMachine vendingMachine = new RegularVendingMachine();
        int nBalance = 0;
        vendingMachine.setupVendingMachine();
        // for (int i = 0; i < vendingMachine.getVendingSlot().size(); i++)
        vendingMachine.getVendingSlot().get(1).listSlotInfo();

        System.out.println("Balance: " + nBalance);

        System.out.println("Earnings: " + vendingMachine.getMoneyBox().getTotalEarnings());

        nBalance = nBalance + vendingMachine.insertPayment(200);

        System.out.println("Balance: " + nBalance);

        System.out.println("Earnings: " + vendingMachine.getMoneyBox().getTotalEarnings());

        vendingMachine.calculateChange(nBalance, 1, 5);

        vendingMachine.purchaseItem(1, 5);

        vendingMachine.getVendingSlot().get(1).listSlotInfo();

        vendingMachine.displayTransactions();
    }
}
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
        int nBalance = 0;
        RegularVendingMachine vendingMachine = new RegularVendingMachine();

        vendingMachine.setupVendingMachine();
        vendingMachine.getVendingSlot().get(1).listSlotInfo();

        System.out.println("Balance: " + nBalance);

        nBalance = vendingMachine.insertPayment(100);

        vendingMachine.calculateChange(nBalance);

        vendingMachine.purchaseItem(1, 5);

        vendingMachine.getVendingSlot().get(1).listSlotInfo();
    }
}
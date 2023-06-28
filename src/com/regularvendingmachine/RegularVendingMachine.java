package com.regularvendingmachine;

import java.util.*;
import com.moneybox.MoneyBox;
import com.item.Item;
import com.itemslot.ItemSlot;

public class RegularVendingMachine {
    private ArrayList<ItemSlot> vendingSlots;
    private MoneyBox vendingMoney;
    private ArrayList<String> transactions;

    public RegularVendingMachine() {
        this.vendingSlots = new ArrayList<ItemSlot>();
        this.vendingMoney = new MoneyBox();
        this.transactions = new ArrayList<String>();
    }

    public void setupVendingMachine() {
        vendingSlots.add(new ItemSlot("Garlic Rice Slot",
                new Item("Garlic Fried Rice", 25, 366, 15)));
        vendingSlots
                .add(new ItemSlot("Fried Egg Slot", new Item("Fried Egg", 15, 92, 15)));
        vendingSlots
                .add(new ItemSlot("Beef Tapa Slot", new Item("Beef Tapa", 40, 120, 10)));
        vendingSlots
                .add(new ItemSlot("Longganisa Slot", new Item("Longganisa", 30, 136, 15)));
        vendingSlots
                .add(new ItemSlot("Tocino Slot", new Item("Tocino", 30, 230, 15)));
        vendingSlots
                .add(new ItemSlot("Hotdog Slot", new Item("Hotdog", 20, 247, 15)));
        vendingSlots
                .add(new ItemSlot("Shanghai Slot", new Item("Lumpiang Shanghai", 35, 215, 15)));
        vendingSlots
                .add(new ItemSlot("Bangus Slot", new Item("Bangus", 30, 178, 15)));
    }

    // meow

    public void purchaseItem(int nItemIndex, int nItemQuantity) {
        if (this.vendingSlots.get(nItemIndex).getItemAvailability() == true)
            if (nItemQuantity <= this.vendingSlots.get(nItemIndex).getItem().getItemQuantity()) {
                this.vendingSlots.get(nItemIndex).getItem().buyItem(nItemQuantity);

                this.transactions.add("Item: \t\t" + this.vendingSlots.get(nItemIndex).getItem().getItemName()
                        + "\nQuantity: \t" + nItemQuantity);
            } else
                System.out.println("Item amount exceeded.");
    }

    public int insertPayment(int nAmount) {
        this.vendingMoney.insertMoney(nAmount);
        return nAmount;
    }

    // TODO: should also display inventory before and after transactions
    public void displayTransactions() {
        System.out.println("\nTotal Sold: ");
        for (String item : this.transactions) {
            System.out.println(item);
        }
        System.out.println();
    }

    // TODO: create logic for sukli T_T
    public void calculateChange(int nPayment, int nItemIndex, int nItemQuantity) {
        int nChangeHolder = 0;
        int nChange = 0;
        int nChange200 = 0;
        int nChange100 = 0;
        int nChange50 = 0;
        int nChange20 = 0;
        int nChange10 = 0;
        int nChange5 = 0;
        int nChange1 = 0;

        if (vendingMoney.isEmpty()) {
            System.out.println("Order cancelled...\nNot enough change for transaction.");
        } else if (nItemQuantity <= vendingSlots.get(nItemIndex).getItem().getItemQuantity()) {
            if (nPayment >= vendingSlots.get(nItemIndex).getItem().getItemPrice() * nItemQuantity)
                nChangeHolder = nPayment - vendingSlots.get(nItemIndex).getItem().getItemPrice() * nItemQuantity;

            System.out.println();
            System.out.println("Change: " + nChangeHolder);
            System.out.println("In these denominations:");
            System.out.println("200 x " + nChange200);
            System.out.println("100 x " + nChange100);
            System.out.println(" 50 x " + nChange50);
            System.out.println(" 20 x " + nChange20);
            System.out.println(" 10 x " + nChange10);
            System.out.println("  5 x " + nChange5);
            System.out.println("  1 x " + nChange1);
        } else
            System.out.println("Payment not enough. Please insert the right amount.");

    }

    public void replenishChange(int nAmount) {
        this.vendingMoney.insertMoney(nAmount);
    }

    public void getEarnings() {
        this.vendingMoney.collectEarnings();
    }

    public ArrayList<ItemSlot> getVendingSlot() {
        return this.vendingSlots;
    }

    public MoneyBox getMoneyBox() {
        return this.vendingMoney;
    }

}

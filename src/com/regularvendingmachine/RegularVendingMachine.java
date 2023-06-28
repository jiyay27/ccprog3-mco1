package com.regularvendingmachine;

import java.util.*;
import com.moneybox.MoneyBox;
import com.item.Item;
import com.itemslot.ItemSlot;

public class RegularVendingMachine {
    private ArrayList<ItemSlot> vendingSlot;
    private MoneyBox vendingMoney;
    private ArrayList<String> transactions;

    public RegularVendingMachine() {
        this.vendingSlot = new ArrayList<ItemSlot>();
        this.vendingMoney = new MoneyBox();
        this.transactions = new ArrayList<String>();
    }

    public void setupVendingMachine() {
        vendingSlot.add(new ItemSlot("Garlic Rice Slot",
                new Item("Garlic Fried Rice", 25, 366, 15)));
        vendingSlot
                .add(new ItemSlot("Fried Egg Slot", new Item("Fried Egg", 15, 92, 15)));
        vendingSlot
                .add(new ItemSlot("Beef Tapa Slot", new Item("Beef Tapa", 40, 120, 10)));
        vendingSlot
                .add(new ItemSlot("Longganisa Slot", new Item("Longganisa", 30, 136, 15)));
        vendingSlot
                .add(new ItemSlot("Tocino Slot", new Item("Tocino", 30, 230, 15)));
        vendingSlot
                .add(new ItemSlot("Hotdog Slot", new Item("Hotdog", 20, 247, 15)));
        vendingSlot
                .add(new ItemSlot("Shanghai Slot", new Item("Lumpiang Shanghai", 35, 215, 15)));
        vendingSlot
                .add(new ItemSlot("Bangus Slot", new Item("Bangus", 30, 178, 15)));
    }

    // meow

    public void purchaseItem(int nItemIndex, int nItemQuantity) {
        if (this.vendingSlot.get(nItemIndex).getItemAvailability() == true)
            if (nItemQuantity <= this.vendingSlot.get(nItemIndex).getItem().getItemQuantity()) {
                this.vendingSlot.get(nItemIndex).getItem().buyItem(nItemQuantity);

                this.transactions.add("Item: \t\t" + this.vendingSlot.get(nItemIndex).getItem().getItemName()
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
    }

    // TODO: create logic for sukli T_T
    public void calculateChange(int nPayment, int nItemIndex, int nItemQuantity) {
        int changeHolder = 0;
        int change = 0;
        int change200 = 0;
        int change100 = 0;
        int change50 = 0;
        int change20 = 0;
        int change10 = 0;
        int change5 = 0;
        int change1 = 0;

        if (vendingMoney.isEmpty()) {
            System.out.println("Order cancelled...\nNot enough change for transaction.");
        } else if (nItemQuantity <= vendingSlot.get(nItemIndex).getItem().getItemQuantity()) {
            if (nPayment >= vendingSlot.get(nItemIndex).getItem().getItemPrice() * nItemQuantity)
                changeHolder = nPayment - vendingSlot.get(nItemIndex).getItem().getItemPrice() * nItemQuantity;
            System.out.println("Change: " + changeHolder);
            System.out.println("In these denominations:");
            System.out.println("200 x " + change200);
            System.out.println("100 x " + change100);
            System.out.println(" 50 x " + change50);
            System.out.println(" 20 x " + change20);
            System.out.println(" 10 x " + change10);
            System.out.println("  5 x " + change5);
            System.out.println("  1 x " + change1);
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
        return this.vendingSlot;
    }

    public MoneyBox getMoneyBox() {
        return this.vendingMoney;
    }

}

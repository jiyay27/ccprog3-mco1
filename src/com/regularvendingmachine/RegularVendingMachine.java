package com.regularvendingmachine;

import java.util.*;
import com.moneybox.MoneyBox;
import com.item.Item;
import com.itemslot.ItemSlot;

public class RegularVendingMachine {
    private ArrayList<ItemSlot> vendingSlot;
    private MoneyBox vendingMoney;

    public RegularVendingMachine() {
        this.vendingSlot = new ArrayList<ItemSlot>();
        this.vendingMoney = new MoneyBox();
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

    // TODO:
    public void purchaseItem(int itemIndex, int nItemQuantity) {
        if (this.vendingSlot.get(itemIndex).getItemAvailability() == true)
            if (nItemQuantity <= this.vendingSlot.get(itemIndex).getItem().getItemQuantity()) {
                this.vendingSlot.get(itemIndex).getItem().buyItem(nItemQuantity);
            } else
                System.out.println("Item amount exceeded.");
    }

    // public void updateVendingMachine(int itemIndex, int nItemQuantity) {
    // if(this.vendingSlot.get(itemIndex).getItemAvailability()) {

    // }
    // }

    public int insertPayment(int nAmount) {
        this.vendingMoney.insertMoney(nAmount);
        return nAmount;
    }

    // TODO:
    public void displayTransactions() {

    }

    // TODO: create logic for sukli
    public void calculateChange(int payment, int itemIndex, int nItemQuantity) {
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
        } else if (nItemQuantity <= vendingSlot.get(itemIndex).getItem().getItemQuantity()) {
            if (payment >= vendingSlot.get(itemIndex).getItem().getItemPrice() * nItemQuantity)
                changeHolder = payment - vendingSlot.get(itemIndex).getItem().getItemPrice() * nItemQuantity;
            change = changeHolder;
            if (change >= 200) {
                change200 = changeHolder / 200;
                change -= change200 * 200;
            }
            if (change >= 100) {
                change100 = changeHolder / 100;
                change -= change100 * 100;
            }
            if (change >= 50) {
                change50 = changeHolder / 50;
                change -= change50 * 50;
            }
            if (change >= 20) {
                change20 = changeHolder / 20;
                change -= change20 * 20;
            }
            if (change >= 10) {
                change10 = changeHolder / 10;
                change -= change10 * 10;
            }
            if (change >= 5) {
                change5 = changeHolder / 5;
                change -= change5 * 5;
            }
            if (change >= 1) {
                change1 = changeHolder / 1;
                change -= change1;
            }
            System.out.println("Change: " + changeHolder);
            System.out.println("In these denominations:");
            System.out.println("200 x " + change200);
            System.out.println("100 x " + change100);
            System.out.println("50 x " + change50);
            System.out.println("20 x " + change20);
            System.out.println("10 x " + change10);
            System.out.println("5 x " + change5);
            System.out.println("1 x " + change1);
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

    // public Item getItem(String name) {
    // Item theItem = null;
    // for (Item item : soemething something) {
    // if (item.getItemName().equals(name))
    // theItem = item;
    // break;
    // }
    // return theItem;
    // }

}

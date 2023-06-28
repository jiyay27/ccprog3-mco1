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
    public void calculateChange(int payment) {
        if (vendingMoney.isEmpty()) {
            System.out.println("Order cancelled...\nNot enough change for transaction.");
        } else {
            // if ()
        }
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

package com.regularvendingmachine;

import java.util.*;
import com.moneybox.MoneyBox;
import com.item.Item;
import com.itemslot.ItemSlot;

public class RegularVendingMachine {
    private String strVendingName;
    private ArrayList<ItemSlot> vendingSlot;
    private MoneyBox vendingMoney;
    private int MAX_CAPACITY = 15;

    public RegularVendingMachine() {
        this.strVendingName = null;
        this.vendingSlot = new ArrayList<ItemSlot>();
        this.vendingMoney = new MoneyBox();
    }

    public RegularVendingMachine(String strVendingName) {
        this.strVendingName = strVendingName;
        this.vendingSlot = new ArrayList<ItemSlot>();
        this.vendingMoney = new MoneyBox();
    }

    // meow
    // TODO:
    public boolean purchaseItem() {
        return true;
    }

    public Item getItem(String name) {
        Item theItem = null;
        for (Item item : soemething something) {
            if (item.getItemName().equals(name))
                theItem = item;
            break;
        }

        return theItem;
    }

    // TODO:
    public void restockItem(int slotIndex, Item item) {
        if (this.vendingSlot.get(slotIndex).getItemQuantity() < MAX_CAPACITY)
            
        else
            System.out.println("ERROR: Item slot full!");
    }

    // TODO:
    public void replenishChange() {

    }

    // TODO:
    public void collectEarnings() {

    }

    // TODO:
    public void displayTransactions() {

    }

    // TODO:
    public void getItemQuantity() {

    }

}

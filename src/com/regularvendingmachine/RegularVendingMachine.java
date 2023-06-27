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

    // meow
    // TODO:
    public boolean purchaseItem() {
        return true;
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

    // TODO:
    public void displayTransactions() {

    }

    // TODO:
    public ArrayList<ItemSlot> getVendingSlot() {
        return this.vendingSlot;
    }

}

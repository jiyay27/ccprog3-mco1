package com.regularvendingmachine;

import java.util.*;
import com.moneybox.MoneyBox;
import com.itemslot.ItemSlot;

public class RegularVendingMachine {
    private String strVendingName;
    private ArrayList<ItemSlot> vendingSlot;
    private MoneyBox vendingMoney;

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
    public void getItemQuantity() {

    }

}

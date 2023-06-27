package com.regularvendingmachine;

import java.util.*;
import com.moneybox.MoneyBox;
import com.itemslot.ItemSlot;
import com.money.Money;

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

    // TODO:
    public void restockItem() {

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

    // TODO:
    public void setItemPrice(ArrayList<ItemSlot> item) {

    }
}

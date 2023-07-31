package com.vendingmodel.vendingmachine;

import java.util.*;

import com.vendingmodel.item.Item;
import com.vendingmodel.itemslot.ItemSlot;
import com.vendingmodel.moneybox.MoneyBox;

public class VendingMachine {
    private ArrayList<ItemSlot> CVendingSlot;
    private MoneyBox vendingMoney;
    private ArrayList<String> transactions;

    public VendingMachine() {
        this.CVendingSlot = new ArrayList<ItemSlot>();
        this.vendingMoney = new MoneyBox();
        this.transactions = new ArrayList<String>();
    }

    public void setupVendingMachine() {

    }

    public void purchaseItem(int nItemIndex, int nItemQuantity) {
        if (this.CVendingSlot.get(nItemIndex).getItemAvailability() == true)
            if (nItemQuantity <= this.CVendingSlot.get(nItemIndex).getItemQuantity()) {
                this.CVendingSlot.get(nItemIndex).buyItem(nItemQuantity);

                this.transactions.add("Item: \t\t" + this.CVendingSlot.get(nItemIndex).getItem().getItemName()
                        + "\nQuantity: \t" + nItemQuantity);
            } else
                System.out.println("Item amount exceeded.");
    }

    public boolean findItem(String name) {
        for (ItemSlot item : this.CVendingSlot)
            if (item.getItem().getItemName().equalsIgnoreCase(name))
                return true;
        return false;
    }

    public boolean insertPayment(int nAmount) {
        if (nAmount == 200 || nAmount == 100 || nAmount == 50
                || nAmount == 20 || nAmount == 10 || nAmount == 5
                || nAmount == 1 || nAmount == 0) {
            this.vendingMoney.addMoney(nAmount);
            return true;
        } else
            return false;
    }
}
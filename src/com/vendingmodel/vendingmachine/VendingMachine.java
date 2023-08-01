package com.vendingmodel.vendingmachine;

import java.util.*;

import com.vendingmodel.product.Product;
import com.vendingmodel.item.Item;
import com.vendingmodel.itemslot.ItemSlot;
import com.vendingmodel.moneybox.MoneyBox;

public class VendingMachine {
    protected ArrayList<ItemSlot> CVendingSlot;
    protected MoneyBox vendingMoney;
    protected ArrayList<String> transactions;

    public VendingMachine() {

    }

    /**
     * Receives money from the user by inserting the accepted
     * amount/s(denominations)
     * 
     * @param nAmount represents the money to be inserted by the user
     * @return true if the value inserted is equal to any of the following
     *         amount: 0, 1, 5, 10, 20, 50, 100, and 200 and false otherwise
     */
    public boolean insertPayment(int nAmount) {
        if (nAmount == 200 || nAmount == 100 || nAmount == 50
                || nAmount == 20 || nAmount == 10 || nAmount == 5
                || nAmount == 1 || nAmount == 0) {
            this.vendingMoney.addMoney(nAmount);
            return true;
        } else
            return false;
    }

    /**
     * Shows the transaction/s made by the user which includes
     * the item name and its quantity
     */
    public void displayTransactions() {
        System.out.println("\n\tTotal Sold");
        for (String item : this.transactions) {
            System.out.println(item);
        }
        System.out.println();
    }

    /**
     * Replenishes the change in the vending machine by adding the
     * specified nAmount to the vendingMoney object, which manages
     * the money in the machine
     * 
     * @param nAmount represents the value to be added to the vending money
     */
    public void replenishChange(int nAmount) {
        this.vendingMoney.addMoney(nAmount);
    }

    /**
     * Returns the values stored which is the earnings accumulated
     * by the vending machine in the CVendingSlot variable
     */
    public void getEarnings() {
        this.vendingMoney.collectEarnings();
    }

    /**
     * Returns the values stored in the vendingMoney variable
     * 
     * @return this.vendingMoney represents the vending money stored
     */
    public MoneyBox getMoneyBox() {
        return this.vendingMoney;
    }

}
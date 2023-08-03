package com.vendingmodel.vendingmachine;

import java.util.*;

import com.vendingmodel.item.Item;
import com.vendingmodel.itemslot.ItemSlot;
import com.vendingmodel.moneybox.MoneyBox;

/**
 * This is <code>VendingMachine</code> class which represents the
 * vending machine object of the machine
 */
public class VendingMachine {
    protected ArrayList<ItemSlot> CVendingSlot;
    protected MoneyBox vendingMoney;
    protected ArrayList<String> transactions;

    /**
     * This is the VendingMachine constructor
     */
    public VendingMachine() {
        this.CVendingSlot = new ArrayList<ItemSlot>();
        this.vendingMoney = new MoneyBox();
        this.transactions = new ArrayList<String>();
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
     * Finds an item within the CVendingSlot
     * 
     * @param strName represents the name of a new item
     * @return true if the item was found and false otherwise
     */
    public boolean findItem(String strName) {
        for (ItemSlot item : this.CVendingSlot)
            if (item.getItem().getItemName().equalsIgnoreCase(strName))
                return true;
        return false;
    }

    /**
     * Finds an item within the CVendingSlot
     * 
     * @param strName represents the name of a new item
     * @return the index of the item with the same item name, return 0 otherwise
     */
    public int getFoundItem(String strName) {
        for (ItemSlot item : this.CVendingSlot)
            if (item.getItem().getItemName().equalsIgnoreCase(strName))
                return item.getSlotIndex();
        return 0;
    }

    /**
     * Displays the information of the item to be purchased which includes its
     * name, price, and quantity
     * 
     * @param nItemIndex    represents the index of an item
     * @param nItemQuantity represents the quantity of an item
     */
    public String displayToPurchase(int nItemIndex, int nItemQuantity) {
        StringBuilder display = new StringBuilder();
        display.append("\n--------------------------\n");
        display.append("Item Name: \t" + this.CVendingSlot.get(nItemIndex).getItem().getItemName());
        display.append("Total Price: \t"
                + this.CVendingSlot.get(nItemIndex).getItem().getItemPrice() * nItemQuantity + "\n");
        display.append("Total Quantity: " + nItemQuantity + "\n");
        display.append("--------------------------\n");

        return display.toString();
    }

    /**
     * Enables the user to purchase availabale items in the vending machine
     * as well as updates the nec
     *
     * @param nItemIndex    represents the index of an item
     * @param nItemQuantity represents the quatity of an item
     */
    public String purchaseItem(int nItemIndex, int nItemQuantity) {
        StringBuilder display = new StringBuilder();
        if (this.CVendingSlot.get(nItemIndex).getItemAvailability() == true)
            if (nItemQuantity <= this.CVendingSlot.get(nItemIndex).getItem().getItemQuantity()) {
                this.CVendingSlot.get(nItemIndex).getItem().buyItem(nItemQuantity);

                this.transactions.add("Item: " +
                        this.CVendingSlot.get(nItemIndex).getItem().getItemName()
                        + "\nQuantity: " + nItemQuantity);
                display.append("Item bought.");
                return display.toString();
            } else
                display.append("Item amount exceeded. \n Transaction cancelled.");

        return display.toString();
    }

    /**
     * Calculates the change to be returned to the user after a purchase,
     * keeps track of the number of each denomination used, and prints the
     * breakdown
     * of the change. The method then returns the initial change amount
     *
     * @param nPayment      represents the amount paid by the user
     * @param nItemIndex    represents the index of an item
     * @param nItemQuantity represents the quantity of an item
     * @return nFullChange represents the amount of money left of the user
     */
    public String calculateChange(int nPayment, int nItemIndex, int nItemQuantity) {
        StringBuilder display = new StringBuilder();
        int nChange = nPayment -
                (this.CVendingSlot.get(nItemIndex).getItem().getItemPrice() * nItemQuantity);
        int nFullChange = nPayment -
                (this.CVendingSlot.get(nItemIndex).getItem().getItemPrice() * nItemQuantity);
        int[] arrDenominations = this.vendingMoney.getDenominations();
        int[] arrCount = { 0, 0, 0, 0, 0, 0, 0 };
        for (int i = 0; i < arrDenominations.length; i++) {
            while (nChange >= arrDenominations[i]) {
                arrCount[i]++;
                nChange -= arrDenominations[i];
            }
        }

        this.getMoneyBox().negateMoney(nFullChange);

        display.append("\n");
        display.append(" Change: " + nFullChange + "\n");
        if (nFullChange == 0) {

        } else {
            this.getMoneyBox().addEarnings(nFullChange);
            display.append(" In these denominations: \n");
            for (int i = 0; i < arrDenominations.length; i++)
                display.append(" " + arrDenominations[i] + " x " + arrCount[i] + "\n");
            
        }

        return display.toString();
    }

    /**
     * Returns the values stored in the CVendingSlot variable
     * 
     * @return this.CVendingSlot represents the arraylist of the vending slot stored
     */
    public ArrayList<ItemSlot> getVendingSlot() {
        return this.CVendingSlot;
    }

    /**
     * Shows the transaction/s made by the user which includes
     * the item name and its quantity
     */
    public String displayTransactions() {
        StringBuilder display = new StringBuilder();

        display.append("Earnings: " + this.getEarnings() + "\n");
        display.append("Change: " + this.getMoneyBox().getTotalMoney());
        display.append("\n\tTotal Sold\n");
        for (String item : this.transactions) {
            display.append(item + "\n");
        }

        return display.toString();
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
    public int getEarnings() {
        return this.vendingMoney.collectEarnings();
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
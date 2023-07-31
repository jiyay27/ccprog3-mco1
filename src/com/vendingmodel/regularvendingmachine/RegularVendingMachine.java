package com.vendingmodel.regularvendingmachine;

import java.util.*;

import com.vendingmodel.item.Item;
import com.vendingmodel.itemslot.ItemSlot;
import com.vendingmodel.moneybox.MoneyBox;

/**
 * This is <code>RegularVendingMachine</code> class which represents the regular
 * vending machine object of the machine
 */
public class RegularVendingMachine {
    private ArrayList<ItemSlot> vendingSlot;
    private MoneyBox vendingMoney;
    private ArrayList<String> transactions;

    /**
     * This is the RegularVendingMachine constructor
     */
    public RegularVendingMachine() {
        this.vendingSlot = new ArrayList<ItemSlot>();
        this.vendingMoney = new MoneyBox();
        this.transactions = new ArrayList<String>();
    }

    /**
     * Sets up the vending machine by adding item slots
     */
    public void setupVendingMachine() {
        vendingSlot
                .add(new ItemSlot(1, new Item("Garlic Fried Rice", 25, 366, 15)));
        vendingSlot
                .add(new ItemSlot(2, new Item("Fried Egg", 15, 92, 15)));
        vendingSlot
                .add(new ItemSlot(3, new Item("Beef Tapa", 40, 120, 10)));
        vendingSlot
                .add(new ItemSlot(4, new Item("Longganisa", 30, 136, 15)));
        vendingSlot
                .add(new ItemSlot(5, new Item("Tocino", 30, 230, 15)));
        vendingSlot
                .add(new ItemSlot(6, new Item("Hotdog", 20, 247, 15)));
        vendingSlot
                .add(new ItemSlot(7, new Item("Lumpiang Shanghai", 35, 215, 15)));
        vendingSlot
                .add(new ItemSlot(8, new Item("Bangus", 30, 178, 15)));
    }

    /**
     * Enables the user to purchase availabale items in the vending machine
     * as well as updates the nec
     * 
     * @param nItemIndex    represents the index of an item
     * @param nItemQuantity represents the quatity of an item
     */
    public void purchaseItem(int nItemIndex, int nItemQuantity) {
        if (this.vendingSlot.get(nItemIndex).getItemAvailability() == true)
            if (nItemQuantity <= this.vendingSlot.get(nItemIndex).getItem().getItemQuantity()) {
                this.vendingSlot.get(nItemIndex).getItem().buyItem(nItemQuantity);

                this.transactions.add("Item: \t\t" + this.vendingSlot.get(nItemIndex).getItem().getItemName()
                        + "\nQuantity: \t" + nItemQuantity);
            } else
                System.out.println("Item amount exceeded.");
    }

    /**
     * Finds an item within the vendingSlot
     * 
     * @param name represents the name of a new item
     * @return true if the item was found and false otherwise
     */
    public boolean findItem(String name) {
        for (ItemSlot item : this.vendingSlot)
            if (item.getItem().getItemName().equalsIgnoreCase(name))
                return true;
        return false;
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
     * Displays the information of the item to be purchased which includes its
     * name, price, and quantity
     * 
     * @param nItemIndex    represents the index of an item
     * @param nItemQuantity represents the quantity of an item
     */
    public void displayToPurchase(int nItemIndex, int nItemQuantity) {
        System.out.println("\n--------------------------");
        System.out.println("Item Name: \t" + this.vendingSlot.get(nItemIndex).getItem().getItemName());
        System.out
                .println("Total Price: \t"
                        + this.vendingSlot.get(nItemIndex).getItem().getItemPrice() * nItemQuantity);
        System.out.println("Total Quantity: " + nItemQuantity);
        System.out.println("--------------------------");
    }

    /**
     * Calculates the change to be returned to the user after a purchase,
     * keeps track of the number of each denomination used, and prints the breakdown
     * of the change. The method then returns the initial change amount
     * 
     * @param nPayment      represents the amount paid by the user
     * @param nItemIndex    represents the index of an item
     * @param nItemQuantity represents the quantity of an item
     * @return nFullChange represents the amount of money left of the user
     */
    public int calculateChange(int nPayment, int nItemIndex, int nItemQuantity) {
        int nChange = nPayment - (this.vendingSlot.get(nItemIndex).getItem().getItemPrice() * nItemQuantity);
        int nFullChange = nPayment - (this.vendingSlot.get(nItemIndex).getItem().getItemPrice() * nItemQuantity);
        int[] arrDenominations = this.vendingMoney.getDenominations();
        int[] arrCount = { 0, 0, 0, 0, 0, 0, 0 };
        for (int i = 0; i < arrDenominations.length; i++) {
            while (nChange >= arrDenominations[i]) {
                arrCount[i]++;
                nChange -= arrDenominations[i];
            }

        }
        System.out.println();
        System.out.println("Change: " + nFullChange);
        System.out.println("In these denominations:");
        for (int i = 0; i < arrDenominations.length; i++)
            System.out.println(arrDenominations[i] + " x " + arrCount[i]);

        return nFullChange;
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
     * by the vending machine in the vendingSlot variable
     */
    public void getEarnings() {
        this.vendingMoney.collectEarnings();
    }

    /**
     * Returns the values stored in the vendingSlot variable
     * 
     * @return this.vendingSlot represents the arraylist of the vending slot stored
     */
    public ArrayList<ItemSlot> getVendingSlot() {
        return this.vendingSlot;
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

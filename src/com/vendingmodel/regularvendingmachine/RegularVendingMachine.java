package com.vendingmodel.regularvendingmachine;

import java.util.*;

import com.vendingmodel.item.Item;
import com.vendingmodel.item.Item.ItemType;
import com.vendingmodel.itemslot.ItemSlot;
import com.vendingmodel.moneybox.MoneyBox;
import com.vendingmodel.vendingmachine.VendingMachine;

/**
 * This is <code>RegularVendingMachine</code> class which represents the regular
 * vending machine object of the machine
 */
public class RegularVendingMachine extends VendingMachine {
    /**
     * This is the RegularVendingMachine constructor
     */
    public RegularVendingMachine() {
        super();
    }

    public void setupVendingMachine() {
        this.CVendingSlot
                .add(new ItemSlot(1, new Item("Garlic Fried Rice", 25, 366, 15, ItemType.INGREDIENT)));
        this.CVendingSlot
                .add(new ItemSlot(2, new Item("Fried Egg", 15, 92, 15, ItemType.INGREDIENT)));
        this.CVendingSlot
                .add(new ItemSlot(3, new Item("Beef Tapa", 40, 120, 10, ItemType.INGREDIENT)));
        this.CVendingSlot
                .add(new ItemSlot(4, new Item("Longganisa", 30, 136, 15, ItemType.INGREDIENT)));
        this.CVendingSlot
                .add(new ItemSlot(5, new Item("Tocino", 30, 230, 15, ItemType.INGREDIENT)));
        this.CVendingSlot
                .add(new ItemSlot(6, new Item("Hotdog", 20, 247, 15, ItemType.INGREDIENT)));
        this.CVendingSlot
                .add(new ItemSlot(7, new Item("Lumpiang Shanghai", 35, 215, 15, ItemType.INGREDIENT)));
        this.CVendingSlot
                .add(new ItemSlot(8, new Item("Bangus", 30, 178, 15, ItemType.INGREDIENT)));
    }

    /**
     * Enables the user to purchase availabale items in the vending machine
     * as well as updates the nec
     * 
     * @param nItemIndex    represents the index of an item
     * @param nItemQuantity represents the quatity of an item
     */
    public void purchaseItem(int nItemIndex, int nItemQuantity) {
        if (this.CVendingSlot.get(nItemIndex).getItemAvailability() == true)
            if (nItemQuantity <= this.CVendingSlot.get(nItemIndex).getItem().getItemQuantity()) {
                this.CVendingSlot.get(nItemIndex).getItem().buyItem(nItemQuantity);

                this.transactions.add("Item: \t\t" + this.CVendingSlot.get(nItemIndex).getItem().getItemName()
                        + "\nQuantity: \t" + nItemQuantity);
            } else
                System.out.println("Item amount exceeded.");
    }

    /**
     * Finds an item within the CVendingSlot
     * 
     * @param name represents the name of a new item
     * @return true if the item was found and false otherwise
     */
    public boolean findItem(String name) {
        for (ItemSlot item : this.CVendingSlot)
            if (item.getItem().getItemName().equalsIgnoreCase(name))
                return true;
        return false;
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
        System.out.println("Item Name: \t" + this.CVendingSlot.get(nItemIndex).getItem().getItemName());
        System.out
                .println("Total Price: \t"
                        + this.CVendingSlot.get(nItemIndex).getItem().getItemPrice() * nItemQuantity);
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
        int nChange = nPayment - (this.CVendingSlot.get(nItemIndex).getItem().getItemPrice() * nItemQuantity);
        int nFullChange = nPayment - (this.CVendingSlot.get(nItemIndex).getItem().getItemPrice() * nItemQuantity);
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
     * Returns the values stored in the CVendingSlot variable
     * 
     * @return this.CVendingSlot represents the arraylist of the vending slot stored
     */
    public ArrayList<ItemSlot> getVendingSlot() {
        return this.CVendingSlot;
    }

}

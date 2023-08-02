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

    /**
     * Used to initialize the vending machine by adding items to their corresponding
     * slots
     */
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
    public String displayToPurchase(int nItemIndex, int nItemQuantity) {
        StringBuilder display = new StringBuilder();

        display.append("\n     ------------------------------------------------\n");
        display.append("      Item Name: " + this.CVendingSlot.get(nItemIndex).getItem().getItemName() + "\n");
        display.append("      Total Price: "
                + this.CVendingSlot.get(nItemIndex).getItem().getItemPrice() * nItemQuantity + "\n");
        display.append("      Total Qty: " + nItemQuantity + "\n");
        display.append("     --------------------------------------------------\n");

        return display.toString();
    }

    /**
     * Displays the details of the item occupying a particular slot
     * and prints the item's name, price, calories, and quantity
     */
    public String listSlotInfo() {
        StringBuilder display = new StringBuilder();
        for (int i = 1; i < this.CVendingSlot.size(); i++) {
            display.append("    ------------------------- " + i + " -------------------------\n");
            display.append("        Item: \t" + this.CVendingSlot.get(i - 1).getItem().getItemName() + "\n");
            display.append("        Price: \t" + this.CVendingSlot.get(i - 1).getItem().getItemPrice() + "\n");
            display.append("        Calories: \t" + this.CVendingSlot.get(i - 1).getItem().getItemCalories() + "\n");
            display.append("        Quantity: \t" + this.CVendingSlot.get(i - 1).getItem().getItemQuantity() + "\n");
        }

        return display.toString();
    }

    /**
     * Generates a formatted string which represents the status after
     * purchasing an item in thevending machine such as the change and
     * confirmation message
     * 
     * @param change       represents the change amount
     * @param confirmation represents the confirmation message
     * @return display.toString() represents the formatted string made
     */
    public String displayStatusAfterPurchase(String change, String confirmation) {
        StringBuilder display = new StringBuilder();
        display.append(confirmation + "\n");
        display.append(change);

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

}

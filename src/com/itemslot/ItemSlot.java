package com.itemslot;

import com.item.Item;

/**
 * This is <code>ItemSlot</code> class which represents the item slot object of the machine
 */
public class ItemSlot {
    private int nSlotIndex;
    private Item itemOccupy;

    /**
     * This is the ItemSlot constructor
     * 
     * @param nSlotIndex slot index
     * @param itemOccupy item occupied
     */
    public ItemSlot(int nSlotIndex, Item itemOccupy) {
        this.nSlotIndex = nSlotIndex;
        this.itemOccupy = itemOccupy;
    }

    /**
     * Sets the item occupied
     * 
     * @param itemOccupy represents the occupied item
     */
    public void setItem(Item itemOccupy) {
        this.itemOccupy = itemOccupy;
    }

    /**
     * Determines the availability of the item by its quantity
     * 
     * @return true if the quantity of the occupied item
     *         is not equal to 0 and false otherwise
     */
    public boolean getItemAvailability() {
        if (this.itemOccupy.getItemQuantity() != 0)
            return true;
        else
            return false;
    }

    /**
     * Returns the value stored in the nSlotIndex variable
     * 
     * @return this.nSlotIndex represents the item name stored
     */
    public int getSlotIndex() {
        return this.nSlotIndex;
    }

    /**
     * Returns the value stored in the itemOccupy variable
     * 
     * @return this.itemOccupy represents the item name stored
     */
    public Item getItem() {
        return this.itemOccupy;
    }

    /**
     * Displays the details of the item occupying a particular slot
     * and prints the item's name, price, calories, and quantity
     */
    public void listSlotInfo() {
        System.out.println();
        System.out.println("Item: \t\t" + this.itemOccupy.getItemName());
        System.out.println("Price: \t\t" + this.itemOccupy.getItemPrice());
        System.out.println("Calories: \t" + this.itemOccupy.getItemCalories());
        System.out.println("Quantity: \t" + this.itemOccupy.getItemQuantity());
    }

}
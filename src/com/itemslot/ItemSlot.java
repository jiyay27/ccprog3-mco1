package com.itemslot;

import com.item.Item;

/**
 * This is <code>ItemSlot</code> class which represents the itemslot object of the machine
 */
public class ItemSlot {
    private int nSlotIndex;
    private Item itemOccupy;

    /**
     * This is the item constructor
     * 
     * @param nSlotIndex slot index
     * @param itemOccupy item occupied
     */
    public ItemSlot(int nSlotIndex, Item itemOccupy) {
        this.nSlotIndex = nSlotIndex;
        this.itemOccupy = itemOccupy;
    }

    /**
     * Sets the occupied item
     * 
     * @param itemOccupy represents the new occupied item
     */
    public void setItem(Item itemOccupy) {
        this.itemOccupy = itemOccupy;
    }

    /**
     * Checks the availability of an item using its quantity
     * 
     * @return true if the quantity is not equal to 0 and false otherwise
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
     * @return this.nSlotIndex represents index of the slot stored
     */
    public int getSlotIndex() {
        return this.nSlotIndex;
    }

    /**
     * Returns the value stored in the itemOccupy variable
     * 
     * @return this.itemOccupy represents the item occupied
     */
    public Item getItem() {
        return this.itemOccupy;
    }

    /**
     * This method displays the item occupied including the item name, price,
     * calories, as well as the quantity
     */
    public void listSlotInfo() {
        System.out.println();
        System.out.println("Item: \t\t" + this.itemOccupy.getItemName());
        System.out.println("Price: \t\t" + this.itemOccupy.getItemPrice());
        System.out.println("Calories: \t" + this.itemOccupy.getItemCalories());
        System.out.println("Quantity: \t" + this.itemOccupy.getItemQuantity());
    }

}
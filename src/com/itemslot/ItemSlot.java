package com.itemslot;

import com.item.Item;

/**
 * This is <code>ItemSlot</code> class which represents the item slot object of the machine
 */
public class ItemSlot {
    private int nSlotIndex;
    private Item CItemOccupy;

    /**
     * This is the ItemSlot constructor
     * 
     * @param nSlotIndex slot index
     * @param CItemOccupy item occupied
     */
    public ItemSlot(int nSlotIndex, Item CItemOccupy) {
        this.nSlotIndex = nSlotIndex;
        this.CItemOccupy = CItemOccupy;
    }

    /**
     * Sets the item occupied
     * 
     * @param CItemOccupy represents the occupied item
     */
    public void setItem(Item CItemOccupy) {
        this.CItemOccupy = CItemOccupy;
    }

    /**
     * Determines the availability of the item by its quantity
     * 
     * @return true if the quantity of the occupied item
     *         is not equal to 0 and false otherwise
     */
    public boolean getItemAvailability() {
        if (this.CItemOccupy.getItemQuantity() != 0)
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
     * Returns the value stored in the CItemOccupy variable
     * 
     * @return this.CItemOccupy represents the item name stored
     */
    public Item getItem() {
        return this.CItemOccupy;
    }

    /**
     * Displays the details of the item occupying a particular slot
     * and prints the item's name, price, calories, and quantity
     */
    public void listSlotInfo() {
        System.out.println();
        System.out.println("Item: \t\t" + this.CItemOccupy.getItemName());
        System.out.println("Price: \t\t" + this.CItemOccupy.getItemPrice());
        System.out.println("Calories: \t" + this.CItemOccupy.getItemCalories());
        System.out.println("Quantity: \t" + this.CItemOccupy.getItemQuantity());
    }

}
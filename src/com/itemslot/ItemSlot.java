package com.itemslot;

import com.item.Item;

public class ItemSlot {
    private int nSlotIndex;
    private Item itemOccupy;

    public ItemSlot(int nSlotIndex, Item itemOccupy) {
        this.nSlotIndex = nSlotIndex;
        this.itemOccupy = itemOccupy;
    }

    public void setItem(Item itemOccupy) {
        this.itemOccupy = itemOccupy;
    }

    public boolean getItemAvailability() {
        if (this.itemOccupy.getItemQuantity() != 0)
            return true;
        else
            return false;
    }

    public int getSlotIndex() {
        return this.nSlotIndex;
    }

    public Item getItem() {
        return this.itemOccupy;
    }

    public void listSlotInfo() {
        System.out.println();
        System.out.println("Item: \t\t" + this.itemOccupy.getItemName());
        System.out.println("Price: \t\t" + this.itemOccupy.getItemPrice());
        System.out.println("Calories: \t" + this.itemOccupy.getItemCalories());
        System.out.println("Quantity: \t" + this.itemOccupy.getItemQuantity());
    }

}
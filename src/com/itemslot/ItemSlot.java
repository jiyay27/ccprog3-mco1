package com.itemslot;

import com.item.Item;
import java.util.*;

public class ItemSlot {
    private String slotName;
    private ArrayList<Item> itemOccupy;

    public ItemSlot(String slotName) {
        this.slotName = slotName;
        this.itemOccupy = new ArrayList<Item>();
    }

    public ItemSlot(String slotName, Item itemOccupy, int nQuantity) {
        this.slotName = slotName;
        this.itemOccupy = new ArrayList<Item>();
        for (int i = 0; i < nQuantity; i++) {
            this.itemOccupy.add(itemOccupy);
        }
    }

    // TODO: SET ITEM
    public void setItem(Item itemOccupy, int nQuantity) {
        for (int i = 0; i < nQuantity; i++) {
            this.itemOccupy.add(itemOccupy);
        }
    }

    // public boolean getItemAvailability() {
    // boolean bFlag = true;
    // if (this.itemOccupy.size() != 0)
    // return bFlag;
    // else
    // return !bFlag;
    // }

    public Item getItem() {
        return this.itemOccupy.get(this.itemOccupy.size() - 1);
    }

    public int getItemQuantity() {
        return this.itemOccupy.size();
    }

    public String getSlotName() {
        return this.slotName;
    }
}
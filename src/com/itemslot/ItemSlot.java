package com.itemslot;

import com.item.Item;
import java.util.*;

public class ItemSlot {
    private String slotName;
    private boolean bAvailable;
    private ArrayList<Item> itemOccupy;

    public ItemSlot(String slotName) {
        this.slotName = slotName;
        this.bAvailable = true;
        this.itemOccupy = new ArrayList<Item>();
    }

    public ItemSlot(String slotName, Item itemOccupy, int nQuantity) {
        this.slotName = slotName;
        this.bAvailable = true;
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

    public boolean getAvailability() {
        return this.bAvailable;
    }
}
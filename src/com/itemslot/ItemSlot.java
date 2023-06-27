package com.itemslot;

import com.item.Item;
import java.util.*;

public class ItemSlot {
    private String slotName;
    private boolean bAvailable;
    private ArrayList<Item> itemsOccupy;

    public ItemSlot(String slotName) {
        this.slotName = slotName;
        this.bAvailable = true;
        this.itemsOccupy = new ArrayList<Item>();
    }

    public ItemSlot(String slotName, Item itemsOccupy, int nQuantity) {
        this.slotName = slotName;
        this.bAvailable = true;
        for (int i = 0; i < nQuantity; i++) {
            this.itemsOccupy.add(itemsOccupy);
        }
    }

    // TODO: SET ITEM
    public void setItem(Item item) {

    }

    public boolean getAvailability() {
        return this.bAvailable;
    }
}
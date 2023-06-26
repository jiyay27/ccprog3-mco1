package com.itemslot;

import com.item.Item;
import java.util.*;

public class ItemSlot {
    private String slotName;
    private boolean bAvailable;
    private ArrayList<Item> itemsOccupy;

    public ItemSlot() {
        this.slotName = null;
        this.bAvailable = true;
        this.itemsOccupy = null;
    }

    public ItemSlot(String slotName) {
        this.slotName = slotName;
        this.bAvailable = true;
        // this.itemsOccupy;
    }

    public boolean setItem(Item item) {

        return true;
    }

    public boolean getAvailability() {
        return true;
    }
}
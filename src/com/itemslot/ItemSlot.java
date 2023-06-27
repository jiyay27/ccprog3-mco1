package com.itemslot;

import com.item.Item;
import java.util.*;

public class ItemSlot {
    private String slotName;
    private Item itemOccupy;

    public ItemSlot(String slotName, Item itemOccupy) {
        this.slotName = slotName;
        this.itemOccupy = itemOccupy;
    }

    // TODO: SET ITEM
    public void setItem(Item itemOccupy) {

    }

    public boolean getItemAvailability() {
        if (this.itemOccupy.getItemQuantity() != 0)
            return true;
        else
            return false;
    }

    public String getSlotName() {
        return this.slotName;
    }
}
package com.item;

public class Item {
    private String strItemName;
    private int nItemPrice;
    private int nItemCalories;
    private int nItemQuantity;

    public Item(String strItemName, int nItemPrice, int nItemCalories, int nItemQuantity) {
        this.strItemName = strItemName;
        this.nItemPrice = nItemPrice;
        this.nItemCalories = nItemCalories;
        this.nItemQuantity = nItemQuantity;
    }

    public boolean sellItem(int nItemQuantity) {
        if (nItemQuantity <= this.nItemPrice) {
            this.nItemQuantity -= nItemQuantity;
            return true;
        } else
            return false;
    }

    public void setItemPrice(int nItemPrice) {
        this.nItemPrice = nItemPrice;
    }

    public String getItemName() {
        return this.strItemName;
    }

    public int getItemPrice() {
        return this.nItemPrice;
    }

    public int getItemCalories() {
        return this.nItemCalories;
    }

    public int getItemQuantity() {
        return this.nItemQuantity;
    }
}
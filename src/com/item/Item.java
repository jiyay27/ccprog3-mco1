package com.item;

public class Item {
    private String strItemName;
    private int nItemPrice;
    private int nItemCalories;

    public Item(String strItemName, int nItemPrice, int nItemCalories) {
        this.strItemName = strItemName;
        this.nItemPrice = nItemPrice;
        this.nItemCalories = nItemCalories;
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
}
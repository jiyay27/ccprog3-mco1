package com.item;

public class Item {
    private String strItemName;
    private double dItemPrice;
    private double dItemCalories;

    public Item(String strItemName, double dItemPrice, double dItemCalories) {
        this.strItemName = strItemName;
        this.dItemPrice = dItemPrice;
        this.dItemCalories = dItemCalories;
    }

    public void changeItemPrice() {

    }

    public String getItemName() {
        return this.strItemName;
    }

    public double getItemPrice() {
        return this.dItemPrice;
    }

    public double getItemCalories() {
        return this.dItemCalories;
    }
}
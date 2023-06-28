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

    private boolean isAllowSell(int nItemSold) {
        if (nItemSold <= this.nItemQuantity)
            return true;
        else
            return false;
    }

    public int buyItem(int nItemSold) {
        if (isAllowSell(nItemSold))
            this.nItemQuantity -= nItemSold;
        return nItemSold;
    }

    public void setItemPrice(int nItemPrice) {
        this.nItemPrice = nItemPrice;
    }

    public void setItemQuantity(int nItemQuantity) {
        this.nItemQuantity = nItemQuantity;
    }

    public boolean canRestock(int nQuantity) {
        if (this.getItemQuantity() < 15)
            if (nQuantity <= 15 - this.getItemQuantity()) {
                return true;
            }
        return false;
    }

    public void restockItem(int nQuantity) {
        this.setItemQuantity(this.getItemQuantity() + nQuantity);
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
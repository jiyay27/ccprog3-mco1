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

    /** 
        checks if the item is still available to be sold
        
        @param nItemSold number of item/s to be checked
        @return true if the item sold is less than the quantity provided and otherwise false
    */
    private boolean isAllowSell(int nItemSold) {
        if (nItemSold <= this.nItemQuantity)
            return true;
        else
            return false;
    }

    /** 
        handles item purchases wherein sold quantity will be deducted to the available one
        
        @param nItemSold number of item/s to be checked
        @return the number of item/s sold
    */
    public int buyItem(int nItemSold) {
        if (isAllowSell(nItemSold))
            this.nItemQuantity -= nItemSold;
        return nItemSold;
    }

    /** 
        sets the price of an item
        
        @param nItemPrice represents the new item price
    */
    public void setItemPrice(int nItemPrice) {
        this.nItemPrice = nItemPrice;
    }

    /** 
        sets the quantity of an item
        
        @param nItemQuantity represents the new item quantity
    */
    public void setItemQuantity(int nItemQuantity) {
        this.nItemQuantity = nItemQuantity;
    }

    /** 
        checks if restocking is possible for an item
        
        @param nQuantity quantity of items to be restocked
        @return true if restocking is possible and false otherwise
    */
    public boolean canRestock(int nQuantity) {
        if (this.getItemQuantity() < 15)
            if (nQuantity <= 15 - this.getItemQuantity()) {
                return true;
            }
        return false;
    }

    /** 
        used to increase item quantity in stock
        
        @param nQuantity represents the number of items to be restocked
    */
    public void restockItem(int nQuantity) {
        this.setItemQuantity(this.getItemQuantity() + nQuantity);
    }

    /** 
        returns the value stored in the strItemName variable
        
        @return this.strItemName represents the item name stored
    */
    public String getItemName() {
        return this.strItemName;
    }

    /** 
        returns the value stored in the nItemPrice variable
        
        @return this.nItemPrice represents the item price stored
    */
    public int getItemPrice() {
        return this.nItemPrice;
    }

    /** 
        returns the value stored in the nItemCalories variable
        
        @return this.nItemCalories represents the item calorie/s stored
    */
    public int getItemCalories() {
        return this.nItemCalories;
    }

    /** 
        returns the value stored in the nItemQuantity variable
        
        @return this.nItemQuantity represents the item quantity/ies stored
    */
    public int getItemQuantity() {
        return this.nItemQuantity;
    }
}
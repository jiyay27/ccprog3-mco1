package com.vendingmodel.item;
/**
 * This is <code>Item</code> class which represents the item object of the machine
 */
public class Item {
    private String strItemName;
    private int nItemPrice;
    private int nItemCalories;

    /**
     * This is the Item constructor
     * 
     * @param strItemName name
     * @param nItemPrice price
     * @param nItemCalories calories
     * @param nItemQuantity quantity
     */
    public Item(String strItemName, int nItemPrice, int nItemCalories) {
        this.strItemName = strItemName;
        this.nItemPrice = nItemPrice;
        this.nItemCalories = nItemCalories;
    }

    /**
     * Sets the price of an item
     * 
     * @param nItemPrice nItemPrice represents the new item price
     */
    public void setItemPrice(int nItemPrice) {
        this.nItemPrice = nItemPrice;
    }


    /**
     * Returns the value stored in the strItemName variable
     * 
     * @return this.strItemName represents the item name stored
     */
    public String getItemName() {
        return this.strItemName;
    }

    /**
     * Returns the value stored in the nItemPrice variable
     * 
     * @return this.nItemPrice represents the item price stored
     */
    public int getItemPrice() {
        return this.nItemPrice;
    }

    /**
     * Returns the value stored in the nItemCalories variable
     * 
     * @return this.nItemCalories represents the item calorie/s stored
     */
    public int getItemCalories() {
        return this.nItemCalories;
    }

}
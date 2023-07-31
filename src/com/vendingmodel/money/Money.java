package com.vendingmodel.money;

/**
 * This is <code>Money</code> class which represents the money object of the machine
 */
public class Money {
    private int nValue;

    /**
     * This is the item slot constructor
     * 
     * @param nValue money value in peso
     */
    public Money(int nValue) {
        this.nValue = nValue;
    }

    /**
     * Returns the value stored in the nValue variable
     * 
     * @return this.nValue represents the money value stored
     */
    public int getValue() {
        return this.nValue;
    }
}

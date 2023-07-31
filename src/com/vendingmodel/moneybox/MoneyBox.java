package com.vendingmodel.moneybox;

/**
 * This is <code>MoneyBox</code> class which represents the item slot object of the machine
 */
public class MoneyBox {
    private int nMoney;
    private int nEarnings;
    private int[] arrDenominations = { 200, 100, 50, 20, 10, 5, 1 };

    /**
     * This is the MoneyBox constructor (without parameter)
     */
    public MoneyBox() {
        this.nMoney = 1000;
        this.nEarnings = 0;
    }

    /**
     * This is the MoneyBox constructor (with parameter)
     * 
     * @param nMoney money value
     */
    public MoneyBox(int nMoney) {
        this.nMoney = nMoney;
        this.nEarnings = 0;
    }

    /**
     * Determines if the this.nMoney is empty or not
     * 
     * @return isEmpty if the money is equal to 0 and !isEmpty otherwise
     */
    public boolean isEmpty() {
        boolean isEmpty = true;
        if (this.nMoney == 0)
            return isEmpty;
        else
            return !isEmpty;
    }

    /**
     * Adds the inputted value (nInput) to this.nMoney
     * 
     * @param nInput represents the value to be added
     */
    public void addMoney(int nInput) {
        this.nMoney += nInput;
    }

    /**
     * Adds the inputted value (nInput) to this.nEarnings
     * 
     * @param nInput represents the value to be added
     */
    public void addEarnings(int nInput) {
        this.nEarnings += nInput;
    }

    /**
     * Resets the value of this.nEarnings to 0
     */
    private void resetEarnings() {
        this.nEarnings = 0;
    }

    /**
     * Collects earnings and resets it for tracking purposes
     * 
     * @return temp stored value for this.nEarnings
     */
    public int collectEarnings() {
        int temp = this.nEarnings;
        this.resetEarnings();
        return temp;
    }

    /**
     * Returns the value stored in the nEarnings variable
     * 
     * @return this.nEarnings represents the total earnings stored
     */
    public int getTotalEarnings() {
        return this.nEarnings;
    }

    /**
     * Returns the value stored in the nMoney variable
     * 
     * @return this.nMoney represents the total money stored
     */
    public int getTotalMoney() {
        return this.nMoney;
    }

    /**
     * Returns the values stored in the arrDenominations variable
     * 
     * @return this.arrDenominations represents the denominations stored
     */
    public int[] getDenominations() {
        return this.arrDenominations;
    }

}
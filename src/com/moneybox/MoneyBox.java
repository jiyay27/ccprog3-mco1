package com.moneybox;

public class MoneyBox {
    private int nMoney;
    private int nEarnings;
    private int[] arrDenominations = { 200, 100, 50, 20, 10, 5, 1 };

    public MoneyBox() {
        this.nMoney = 1000;
        this.nEarnings = 0;
    }

    public boolean isEmpty() {
        boolean isEmpty = true;
        if (this.nMoney == 0)
            return isEmpty;
        else
            return !isEmpty;
    }

    public void addMoney(int nInput) {
        this.nMoney += nInput;
    }

    public void addEarnings(int nInput, int nChange) {
        this.nEarnings += nInput - nChange;
    }

    private void resetEarnings() {
        this.nEarnings = 0;
    }

    public int collectEarnings() {
        int temp = this.nEarnings;
        this.resetEarnings();
        return temp;
    }

    public int getTotalEarnings() {
        return this.nEarnings;
    }

    public int getTotalMoney() {
        return this.nMoney;
    }

    public int[] getDenominations() {
        return this.arrDenominations;
    }

}
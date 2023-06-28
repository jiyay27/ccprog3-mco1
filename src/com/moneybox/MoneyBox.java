package com.moneybox;

public class MoneyBox {
    private int nMoney;
    private int nEarnings;

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
        this.nMoney = this.nMoney + nInput;
        this.nEarnings = this.nEarnings + nInput;
    }

    private void setEarnings() {
        this.nEarnings = 0;
    }

    // TODO:
    public int collectEarnings() {
        int temp = this.nEarnings;
        this.setEarnings();
        return temp;
    }

    public int getTotalEarnings() {
        return this.nEarnings;
    }

}
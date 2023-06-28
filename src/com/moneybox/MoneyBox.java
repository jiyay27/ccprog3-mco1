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
        this.nEarnings += nInput;
    }

    public void addChange(int nInput) {
        this.nMoney += nInput;
    }

    private void setEarnings() {
        this.nEarnings = 0;
    }

    public int collectEarnings() {
        int temp = this.nEarnings;
        this.setEarnings();
        return temp;
    }

    public int getTotalEarnings() {
        return this.nEarnings;
    }

    public int[] getDenominations() {
        return this.arrDenominations;
    }

}
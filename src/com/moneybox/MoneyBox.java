package com.moneybox;

import java.util.*;

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

    private void addMoney(int nInput) {
        this.nMoney = this.nMoney + nInput;
        this.nEarnings = this.nEarnings + nInput;
    }

    public void insertMoney(int nInput) {
        if (nInput == 200 || nInput == 100 || nInput == 50
                || nInput == 20 || nInput == 10 || nInput == 5
                || nInput == 1) {
            addMoney(nInput);
        } else
            System.out.println("Money not accepted... \nPlease insert the right denomation...");
    }

    // TODO:
    public int collectEarnings() {
        int temp = this.getTotalEarnings();
        ;
        return temp;
    }

    public int getTotalEarnings() {
        return this.nEarnings;
    }
}
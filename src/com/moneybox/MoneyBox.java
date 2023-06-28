package com.moneybox;

import java.util.*;

public class MoneyBox {
    private ArrayList<Integer> nMoneyBox;
    private ArrayList<Integer> nEarnings;

    public MoneyBox() {
        this.nMoneyBox = new ArrayList<Integer>();
        this.nEarnings = new ArrayList<Integer>();

        for (int i = 0; i < 10; i++) {
            this.nMoneyBox.add(200);
            this.nMoneyBox.add(100);
        }
        for (int i = 0; i < 30; i++) {
            this.nMoneyBox.add(50);
            this.nMoneyBox.add(20);
        }
        for (int i = 0; i < 30; i++) {
            this.nMoneyBox.add(10);
            this.nMoneyBox.add(5);
            this.nMoneyBox.add(1);
        }
    }

    public boolean isEmpty() {
        boolean isEmpty = true;
        if (this.nMoneyBox.size() == 0)
            return isEmpty;
        else
            return !isEmpty;
    }

    private void addMoney(int nValue) {
        this.nMoneyBox.add(nValue);
        this.nEarnings.add(nValue);
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
        this.nEarnings.removeAll(this.nEarnings);
        return temp;
    }

    public int getTotalEarnings() {
        int nTotal = 0;
        for (Integer money : this.nEarnings) {
            nTotal += money;
        }
        return nTotal;
    }
}
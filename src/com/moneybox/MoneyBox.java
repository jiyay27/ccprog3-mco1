package com.moneybox;

import java.util.*;

import com.money.Money;

public class MoneyBox {
    private ArrayList<Money> nMoneyBox;
    private ArrayList<Money> nEarnings;

    public MoneyBox() {
        this.nMoneyBox = new ArrayList<Money>();
        this.nEarnings = new ArrayList<Money>();

        for (int i = 0; i < 10; i++) {
            this.nMoneyBox.add(new Money(200));
            this.nMoneyBox.add(new Money(100));
        }
        for (int i = 0; i < 30; i++) {
            this.nMoneyBox.add(new Money(50));
            this.nMoneyBox.add(new Money(20));
        }
        for (int i = 0; i < 30; i++) {
            this.nMoneyBox.add(new Money(10));
            this.nMoneyBox.add(new Money(5));
            this.nMoneyBox.add(new Money(1));
        }
    }

    public boolean isEmpty() {
        boolean isEmpty = true;
        if (this.nMoneyBox.size() == 0)
            return isEmpty;
        else
            return !isEmpty;
    }

    public boolean isAllowed() {
        boolean isAllowed = true;
        if (this.nMoneyBox.isEmpty())
            return !isAllowed;
        else {
            return isAllowed;
        }
    }

    public void addMoney(int nValue) {
        this.nMoneyBox.add(new Money(nValue));
        this.nEarnings.add(new Money(nValue));
    }

    public void insertMoney(int nInput) {
        if (nInput == 200 || nInput == 100 || nInput == 50
                || nInput == 20 || nInput == 10 || nInput == 5
                || nInput == 1) {
            addMoney(nInput);
        } else
            System.out.println("Money not accepted... \nPlease insert the right denomation...");
    }

    // TODO: create logic for sukli
    public void produceChange() {
        if (isAllowed()) {

        }
    }

    // TODO: create logic for replenishing sukli
    public void replenishChange() {

    }

    // TODO: collect money earned
    public void collectEarnings() {

    }

    public int getTotal() {
        int nTotal = 0;
        for (Money money : this.nMoneyBox) {
            nTotal += money.getValue();
        }
        return nTotal;
    }
}
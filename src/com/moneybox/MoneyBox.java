package com.moneybox;

import java.util.*;

import com.money.Money;

public class MoneyBox {
    private ArrayList<Money> nDenominations;
    private ArrayList<Money> nEarnings;

    public MoneyBox() {
        this.nDenominations = new ArrayList<Money>();
        this.nEarnings = new ArrayList<Money>();

        for (int i = 0; i < 10; i++) {
            this.nDenominations.add(new Money(200));
            this.nDenominations.add(new Money(100));
        }
        for (int i = 0; i < 30; i++) {
            this.nDenominations.add(new Money(50));
            this.nDenominations.add(new Money(20));
        }
        for (int i = 0; i < 40; i++) {
            this.nDenominations.add(new Money(10));
            this.nDenominations.add(new Money(5));
            this.nDenominations.add(new Money(1));
        }
    }

    public boolean isEmpty() {
        boolean isEmpty = true;
        if (this.nDenominations.size() == 0)
            return isEmpty;
        else
            return !isEmpty;
    }

    public boolean isAllowed() {
        boolean isAllowed = true;
        if (this.nDenominations.isEmpty())
            return !isAllowed;
        else {
            return isAllowed;
        }
    }

    public void addMoney(int nValue) {
        this.nDenominations.add(new Money(nValue));
        this.nEarnings.add(new Money(nValue));
    }

    public void insertMoney(int nInput) {
        if (nInput == 500 || nInput == 200
                || nInput == 100 || nInput == 50
                || nInput == 20 || nInput == 10
                || nInput == 5 || nInput == 1) {
            addMoney(nInput);
        } else
            System.out.println("Money not accepted... \nPlease insert the right denomation...");
    }

    public void produceChange() {
        if (isAllowed()) {

        }
    }

    public int getTotal() {
        int nTotal = 0;
        for (Money money : this.nDenominations) {
            nTotal += money.getValue();
        }
        return nTotal;
    }
}
package com.moneybox;

import java.util.*;

import com.money.Money;

public class MoneyBox {
    private ArrayList<Money> nDenominations;
    private ArrayList<Money> nAddedMoney;

    public MoneyBox() {
        this.nDenominations = new ArrayList<Money>();
        this.nAddedMoney = null;

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
        this.nAddedMoney.add(new Money(nValue));
    }

    public void produceChange() {
        if (isAllowed())
    }

    public int getTotal() {
        int nTotal = 0;
        for (Money money : this.nDenominations) {
            nTotal += money.getValue();
        }
        return nTotal;
    }
}
package com.main;

import com.vendingmachineinterface.VendingMachineInterface;
import com.moneybox.MoneyBox;

// import java.util.*;

public class Main {
    public static void main(String[] args) {
        VendingMachineInterface CVendingMachineInterface = new VendingMachineInterface();
        // boolean bFlag = true;
        MoneyBox moneyBox = new MoneyBox();
        /*
         * while (bFlag) {
         * CVendingMachineInterface.displayMainMenu();
         * }
         */

        moneyBox.displayTotal();
        System.out.println(moneyBox.isEmpty());

    }
}
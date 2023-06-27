package com.main;

import com.machineinterface.MachineInterface;
import com.regularvendingmachine.RegularVendingMachine;
import com.item.Item;
import com.itemslot.ItemSlot;

// import java.util.*;

public class Main {
    public static void main(String[] args) {
        RegularVendingMachine CVending = new RegularVendingMachine("Maangas");
        // MachineInterface CMachineInterface = new
        // MachineInterface();
        // boolean bFlag = true;

        // while (bFlag) {
        // CVendingMachineInterface.displayMainMenu();
        // }

        ItemSlot FriedEgg = new ItemSlot("FriedEggSlot", new Item("Fried Egg", 15, 92), 10);

        System.out.println(FriedEgg.getItem().get(0).getItemName());
        System.out.println(FriedEgg.getItem().get(0).getItemCalories());
        System.out.println(FriedEgg.getItem().get(0).getItemPrice());
        System.out.println(FriedEgg.getItem().size());
    }
}
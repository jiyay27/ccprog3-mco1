package com.vendingmodel.specialvendingmachine;

import java.util.*;

import com.vendingmodel.product.Product;
import com.vendingmodel.item.Item;
import com.vendingmodel.itemslot.ItemSlot;
import com.vendingmodel.moneybox.MoneyBox;
import com.vendingmodel.vendingmachine.VendingMachine;

public class SpecialVendingMachine extends VendingMachine {
    protected ArrayList<Product> vendingOptions;

    public SpecialVendingMachine() {
        super();
        this.vendingOptions = new ArrayList<Product>();
    }

    public void setupVendingStock() {
        CVendingSlot
                .add(new ItemSlot(1, new Item("Garlic Fried Rice", 25, 366, 15)));
        CVendingSlot
                .add(new ItemSlot(2, new Item("Fried Egg", 15, 92, 15)));
        CVendingSlot
                .add(new ItemSlot(3, new Item("Beef Tapa", 40, 120, 10)));
        CVendingSlot
                .add(new ItemSlot(4, new Item("Longganisa", 30, 136, 15)));
        CVendingSlot
                .add(new ItemSlot(5, new Item("Tocino", 30, 230, 15)));
        CVendingSlot
                .add(new ItemSlot(6, new Item("Hotdog", 20, 247, 15)));
        CVendingSlot
                .add(new ItemSlot(7, new Item("Lumpiang Shanghai", 35, 215, 15)));
        CVendingSlot
                .add(new ItemSlot(8, new Item("Bangus", 30, 178, 15)));
    }

    public void setupSpecialVendingMachine() {
        ArrayList<Item> tapsilogIngredients = new ArrayList<Item>();
        tapsilogIngredients.add(1, new Item("Beef Tapa", 0, 0, 1));
        tapsilogIngredients.add(2, new Item("GarlicFriedRice", 0, 0, 1));
        tapsilogIngredients.add(3, new Item("Fried Egg", 0, 0, 1));
        tapsilogIngredients.add(4, new Item("Sliced Tomatoes", 0, 0, 2));
        tapsilogIngredients.add(5, new Item("Sliced Cucumber", 0, 0, 2));
        tapsilogIngredients.add(6, new Item("Atchara", 0, 0, 1));

        vendingOptions.add(1, new Product("Tapsilog", 0, 0, tapsilogIngredients));
    }

    public void purchaseProduct(int nIndex) {
        if () {
            
            System.out.println("");
        } else
            System.out.println("Item amount exceeded.");
    }
}
package com.vendingmodel.specialvendingmachine;

import java.util.*;

import com.vendingmodel.product.Product;
import com.vendingmodel.item.Item;
import com.vendingmodel.moneybox.MoneyBox;
import com.vendingmodel.vendingmachine.VendingMachine;

public class SpecialVendingMachine extends VendingMachine {
    protected ArrayList<Product> vendingOptions;

    public SpecialVendingMachine() {
        super();
        this.vendingOptions = new ArrayList<Product>();
    }

    public void setupVendingMachine() {
        ArrayList<Item> tapsilogIngredients = new ArrayList<Item>();
        tapsilogIngredients.add(1, new Item("Beef Tapa", 0, 0, 1));
        tapsilogIngredients.add(2, new Item("GarlicFriedRice", 0, 0, 1));
        tapsilogIngredients.add(3, new Item("Fried Egg", 0, 0, 1));
        tapsilogIngredients.add(4, new Item("Sliced Tomatoes", 0, 0, 2));
        tapsilogIngredients.add(5, new Item("Sliced Cucumber", 0, 0, 2));
        tapsilogIngredients.add(6, new Item("Atchara", 0, 0, 1));

        vendingOptions.add(1, new Product("Tapsilog", 0, 0, tapsilogIngredients));
    }

}
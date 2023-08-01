package com.vendingmodel.product;

import java.util.ArrayList;
import com.vendingmodel.item.Item;

public class Product {
    private String strproductName;
    private int nProductPrice;
    private int nProductCalories;
    private ArrayList<Item> ingredientsList;

    public Product(String strProductName, int nProductPrice, int nProductCalories, ArrayList<Item> ingredientsList) {
        this.strproductName = strProductName;
        this.nProductPrice = nProductPrice;
        this.nProductCalories = nProductCalories;
        this.ingredientsList = new ArrayList<Item>();
    }

    public String getProductName() {
        return this.strproductName;
    }

    public int getProductPrice() {
        return this.nProductPrice;
    }

    public int getProductCalories() {
        return this.nProductCalories;
    }

    public ArrayList<Item> getIngredients() {
        return this.ingredientsList;
    }

    public void setProductName(String strProductName) {
        this.strproductName = strProductName;
    }

    public void setProductPrice(int nProductPrice) {
        this.nProductPrice = nProductPrice;
    }

    public void setProductCalories(int nProductCalories) {
        this.nProductCalories = nProductCalories;
    }

    public void setIngredients(ArrayList<Item> ingredients) {
        this.ingredientsList = ingredients;
    }

}

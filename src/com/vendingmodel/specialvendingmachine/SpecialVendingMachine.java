package com.vendingmodel.specialvendingmachine;

import java.util.*;

import com.vendingmodel.product.Product;
import com.vendingmodel.item.Item;
import com.vendingmodel.item.Item.ItemType;
import com.vendingmodel.itemslot.ItemSlot;
import com.vendingmodel.moneybox.MoneyBox;
import com.vendingmodel.vendingmachine.VendingMachine;
import java.util.HashMap;

public class SpecialVendingMachine extends VendingMachine {
        private ArrayList<Product> vendingOptions;
        private ArrayList<Item> vendingIngredients;

        public SpecialVendingMachine() {
                super();
                this.vendingOptions = new ArrayList<Product>();
                this.vendingIngredients = new ArrayList<Item>();
        }

        public void setupSpecialVendingStock() {
                CVendingSlot
                                .add(new ItemSlot(1, new Item("Garlic Fried Rice", 25, 366, 15, ItemType.INGREDIENT)));
                CVendingSlot
                                .add(new ItemSlot(2, new Item("Fried Egg", 15, 92, 15, ItemType.INGREDIENT)));
                CVendingSlot
                                .add(new ItemSlot(3, new Item("Beef Tapa", 40, 120, 10, ItemType.INGREDIENT)));
                CVendingSlot
                                .add(new ItemSlot(4, new Item("Longganisa", 30, 136, 15, ItemType.INGREDIENT)));
                CVendingSlot
                                .add(new ItemSlot(5, new Item("Tocino", 30, 230, 15, ItemType.INGREDIENT)));
                CVendingSlot
                                .add(new ItemSlot(6, new Item("Hotdog", 20, 247, 15, ItemType.INGREDIENT)));
                CVendingSlot
                                .add(new ItemSlot(7, new Item("Lumpiang Shanghai", 35, 215, 15, ItemType.INGREDIENT)));
                CVendingSlot
                                .add(new ItemSlot(8, new Item("Bangus", 30, 178, 15, ItemType.INGREDIENT)));
                CVendingSlot
                                .add(new ItemSlot(9, new Item("Sliced Tomatoes", 1, 4, 13, ItemType.ADDON)));
                CVendingSlot
                                .add(new ItemSlot(10, new Item("Sliced Cucumber", 2, 1, 13, ItemType.ADDON)));
                CVendingSlot
                                .add(new ItemSlot(11, new Item("Atchara", 10, 28, 13, ItemType.ADDON)));
        }

        private HashMap<String, Integer> setupProduct(String strProductName) {
                HashMap<String, Integer> productOptions = new HashMap<String, Integer>();
                switch (strProductName.toLowerCase()) {
                        case "tapsilog":
                                productOptions.put("Beef Tapa", 1);
                                productOptions.put("Garlic Fried Rice", 1);
                                productOptions.put("Fried Egg", 1);
                                productOptions.put("Sliced Tomatoes", 2);
                                productOptions.put("Sliced Cucumber", 2);
                                productOptions.put("Atchara", 1);
                                break;
                        case "longsilog":
                                productOptions.put("Longganisa", 1);
                                productOptions.put("Garlic Fried Rice", 1);
                                productOptions.put("Fried Egg", 1);
                                productOptions.put("Sliced Tomatoes", 3);
                                break;
                        case "tocilog":
                                productOptions.put("Tocino", 1);
                                productOptions.put("Garlic Fried Rice", 1);
                                productOptions.put("Fried Egg", 1);
                                break;
                        case "hotsilog":
                                productOptions.put("Hotdog", 1);
                                productOptions.put("Garlic Fried Rice", 1);
                                productOptions.put("Fried Egg", 1);
                                break;
                        case "bangsilog":
                                productOptions.put("Bangus", 1);
                                productOptions.put("Garlic Fried Rice", 1);
                                productOptions.put("Fried Egg", 1);
                                productOptions.put("Sliced Tomatoes", 2);
                                break;
                        case "shangsilog":
                                productOptions.put("Lumpiang Shanghai", 1);
                                productOptions.put("Garlic Fried Rice", 1);
                                productOptions.put("Fried Egg", 1);
                                productOptions.put("Sliced Tomatoes", 3);
                                break;
                }
                return productOptions;
        }

        public void purchaseProduct(String strProductName) {
                HashMap<String, Integer> product = this.setupProduct(strProductName);

                for (String name : product.keySet()) {
                        this.CVendingSlot.get(this.findItemSlotIndex(name)).getItem().buyItem(1);
                }

        }

        /**
         * Displays the information of the item to be purchased which includes its
         * name, price, and quantity
         * 
         * @param nItemIndex    represents the index of an item
         * @param nItemQuantity represents the quantity of an item
         */
        public void displayToPurchase(int nItemIndex, int nItemQuantity) {
                System.out.println("\n--------------------------");
                System.out.println("Item Name: \t" + this.CVendingSlot.get(nItemIndex).getItem().getItemName());
                System.out
                                .println("Total Price: \t"
                                                + this.CVendingSlot.get(nItemIndex).getItem().getItemPrice()
                                                                * nItemQuantity);
                System.out.println("Total Quantity: " + nItemQuantity);
                System.out.println("--------------------------");
        }

        public int calculateChange(int nPayment, int nIndex) {
                int nChange = nPayment - (this.vendingOptions.get(nIndex).getProductPrice());
                int nFullChange = nPayment
                                - (this.vendingOptions.get(nIndex).getProductPrice());
                int[] arrDenominations = this.vendingMoney.getDenominations();
                int[] arrCount = { 0, 0, 0, 0, 0, 0, 0 };
                for (int i = 0; i < arrDenominations.length; i++) {
                        while (nChange >= arrDenominations[i]) {
                                arrCount[i]++;
                                nChange -= arrDenominations[i];
                        }

                }
                System.out.println();
                System.out.println("Change: " + nFullChange);
                System.out.println("In these denominations:");
                for (int i = 0; i < arrDenominations.length; i++)
                        System.out.println(arrDenominations[i] + " x " + arrCount[i]);

                return nFullChange;
        }

        public int findItemSlotIndex(String strItemName) {
                int index;
                for (ItemSlot slot : this.CVendingSlot) {
                        if (slot.getItem().getItemName().equalsIgnoreCase(strItemName)) {
                                index = slot.getSlotIndex();
                                return index;
                        }
                }
                return -1;
        }

        public void addItemToIngredients(String strItemName) {
                this.vendingIngredients.add(this.CVendingSlot.get(this.findItemSlotIndex(strItemName)).getItem());
                this.CVendingSlot.get(this.findItemSlotIndex(strItemName)).getItem().buyItem(1);
        }

        public void cookSilog() {
                int i;
                for (i = 0; i <= this.vendingIngredients.size(); i++)
                        switch (this.vendingIngredients.get(i).getItemName()) {
                                case "Garlic Fried Rice":
                                        System.out.println("Frying rice...");
                                        try {
                                                Thread.sleep(500);
                                        } catch (InterruptedException e) {
                                                System.out.println(e);
                                        }
                                        break;
                                case "Fried Egg":
                                        System.out.println("Frying egg...");
                                        try {
                                                Thread.sleep(500);
                                        } catch (InterruptedException e) {
                                                System.out.println(e);
                                        }
                                        break;
                                case "Beef Tapa":
                                        System.out.println("Cooking tapa...");
                                        try {
                                                Thread.sleep(500);
                                        } catch (InterruptedException e) {
                                                System.out.println(e);
                                        }
                                        break;
                                case "Longganisa":
                                        System.out.println("Cooking longganisa...");
                                        try {
                                                Thread.sleep(500);
                                        } catch (InterruptedException e) {
                                                System.out.println(e);
                                        }
                                        break;
                                case "Tocino":
                                        System.out.println("Cooking tocino...");
                                        try {
                                                Thread.sleep(500);
                                        } catch (InterruptedException e) {
                                                System.out.println(e);
                                        }
                                        break;
                                case "Hotdog":
                                        System.out.println("Cooking hotdog...");
                                        try {
                                                Thread.sleep(500);
                                        } catch (InterruptedException e) {
                                                System.out.println(e);
                                        }
                                        break;
                                case "Lumpiang Shanghai":
                                        System.out.println("Cooking lumpia...");
                                        try {
                                                Thread.sleep(500);
                                        } catch (InterruptedException e) {
                                                System.out.println(e);
                                        }
                                        break;
                                case "Bangus":
                                        System.out.println("Frying bangus...");
                                        try {
                                                Thread.sleep(500);
                                        } catch (InterruptedException e) {
                                                System.out.println(e);
                                        }
                                        break;
                                case "Sliced Tomatoes":
                                        System.out.println("Slicing some tomatoes...");
                                        try {
                                                Thread.sleep(500);
                                        } catch (InterruptedException e) {
                                                System.out.println(e);
                                        }
                                        break;
                                case "Sliced Cucumber":
                                        System.out.println("Slicing some cucumber...");
                                        try {
                                                Thread.sleep(500);
                                        } catch (InterruptedException e) {
                                                System.out.println(e);
                                        }
                                        break;
                                case "Atchara":
                                        System.out.println("Adding some cucumber...");
                                        try {
                                                Thread.sleep(500);
                                        } catch (InterruptedException e) {
                                                System.out.println(e);
                                        }
                                        break;
                                default:
                                        break;
                        }
                if (i == this.vendingIngredients.size())
                        System.out.println("Silog meal is done!");
        }

}
package com.vendingmodel.specialvendingmachine;

import java.util.*;

import com.vendingmodel.item.Item;
import com.vendingmodel.itemslot.ItemSlot;
import com.vendingmodel.moneybox.MoneyBox;
import com.vendingmodel.vendingmachine.VendingMachine;

/**
 * This is <code>SpecialVendingMachine</code> class which represents the special
 * vending machine object of the machine
 */
public class SpecialVendingMachine extends VendingMachine {
        private ArrayList<Item> CVendingIngredients;

        /**
         * This is the SpecialVendingMachine constructor
         */
        public SpecialVendingMachine() {
                super();
                this.CVendingIngredients = new ArrayList<Item>();
        }

        /**
         * Used to initialize the vending machine by adding items as well as
         * additional products to their corresponding slots
         */
        public void setupSpecialVendingStock() {
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
                CVendingSlot
                                .add(new ItemSlot(9, new Item("Sliced Tomatoes", 1, 4, 13)));
                CVendingSlot
                                .add(new ItemSlot(10, new Item("Sliced Cucumber", 2, 1, 13)));
                CVendingSlot
                                .add(new ItemSlot(11, new Item("Atchara", 10, 28, 13)));
        }

        /**
         * Initializes the available options for a particular silog in the menu
         * 
         * @param strProductName represents the name of the product that is inputted by
         *                       the user
         * @return productOptions represents the hashmap of the options available for
         *         that product along with its quantities
         */
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

        /**
         * Allows the user to purchase products from the vending machine.
         * Aside from purchasing, this also checks if there are enough
         * ingredients in the vending machine. If there is, it will display
         * the cooking process of the item selected
         * 
         * @param strProductName represents the name of the product that the
         *                       user wants to purchase
         */
        public void purchaseProduct(String strProductName) {
                HashMap<String, Integer> product = this.setupProduct(strProductName);

                try {
                        for (String name : product.keySet()) {
                                if (this.CVendingSlot.get(this.findItemSlotIndex(name)).getItem().getItemName()
                                                .equalsIgnoreCase(name))
                                        this.CVendingSlot.get(this.findItemSlotIndex(name)).getItem()
                                                        .buyItem(product.get(name));
                        }
                } catch (Exception e) {
                        throw new ArrayIndexOutOfBoundsException(
                                        "Ingredients not enough.");
                } finally {
                        for (String name : product.keySet())
                                switch (name) {
                                        case "Garlic Fried Rice":
                                                System.out.println("Frying rice...");
                                                break;
                                        case "Fried Egg":
                                                System.out.println("Frying egg...");
                                                break;
                                        case "Beef Tapa":
                                                System.out.println("Cooking beef...");
                                                break;
                                        case "Longganisa":
                                                System.out.println("Cooking longganisa...");
                                                break;
                                        case "Tocino":
                                                System.out.println("Cooking tocino...");
                                                break;
                                        case "Hotdog":
                                                System.out.println("Cooking hotdog...");
                                                break;
                                        case "Lumpiang Shanghai":
                                                System.out.println("Cooking shanghai...");
                                                break;
                                        case "Bangus":
                                                System.out.println("Frying bangus...");
                                                break;
                                }
                }
        }

        /**
         * Displays the information of the item to be purchased which includes its
         * name, price, and quantity
         * 
         * @param nItemIndex    represents the index of an item
         * @param nItemQuantity represents the quantity of an item
         */
        public String displayToPurchase(int nItemIndex, int nItemQuantity) {
                StringBuilder display = new StringBuilder();

                System.out.println("\n--------------------------");
                System.out.println("Item Name: \t" + this.CVendingSlot.get(nItemIndex).getItem().getItemName());
                System.out
                                .println("Total Price: \t"
                                                + this.CVendingSlot.get(nItemIndex).getItem().getItemPrice()
                                                                * nItemQuantity);
                System.out.println("Total Quantity: " + nItemQuantity);
                System.out.println("--------------------------");

                return display.toString();
        }

        /**
         * Searches an item and return the index of the slot where the item is located
         * 
         * @param strItemName represents the name of the item to be searched
         * @return index if the found and -1 otherwise
         */
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

        /**
         * This method handles the vending machine's inventory and peforms ingredient
         * tracking wherein it will add an item to the list of ingredients inside the
         * vending machine.
         * 
         * @param strItemName represents the name of the item to be added in the
         *                    ingredients' list
         */
        public void addItemToIngredients(String strItemName) {
                this.CVendingIngredients.add(this.CVendingSlot.get(this.findItemSlotIndex(strItemName)).getItem());
                this.CVendingSlot.get(this.findItemSlotIndex(strItemName)).getItem().buyItem(1);
        }

}
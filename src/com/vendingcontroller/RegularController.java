package com.vendingcontroller;

import java.awt.*;
import java.io.File;
import java.util.concurrent.Flow;

import javax.swing.Action;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.vendingmodel.item.*;
import com.vendingmodel.itemslot.*;
import com.vendingmodel.regularvendingmachine.RegularVendingMachine;
import com.vendingview.regulargui.RegularGui;

import com.vendingcontroller.MenuController;
import com.vendingview.menugui.MenuGui;

/**
 * This is <code>RegularController</code> class which represents the regular
 * vending machine controller object of the machine
 */
public class RegularController {
    private RegularVendingMachine regularModel;
    private RegularGui regularGui;
    private MenuGui menu;

    /**
     * This is the RegularController constructor
     * 
     * @param regularGui   regular machine gui
     * @param regularModel regular machine model
     * @param menu         main menu
     */
    public RegularController(RegularGui regularGui, RegularVendingMachine regularModel, MenuGui menu) {
        this.regularGui = regularGui;
        this.regularModel = regularModel;
        this.menu = menu;

        this.regularGui.setConfirmButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int nItemIndex = Integer.parseInt(regularGui.getItemIndexTextInput()) - 1;
                int nItemQuantity = Integer.parseInt(regularGui.getItemQtyTextInput());

                regularGui.setStatusItemText(regularModel.displayToPurchase(nItemIndex, nItemQuantity));
            }
        });

        this.regularGui.setPayButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int nItemIndex = Integer.parseInt(regularGui.getItemIndexTextInput()) - 1;
                int nItemQuantity = Integer.parseInt(regularGui.getItemQtyTextInput());
                int nPayment = Integer.parseInt(regularGui.getPayment());

                if (regularModel.insertPayment(nPayment) == true) {
                    if (nPayment >= regularModel.getVendingSlot().get(nItemIndex).getItem().getItemPrice()
                            * nItemQuantity) {
                        regularGui.setStatusItemText(regularModel.displayStatusAfterPurchase(
                        regularModel.purchaseItem(nItemIndex, nItemQuantity),
                        regularModel.calculateChange(nPayment, nItemIndex, nItemQuantity)));

                        regularGui.setDisplayItemText(regularModel.listSlotInfo());

                        regularGui.clearTextFiedls();

                    } else {
                        regularGui.setStatusItemText("NOT ENOUGH PAYMENT");
                    }
                } else {
                    regularGui.setStatusItemText("INVALID BILL.");
                }
            }
        });

        this.regularGui.setCancelButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                regularGui.setStatusItemText(null);
                regularGui.clearTextFiedls();
            }
        });

        this.regularGui.setMaintenanceButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                regularGui.getRegularFrame().setVisible(false);
                regularGui.getRegularMaintenanceFrame().setVisible(true);

                regularGui.setMaintenanceDisplayText(regularModel.listSlotInfo());

                regularGui.setMaintenanceStatusText(regularModel.displayTransactions());
            }
        });

        this.regularGui.setReturnToMainMenuButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                regularGui.getRegularFrame().dispose();
                menu.getMainFrame().setVisible(true);
            }
        });

        this.regularGui.setStockButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null, regularGui.initializeStockPanel(),
                        "STOCK NEW ITEM", JOptionPane.OK_CANCEL_OPTION);

                if (result == JOptionPane.OK_OPTION) {
                    String name = regularGui.getNameTextField();
                    int price = Integer.parseInt(regularGui.getPriceTextField());
                    int calories = Integer.parseInt(regularGui.getCaloriesTextField());
                    int qty = Integer.parseInt(regularGui.getQtyTextField());

                    if (regularModel.findItem(name) == false && qty <= 15) {
                        regularModel.getVendingSlot().add(new ItemSlot(regularModel.getVendingSlot().size() + 1,
                                new Item(name, price, calories, qty)));
                                regularGui.setMaintenanceDisplayText(regularModel.listSlotInfo());
                    } else {
                        regularGui.setStatusItemText("Item already exists.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Transaction Cancelled.");
                }
            }
        });

        this.regularGui.setRestockButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null, regularGui.initializeRestockPanel(),
                        "RESTOCK ITEM", JOptionPane.OK_CANCEL_OPTION);

                if (result == JOptionPane.OK_OPTION) {
                    String name = regularGui.getNameTextField();
                    int qty = Integer.parseInt(regularGui.getQtyTextField());

                    if (regularModel.getVendingSlot().get(regularModel.getFoundItem(name)).getItem().canRestock(qty)) {
                        regularModel.getVendingSlot().get(regularModel.getFoundItem(name)).getItem()
                                .restockItem(qty);
                        regularGui.setMaintenanceDisplayText(regularModel.listSlotInfo());
                    } else {
                        JOptionPane.showMessageDialog(null, "Item limit exceeded.");
                    }
                }
            }
        });

        this.regularGui.setItemPriceButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(regularGui.getRegularMaintenanceFrame(),
                        regularGui.initializePricePanel(),
                        "SET PRICE", JOptionPane.OK_CANCEL_OPTION);

                if (result == JOptionPane.OK_OPTION) {
                    String name = regularGui.getNameTextField();
                    int price = Integer.parseInt(regularGui.getPriceTextField());

                    regularModel.getVendingSlot().get(regularModel.getFoundItem(name)).getItem().setItemPrice(price);
                    regularGui.setMaintenanceDisplayText(regularModel.listSlotInfo());
                }
            }
        });

        this.regularGui.setEarningsButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    regularModel.getEarnings();
                    regularGui.setMaintenanceStatusText(regularModel.displayTransactions());
                    JOptionPane.showMessageDialog(null, "Earnings collected.");
            }
        });

        this.regularGui.setChangeButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null, regularGui.initializeChangePanel(),
                        "REPLENISH CHANGE", JOptionPane.OK_CANCEL_OPTION);

                if (result == JOptionPane.OK_OPTION) {
                    int change = Integer.parseInt(regularGui.getChangeTextField());
                        
                    regularModel.getMoneyBox().addMoney(change);
                    regularGui.setMaintenanceStatusText(regularModel.displayTransactions());

                } else {
                    JOptionPane.showMessageDialog(null, "Transaction Cancelled.");
                }
            }
        });

        this.regularGui.setGobackButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                regularGui.getRegularMaintenanceFrame().setVisible(false);
                regularGui.getRegularFrame().setVisible(true);
            }
        });
    }
}

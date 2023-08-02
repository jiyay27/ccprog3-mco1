package com.vendingcontroller;

import java.awt.*;
import java.io.File;
import java.util.concurrent.Flow;

import javax.swing.Action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                int nItemIndex = Integer.parseInt(regularGui.getItemIndexTextInput());
                int nItemQuantity = Integer.parseInt(regularGui.getItemQtyTextInput());

                regularGui.setStatusItemText(regularModel.displayToPurchase(nItemIndex - 1, nItemQuantity));
            }
        });

        this.regularGui.setPayButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int nItemIndex = Integer.parseInt(regularGui.getItemIndexTextInput());
                int nItemQuantity = Integer.parseInt(regularGui.getItemQtyTextInput());
                int nPayment = Integer.parseInt(regularGui.getPayment());

                if (regularModel.insertPayment(nPayment) == true) {
                    if (nPayment >= regularModel.getVendingSlot().get(nItemIndex - 1).getItem().getItemPrice()
                            * nItemQuantity) {
                        // regularGui.setStatusItemText(regularModel.calculateChange(nPayment,
                        // nItemIndex, nItemQuantity));
                        regularGui.setStatusItemText(regularModel.displayStatusAfterPurchase(
                                regularModel.purchaseItem(nItemIndex - 1, nItemQuantity),
                                regularModel.calculateChange(nPayment, nItemIndex, nItemQuantity)));

                        regularGui.setDisplayItemText(regularModel.listSlotInfo());

                        regularGui.clearTextFiedls();
                    } else {
                        regularGui.setStatusItemText("\n\n          NOT ENOUGH PAYMENT");
                    }
                } else {
                    regularGui.setStatusItemText("INVALID BILL.");
                }
            }
        });

        this.regularGui.setCancelButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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

        this.regularGui.setEarningsButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        this.regularGui.setChangeButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

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

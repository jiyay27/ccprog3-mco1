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
 * vedning machine controller object of the machine
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

            }
        });

        this.regularGui.setCancelButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        this.regularGui.setMaintenanceButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                regularGui.getRegularFrame().setVisible(false);
                regularGui.getRegularMaintenanceFrame().setVisible(true);
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

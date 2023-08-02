package com.vendingcontroller;

import java.awt.*;
import java.io.File;
import java.util.concurrent.Flow;

import javax.swing.Action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.vendingmodel.specialvendingmachine.SpecialVendingMachine;
import com.vendingview.specialgui.SpecialGui;

import com.vendingcontroller.MenuController;
import com.vendingview.menugui.MenuGui;

/**
 * This is <code>SpecialController</code> class which represents the special
 * vending machine controller object of the machine
 */
public class SpecialController {
    private SpecialVendingMachine specialModel;
    private SpecialGui specialGui;
    private MenuGui menu;

    /**
     * This is the SpecialController constructor
     * 
     * @param specialGui   special machine gui
     * @param specialModel special machine model
     * @param menu         main menu
     */
    public SpecialController(SpecialGui specialGui, SpecialVendingMachine specialModel, MenuGui menu) {
        this.specialGui = specialGui;
        this.specialModel = specialModel;
        this.menu = menu;

        this.specialGui.setSpecialConfirmButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        this.specialGui.setSpecialCancelButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        this.specialGui.setSpecialMaintenanceButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                specialGui.getSpecialFrame().setVisible(false);
                specialGui.getSpecialMaintenanceFrame().setVisible(true);
            }
        });

        this.specialGui.setSpecialReturnToMainMenuButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                specialGui.getSpecialFrame().dispose();
                menu.getMainFrame().setVisible(true);
            }
        });

        this.specialGui.setSpecialEarningsButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        this.specialGui.setSpecialChangeButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        this.specialGui.setSpecialGobackButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                specialGui.getSpecialMaintenanceFrame().setVisible(false);
                specialGui.getSpecialFrame().setVisible(true);
            }
        });
    }
}

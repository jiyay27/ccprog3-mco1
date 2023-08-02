package com.vendingcontroller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

import com.vendingview.menugui.MenuGui;

import com.vendingmodel.regularvendingmachine.RegularVendingMachine;
import com.vendingview.regulargui.RegularGui;
import com.vendingcontroller.RegularController;

import com.vendingmodel.specialvendingmachine.SpecialVendingMachine;
import com.vendingview.specialgui.SpecialGui;
import com.vendingcontroller.SpecialController;

/**
 * This is <code>MenuController</code> class which represents the menu
 * controller object of the machine
 */
public class MenuController {
    private MenuGui menu;

    private RegularVendingMachine regularMachine;
    private RegularGui regularMachineGui;
    private RegularController regularController;

    private SpecialVendingMachine specialMachine;
    private SpecialGui specialMachineGui;
    private SpecialController specialController;

    /**
     * This is the MenuController constructor
     * 
     * @param menu main menu
     */
    public MenuController(MenuGui menu) {
        this.menu = menu;

        this.menu.setCreateRegularButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (regularMachine != null) {
                    JOptionPane.showMessageDialog(null,
                            "<html>Regular vending macine has already been created.</html>", "ERROR",
                            JOptionPane.WARNING_MESSAGE, null);
                } else if (specialMachine != null) {
                    JOptionPane.showMessageDialog(null,
                            "<html>Special vpending macine already exists.</html>", "ERROR",
                            JOptionPane.WARNING_MESSAGE, null);
                } else {
                    regularMachine = new RegularVendingMachine();
                    regularMachine.setupVendingMachine();
                    menu.getMainFrame();

                    JOptionPane.showMessageDialog(null, "Regular vending machine has been created.", null,
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        this.menu.setCreateSpecialButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (specialMachine != null) {
                    JOptionPane.showMessageDialog(null,
                            "<html>Special vending macine has already been created.</html>", "ERROR",
                            JOptionPane.WARNING_MESSAGE, null);
                } else if (regularMachine != null) {
                    JOptionPane.showMessageDialog(null,
                            "<html>Regular vending macine already exists.</html>", "ERROR",
                            JOptionPane.WARNING_MESSAGE, null);
                } else {
                    specialMachine = new SpecialVendingMachine();
                    specialMachine.setupSpecialVendingStock();
                    menu.getMainFrame();

                    JOptionPane.showMessageDialog(null, "Special vending machine has been created.", null,
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        this.menu.setTestButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (regularMachine == null && specialMachine == null) {
                    JOptionPane.showMessageDialog(null,

                            "<html>Vending machine does not extist. <br>Please create a vending machine.</html>",
                            "ERROR",
                            JOptionPane.WARNING_MESSAGE, null);
                } else if (regularMachine != null) {
                    RegularGui regularMachineGui = new RegularGui();
                    regularMachineGui.initializeFeatures();
                    regularMachineGui.setDisplayItemText(regularMachine.listSlotInfo());

                    regularMachineGui.initializeMaintenance();
                    regularMachineGui.getRegularMaintenanceFrame().setVisible(false);

                    menu.getMainFrame().setVisible(false);

                    RegularController regularController = new RegularController(regularMachineGui, regularMachine,
                            menu);

                    specialMachineGui.getSpecialMaintenanceFrame().setVisible(false);

                } else if (specialMachine != null) {
                    SpecialGui specialMachineGui = new SpecialGui();
                    specialMachineGui.initializeSpecialFeatures();
                    specialMachineGui.initializeSpecialMaintenance();
                    specialMachineGui.getSpecialMaintenanceFrame().setVisible(false);

                    menu.getMainFrame().setVisible(false);

                    SpecialController specialController = new SpecialController(specialMachineGui, specialMachine,
                            menu);
                }
            }

        });

        this.menu.setExitButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Program has succesfully terminated.");
                System.exit(0);
            }
        });
    }
}

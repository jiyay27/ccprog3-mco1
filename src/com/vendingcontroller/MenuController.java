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

public class MenuController {
    private MenuGui menu;

    private RegularVendingMachine regularMachine;
    private RegularGui regularMachineGui;
    private RegularController regularController;

    private SpecialVendingMachine specialMachine;
    private SpecialGui specialMachineGui;
    private SpecialController specialController;

    public MenuController(MenuGui menu) {
        this.menu = menu;

        this.menu.setCreateRegularButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // if (e == ) {

                regularMachine = new RegularVendingMachine();
                regularMachine.setupVendingMachine();
                menu.getMainFrame();

                menu.getMainFrame().setVisible(true);

                JOptionPane.showMessageDialog(null, "Vending machine has been created.", null,
                        JOptionPane.INFORMATION_MESSAGE);
                // }

            }
        });

        this.menu.setCreateSpecialButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // if (e == ) {
                RegularVendingMachine regularMachine = new RegularVendingMachine();

                regularMachine.setupVendingMachine();
                menu.getMainFrame();
                JOptionPane.showMessageDialog(null, "Vending machine has been created.", null,
                        JOptionPane.INFORMATION_MESSAGE);
                // }

            }
        });
        this.menu.setTestButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        this.menu.setExitButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Program has succesfully terminated.",
                        null, JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        });

    }
}
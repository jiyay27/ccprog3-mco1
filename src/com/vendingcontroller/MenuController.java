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

        this.menu.setCreateButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RegularVendingMachine regularMachine = new RegularVendingMachine();

                regularMachine.setupVendingMachine();
                menu.initializeCreateVendingElements();
            }
        });

        this.menu.setTestButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        this.menu.setExitButtonListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });

    }
}
package com.vendingcontroller;

import java.awt.*;
import java.io.File;
import java.util.concurrent.Flow;

import javax.swing.Action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.vendingmodel.regularvendingmachine.RegularVendingMachine;
import com.vendingview.regulargui.RegularGui;

public class RegularController {
    private RegularGui regularGui;

    public RegularController(RegularGui regularGui, RegularVendingMachine regularModel) {
        this.regularGui = regularGui;

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
                regularGui.initializeMaintenance();
                regularGui.getRegularMaintenanceFrame();
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
            }
        });
    }
}

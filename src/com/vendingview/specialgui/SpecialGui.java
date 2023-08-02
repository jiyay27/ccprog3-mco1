package com.vendingview.specialgui;

import javax.swing.*;
import javax.swing.text.StyleConstants.ColorConstants;

import java.awt.*;
import java.io.File;
import java.util.concurrent.Flow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SpecialGui {
    private JFrame specialFrame,
            specialMaintenanceFrame;

    private JPanel fSpecialViewingPanel,
            fSpecialUserPanel,
            specialfeaturesPanel,

            mSpecialViewingPanel,
            mSpecialUserPanel,
            specialmaintenancePanel; // FOR MAINTENANCE (edited alr)

    private JLabel sProductLabel,
            sTotalLabel,
            sPaymentLabel,
            sSelectLabel; // FOR MAINTENANCE (edited alr)

    private JButton sConfirm,
            sCancel,
            sMaintenance,
            sBackToMain,

            sStock,
            sRestock,
            sSetPrice,
            sEarnings,
            sChange,
            sGoback; // FOR MAINTENANCE. (edited alr)

    private JTextArea sDisplayProducts,
            sShowStatus,

            specialMaintenanceDisplay,
            specialMaintenanceStatus; // FOR MAINTENANCE. (edited alr)

    private JTextField sProductTxtField,
            sTotalTxtField,
            sPaymentTxtField,

            sSelectTxtField; // FOR MAINTENANCE. (edited alr)

    public SpecialGui() {
        this.specialFrame = new JFrame("Special Vending Features");
        this.specialFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.specialFrame.setLayout(new GridLayout(1, 2));
        this.specialFrame.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.specialFrame.setSize(600, 800);
        this.specialFrame.setLocationRelativeTo(null);
        this.specialFrame.setResizable(false);

        this.specialMaintenanceFrame = new JFrame("Special Maintenance Features");
        this.specialMaintenanceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.specialMaintenanceFrame.setLayout(new GridLayout(1, 2));
        this.specialMaintenanceFrame.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.specialMaintenanceFrame.setSize(600, 800);
        this.specialMaintenanceFrame.setLocationRelativeTo(null);
        this.specialMaintenanceFrame.setResizable(false);

        // TODO:
    }

    public void initializeSpecialFeatures() {
        // ! FEATURES PANEL
        this.specialfeaturesPanel = new JPanel(new GridLayout(0, 2));
        this.specialfeaturesPanel.setBackground(Color.RED);
        this.specialfeaturesPanel.setSize(590, 790);

        // ! VIEWING PANEL
        this.fSpecialViewingPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        this.fSpecialViewingPanel.setBackground(Color.BLUE);
        this.fSpecialViewingPanel.setPreferredSize(new Dimension(280, 700));

        // ! TEXT AREA
        this.sDisplayProducts = new JTextArea();
        this.sDisplayProducts.setBackground(Color.WHITE);
        this.sDisplayProducts.setBorder(BorderFactory.createLineBorder(Color.getColor("BLACK")));
        this.sDisplayProducts.setPreferredSize(new Dimension(280, 590));
        this.sDisplayProducts.setFocusable(false);

        this.sShowStatus = new JTextArea();
        this.sShowStatus.setBackground(Color.WHITE);
        this.sShowStatus.setBorder(BorderFactory.createLineBorder(Color.getColor("BLACK")));
        this.sShowStatus.setPreferredSize(new Dimension(280, 150));
        this.sShowStatus.setFocusable(false);

        this.fSpecialViewingPanel.add(sDisplayProducts);
        this.fSpecialViewingPanel.add(sShowStatus);

        // ! USER INPUT PANEl
        this.fSpecialUserPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        this.fSpecialUserPanel.setBackground(Color.GREEN);
        this.fSpecialUserPanel.setSize(280, 700);

        // ! LABEL
        // ! PRODUCT NAME
        this.sProductLabel = new JLabel("Product Name:", SwingConstants.LEFT);
        // this.menuNameLabel.setFont(new Font("Nirmala", Font.BOLD, 30));
        this.sProductLabel.setForeground(Color.BLACK);

        // ! TOTAL
        this.sTotalLabel = new JLabel("Total:", SwingConstants.LEFT);
        // this.menuNameLabel.setFont(new Font("Nirmala", Font.BOLD, 30));
        this.sTotalLabel.setForeground(Color.BLACK);

        // ! PAYMENT
        this.sPaymentLabel = new JLabel("Payment:", SwingConstants.LEFT);
        // this.menuNameLabel.setFont(new Font("Nirmala", Font.BOLD, 30));
        this.sPaymentLabel.setForeground(Color.BLACK);

        // ! TEXT FIELDS
        this.sProductTxtField = new JTextField();
        this.sProductTxtField.setMaximumSize(new Dimension(270, 30));
        this.sProductTxtField.setMinimumSize(new Dimension(270, 30));
        this.sProductTxtField.setPreferredSize(new Dimension(270, 30));

        this.sTotalTxtField = new JTextField();
        this.sTotalTxtField.setMaximumSize(new Dimension(270, 30));
        this.sTotalTxtField.setMinimumSize(new Dimension(270, 30));
        this.sTotalTxtField.setPreferredSize(new Dimension(270, 30));
        this.sTotalTxtField.setFocusable(false);

        this.sPaymentTxtField = new JTextField();
        this.sPaymentTxtField.setMaximumSize(new Dimension(270, 30));
        this.sPaymentTxtField.setMinimumSize(new Dimension(270, 30));
        this.sPaymentTxtField.setPreferredSize(new Dimension(270, 30));

        this.fSpecialUserPanel.add(sProductLabel);
        this.fSpecialUserPanel.add(sProductTxtField);
        this.fSpecialUserPanel.add(sTotalLabel);
        this.fSpecialUserPanel.add(sTotalTxtField);
        this.fSpecialUserPanel.add(sPaymentLabel);
        this.fSpecialUserPanel.add(sPaymentTxtField);

        // !! BUTTONS
        // ! CONFIRM
        this.sConfirm = new JButton("Confirm");
        this.sConfirm.setMaximumSize(new Dimension(270, 100));
        this.sConfirm.setMinimumSize(new Dimension(270, 100));
        this.sConfirm.setPreferredSize(new Dimension(270, 100));
        this.sConfirm.setBackground(Color.WHITE);

        // ! BUTTONS PANEL
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel.setPreferredSize(new Dimension(270, 100));
        buttonsPanel.setBackground(Color.LIGHT_GRAY);
        buttonsPanel.add(sConfirm);
        this.fSpecialUserPanel.add(buttonsPanel);

        // ! CANCEL
        this.sCancel = new JButton("Cancel");
        this.sCancel.setMaximumSize(new Dimension(270, 100));
        this.sCancel.setMinimumSize(new Dimension(270, 100));
        this.sCancel.setPreferredSize(new Dimension(270, 100));
        this.sCancel.setBackground(Color.WHITE);

        // ! BUTTONS PANEL
        buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel.setPreferredSize(new Dimension(270, 100));
        buttonsPanel.setBackground(Color.LIGHT_GRAY);
        buttonsPanel.add(sCancel);
        this.fSpecialUserPanel.add(buttonsPanel);

        // ! MAINTENANCE
        this.sMaintenance = new JButton("Special Maintenance Features");
        this.sMaintenance.setMaximumSize(new Dimension(270, 100));
        this.sMaintenance.setMinimumSize(new Dimension(270, 100));
        this.sMaintenance.setPreferredSize(new Dimension(270, 100));
        this.sMaintenance.setBackground(Color.WHITE);

        buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel.setPreferredSize(new Dimension(270, 100));
        buttonsPanel.setBackground(Color.LIGHT_GRAY);
        buttonsPanel.add(sMaintenance);
        this.fSpecialUserPanel.add(buttonsPanel);

        // ! RETURN TO MAIN MENU
        this.sBackToMain = new JButton("Return to Main Menu");
        this.sBackToMain.setMaximumSize(new Dimension(270, 100));
        this.sBackToMain.setMinimumSize(new Dimension(270, 100));
        this.sBackToMain.setPreferredSize(new Dimension(270, 100));
        this.sBackToMain.setBackground(Color.WHITE);

        buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel.setPreferredSize(new Dimension(270, 100));
        buttonsPanel.setBackground(Color.LIGHT_GRAY);
        buttonsPanel.add(sBackToMain);

        this.fSpecialUserPanel.add(buttonsPanel);

        this.specialfeaturesPanel.add(fSpecialViewingPanel);
        this.specialfeaturesPanel.add(fSpecialUserPanel);

        this.specialFrame.add(specialfeaturesPanel);
        // this.regularFrame.setVisible(true);
        this.specialFrame.setVisible(true);
        this.specialMaintenanceFrame.setVisible(false);
    }

    public void initializeSpecialMaintenance() {
        // ! MAINTENANCE PANEL
        this.specialmaintenancePanel = new JPanel(new GridLayout(0, 2));
        this.specialmaintenancePanel.setBackground(Color.RED);
        this.specialmaintenancePanel.setSize(590, 790);

        // ! VIEWING PANEL
        this.mSpecialViewingPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        this.mSpecialViewingPanel.setBackground(Color.BLUE);
        this.mSpecialViewingPanel.setPreferredSize(new Dimension(280, 700));

        // ! TEXT AREA
        this.specialMaintenanceDisplay = new JTextArea();
        this.specialMaintenanceDisplay.setBackground(Color.WHITE);
        this.specialMaintenanceDisplay.setBorder(BorderFactory.createLineBorder(Color.getColor("BLACK")));
        this.specialMaintenanceDisplay.setPreferredSize(new Dimension(280, 590));
        this.specialMaintenanceDisplay.setFocusable(false);

        this.specialMaintenanceStatus = new JTextArea();
        this.specialMaintenanceStatus.setBackground(Color.WHITE);
        this.specialMaintenanceStatus.setBorder(BorderFactory.createLineBorder(Color.getColor("BLACK")));
        this.specialMaintenanceStatus.setPreferredSize(new Dimension(280, 150));
        this.specialMaintenanceStatus.setFocusable(false);

        this.mSpecialViewingPanel.add(specialMaintenanceDisplay);
        this.mSpecialViewingPanel.add(specialMaintenanceStatus);

        // ! USER INPUT PANEl
        this.mSpecialUserPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        this.mSpecialUserPanel.setBackground(Color.GREEN);
        this.mSpecialUserPanel.setSize(280, 700);

        // ! LABEL
        // ! ITEM NAME
        this.sSelectLabel = new JLabel("Input Item Name: ", SwingConstants.LEFT);
        // this.menuNameLabel.setFont(new Font("Nirmala", Font.BOLD, 30));
        this.sSelectLabel.setForeground(Color.BLACK);

        // ! TEXT FIELD
        this.sSelectTxtField = new JTextField();
        this.sSelectTxtField.setMaximumSize(new Dimension(270, 30));
        this.sSelectTxtField.setMinimumSize(new Dimension(270, 30));
        this.sSelectTxtField.setPreferredSize(new Dimension(270, 30));

        this.mSpecialUserPanel.add(sSelectLabel);
        this.mSpecialUserPanel.add(sSelectTxtField);

        // !! BUTTONS
        // ! STOCK
        this.sStock = new JButton("Stock");
        this.sStock.setMaximumSize(new Dimension(270, 100));
        this.sStock.setMinimumSize(new Dimension(270, 100));
        this.sStock.setPreferredSize(new Dimension(270, 100));
        this.sStock.setBackground(Color.WHITE);

        // ! BUTTONS PANEL
        JPanel buttonsPanel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel2.setPreferredSize(new Dimension(270, 100));
        buttonsPanel2.setBackground(Color.LIGHT_GRAY);
        buttonsPanel2.add(sStock);
        this.mSpecialUserPanel.add(buttonsPanel2);

        // ! RESTOCK
        this.sRestock = new JButton("Restock");
        this.sRestock.setMaximumSize(new Dimension(270, 100));
        this.sRestock.setMinimumSize(new Dimension(270, 100));
        this.sRestock.setPreferredSize(new Dimension(270, 100));
        this.sRestock.setBackground(Color.WHITE);

        // ! BUTTONS PANEL
        buttonsPanel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel2.setPreferredSize(new Dimension(270, 100));
        buttonsPanel2.setBackground(Color.LIGHT_GRAY);
        buttonsPanel2.add(sRestock);
        this.mSpecialUserPanel.add(buttonsPanel2);

        // ! SET PRICE
        this.sSetPrice = new JButton("Set Item Price");
        this.sSetPrice.setMaximumSize(new Dimension(270, 100));
        this.sSetPrice.setMinimumSize(new Dimension(270, 100));
        this.sSetPrice.setPreferredSize(new Dimension(270, 100));
        this.sSetPrice.setBackground(Color.WHITE);

        // ! BUTTONS PANEL
        buttonsPanel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel2.setPreferredSize(new Dimension(270, 100));
        buttonsPanel2.setBackground(Color.LIGHT_GRAY);
        buttonsPanel2.add(sSetPrice);
        this.mSpecialUserPanel.add(buttonsPanel2);

        // ! EARNINGS
        this.sEarnings = new JButton("Earnings");
        this.sEarnings.setMaximumSize(new Dimension(270, 100));
        this.sEarnings.setMinimumSize(new Dimension(270, 100));
        this.sEarnings.setPreferredSize(new Dimension(270, 100));
        this.sEarnings.setBackground(Color.WHITE);

        // ! BUTTONS PANEL
        buttonsPanel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel2.setPreferredSize(new Dimension(270, 100));
        buttonsPanel2.setBackground(Color.LIGHT_GRAY);
        buttonsPanel2.add(sEarnings);
        this.mSpecialUserPanel.add(buttonsPanel2);

        // ! CHANGE
        this.sChange = new JButton("Change");
        this.sChange.setMaximumSize(new Dimension(270, 100));
        this.sChange.setMinimumSize(new Dimension(270, 100));
        this.sChange.setPreferredSize(new Dimension(270, 100));
        this.sChange.setBackground(Color.WHITE);

        // ! BUTTONS PANEL
        buttonsPanel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel2.setPreferredSize(new Dimension(270, 100));
        buttonsPanel2.setBackground(Color.LIGHT_GRAY);
        buttonsPanel2.add(sChange);
        this.mSpecialUserPanel.add(buttonsPanel2);

        // ! GO BACK
        this.sGoback = new JButton("Return to Vending Features");
        this.sGoback.setMaximumSize(new Dimension(270, 100));
        this.sGoback.setMinimumSize(new Dimension(270, 100));
        this.sGoback.setPreferredSize(new Dimension(270, 100));
        this.sGoback.setBackground(Color.WHITE);

        // ! BUTTONS PANEL
        buttonsPanel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel2.setPreferredSize(new Dimension(270, 100));
        buttonsPanel2.setBackground(Color.LIGHT_GRAY);
        buttonsPanel2.add(sGoback);
        this.mSpecialUserPanel.add(buttonsPanel2);

        this.specialmaintenancePanel.add(mSpecialViewingPanel);
        this.specialmaintenancePanel.add(mSpecialUserPanel);

        this.specialMaintenanceFrame.add(specialmaintenancePanel);
        // this.regularMaintenanceFrame.setVisible(false);
        this.specialMaintenanceFrame.setVisible(true);
    }

    public JFrame getSpecialFrame() {
        return this.specialFrame;
    }

    public JFrame getSpecialMaintenanceFrame() {
        return this.specialMaintenanceFrame;
    }

    public void setSpecialConfirmButtonListener(ActionListener action) {
        this.sConfirm.addActionListener(action);
    }

    public void setSpecialCancelButtonListener(ActionListener action) {
        this.sCancel.addActionListener(action);
    }

    public void setSpecialMaintenanceButtonListener(ActionListener action) {
        this.sMaintenance.addActionListener(action);
    }

    public void setSpecialReturnToMainMenuButtonListener(ActionListener action) {
        this.sBackToMain.addActionListener(action);
    }

    public void setSpecialStockButtonListener(ActionListener action) {
        this.sStock.addActionListener(action);
    }

    public void setSpecialRestockButtonListener(ActionListener action) {
        this.sRestock.addActionListener(action);
    }

    public void setSpecialItemPriceButtonListener(ActionListener action) {
        this.sSetPrice.addActionListener(action);
    }

    public void setSpecialEarningsButtonListener(ActionListener action) {
        this.sEarnings.addActionListener(action);
    }

    public void setSpecialChangeButtonListener(ActionListener action) {
        this.sChange.addActionListener(action);
    }

    public void setSpecialGobackButtonListener(ActionListener action) {
        this.sGoback.addActionListener(action);
    }
}
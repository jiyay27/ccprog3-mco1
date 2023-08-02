package com.vendingview.regulargui;

import javax.swing.*;
import javax.swing.text.StyleConstants.ColorConstants;

import java.awt.*;
import java.io.File;
import java.util.concurrent.Flow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegularGui {
    private JFrame regularFrame,
            regularMaintenanceFrame;

    private JPanel fViewingPanel,
            fUserPanel,
            featuresPanel,
            mViewingPanel,
            mUserPanel,
            maintenancePanel;

    private JLabel itemLabel,
            qtyLabel,
            paymentLabel,
            totalLabel,
            selectLabel;

    private JButton confirm,
            cancel,
            maintenance,
            backToMain,
            stock,
            restock,
            setPrice,
            earnings,
            change,
            goback;

    private JTextArea displayItems,
            showStatus,
            maintenanceDisplay,
            maintenanceStatus;

    private JTextField itemTxtField,
            qtyTxtField,
            paymentTxtField,
            totalTxtField,
            selectTxtField;

    public RegularGui() {
        this.regularFrame = new JFrame("Regular Vending Features");
        this.regularFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.regularFrame.setLayout(new GridLayout(1, 2));
        this.regularFrame.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.regularFrame.setSize(600, 800);
        this.regularFrame.setLocationRelativeTo(null);
        this.regularFrame.setResizable(false);

        this.regularMaintenanceFrame = new JFrame("Regular Maintenance Features");
        this.regularMaintenanceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.regularMaintenanceFrame.setLayout(new GridLayout(1, 2));
        this.regularMaintenanceFrame.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.regularMaintenanceFrame.setSize(600, 800);
        this.regularMaintenanceFrame.setLocationRelativeTo(null);
        this.regularMaintenanceFrame.setResizable(false);

        // TODO:
    }

    public void initializeFeatures() {
        // ! FEATURES PANEL
        this.featuresPanel = new JPanel(new GridLayout(0, 2));
        this.featuresPanel.setBackground(Color.RED);
        this.featuresPanel.setSize(590, 790);

        // ! VIEWING PANEL
        this.fViewingPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        this.fViewingPanel.setBackground(Color.BLUE);
        this.fViewingPanel.setPreferredSize(new Dimension(280, 700));

        // ! TEXT AREA
        this.displayItems = new JTextArea();
        this.displayItems.setBackground(Color.WHITE);
        this.displayItems.setBorder(BorderFactory.createLineBorder(Color.getColor("BLACK")));
        this.displayItems.setPreferredSize(new Dimension(280, 590));
        this.displayItems.setFocusable(false);

        this.showStatus = new JTextArea();
        this.showStatus.setBackground(Color.WHITE);
        this.showStatus.setBorder(BorderFactory.createLineBorder(Color.getColor("BLACK")));
        this.showStatus.setPreferredSize(new Dimension(280, 150));
        this.showStatus.setFocusable(false);

        this.fViewingPanel.add(displayItems);
        this.fViewingPanel.add(showStatus);

        // ! USER INPUT PANEl
        this.fUserPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        this.fUserPanel.setBackground(Color.GREEN);
        this.fUserPanel.setSize(280, 700);

        // ! LABEL
        // ! ITEM SLOT NUMBER
        this.itemLabel = new JLabel("Item Slot Number:", SwingConstants.LEFT);
        // this.menuNameLabel.setFont(new Font("Nirmala", Font.BOLD, 30));
        this.itemLabel.setForeground(Color.BLACK);

        // ! QUANTITY
        this.qtyLabel = new JLabel("Quantity:", SwingConstants.LEFT);
        // this.menuNameLabel.setFont(new Font("Nirmala", Font.BOLD, 30));
        this.qtyLabel.setForeground(Color.BLACK);

        // ! TOTAL
        this.totalLabel = new JLabel("Total:", SwingConstants.LEFT);
        // this.menuNameLabel.setFont(new Font("Nirmala", Font.BOLD, 30));
        this.totalLabel.setForeground(Color.BLACK);

        // ! PAYMENT
        this.paymentLabel = new JLabel("Payment:", SwingConstants.LEFT);
        // this.menuNameLabel.setFont(new Font("Nirmala", Font.BOLD, 30));
        this.paymentLabel.setForeground(Color.BLACK);

        // ! TEXT FIELDS
        this.itemTxtField = new JTextField();
        this.itemTxtField.setMaximumSize(new Dimension(270, 30));
        this.itemTxtField.setMinimumSize(new Dimension(270, 30));
        this.itemTxtField.setPreferredSize(new Dimension(270, 30));

        this.qtyTxtField = new JTextField();
        this.qtyTxtField.setMaximumSize(new Dimension(270, 30));
        this.qtyTxtField.setMinimumSize(new Dimension(270, 30));
        this.qtyTxtField.setPreferredSize(new Dimension(270, 30));

        this.totalTxtField = new JTextField();
        this.totalTxtField.setMaximumSize(new Dimension(270, 30));
        this.totalTxtField.setMinimumSize(new Dimension(270, 30));
        this.totalTxtField.setPreferredSize(new Dimension(270, 30));
        this.totalTxtField.setFocusable(false);

        this.paymentTxtField = new JTextField();
        this.paymentTxtField.setMaximumSize(new Dimension(270, 30));
        this.paymentTxtField.setMinimumSize(new Dimension(270, 30));
        this.paymentTxtField.setPreferredSize(new Dimension(270, 30));

        this.fUserPanel.add(itemLabel);
        this.fUserPanel.add(itemTxtField);
        this.fUserPanel.add(qtyLabel);
        this.fUserPanel.add(qtyTxtField);
        this.fUserPanel.add(totalLabel);
        this.fUserPanel.add(totalTxtField);
        this.fUserPanel.add(paymentLabel);
        this.fUserPanel.add(paymentTxtField);

        // !! BUTTONS
        // ! CONFIRM
        this.confirm = new JButton("Confirm");
        this.confirm.setMaximumSize(new Dimension(270, 100));
        this.confirm.setMinimumSize(new Dimension(270, 100));
        this.confirm.setPreferredSize(new Dimension(270, 100));
        this.confirm.setBackground(Color.WHITE);

        // ! BUTTONS PANEL
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel.setPreferredSize(new Dimension(270, 100));
        buttonsPanel.setBackground(Color.LIGHT_GRAY);
        buttonsPanel.add(confirm);
        this.fUserPanel.add(buttonsPanel);

        // ! CANCEL
        this.cancel = new JButton("Cancel");
        this.cancel.setMaximumSize(new Dimension(270, 100));
        this.cancel.setMinimumSize(new Dimension(270, 100));
        this.cancel.setPreferredSize(new Dimension(270, 100));
        this.cancel.setBackground(Color.WHITE);

        // ! BUTTONS PANEL
        buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel.setPreferredSize(new Dimension(270, 100));
        buttonsPanel.setBackground(Color.LIGHT_GRAY);
        buttonsPanel.add(cancel);
        this.fUserPanel.add(buttonsPanel);

        // ! MAINTENANCE
        this.maintenance = new JButton("Maintenance Features");
        this.maintenance.setMaximumSize(new Dimension(270, 100));
        this.maintenance.setMinimumSize(new Dimension(270, 100));
        this.maintenance.setPreferredSize(new Dimension(270, 100));
        this.maintenance.setBackground(Color.WHITE);

        buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel.setPreferredSize(new Dimension(270, 100));
        buttonsPanel.setBackground(Color.LIGHT_GRAY);
        buttonsPanel.add(maintenance);
        this.fUserPanel.add(buttonsPanel);

        // ! RETURN TO MAIN MENU
        this.backToMain = new JButton("Return to Main Menu");
        this.backToMain.setMaximumSize(new Dimension(270, 100));
        this.backToMain.setMinimumSize(new Dimension(270, 100));
        this.backToMain.setPreferredSize(new Dimension(270, 100));
        this.backToMain.setBackground(Color.WHITE);

        buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel.setPreferredSize(new Dimension(270, 100));
        buttonsPanel.setBackground(Color.LIGHT_GRAY);
        buttonsPanel.add(backToMain);

        this.fUserPanel.add(buttonsPanel);

        this.featuresPanel.add(fViewingPanel);
        this.featuresPanel.add(fUserPanel);

        this.regularFrame.add(featuresPanel);
        // this.regularFrame.setVisible(true);
        this.regularFrame.setVisible(true);
        this.regularMaintenanceFrame.setVisible(false);
    }

    public void initializeMaintenance() {
        // ! MAINTENANCE PANEL
        this.maintenancePanel = new JPanel(new GridLayout(0, 2));
        this.maintenancePanel.setBackground(Color.RED);
        this.maintenancePanel.setSize(590, 790);

        // ! VIEWING PANEL
        this.mViewingPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        this.mViewingPanel.setBackground(Color.BLUE);
        this.mViewingPanel.setPreferredSize(new Dimension(280, 700));

        // ! TEXT AREA
        this.maintenanceDisplay = new JTextArea();
        this.maintenanceDisplay.setBackground(Color.WHITE);
        this.maintenanceDisplay.setBorder(BorderFactory.createLineBorder(Color.getColor("BLACK")));
        this.maintenanceDisplay.setPreferredSize(new Dimension(280, 590));
        this.maintenanceDisplay.setFocusable(false);

        this.maintenanceStatus = new JTextArea();
        this.maintenanceStatus.setBackground(Color.WHITE);
        this.maintenanceStatus.setBorder(BorderFactory.createLineBorder(Color.getColor("BLACK")));
        this.maintenanceStatus.setPreferredSize(new Dimension(280, 150));
        this.maintenanceStatus.setFocusable(false);

        this.mViewingPanel.add(displayItems);
        this.mViewingPanel.add(showStatus);

        // ! USER INPUT PANEl
        this.mUserPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        this.mUserPanel.setBackground(Color.GREEN);
        this.mUserPanel.setSize(280, 700);

        // ! LABEL
        // ! ITEM SLOT NUMBER
        this.selectLabel = new JLabel("Input Item Name: ", SwingConstants.LEFT);
        // this.menuNameLabel.setFont(new Font("Nirmala", Font.BOLD, 30));
        this.selectLabel.setForeground(Color.BLACK);

        // ! TEXT FIELD
        this.selectTxtField = new JTextField();
        this.selectTxtField.setMaximumSize(new Dimension(270, 30));
        this.selectTxtField.setMinimumSize(new Dimension(270, 30));
        this.selectTxtField.setPreferredSize(new Dimension(270, 30));

        this.mUserPanel.add(itemLabel);
        this.mUserPanel.add(itemTxtField);

        // !! BUTTONS
        // ! STOCK
        this.stock = new JButton("Stock");
        this.stock.setMaximumSize(new Dimension(270, 100));
        this.stock.setMinimumSize(new Dimension(270, 100));
        this.stock.setPreferredSize(new Dimension(270, 100));
        this.stock.setBackground(Color.WHITE);

        // ! BUTTONS PANEL
        JPanel buttonsPanel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel2.setPreferredSize(new Dimension(270, 100));
        buttonsPanel2.setBackground(Color.LIGHT_GRAY);
        buttonsPanel2.add(stock);
        this.mUserPanel.add(buttonsPanel2);

        // ! RESTOCK
        this.restock = new JButton("Restock");
        this.restock.setMaximumSize(new Dimension(270, 100));
        this.restock.setMinimumSize(new Dimension(270, 100));
        this.restock.setPreferredSize(new Dimension(270, 100));
        this.restock.setBackground(Color.WHITE);

        // ! BUTTONS PANEL
        buttonsPanel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel2.setPreferredSize(new Dimension(270, 100));
        buttonsPanel2.setBackground(Color.LIGHT_GRAY);
        buttonsPanel2.add(restock);
        this.mUserPanel.add(buttonsPanel2);

        // ! SET PRICE
        this.setPrice = new JButton("Set Item Price");
        this.setPrice.setMaximumSize(new Dimension(270, 100));
        this.setPrice.setMinimumSize(new Dimension(270, 100));
        this.setPrice.setPreferredSize(new Dimension(270, 100));
        this.setPrice.setBackground(Color.WHITE);

        // ! BUTTONS PANEL
        buttonsPanel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel2.setPreferredSize(new Dimension(270, 100));
        buttonsPanel2.setBackground(Color.LIGHT_GRAY);
        buttonsPanel2.add(setPrice);
        this.mUserPanel.add(buttonsPanel2);

        // ! EARNINGS
        this.earnings = new JButton("Earnings");
        this.earnings.setMaximumSize(new Dimension(270, 100));
        this.earnings.setMinimumSize(new Dimension(270, 100));
        this.earnings.setPreferredSize(new Dimension(270, 100));
        this.earnings.setBackground(Color.WHITE);

        // ! BUTTONS PANEL
        buttonsPanel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel2.setPreferredSize(new Dimension(270, 100));
        buttonsPanel2.setBackground(Color.LIGHT_GRAY);
        buttonsPanel2.add(earnings);
        this.mUserPanel.add(buttonsPanel2);

        // ! CHANGE
        this.change = new JButton("Change");
        this.change.setMaximumSize(new Dimension(270, 100));
        this.change.setMinimumSize(new Dimension(270, 100));
        this.change.setPreferredSize(new Dimension(270, 100));
        this.change.setBackground(Color.WHITE);

        // ! BUTTONS PANEL
        buttonsPanel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel2.setPreferredSize(new Dimension(270, 100));
        buttonsPanel2.setBackground(Color.LIGHT_GRAY);
        buttonsPanel2.add(change);
        this.mUserPanel.add(buttonsPanel2);

        // ! GO BACK
        this.goback = new JButton("Return to Vending Features");
        this.goback.setMaximumSize(new Dimension(270, 100));
        this.goback.setMinimumSize(new Dimension(270, 100));
        this.goback.setPreferredSize(new Dimension(270, 100));
        this.goback.setBackground(Color.WHITE);

        // ! BUTTONS PANEL
        buttonsPanel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel2.setPreferredSize(new Dimension(270, 100));
        buttonsPanel2.setBackground(Color.LIGHT_GRAY);
        buttonsPanel2.add(goback);
        this.mUserPanel.add(buttonsPanel2);

        this.maintenancePanel.add(mViewingPanel);
        this.maintenancePanel.add(mUserPanel);

        this.regularMaintenanceFrame.add(maintenancePanel);
        // this.regularMaintenanceFrame.setVisible(false);
        this.regularFrame.setVisible(false);
        this.regularMaintenanceFrame.setVisible(true);
    }

    public JFrame getRegularFrame() {
        return this.regularFrame;
    }

    public JFrame getRegularMaintenanceFrame() {
        return this.regularMaintenanceFrame;
    }

    // public JPanel getFeaturesPanel() {

    // return this.featuresPanel;
    // }

    // public JPanel getMaintenancePanel() {

    // return this.maintenancePanel;
    // }

    public void setConfirmButtonListener(ActionListener action) {
        this.confirm.addActionListener(action);
    }

    public void setCancelButtonListener(ActionListener action) {
        this.cancel.addActionListener(action);
    }

    public void setMaintenanceButtonListener(ActionListener action) {
        this.maintenance.addActionListener(action);
    }

    public void setReturnToMainMenuButtonListener(ActionListener action) {
        this.backToMain.addActionListener(action);
    }

    public void setStockButtonListener(ActionListener action) {
        this.stock.addActionListener(action);
    }

    public void setRestockButtonListener(ActionListener action) {
        this.restock.addActionListener(action);
    }

    public void setItemPriceButtonListener(ActionListener action) {
        this.setPrice.addActionListener(action);
    }

    public void setEarningsButtonListener(ActionListener action) {
        this.earnings.addActionListener(action);
    }

    public void setChangeButtonListener(ActionListener action) {
        this.change.addActionListener(action);
    }

    public void setGobackButtonListener(ActionListener action) {
        this.goback.addActionListener(action);
    }
}

package com.vendingview.regulargui;

import javax.swing.*;
import javax.swing.text.StyleConstants.ColorConstants;

import java.awt.*;
import java.io.File;
import java.util.concurrent.Flow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is <code>RegularGui</code> class which represents the
 * regular vending machine's gui object of the machine
 */
public class RegularGui {
    private JFrame regularFrame,
            regularMaintenanceFrame;

    private JPanel fViewingPanel,
            fUserPanel,
            featuresPanel,

            mViewingPanel,
            mUserPanel,
            maintenancePanel,

            stockPanel,
            restockPanel,
            pricePanel,
            earningsPanel,
            changePanel;

    private JLabel itemLabel,
            qtyLabel,
            paymentLabel,
            enterDenoLabel;

    private JButton confirm,
            pay,
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

    private JScrollPane displayScroll,
            statusScroll,
            mDisplayScroll,
            mStatusScroll;

    private JTextField itemTxtField,
            qtyTxtField,
            paymentTxtField,

            nameTextField,
            priceTextField,
            caloriesTextField,
            qtyTextField,
            changeTextField;

    /**
     * This is the RegularGui constructor
     */
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
    }

    /**
     * Initializes the contents included in the vending features part of the
     * regular vending machine interface
     */
    public void initializeFeatures() {
        // ! FEATURES PANEL
        this.featuresPanel = new JPanel(new GridLayout(0, 2));
        this.featuresPanel.setBackground(new Color(240, 234, 214));
        this.featuresPanel.setSize(590, 790);

        // ! VIEWING PANEL
        this.fViewingPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        this.fViewingPanel.setBackground(new Color(240, 234, 214));
        this.fViewingPanel.setPreferredSize(new Dimension(280, 700));

        // ! TEXT AREA
        this.displayItems = new JTextArea();
        this.displayItems.setBackground(Color.WHITE);
        this.displayItems.setBorder(BorderFactory.createLineBorder(Color.getColor("BLACK")));
        this.displayItems.setFocusable(false);

        this.showStatus = new JTextArea();
        this.showStatus.setBackground(Color.WHITE);
        this.showStatus.setBorder(BorderFactory.createLineBorder(Color.getColor("BLACK")));
        this.showStatus.setFocusable(false);

        // ! SCROLL PANES
        this.displayScroll = new JScrollPane(displayItems);
        this.displayScroll.setBackground(Color.WHITE);
        this.displayScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.displayScroll.setBorder(BorderFactory.createLineBorder(Color.getColor("BLACK")));
        this.displayScroll.setPreferredSize(new Dimension(280, 590));
        this.displayScroll.setFocusable(false);

        this.statusScroll = new JScrollPane(showStatus);
        this.statusScroll.setBackground(Color.WHITE);
        this.statusScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.statusScroll.setBorder(BorderFactory.createLineBorder(Color.getColor("BLACK")));
        this.statusScroll.setPreferredSize(new Dimension(280, 150));
        this.statusScroll.setFocusable(false);

        this.fViewingPanel.add(this.displayScroll);
        this.fViewingPanel.add(this.statusScroll);

        // ! USER INPUT PANEl
        this.fUserPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        this.fUserPanel.setBackground(new Color(240, 234, 214));
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

        // ! PAYMENT
        this.paymentLabel = new JLabel("Payment:", SwingConstants.LEFT);
        // this.menuNameLabel.setFont(new Font("Nirmala", Font.BOLD, 30));
        this.paymentLabel.setForeground(Color.BLACK);

        // TODO
        this.enterDenoLabel = new JLabel("[Allowed Bills - 20, 50, 100, 200]", SwingConstants.LEFT);
        this.enterDenoLabel.setForeground(Color.BLACK);

        // ! TEXT FIELDS
        this.itemTxtField = new JTextField();
        this.itemTxtField.setMaximumSize(new Dimension(270, 30));
        this.itemTxtField.setMinimumSize(new Dimension(270, 30));
        this.itemTxtField.setPreferredSize(new Dimension(270, 30));

        this.qtyTxtField = new JTextField();
        this.qtyTxtField.setMaximumSize(new Dimension(270, 30));
        this.qtyTxtField.setMinimumSize(new Dimension(270, 30));
        this.qtyTxtField.setPreferredSize(new Dimension(270, 30));

        this.paymentTxtField = new JTextField();
        this.paymentTxtField.setMaximumSize(new Dimension(270, 30));
        this.paymentTxtField.setMinimumSize(new Dimension(270, 30));
        this.paymentTxtField.setPreferredSize(new Dimension(270, 30));

        this.fUserPanel.add(itemLabel);
        this.fUserPanel.add(itemTxtField);
        this.fUserPanel.add(qtyLabel);
        this.fUserPanel.add(qtyTxtField);
        this.fUserPanel.add(paymentLabel);
        this.fUserPanel.add(enterDenoLabel);
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
        buttonsPanel.setBackground(new Color(240, 234, 214));
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
        buttonsPanel.setBackground(new Color(240, 234, 214));
        buttonsPanel.add(cancel);
        this.fUserPanel.add(buttonsPanel);



        // ! PAY
        this.pay = new JButton("Pay");
        this.pay.setMaximumSize(new Dimension(270, 100));
        this.pay.setMinimumSize(new Dimension(270, 100));
        this.pay.setPreferredSize(new Dimension(270, 100));
        this.pay.setBackground(Color.WHITE);

        // ! BUTTONS PANEL
        buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel.setPreferredSize(new Dimension(270, 100));
        buttonsPanel.setBackground(new Color(240, 234, 214));
        buttonsPanel.add(pay);
        this.fUserPanel.add(buttonsPanel);

        // ! MAINTENANCE
        this.maintenance = new JButton("Maintenance Features");
        this.maintenance.setMaximumSize(new Dimension(270, 100));
        this.maintenance.setMinimumSize(new Dimension(270, 100));
        this.maintenance.setPreferredSize(new Dimension(270, 100));
        this.maintenance.setBackground(Color.WHITE);

        buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel.setPreferredSize(new Dimension(270, 100));
        buttonsPanel.setBackground(new Color(240, 234, 214));
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
        buttonsPanel.setBackground(new Color(240, 234, 214));
        buttonsPanel.add(backToMain);

        this.fUserPanel.add(buttonsPanel);

        this.featuresPanel.add(fViewingPanel);
        this.featuresPanel.add(fUserPanel);

        this.regularFrame.add(featuresPanel);
        // this.regularFrame.setVisible(true);
        this.regularFrame.setVisible(true);
        this.regularMaintenanceFrame.setVisible(false);
    }

    /**
     * Initializes the contents included in the maintenance part of the
     * regular vending machine interface
     */
    public void initializeMaintenance() {
        // ! MAINTENANCE PANEL
        this.maintenancePanel = new JPanel(new GridLayout(0, 2));
        this.maintenancePanel.setBackground(new Color(240, 234, 214));
        this.maintenancePanel.setSize(590, 790);

        // ! VIEWING PANEL
        this.mViewingPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        this.mViewingPanel.setBackground(new Color(240, 234, 214));
        this.mViewingPanel.setPreferredSize(new Dimension(280, 700));

        // ! TEXT AREA
        this.maintenanceDisplay = new JTextArea();
        this.maintenanceDisplay.setBackground(Color.WHITE);
        this.maintenanceDisplay.setBorder(BorderFactory.createLineBorder(Color.getColor("BLACK")));
        // this.maintenanceDisplay.setPreferredSize(new Dimension(280, 590));
        this.maintenanceDisplay.setFocusable(false);

        this.maintenanceStatus = new JTextArea();
        this.maintenanceStatus.setBackground(Color.WHITE);
        this.maintenanceStatus.setBorder(BorderFactory.createLineBorder(Color.getColor("BLACK")));
        // this.maintenanceStatus.setPreferredSize(new Dimension(280, 150));
        this.maintenanceStatus.setFocusable(false);

        // ! SCROLL PANES
        this.mDisplayScroll = new JScrollPane(maintenanceDisplay);
        this.mDisplayScroll.setBackground(Color.WHITE);
        this.mDisplayScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.mDisplayScroll.setBorder(BorderFactory.createLineBorder(Color.getColor("BLACK")));
        this.mDisplayScroll.setPreferredSize(new Dimension(280, 590));
        this.mDisplayScroll.setFocusable(false);

        this.mStatusScroll = new JScrollPane(maintenanceStatus);
        this.mStatusScroll.setBackground(Color.WHITE);
        this.mStatusScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.mStatusScroll.setBorder(BorderFactory.createLineBorder(Color.getColor("BLACK")));
        this.mStatusScroll.setPreferredSize(new Dimension(280, 150));
        this.mStatusScroll.setFocusable(false);

        this.mViewingPanel.add(this.mDisplayScroll);
        this.mViewingPanel.add(this.mStatusScroll);

        // ! USER INPUT PANEl
        this.mUserPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        this.mUserPanel.setBackground(new Color(240, 234, 214));
        this.mUserPanel.setSize(280, 700);

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
        this.regularMaintenanceFrame.setVisible(true);
    }

    /**
     * Initializes the contents included in the stock panel of the
     * regular vending machine interface
     */
    public JPanel initializeStockPanel() {
        this.stockPanel = new JPanel(new GridLayout(5, 1, 0, 0));
        this.stockPanel.setPreferredSize(new Dimension(420, 150));

        // ! LABELS
        JLabel nameLabel = new JLabel("Name:", SwingConstants.LEFT);
        nameLabel.setForeground(Color.BLACK);

        // ! TEXT FIELDS
        this.nameTextField = new JTextField();
        this.nameTextField.setMaximumSize(new Dimension(270, 30));
        this.nameTextField.setMinimumSize(new Dimension(270, 30));
        this.nameTextField.setPreferredSize(new Dimension(270, 30));

        // ! LABELS
        JLabel priceLabel = new JLabel("Price:", SwingConstants.LEFT);
        priceLabel.setForeground(Color.BLACK);

        // ! TEXT FIELDS
        this.priceTextField = new JTextField();
        this.priceTextField.setMaximumSize(new Dimension(270, 30));
        this.priceTextField.setMinimumSize(new Dimension(270, 30));
        this.priceTextField.setPreferredSize(new Dimension(270, 30));

        // ! LABELS
        JLabel caloriesLabel = new JLabel("Calories:", SwingConstants.LEFT);
        caloriesLabel.setForeground(Color.BLACK);

        // ! TEXT FIELDS
        this.caloriesTextField = new JTextField();
        this.caloriesTextField.setMaximumSize(new Dimension(270, 30));
        this.caloriesTextField.setMinimumSize(new Dimension(270, 30));
        this.caloriesTextField.setPreferredSize(new Dimension(270, 30));

        // ! LABELS
        JLabel itemQuantity = new JLabel("Label:", SwingConstants.LEFT);
        itemQuantity.setForeground(Color.BLACK);

        // ! TEXT FIELDS
        this.qtyTextField = new JTextField();
        this.qtyTextField.setMaximumSize(new Dimension(270, 30));
        this.qtyTextField.setMinimumSize(new Dimension(270, 30));
        this.qtyTextField.setPreferredSize(new Dimension(270, 30));

        this.stockPanel.add(nameLabel);
        this.stockPanel.add(nameTextField);
        this.stockPanel.add(priceLabel);
        this.stockPanel.add(priceTextField);
        this.stockPanel.add(caloriesLabel);
        this.stockPanel.add(caloriesTextField);
        this.stockPanel.add(qtyLabel);
        this.stockPanel.add(qtyTextField);

        return stockPanel;
    }

    /**
     * Gets the name inputted by the user in the nameTextField
     * 
     * @return nameTextField.getText() represents the nameTextField stored with the
     *         datatype String
     */
    public String getNameTextField() {
        return this.nameTextField.getText();
    }

    /**
     * Gets the price inputted by the user in the priceTextField
     * 
     * @return priceTextField.getText() represents the priceTextField stored with
     *         the datatype String
     */
    public String getPriceTextField() {
        return this.priceTextField.getText();
    }

    /**
     * Gets the calories inputted by the user in the caloriesTextField
     * 
     * @return caloriesTextField.getText() represents the caloriesTextField stored
     *         with the datatype String
     */
    public String getCaloriesTextField() {
        return this.caloriesTextField.getText();
    }

    /**
     * Gets the quantity inputted by the user in the qtyTextField
     * 
     * @return qtyTextField.getText() represents the qtyTextField stored with
     *         the datatype String
     */
    public String getQtyTextField() {
        return this.qtyTextField.getText();
    }

    /**
     * Initializes the contents included in the restock panel of the
     * regular vending machine interface
     */
    public JPanel initializeRestockPanel() {
        this.restockPanel = new JPanel(new GridLayout(5, 1, 0, 0));
        this.restockPanel.setPreferredSize(new Dimension(420, 150));

        // ! LABELS
        JLabel restockNameLabel = new JLabel("Name:", SwingConstants.LEFT);
        restockNameLabel.setForeground(Color.BLACK);

        // ! TEXT FIELDS
        this.nameTextField = new JTextField();
        this.nameTextField.setMaximumSize(new Dimension(270, 30));
        this.nameTextField.setMinimumSize(new Dimension(270, 30));
        this.nameTextField.setPreferredSize(new Dimension(270, 30));

        // ! QUANTITY
        JLabel restockItemQuantity = new JLabel("Quantity:", SwingConstants.LEFT);
        restockItemQuantity.setForeground(Color.BLACK);

        // ! TEXT FIELDS
        this.qtyTextField = new JTextField();
        this.qtyTextField.setMaximumSize(new Dimension(270, 30));
        this.qtyTextField.setMinimumSize(new Dimension(270, 30));
        this.qtyTextField.setPreferredSize(new Dimension(270, 30));

        this.restockPanel.add(restockNameLabel);
        this.restockPanel.add(nameTextField);
        this.restockPanel.add(restockItemQuantity);
        this.restockPanel.add(qtyTextField);

        return restockPanel;
    }

    /**
     * Initializes the contents included in the price panel of the
     * regular vending machine interface
     */
    public JPanel initializePricePanel() {
        this.pricePanel = new JPanel(new GridLayout(5, 1, 0, 0));
        this.pricePanel.setPreferredSize(new Dimension(420, 150));

        // ! LABELS
        JLabel nameLabel = new JLabel("Name:", SwingConstants.LEFT);
        nameLabel.setForeground(Color.BLACK);

        // ! TEXT FIELDS
        this.nameTextField = new JTextField();
        this.nameTextField.setMaximumSize(new Dimension(270, 30));
        this.nameTextField.setMinimumSize(new Dimension(270, 30));
        this.nameTextField.setPreferredSize(new Dimension(270, 30));

        // ! LABELS
        JLabel priceLabel = new JLabel("Price:", SwingConstants.LEFT);
        priceLabel.setForeground(Color.BLACK);

        // ! TEXT FIELDS
        this.priceTextField = new JTextField();
        this.priceTextField.setMaximumSize(new Dimension(270, 30));
        this.priceTextField.setMinimumSize(new Dimension(270, 30));
        this.priceTextField.setPreferredSize(new Dimension(270, 30));

        this.pricePanel.add(nameLabel);
        this.pricePanel.add(nameTextField);
        this.pricePanel.add(priceLabel);
        this.pricePanel.add(priceTextField);

        return pricePanel;
    }

    

    // TODO remove
    /**
     * Initializes the contents included in the earnings panel of the
     * regular vending machine interface
     */
    public JPanel initializeEarnignsPanel() {
        this.earningsPanel = new JPanel();

        return earningsPanel;
    }

    /**
     * Initializes the contents included in the change panel of the
     * regular vending machine interface
     */
    public JPanel initializeChangePanel() {
        this.changePanel = new JPanel(new GridLayout(5, 1, 0, 0));
        this.changePanel.setPreferredSize(new Dimension(420, 150));

        // ! LABELS
        JLabel addChangeLabel = new JLabel("Enter amount:", SwingConstants.LEFT);
        addChangeLabel.setForeground(Color.BLACK);

        // ! TEXT FIELDS
        this.changeTextField = new JTextField();
        this.changeTextField.setMaximumSize(new Dimension(270, 30));
        this.changeTextField.setMinimumSize(new Dimension(270, 30));
        this.changeTextField.setPreferredSize(new Dimension(270, 30));

        this.changePanel.add(addChangeLabel);
        this.changePanel.add(changeTextField);

        return changePanel;
    }

    /**
     * Returns the values stored in the regularFrame variable
     * 
     * @return this.regularFrame represents the regularFrame stored with the
     *         datatype JFrame
     */
    public JFrame getRegularFrame() {
        return this.regularFrame;
    }

    /**
     * Returns the values stored in the regularMaintenanceFrame variable
     * 
     * @return this.regularMaintenanceFrame represents the regularMaintenanceFrame
     *         stored with the datatype JFrame
     */
    public JFrame getRegularMaintenanceFrame() {
        return this.regularMaintenanceFrame;
    }

    /**
     * Updates the displayed text on the screen
     * 
     * @param text represents the text content that the
     *             user wants to display
     */
    public void setDisplayItemText(String strText) {
        this.displayItems.setText(strText);
    }

    /**
     * Updates the displayed status on the screen
     * 
     * @param text represents the status that will be displayed
     */
    public void setStatusItemText(String strText) {
        this.showStatus.setText(strText);
    }

    /**
     * Updates the displayed text on the screen
     * 
     * @param text represents the text content that the
     *             user wants to display
     */
    public void setMaintenanceDisplayText(String strText) {
        this.maintenanceDisplay.setText(strText);
    }

    /**
     * Updates the displayed text on the screen
     * 
     * @param text represents the text content that the
     *             user wants to display
     */
    public void setMaintenanceStatusText(String text) {
        this.maintenanceStatus.setText(text);
    }

    /**
     * Gets the item index inputted by the user in the itemTxtField
     * 
     * @return itemTxtField.getText() represents the itemTxtField stored with the
     *         datatype String
     */
    public String getItemIndexTextInput() {
        return this.itemTxtField.getText();
    }

    /**
     * Gets the item quantity inputted by the user in the qtyTxtField
     * 
     * @return qtyTxtField.getText() represents the qtyTxtField stored with the
     *         datatype String
     */
    public String getItemQtyTextInput() {
        return this.qtyTxtField.getText();
    }

    /**
     * Gets the payment inputted by the user in the paymentTxtField
     * 
     * @return paymentTxtField.getText() represents the paymentTxtField stored with
     *         the datatype String
     */
    public String getPayment() {
        return this.paymentTxtField.getText();
    }

    /**
     * Gets the payment inputted by the user in the changeTextField
     *
     * @return this.changeTextField.getText() represents the changeTextField stored with
     *         the datatype String
     */
    public String getChangeTextField() {
        return this.changeTextField.getText();
    }

    /**
     * Removes the contents within itemTxtField, qtyTxtField, and paymentTxtField
     */
    public void clearTextFields() {
        this.itemTxtField.setText("");
        this.qtyTxtField.setText("");
        this.paymentTxtField.setText("");
    }

    /**
     * Adds functionality to the ConfirmButton in response to
     * the user's interactions
     * 
     * @param action listens to the event(button click) and performs
     *               action/s when that event occurs
     */
    public void setConfirmButtonListener(ActionListener action) {
        this.confirm.addActionListener(action);
    }

    /**
     * Adds functionality to the PayButton in response to
     * the user's interactions
     * 
     * @param action listens to the event(button click) and performs
     *               action/s when that event occurs
     */
    public void setPayButtonListener(ActionListener action) {
        this.pay.addActionListener(action);
    }

    /**
     * Adds functionality to the CancelButton in response to
     * the user's interactions
     * 
     * @param action listens to the event(button click) and performs
     *               action/s when that event occurs
     */
    public void setCancelButtonListener(ActionListener action) {
        this.cancel.addActionListener(action);
    }

    /**
     * Adds functionality to the MaintenanceButton in response to
     * the user's interactions
     * 
     * @param action listens to the event(button click) and performs
     *               action/s when that event occurs
     */
    public void setMaintenanceButtonListener(ActionListener action) {
        this.maintenance.addActionListener(action);
    }

    /**
     * Adds functionality to the ReturnToMainMenuButton in response to
     * the user's interactions
     * 
     * @param action listens to the event(button click) and performs
     *               action/s when that event occurs
     */
    public void setReturnToMainMenuButtonListener(ActionListener action) {
        this.backToMain.addActionListener(action);
    }

    /**
     * Adds functionality to the StockButton in response to
     * the user's interactions
     * 
     * @param action listens to the event(button click) and performs
     *               action/s when that event occurs
     */
    public void setStockButtonListener(ActionListener action) {
        this.stock.addActionListener(action);
    }

    /**
     * Adds functionality to the RestockButton in response to
     * the user's interactions
     * 
     * @param action listens to the event(button click) and performs
     *               action/s when that event occurs
     */
    public void setRestockButtonListener(ActionListener action) {
        this.restock.addActionListener(action);
    }

    /**
     * Adds functionality to the ItemPriceButton in response to
     * the user's interactions
     * 
     * @param action listens to the event(button click) and performs
     *               action/s when that event occurs
     */
    public void setItemPriceButtonListener(ActionListener action) {
        this.setPrice.addActionListener(action);
    }

    /**
     * Adds functionality to the EarningsButton in response to
     * the user's interactions
     * 
     * @param action listens to the event(button click) and performs
     *               action/s when that event occurs
     */
    public void setEarningsButtonListener(ActionListener action) {
        this.earnings.addActionListener(action);
    }

    /**
     * Adds functionality to the ChangeButton in response to
     * the user's interactions
     * 
     * @param action listens to the event(button click) and performs
     *               action/s when that event occurs
     */
    public void setChangeButtonListener(ActionListener action) {
        this.change.addActionListener(action);
    }

    /**
     * Adds functionality to the GobackButton in response to
     * the user's interactions
     * 
     * @param action listens to the event(button click) and performs
     *               action/s when that event occurs
     */
    public void setGobackButtonListener(ActionListener action) {
        this.goback.addActionListener(action);
    }
}

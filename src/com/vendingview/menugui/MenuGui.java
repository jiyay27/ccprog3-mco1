package com.vendingview.menugui;

import javax.swing.*;
import javax.swing.text.StyleConstants.ColorConstants;

import java.awt.*;
import java.io.File;
import java.util.concurrent.Flow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuGui {
    private JFrame mainFrame;
    private JPanel menuNamePanel;
    private JPanel buttonsPanel;
    private JLabel menuNameLabel;
    private JButton createVending,
            testVending,
            exitBtn;

    private JPanel createVendingPanel;
    private JLabel createVendingLabel;

    private JButton regularVending,
            specialVending,
            returnToMainMenu;
    private JPanel buttonsPanel2;

    public MenuGui() {
        this.mainFrame = new JFrame("Arcega-Donato Vending Machine Factory");
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.mainFrame.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.mainFrame.setSize(600, 800);
        this.mainFrame.setLocationRelativeTo(null);
        this.mainFrame.setResizable(false);

        initializeGreetingElements();

        this.mainFrame.setVisible(true);
    }

    private void initializeGreetingElements() {
        // MENU NAME LABEL
        this.menuNameLabel = new JLabel();
        this.menuNameLabel.setText("Vending Machine Factory");
        this.menuNameLabel.setBorder(BorderFactory.createEmptyBorder(200, 100, 100, 100));
        this.menuNameLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        this.menuNameLabel.setForeground(Color.BLACK);
        // MENU NAME PANEL
        this.menuNamePanel = new JPanel();
        this.menuNamePanel.setLayout(new FlowLayout());

        this.menuNamePanel.add(menuNameLabel);
        this.menuNamePanel.setBackground(Color.LIGHT_GRAY);
        this.mainFrame.add(menuNamePanel, BorderLayout.NORTH);

        // BUTTONS
        this.createVending = new JButton("Create a Vending Machine");
        this.createVending.setBounds(10, 10, 250, 100);
        this.createVending.setBackground(Color.WHITE);
        this.createVending.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.testVending = new JButton("Test a Vending Machine");
        // this.testVending.setMaximumSize(new Dimension(300, 100));
        this.testVending.setBackground(Color.WHITE);
        this.testVending.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.exitBtn = new JButton("Exit");
        // this.exitBtn.setMaximumSize(new Dimension(300, 100));
        this.exitBtn.setBackground(Color.WHITE);
        this.exitBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        // BUTTONS PANEL
        this.buttonsPanel = new JPanel();
        this.buttonsPanel.setLayout(new GridLayout(3, 1, 20, 20));
        this.buttonsPanel.setBackground(Color.LIGHT_GRAY);

        this.buttonsPanel.add(createVending);
        this.buttonsPanel.add(testVending);
        this.buttonsPanel.add(exitBtn);

        this.mainFrame.setContentPane(buttonsPanel);
    }

    public void initializeCreateVendingElements() {
        // REGULAR VENDING LABEL
        this.createVendingLabel = new JLabel();
        this.createVendingLabel.setText("Create Vending Machine");
        this.createVendingLabel.setBorder(BorderFactory.createEmptyBorder(200, 100, 100, 100));
        this.createVendingLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        this.createVendingLabel.setForeground(Color.BLACK);
        // MENU NAME PANEL
        this.createVendingPanel = new JPanel();
        this.createVendingPanel.setLayout(new FlowLayout());

        this.createVendingPanel.add(menuNameLabel);
        this.createVendingPanel.setBackground(Color.LIGHT_GRAY);
        this.mainFrame.add(createVendingPanel, BorderLayout.NORTH);

        // BUTTONS
        this.regularVending = new JButton("Create a Vending Machine");
        this.regularVending.setBounds(10, 10, 250, 100);
        this.regularVending.setBackground(Color.WHITE);
        this.regularVending.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.specialVending = new JButton("Test a Vending Machine");
        // this.testVending.setMaximumSize(new Dimension(300, 100));
        this.specialVending.setBackground(Color.WHITE);
        this.specialVending.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.returnToMainMenu = new JButton("Exit");
        // this.exitBtn.setMaximumSize(new Dimension(300, 100));
        this.returnToMainMenu.setBackground(Color.WHITE);
        this.returnToMainMenu.setAlignmentX(Component.CENTER_ALIGNMENT);

        // BUTTONS PANEL
        this.buttonsPanel2 = new JPanel();
        this.buttonsPanel2.setLayout(new GridLayout(3, 1, 20, 20));
        this.buttonsPanel2.setBackground(Color.LIGHT_GRAY);

        this.buttonsPanel2.add(regularVending);
        this.buttonsPanel2.add(specialVending);
        this.buttonsPanel2.add(returnToMainMenu);

        this.mainFrame.setContentPane(buttonsPanel);

        this.mainFrame.setVisible(true);
    }

    public void setCreateButtonListener(ActionListener action) {
        this.createVending.addActionListener(action);
    }

    public void setTestButtonListener(ActionListener action) {
        this.testVending.addActionListener(action);
    }

    public void setExitButtonListener(ActionListener action) {
        this.exitBtn.addActionListener(action);
    }

}

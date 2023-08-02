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
    private JPanel mainPanel;

    private JLabel menuNameLabel;
    private JButton regularVending,
            specialVending,
            testVending,
            exitBtn;

    public MenuGui() {
        this.mainFrame = new JFrame("Arcega-Donato Vending Machine Factory");
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.mainFrame.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.mainFrame.setSize(600, 800);
        this.mainFrame.setLocationRelativeTo(null);
        this.mainFrame.setResizable(false);

        // MENU NAME PANEL
        this.mainPanel = new JPanel(new GridLayout(6, 1));
        this.mainPanel.setBackground(Color.LIGHT_GRAY);
        this.mainPanel.setSize(600, 800);

        // MENU NAME LABEL
        this.menuNameLabel = new JLabel("Vending Machine Factory", SwingConstants.CENTER);
        // this.menuNameLabel.setFont(new Font("Nirmala", Font.BOLD, 30));
        this.menuNameLabel.setForeground(Color.BLACK);

        this.mainPanel.add(menuNameLabel);

        // BUTTONS
        // CREATE REGULAR VENDING MACHINE
        this.regularVending = new JButton("Create a Regular Vending Machine");
        this.regularVending.setMaximumSize(new Dimension(250, 100));
        this.regularVending.setMinimumSize(new Dimension(250, 100));
        this.regularVending.setPreferredSize(new Dimension(250, 100));
        this.regularVending.setBackground(Color.WHITE);
        this.regularVending.setAlignmentX(Component.CENTER_ALIGNMENT);

        // BUTTONS PANEL
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel.setPreferredSize(new Dimension(250, 100));
        buttonsPanel.setBackground(Color.LIGHT_GRAY);
        buttonsPanel.add(regularVending);
        this.mainPanel.add(buttonsPanel);

        // CREATE SPECIAL VENDING MACHINE
        this.specialVending = new JButton("Create a Special Vending Machine");
        this.specialVending.setMaximumSize(new Dimension(250, 100));
        this.specialVending.setMinimumSize(new Dimension(250, 100));
        this.specialVending.setPreferredSize(new Dimension(250, 100));
        this.specialVending.setBackground(Color.WHITE);
        this.specialVending.setAlignmentX(Component.CENTER_ALIGNMENT);

        // BUTTONS PANEL
        buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel.setPreferredSize(new Dimension(250, 100));
        buttonsPanel.setBackground(Color.LIGHT_GRAY);
        buttonsPanel.add(specialVending);
        this.mainPanel.add(buttonsPanel);

        // TEST VENDING MACHINE
        this.testVending = new JButton("Test a Vending Machine");
        this.testVending.setMaximumSize(new Dimension(250, 100));
        this.testVending.setMinimumSize(new Dimension(250, 100));
        this.testVending.setPreferredSize(new Dimension(250, 100));
        this.testVending.setBackground(Color.WHITE);
        this.testVending.setAlignmentX(Component.CENTER_ALIGNMENT);

        buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel.setPreferredSize(new Dimension(250, 100));
        buttonsPanel.setBackground(Color.LIGHT_GRAY);
        buttonsPanel.add(testVending);
        this.mainPanel.add(buttonsPanel);

        // EXIT PROGRAM
        this.exitBtn = new JButton("Exit");
        this.exitBtn.setMaximumSize(new Dimension(250, 100));
        this.exitBtn.setMinimumSize(new Dimension(250, 100));
        this.exitBtn.setPreferredSize(new Dimension(250, 100));
        this.exitBtn.setBackground(Color.WHITE);
        this.exitBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel.setPreferredSize(new Dimension(250, 100));
        buttonsPanel.setBackground(Color.LIGHT_GRAY);
        buttonsPanel.add(exitBtn);
        this.mainPanel.add(buttonsPanel);

        this.mainFrame.setContentPane(mainPanel);

        this.mainFrame.setVisible(true);
    }

    public void setCreateRegularButtonListener(ActionListener action) {
        this.regularVending.addActionListener(action);
    }

    public void setCreateSpecialButtonListener(ActionListener action) {
        this.specialVending.addActionListener(action);
    }

    public void setTestButtonListener(ActionListener action) {
        this.testVending.addActionListener(action);
    }

    public void setExitButtonListener(ActionListener action) {
        this.exitBtn.addActionListener(action);
    }

    public JFrame getMainFrame() {
        return this.mainFrame;
    }
    

}

package com.vendingview.menugui;

import javax.swing.*;
import javax.swing.text.StyleConstants.ColorConstants;

import java.awt.*;
import java.io.File;
import java.util.concurrent.Flow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is <code>MenuGui</code> class which represents the
 * menu' gui object of the machine
 */
public class MenuGui {
    private JFrame mainFrame;
    private JPanel mainPanel;

    private JLabel menuNameLabel;
    private JButton regularVending,
            specialVending,
            testVending,
            exitBtn;

    /**
     * This is the MenuGui constructor
     */
    public MenuGui() {
        this.mainFrame = new JFrame("Arcega-Donato Vending Machine Factory");
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.mainFrame.getContentPane().setBackground(new Color(240, 234, 214));
        this.mainFrame.setSize(600, 800);
        this.mainFrame.setLocationRelativeTo(null);
        this.mainFrame.setResizable(false);

        // MENU NAME PANEL
        this.mainPanel = new JPanel(new GridLayout(6, 1));
        this.mainPanel.setBackground(new Color(240, 234, 214));
        this.mainPanel.setSize(600, 800);

        // MENU NAME LABEL
        this.menuNameLabel = new JLabel("Vending Machine Factory", SwingConstants.CENTER);
        this.menuNameLabel.setFont(new Font("Nirmala", Font.BOLD, 30));
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
        buttonsPanel.setBackground(new Color(240, 234, 214));
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
        buttonsPanel.setBackground(new Color(240, 234, 214));
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
        buttonsPanel.setBackground(new Color(240, 234, 214));
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
        buttonsPanel.setBackground(new Color(240, 234, 214));
        buttonsPanel.add(exitBtn);
        this.mainPanel.add(buttonsPanel);

        this.mainFrame.setContentPane(mainPanel);

        this.mainFrame.setVisible(true);
    }

    /**
     * Adds functionality to the CreateRegularButton in response to
     * the user's interactions
     * 
     * @param action listens to the event(button click) and performs
     *               action/s when that event occurs
     */
    public void setCreateRegularButtonListener(ActionListener action) {
        this.regularVending.addActionListener(action);
    }

    /**
     * Adds functionality to the CreateSpecialButton in response to
     * the user's interactions
     * 
     * @param action listens to the event(button click) and performs
     *               action/s when that event occurs
     */
    public void setCreateSpecialButtonListener(ActionListener action) {
        this.specialVending.addActionListener(action);
    }

    /**
     * Adds functionality to the TestButton in response to
     * the user's interactions
     * 
     * @param action listens to the event(button click) and performs
     *               action/s when that event occurs
     */
    public void setTestButtonListener(ActionListener action) {
        this.testVending.addActionListener(action);
    }

    /**
     * Adds functionality to the ExitButton in response to
     * the user's interactions
     * 
     * @param action listens to the event(button click) and performs
     *               action/s when that event occurs
     */
    public void setExitButtonListener(ActionListener action) {
        this.exitBtn.addActionListener(action);
    }

    /**
     * Returns the values stored in the mainFrame variable
     * 
     * @return this.mainFrame represents the mainFrame stored with the datatype
     *         JFrame
     */
    public JFrame getMainFrame() {
        return this.mainFrame;
    }

}

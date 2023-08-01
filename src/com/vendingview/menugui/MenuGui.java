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
        // this.createVending.setMaximumSize(new Dimension(1000, 1000));
        this.createVending.setBounds(10,10,250,100);
        this.createVending.setBackground(Color.WHITE);
        this.createVending.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.createVending.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                // createVending.setText("Hello");
            }
        });

        this.testVending = new JButton("Test a Vending Machine");
        this.testVending.setMaximumSize(new Dimension(300, 100));
        this.testVending.setBackground(Color.WHITE);
        this.testVending.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.testVending.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // testVending.setText("Hello");
            }
        });

        this.exitBtn = new JButton("Exit");
        this.exitBtn.setMaximumSize(new Dimension(300, 100));
        this.exitBtn.setBackground(Color.WHITE);
        this.exitBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });

        // BUTTONS PANEL
        this.buttonsPanel = new JPanel();
        this.buttonsPanel.setLayout(new GridLayout(3, 1, 20, 20));
        this.buttonsPanel.setBackground(Color.LIGHT_GRAY);
        this.buttonsPanel.add(createVending);
        this.buttonsPanel.add(testVending);
        this.buttonsPanel.add(exitBtn);

        this.mainFrame.add(buttonsPanel, BorderLayout.CENTER);

        
    }

    private void initializeAlignmentElements() {

    }

    private void initializeSwappingElements() {

    }
}

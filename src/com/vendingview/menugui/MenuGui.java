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
    private JButton createVending,
            testVending,
            exitBtn;

    public MenuGui() {
        this.mainFrame = new JFrame("Vending Machine Factory");
        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.mainFrame.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.mainFrame.setSize(600, 800);
        this.mainFrame.setLocationRelativeTo(null);
        this.mainFrame.setResizable(false);

        this.mainPanel = new JPanel(new GridLayout(4, 1));
        this.mainPanel.setBackground(Color.getHSBColor(240, 234, 214));
        this.mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        this.mainPanel.setSize(600, 800);

        initializeGreetingElements();
        this.mainFrame.setVisible(true);
    }

    private void initializeGreetingElements() {
        JLabel menuName = new JLabel();
        menuName.setText("Vending Machine Factory");

        this.createVending = new JButton("Create a Vending Machine");
        this.createVending.setMaximumSize(new Dimension(300, 100));    

        this.testVending = new JButton("Test a Vending Machine");
        this.testVending.setMaximumSize(new Dimension(300, 100));

        this.exitBtn = new JButton("Exit");
        this.exitBtn.setMaximumSize(new Dimension(300, 100));

        createVending.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                // createVending.setText("Hello");
            }
        });

        testVending.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // testVending.setText("Hello");
            }
        });

        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // exitBtn.setText("Hello");
            }
        });

        this.mainFrame.add(createVending);
        this.mainFrame.add(testVending);
        this.mainFrame.add(exitBtn);
    }

    private void initializeAlignmentElements() {

    }

    private void initializeSwappingElements() {

    }
}

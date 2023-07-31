package com.vendingview.menugui;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class MenuGui {
    private JFrame mainFrame;
    private JPanel mainPanel; 

    public MenuGui() {
        this.mainFrame = new JFrame("Vending Machine Factory");
        this.mainPanel = new JPanel();
        this.mainPanel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        this.mainPanel.setLayout(new GridLayout(5,3));

        this.mainFrame.add(this.mainFrame, BorderLayout.CENTER);
        this.mainFrame.pack();

        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.mainFrame.setLayout(new FlowLayout());
        //this.mainFrame.setSize(500, 800);

        this.mainFrame.setVisible(true);
    }

    private void initializeGreetingElements() {
        JLabel menuName = new JLabel();
        menuName.setText("Vending Machine Factory");
    }

    private void initializeAlignmentElements() {

    }

    private void initializeSwappingElements() {

    }
}

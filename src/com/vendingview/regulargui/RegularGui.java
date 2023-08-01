package com.vendingview.regulargui;

import javax.swing.*;
import javax.swing.text.StyleConstants.ColorConstants;

import java.awt.*;
import java.io.File;
import java.util.concurrent.Flow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegularGui {
    private JFrame regularFrame;
    private JPanel fViewingPanel,
            fUserPanel,
            featuresPanel,
            mViewingPanel,
            mUserPanel,
            maintenancePanel;

    private JLabel itemLabel,
            qtyLabel,
            paymentLabel,
            totalLabel;

    private JButton confirm,
            cancel,
            maintenance;

    private JTextArea displayItems,
            showStatus;

    public RegularGui() {
        this.regularFrame = new JFrame("Regular Vending Feautres");
        this.regularFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.regularFrame.setLayout(new GridLayout(1, 2, 5, 5));
        this.regularFrame.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.regularFrame.setSize(600, 800);
        this.regularFrame.setLocationRelativeTo(null);
        this.regularFrame.setResizable(false);

        // FEATURES PANEL
        this.featuresPanel = new JPanel(new FlowLayout(FlowLayout.LEADING));
        this.featuresPanel.setBackground(Color.LIGHT_GRAY);
        this.featuresPanel.setPreferredSize(new Dimension(590, 790));// (500, 700);

        // VIEWING PANEL
        this.fViewingPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        this.fViewingPanel.setBackground(Color.LIGHT_GRAY);
        this.fViewingPanel.setPreferredSize(new Dimension(280, 700));

        // TEXT AREA
        this.displayItems = new JTextArea();
        this.displayItems.setBackground(Color.WHITE);
        this.displayItems.setBorder(BorderFactory.createLineBorder(Color.getColor("BLACK")));
        this.displayItems.setPreferredSize(new Dimension(280, 590));
        this.displayItems.setFocusable(false);

        this.showStatus = new JTextArea();
        this.showStatus.setBackground(Color.WHITE);
        this.showStatus.setBorder(BorderFactory.createLineBorder(Color.getColor("BLACK")));
        this.showStatus.setMaximumSize(new Dimension(280, 100));
        this.showStatus.setFocusable(false);

        this.fViewingPanel.add(displayItems);
        this.fViewingPanel.add(showStatus);

        this.featuresPanel.add(fViewingPanel);

        // USER INPUT PANEl
        this.fUserPanel = new JPanel(new GridLayout(10, 1));
        this.fUserPanel.setBackground(Color.LIGHT_GRAY);
        this.fUserPanel.setSize(295, 800);

        this.featuresPanel.add(fUserPanel);

        this.regularFrame.add(fViewingPanel);
        this.regularFrame.add(fUserPanel);
        // this.regularFrame.pack();
        this.regularFrame.setVisible(true);
    }

    public JFrame getRegularFrame() {
        return this.regularFrame;
    }
}

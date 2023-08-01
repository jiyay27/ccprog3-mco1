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

    public RegularGui() {
        this.regularFrame = new JFrame("Regular Vending Feautres");
        this.regularFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.regularFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.regularFrame.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.regularFrame.setSize(600, 800);
        this.regularFrame.setLocationRelativeTo(null);
        this.regularFrame.setResizable(false);

        // VIEWING PANEL
        this.fViewingPanel = new JPanel(new GridLayout(6, 1));
        this.fViewingPanel.setBackground(Color.LIGHT_GRAY);
        this.fViewingPanel.setSize(300, 800);

        // USER INPUT PANEl
        this.fUserPanel = new JPanel(new GridLayout(6, 1));
        this.fUserPanel.setBackground(Color.LIGHT_GRAY);
        this.fUserPanel.setSize(300, 800);

        // FEATURES PANEL
        this.featuresPanel = new JPanel(new GridLayout());
        this.featuresPanel.setBackground(Color.LIGHT_GRAY);
        this.featuresPanel.setSize(600, 800);

        this.featuresPanel.add(fViewingPanel);
        this.featuresPanel.add(fUserPanel);

    }
}

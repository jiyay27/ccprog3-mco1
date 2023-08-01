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
        this.regularFrame.setLayout(new GridLayout(1, 2));
        this.regularFrame.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.regularFrame.setSize(600, 800);
        this.regularFrame.setLocationRelativeTo(null);
        this.regularFrame.setResizable(false);

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
        this.fUserPanel = new JPanel(new GridLayout(10, 1));
        this.fUserPanel.setBackground(Color.GREEN);
        this.fUserPanel.setSize(280, 700);

        // BUTTONS
        // ! CONFIRM
        this.confirm = new JButton("Confirm");
        this.confirm.setMaximumSize(new Dimension(250, 100));
        this.confirm.setMinimumSize(new Dimension(250, 100));
        this.confirm.setPreferredSize(new Dimension(250, 100));
        this.confirm.setBackground(Color.WHITE);

        // ! BUTTONS PANEL
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel.setPreferredSize(new Dimension(250, 100));
        buttonsPanel.setBackground(Color.LIGHT_GRAY);
        buttonsPanel.add(confirm);
        this.fUserPanel.add(buttonsPanel);

        // ! CANCEL
        this.cancel = new JButton("Cancel");
        this.cancel.setMaximumSize(new Dimension(250, 100));
        this.cancel.setMinimumSize(new Dimension(250, 100));
        this.cancel.setPreferredSize(new Dimension(250, 100));
        this.cancel.setBackground(Color.WHITE);

        // ! BUTTONS PANEL
        buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel.setPreferredSize(new Dimension(250, 100));
        buttonsPanel.setBackground(Color.LIGHT_GRAY);
        buttonsPanel.add(cancel);
        this.fUserPanel.add(buttonsPanel);

        // ! MAINTENANCE
        this.maintenance = new JButton("Maintenance Features");
        this.maintenance.setMaximumSize(new Dimension(250, 100));
        this.maintenance.setMinimumSize(new Dimension(250, 100));
        this.maintenance.setPreferredSize(new Dimension(250, 100));
        this.maintenance.setBackground(Color.WHITE);

        buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel.setPreferredSize(new Dimension(250, 100));
        buttonsPanel.setBackground(Color.LIGHT_GRAY);
        buttonsPanel.add(maintenance);
        this.fUserPanel.add(buttonsPanel);

        this.featuresPanel.add(fViewingPanel);
        this.featuresPanel.add(fUserPanel);

        this.regularFrame.add(featuresPanel);

        this.regularFrame.setVisible(true);
    }

    public JFrame getRegularFrame() {
        return this.regularFrame;
    }

    public void setConfirmButtonListener(ActionListener action) {
        this.confirm.addActionListener(action);
    }

    public void setCancelButtonListener(ActionListener action) {
        this.cancel.addActionListener(action);
    }

    public void setMaintenanceButtonListener(ActionListener action) {
        this.maintenance.addActionListener(action);
    }
}

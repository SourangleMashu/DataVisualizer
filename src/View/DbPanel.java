package View;

/*
 * This panel holds all tables in a database.
 * Due to unknown reasons, the panel often decides to disappear :(
 */

import java.util.ArrayList;

import javax.swing.JLabel;

import Controller.DbController;

import Application.Application;


public class DbPanel extends javax.swing.JPanel {

    // constructor
    public DbPanel(String dbName) {
        initComponents(dbName);
    }

    private void initComponents(String dbName) {

        tabbedPanel = new javax.swing.JTabbedPane();

        setLayout(new java.awt.BorderLayout());

        ArrayList<String> tableNames = DbController.getTableNames(dbName);

        if (tableNames.isEmpty()) {
            JLabel label = new JLabel("No tables found in database: " + dbName, JLabel.CENTER);
            add(label, java.awt.BorderLayout.CENTER);
            return;
        }

        for (String tableName : tableNames) {
            tabbedPanel.addTab(tableName, new TablePanel(dbName, tableName));
        }

        tabbedPanel.addChangeListener(e -> {
            int index = tabbedPanel.getSelectedIndex();
            if (index >= 0) {
                Application.currentTable = tabbedPanel.getTitleAt(index);
            }
        });


        add(tabbedPanel, java.awt.BorderLayout.CENTER);
    }

    // Get the current table name
    public String getCurrentTableName() {
        int selectedIndex = tabbedPanel.getSelectedIndex();
        return tabbedPanel.getTitleAt(selectedIndex);
    }

    public javax.swing.JTabbedPane tabbedPanel;
}

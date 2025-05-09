package View;

/*
 * This class creates a panel that displays a table from the database.
 */

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import Controller.DbController;

public class TablePanel extends javax.swing.JPanel {

    public TablePanel(String dbName, String tableName) {
        // if the table can not be shown, return
        if (initComponents(dbName, tableName) == false)
            return;
    }

    private boolean initComponents(String dbName, String tableName) {

        scrollPane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        setLayout(new java.awt.BorderLayout());

        try {
            ResultSet resultSet = DbController.statement.executeQuery("SELECT * FROM " + tableName);

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            String[] columnNames = new String[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                columnNames[i - 1] = metaData.getColumnName(i);
            }

            ArrayList<Object[]> rows = new ArrayList<Object[]>();
            while (resultSet.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = resultSet.getObject(i);
                }
                rows.add(row);
            }

            // Set table model
            table.setModel(new DefaultTableModel(rows.toArray(new Object[0][]), columnNames));

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Table can not be shown", "Error", JOptionPane.ERROR_MESSAGE);

            return false;
        }

        scrollPane.setViewportView(table);

        add(scrollPane, java.awt.BorderLayout.CENTER);

        return true;
    }

    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable table;
}

package View;

/*
 * This class create a JDialogBox that allows the user to 
 * select the columns from the database table.
 */

import javax.swing.*;

import Application.Application;
import Controller.DbController;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataChooser extends JDialog {
    private JComboBox<String> column1ComboBox;
    private JComboBox<String> column2ComboBox;
    private JButton okButton;

    public static String column1;
    public static String column2;

    public DataChooser() {

        // Create the combo boxes
        column1ComboBox = new JComboBox<>();
        column2ComboBox = new JComboBox<>();
        okButton = new JButton("OK");

        // Fetch the column names from the database table
        List<String> columnNames = getColumnNamesFromDatabase();

        // Add the column names to the combo boxes
        for (String columnName : columnNames) {
            column1ComboBox.addItem(columnName);
            column2ComboBox.addItem(columnName);
        }

        // Add an action listener to the OK button
        okButton.addActionListener(event -> {
            column1 = (String) column1ComboBox.getSelectedItem();
            column2 = (String) column2ComboBox.getSelectedItem();

            try (
                    // Get the data from the database
                    Statement statement = DbController.connection.createStatement();
                    ResultSet resultSet = statement
                            .executeQuery("SELECT " + column1 + ", " + column2 + " FROM " + Application.currentTable)) {

                while (resultSet.next()) {

                    // Add the data to the dataset
                    String category = resultSet.getString(column1);
                    double value = resultSet.getDouble(column2);
                    Application.dataset.addValue(value, "", category);
                }

                // Create a chart frame
                ChartFrame chartFrame = new ChartFrame();
                chartFrame.setVisible(true);

            } catch (Exception e) {
                e.printStackTrace();
            }

            dispose();
        });

        // Create a panel to hold the combo boxes
        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Column:"));
        panel.add(column1ComboBox);
        panel.add(new JLabel("Value:"));
        panel.add(column2ComboBox);

        panel.add(okButton);

        // Add the panel to the dialog
        getContentPane().add(panel);

        pack();
        setResizable(false);
    }

    // Get the column names in that table
    private List<String> getColumnNamesFromDatabase() {

        List<String> columnNames = new ArrayList<>();

        try {
            Statement statement = DbController.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + Application.currentTable);

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            for (int i = 1; i <= columnCount; i++) {
                columnNames.add(metaData.getColumnName(i));
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return columnNames;
    }
}
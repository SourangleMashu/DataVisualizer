package View;

/*
 * This class is a dialog that allows the user to select a database to load.
 */

import javax.swing.*;

import Application.Application;
import Controller.DbController;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DbDownload extends JDialog {
    private JComboBox<String> databaseComboBox;
    private JButton confirmButton;

    // Constructor
    public DbDownload() {

        // Tried to use super() to get rid of the empty JFrame after dispose.
        super(Application.mainFrame, "Database Selection", true);

        // Center the dialog on the screen
        setLocationRelativeTo(null);

        setTitle("Database Selection");
        setSize(400, 100);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        databaseComboBox = new JComboBox<>();
        add(databaseComboBox, BorderLayout.CENTER);

        ArrayList<String> databases = DbController.getDatabaseNames();
        for (String database : databases) {
            databaseComboBox.addItem(database);
        }

        // Create a panel for the button to separate it from the combo box
        JPanel buttonPanel = new JPanel();
        confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Application.dbDownloadConfirmButtonActionPerformed(databaseComboBox.getSelectedItem().toString());
                dispose();
            }
        });
        buttonPanel.add(confirmButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
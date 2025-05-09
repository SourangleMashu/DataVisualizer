package View;

/*
 * It class opens a JFileChooser dialog to select a CSV file to upload to the database.
 */

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import Application.Application;
import Controller.TableController;

import java.io.File;

public class DbUpload extends JDialog {
    private String filePath;

    public DbUpload() {

        // Tried to use super() to get rid of the empty JFrame after dispose.
        super(Application.mainFrame, "Upload CSV File", true);

        // Center the dialog on the screen
        setLocationRelativeTo(null);

        // Create a file chooser
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setDialogTitle("Select CSV File");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV files", "csv");
        fileChooser.setFileFilter(filter);

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String fileName = selectedFile.getName();
            fileName = fileName.substring(0, fileName.lastIndexOf("."));

            // Replace backslashes with forward slashes so the file path can be used for CSV reader
            filePath = selectedFile.getAbsolutePath().replace("\\", "/");

            // Create and load the table
            TableController.createTable(fileName, filePath);
            TableController.loadTable(fileName, filePath);
        } else {
            filePath = null;
        }
        dispose();
        Application.refreshTable();
    }

    public String getFilePath() {
        return filePath;
    }
}
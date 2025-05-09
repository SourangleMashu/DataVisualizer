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
        super(Application.mainFrame, "Upload CSV File", true);

        // Don't show dialog layout – just trigger file picker directly
        uploadFileAndClose();
    }

    private void uploadFileAndClose() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setDialogTitle("Select CSV File");

        FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV files", "csv");
        fileChooser.setFileFilter(filter);

        int result = fileChooser.showOpenDialog(this); // show chooser relative to this dialog

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String fileName = selectedFile.getName();
            fileName = fileName.substring(0, fileName.lastIndexOf("."));
            filePath = selectedFile.getAbsolutePath().replace("\\", "/");

            TableController.createTable(fileName, filePath);
            TableController.loadTable(fileName, filePath);

            Application.refreshTable();
        }

        dispose(); // always dispose after closing chooser
    }

    public String getFilePath() {
        return filePath;
    }
}

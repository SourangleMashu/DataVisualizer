package Application;
/*
 * Name: Jimmy Wu
 * Date: 2024-6-14
 * Course Code: ICS4U1
 * Title: Chart Generator
 * Description: The program will be a chart generator that allows users to 
 *              select any data set from a CSV file and display it as a chart in different 
 *              formats. It will have functions similar to those found in Google Sheets or 
 *              Microsoft Excel.
 * Features: 
 *       - Allow the user to select and upload CSV file (JFileChooser)
 *       - Login to data base
 *       - Specify columns and values
 *       - Able to show the imported data as a table (JTable)
 *       - Use database (jdbc) to load and save data
 *       - Download chars as PNG
 * Major Skills:
 *      - SQL and jdbc using
 *      - Linux server building
 * Areas of Concern:
 *      - Several functions are not implemented
 *      - Username: user
 *      - Password: password
 */

import java.util.TimerTask;
import java.util.Timer;

import javax.swing.*;

import org.jfree.data.category.DefaultCategoryDataset;
//import org.pushingpixels.radiance.theming.api.skin.RadianceNightShadeLookAndFeel;

import Controller.DbController;
import Controller.TableController;
import View.DataChooser;
import View.DbLoad;
import View.DbPanel;
import View.DbUpload;
import View.LoginPanel;
import View.MainFrame;
import View.MainPanel;
import View.ToolBarPanel;

public class Application {

    public static MainFrame mainFrame;
    public static LoginPanel loginPanel;
    public static MainPanel mainPanel;
    public static ToolBarPanel toolBarPanel;
    public static DbPanel dbPanel;
    public static Timer timer = new Timer();

    // Indicates the current database and table
    public static String currentDb = "";
    public static String currentTable = "";
    public static int currentTableIndex = 0;

    public static DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    public static void main(String[] args) {

            mainFrame = new MainFrame();
            loginPanel = new LoginPanel();

            mainFrame.setBounds(0, 0, 1920, 1000);
            loginPanel.setBounds(0, 0, 1920, 1000);

            mainFrame.add(loginPanel);
            mainFrame.setVisible(true);
            
    }

    // Actions when successfully login
    public static void loginSuccess(String username) {

        toolBarPanel = new ToolBarPanel(username);
        toolBarPanel.setBounds(0, 0, 1920, 175);

        mainPanel = new MainPanel();
        mainPanel.setLayout(null);
        mainPanel.setBounds(0, 0, 1920, 1000);

        mainPanel.add(toolBarPanel);
        mainFrame.remove(loginPanel);
        mainFrame.add(mainPanel);

        mainFrame.revalidate();
        mainFrame.repaint();
    }

    // Actions when download button is clicked
    public static void dbLoadButtonActionPerformed() {
        DbLoad dbLoad = new DbLoad();
        dbLoad.setAlwaysOnTop(true);
        dbLoad.setVisible(true);
    }

    public static void tableLoadButtonActionPerformed() {

    }

    // Refresh the tables
    public static void refreshTable() {
    if (dbPanel != null) {
        currentTable = dbPanel.getCurrentTableName();
        currentTableIndex = dbPanel.tabbedPanel.getSelectedIndex();
        mainPanel.removeAll();
        dbPanel = null;
    }

    mainPanel.add(toolBarPanel);

    DbController.useDatabase(currentDb);
    dbPanel = new DbPanel(currentDb);
    dbPanel.setBounds(0, 175, 1920, 810);
    mainPanel.add(dbPanel);

    if (dbPanel.tabbedPanel.getTabCount() > 0) {
        dbPanel.tabbedPanel.setSelectedIndex(currentTableIndex);
        currentTable = dbPanel.getCurrentTableName();
    }

    TimerTask task = new TimerTask() {
        public void run() {
            dbPanel.revalidate();
            mainPanel.revalidate();
        }
    };
    timer.schedule(task, 500);
}

    // Actions when database download confirm button is clicked
    public static void dbLoadConfirmButtonActionPerformed(String dbName) {
        currentDb = dbName;
        refreshTable(); 
    }

    // Actions when database upload confirm button is clicked
    public static void uploadButtonActionPerformed() {
        new DbUpload();
    }

    public static void downLoadButtonActionPerformed() {
        // Export only if there’s a valid table selected
        if (dbPanel != null && dbPanel.tabbedPanel.getTabCount() > 0) {
            currentTable = dbPanel.getCurrentTableName();
            TableController.exportTableToCSV(currentTable, "./" + currentTable + ".csv");
        } else {
            System.out.println("No table to export.");
        }    

    }

    // Actions when chart button is clicked
    public static void chartsButtonActionPerformed() {
        refreshTable();
        DataChooser dataChooser = new DataChooser();
        dataChooser.setVisible(true);

    }
}

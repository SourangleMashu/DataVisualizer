package View;

/*
 *  This class is originally used to show different databases.
 *  However due the Swing issues, it is not used in the project.
 */

import javax.swing.*;

public class DataPanel extends javax.swing.JPanel {

    public DataPanel() {
        initComponents();
    }

    private void initComponents() {

        tabbedPanel = new JTabbedPane();

        setLayout(new java.awt.BorderLayout());

        add(tabbedPanel, java.awt.BorderLayout.CENTER);
    }

    public JTabbedPane tabbedPanel;
}

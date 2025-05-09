package View;
/*
 * This class creates the main panel for the application, 
 * which holds the loginPanel and the dpPanel.
 */
import javax.swing.JPanel;

import Application.Application;

public class MainPanel extends JPanel{

    public MainPanel() {
        initComponents();
    }

    private void initComponents() {
        setLayout(null);
        setBounds(0, 0, 1920, 1000);

        add(Application.toolBarPanel);
    }
}
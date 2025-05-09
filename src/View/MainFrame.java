package View;

/*
 * This class creates the main frame for the application.
 */

import javax.swing.JFrame;

public class MainFrame extends JFrame {
    public MainFrame() {
        init();
    }

    private void init() {
        setTitle("Chart Generator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
    }
}

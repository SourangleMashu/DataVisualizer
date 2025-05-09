package View;

/*
 * The login panel, which has a background image, a text field for the username, 
 * a password field for the password, and a button to log in.
 */

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

import Application.Application;
import Controller.DbController;

public class LoginPanel extends javax.swing.JPanel {

    public LoginPanel() {
        initComponents();
    }

    private void initComponents() {

        usernameTextField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        button = new javax.swing.JButton();
        backgroundLabel = new javax.swing.JLabel();

        setLayout(null);

        // Text field for the username
        usernameTextField.setBackground(new java.awt.Color(0, 0, 0, 0));
        usernameTextField.setFont(new java.awt.Font("Arial", 0, 26));
        usernameTextField.setBorder(BorderFactory.createEmptyBorder());
        usernameTextField.setOpaque(false);

        add(usernameTextField);
        usernameTextField.setBounds(770, 410, 420, 70);

        // Password field for the password
        passwordField.setBackground(new java.awt.Color(0, 0, 0, 0));
        passwordField.setFont(new java.awt.Font("Arial", 0, 20));
        passwordField.setBorder(BorderFactory.createEmptyBorder());
        passwordField.setOpaque(false);

        add(passwordField);
        passwordField.setBounds(770, 595, 420, 70);

        // Button to log in
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActionPerformed(evt);
            }
        });
        add(button);
        button.setBounds(910, 720, 100, 100);

        backgroundLabel.setIcon(new javax.swing.ImageIcon("images\\background.png"));
        add(backgroundLabel);
        backgroundLabel.setBounds(0, 0, 1920, 1000);
    }

    // Check the username and password and log in
    private void buttonActionPerformed(java.awt.event.ActionEvent evt) {
        String username = usernameTextField.getText();
        String password = new String(passwordField.getPassword());
        if (DbController.connectDB(username, password))
            Application.loginSuccess(username);
        else
            JOptionPane.showMessageDialog(this, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
    }

    private javax.swing.JLabel backgroundLabel;
    private javax.swing.JButton button;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField usernameTextField;
}

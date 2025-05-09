package View;
import Application.Application;

/*
 * This class creates the toolbar panel for the application.
 * The background is used as images.
 * Many buttons are not complete and need to be implemented.
 */

public class ToolBarPanel extends javax.swing.JPanel {

    public ToolBarPanel(String username) {
        initComponents(username);
    }

    private void initComponents(String username) {

        tabbedPanel = new javax.swing.JTabbedPane();
        cloudPanel = new javax.swing.JPanel();
        uploadButton = new javax.swing.JButton();
        downloadButton = new javax.swing.JButton();
        accountsButton = new javax.swing.JButton();
        databaseButton = new javax.swing.JButton();
        tablesButton = new javax.swing.JButton();
        cloudBackground = new javax.swing.JLabel();
        editPanel = new javax.swing.JPanel();
        fontComboBox = new javax.swing.JComboBox<>();
        textSizeComboBox = new javax.swing.JComboBox<>();
        colorButton = new javax.swing.JButton();
        boldButton = new javax.swing.JButton();
        italicButton = new javax.swing.JButton();
        normalButton = new javax.swing.JButton();
        leftButton = new javax.swing.JButton();
        middleButton = new javax.swing.JButton();
        rightButton = new javax.swing.JButton();
        editBackground = new javax.swing.JLabel();
        calculatePanel = new javax.swing.JPanel();
        chartsButton = new javax.swing.JButton();
        calculateButton = new javax.swing.JButton();
        calculateBackground = new javax.swing.JLabel();
        welcomeLabel = new javax.swing.JLabel();

        setLayout(null);

        cloudPanel.setBackground(new java.awt.Color(31, 31, 31));
        cloudPanel.setOpaque(false);
        cloudPanel.setLayout(null);

        uploadButton.setBorderPainted(false);
        uploadButton.setContentAreaFilled(false);
        uploadButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        uploadButton.setFocusPainted(false);
        uploadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadButtonActionPerformed(evt);
            }
        });
        cloudPanel.add(uploadButton);
        uploadButton.setBounds(20, 20, 50, 70);

        downloadButton.setBorderPainted(false);
        downloadButton.setContentAreaFilled(false);
        downloadButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        downloadButton.setFocusPainted(false);
        downloadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downloadButtonActionPerformed(evt);
            }
        });
        cloudPanel.add(downloadButton);
        downloadButton.setBounds(100, 20, 50, 70);

        accountsButton.setBorderPainted(false);
        accountsButton.setContentAreaFilled(false);
        accountsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        accountsButton.setFocusPainted(false);
        accountsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accountsButtonActionPerformed(evt);
            }
        });
        cloudPanel.add(accountsButton);
        accountsButton.setBounds(200, 20, 50, 70);

        databaseButton.setBorderPainted(false);
        databaseButton.setContentAreaFilled(false);
        databaseButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        databaseButton.setFocusPainted(false);
        databaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                databaseButtonActionPerformed(evt);
            }
        });
        cloudPanel.add(databaseButton);
        databaseButton.setBounds(290, 30, 60, 60);

        tablesButton.setBorderPainted(false);
        tablesButton.setContentAreaFilled(false);
        tablesButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablesButton.setFocusPainted(false);
        tablesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tablesButtonActionPerformed(evt);
            }
        });
        cloudPanel.add(tablesButton);
        tablesButton.setBounds(360, 30, 60, 60);

        cloudBackground.setIcon(new javax.swing.ImageIcon(
                "images\\toolBar - Cloud.png")); // NOI18N
        cloudPanel.add(cloudBackground);
        cloudBackground.setBounds(0, -10, 1920, 120);

        tabbedPanel.addTab("Cloud", cloudPanel);

        editPanel.setBackground(new java.awt.Color(31, 31, 31));
        editPanel.setOpaque(false);
        editPanel.setLayout(null);

        fontComboBox.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        fontComboBox.setOpaque(true);
        editPanel.add(fontComboBox);
        fontComboBox.setBounds(10, 20, 110, 22);

        textSizeComboBox.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        textSizeComboBox.setOpaque(true);
        editPanel.add(textSizeComboBox);
        textSizeComboBox.setBounds(10, 57, 70, 22);

        colorButton.setBorderPainted(false);
        colorButton.setContentAreaFilled(false);
        colorButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        colorButton.setFocusPainted(false);
        colorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colorButtonActionPerformed(evt);
            }
        });
        editPanel.add(colorButton);
        colorButton.setBounds(100, 60, 30, 30);

        boldButton.setBorderPainted(false);
        boldButton.setContentAreaFilled(false);
        boldButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        boldButton.setFocusPainted(false);
        boldButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boldButtonActionPerformed(evt);
            }
        });
        editPanel.add(boldButton);
        boldButton.setBounds(180, 40, 30, 30);

        italicButton.setBorderPainted(false);
        italicButton.setContentAreaFilled(false);
        italicButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        italicButton.setFocusPainted(false);
        italicButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                italicButtonActionPerformed(evt);
            }
        });
        editPanel.add(italicButton);
        italicButton.setBounds(230, 40, 30, 30);

        normalButton.setBorderPainted(false);
        normalButton.setContentAreaFilled(false);
        normalButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        normalButton.setFocusPainted(false);
        normalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                normalButtonActionPerformed(evt);
            }
        });
        editPanel.add(normalButton);
        normalButton.setBounds(280, 40, 30, 30);

        leftButton.setBorderPainted(false);
        leftButton.setContentAreaFilled(false);
        leftButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        leftButton.setFocusPainted(false);
        leftButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftButtonActionPerformed(evt);
            }
        });
        editPanel.add(leftButton);
        leftButton.setBounds(360, 40, 30, 30);

        middleButton.setBorderPainted(false);
        middleButton.setContentAreaFilled(false);
        middleButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        middleButton.setFocusPainted(false);
        middleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                middleButtonActionPerformed(evt);
            }
        });
        editPanel.add(middleButton);
        middleButton.setBounds(400, 40, 30, 30);

        rightButton.setBorderPainted(false);
        rightButton.setContentAreaFilled(false);
        rightButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rightButton.setFocusPainted(false);
        rightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightButtonActionPerformed(evt);
            }
        });
        editPanel.add(rightButton);
        rightButton.setBounds(450, 40, 30, 30);

        editBackground.setIcon(new javax.swing.ImageIcon(
                "images\\toolBar - Edit.png"));
        editPanel.add(editBackground);
        editBackground.setBounds(0, -10, 1920, 120);

        tabbedPanel.addTab("Edit", editPanel);

        calculatePanel.setBackground(new java.awt.Color(31, 31, 31));
        calculatePanel.setOpaque(false);
        calculatePanel.setLayout(null);

        chartsButton.setBorderPainted(false);
        chartsButton.setContentAreaFilled(false);
        chartsButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chartsButton.setFocusPainted(false);
        chartsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chartsButtonActionPerformed(evt);
            }
        });
        calculatePanel.add(chartsButton);
        chartsButton.setBounds(12, 23, 60, 70);

        calculateButton.setBorderPainted(false);
        calculateButton.setContentAreaFilled(false);
        calculateButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        calculateButton.setFocusPainted(false);
        calculateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateButtonActionPerformed(evt);
            }
        });
        calculatePanel.add(calculateButton);
        calculateButton.setBounds(70, 20, 70, 80);

        calculateBackground.setIcon(new javax.swing.ImageIcon(
                "images\\toolBar - Calculate.png")); // NOI18N
        calculateBackground.setToolTipText("");
        calculatePanel.add(calculateBackground);
        calculateBackground.setBounds(0, -5, 1930, 110);

        tabbedPanel.addTab("Calculate", calculatePanel);

        add(tabbedPanel);
        tabbedPanel.setBounds(0, 50, 1920, 140);

        welcomeLabel.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        welcomeLabel.setText("Welcome, " + username);
        add(welcomeLabel);
        welcomeLabel.setBounds(10, 10, 179, 32);
    }// </editor-fold>

    private void uploadButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Application.uploadButtonActionPerformed();
    }

    private void downloadButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Application.downloadButtonActionPerformed();
    }

    private void accountsButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void databaseButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void tablesButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void boldButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void italicButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void normalButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void leftButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void middleButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void rightButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void colorButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void chartsButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Application.chartsButtonActionPerformed();
    }

    private void calculateButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private javax.swing.JButton accountsButton;
    private javax.swing.JButton boldButton;
    private javax.swing.JLabel calculateBackground;
    private javax.swing.JButton calculateButton;
    private javax.swing.JPanel calculatePanel;
    private javax.swing.JButton chartsButton;
    private javax.swing.JLabel cloudBackground;
    private javax.swing.JPanel cloudPanel;
    private javax.swing.JButton colorButton;
    private javax.swing.JButton databaseButton;
    private javax.swing.JButton downloadButton;
    private javax.swing.JLabel editBackground;
    private javax.swing.JPanel editPanel;
    private javax.swing.JComboBox<String> fontComboBox;
    private javax.swing.JButton italicButton;
    private javax.swing.JButton leftButton;
    private javax.swing.JButton middleButton;
    private javax.swing.JButton normalButton;
    private javax.swing.JButton rightButton;
    private javax.swing.JTabbedPane tabbedPanel;
    private javax.swing.JButton tablesButton;
    private javax.swing.JComboBox<String> textSizeComboBox;
    private javax.swing.JButton uploadButton;
    private javax.swing.JLabel welcomeLabel;
}

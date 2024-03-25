package org.ravindupriyankara;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Objects;

public class login extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private  ImageIcon backgroundImage, logo;
    private JLabel logoLabel;
    public login() {//class constructor
        try {
            // Load the background image from the classpath
            backgroundImage = new ImageIcon(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/splashBackground.png"))));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load the background image.", e);
        }
        initializeUI();
    }
    private void initializeUI(){//create initialize ui function
        //setTitle("Senura Ferniture's Login"); // define a title
        setSize(900, 600); // define a width and height of window
        setLocationRelativeTo(null);

        //hide tittle bar
        setUndecorated(true);

        // Create background panel
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Draw background image
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(null); // Use null layout for precise component positioning
        backgroundPanel.setSize(900, 600); // Set size to match frame size
        add(backgroundPanel);

        // add logo
        logo = new ImageIcon(getClass().getResource("/logo2.png"));
        logoLabel = new JLabel(logo);
        int logoWidth = logo.getIconWidth() ;
        int logoHeight = logo.getIconHeight() ;
        int logoX = 0;
        int logoY = (backgroundPanel.getHeight() - logoHeight) / 2;
        logoLabel.setBounds(logoX, logoY, logoWidth, logoHeight);
        backgroundPanel.add(logoLabel);

        // Create username label
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setForeground(Color.WHITE); // Set text color to white
        int labelWidth = usernameLabel.getPreferredSize().width;
        int labelHeight = usernameLabel.getPreferredSize().height;
        int labelX = 600;
        int labelY = 250;
        usernameLabel.setBounds(labelX, labelY, labelWidth, labelHeight);
        backgroundPanel.add(usernameLabel);

        // Create username field
        usernameField = new JTextField(20);
        usernameField.setOpaque(false); // Set transparent
        int fieldWidth = 150;
        int fieldHeight = usernameField.getPreferredSize().height;
        int fieldX = labelX + labelWidth + 10; // Adjust position relative to label
        int fieldY = labelY - 3; // Adjust position
        usernameField.setBounds(fieldX, fieldY, fieldWidth, fieldHeight);
        setFieldStyle(usernameField); // Apply custom field style
        backgroundPanel.add(usernameField);

        // Create password label
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.WHITE); // Set text color to white
        labelWidth = passwordLabel.getPreferredSize().width;
        labelHeight = passwordLabel.getPreferredSize().height;
        labelY += labelHeight + 20; // Adjust position
        passwordLabel.setBounds(labelX, labelY, labelWidth, labelHeight);
        backgroundPanel.add(passwordLabel);

        // Create password field
        passwordField = new JPasswordField(20);
        passwordField.setOpaque(false); // Set transparent
        fieldHeight = passwordField.getPreferredSize().height;
        fieldY += labelHeight + 20; // Adjust position
        passwordField.setBounds(fieldX, fieldY, fieldWidth, fieldHeight);
        setFieldStyle(passwordField); // Apply custom field style
        backgroundPanel.add(passwordField);

        // Create login button
        JButton loginButton = new JButton("SignIn");
        loginButton.setBounds(labelX + 120, fieldY + fieldHeight + 50, fieldWidth - 30, fieldHeight);
        loginButton.setBackground(Color.GREEN); // Set button background color
        loginButton.setForeground(Color.GREEN); // Set button text color
        loginButton.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25)); // Add padding to the button
        loginButton.setFocusPainted(false); // Remove focus indication
        loginButton.setOpaque(false); // Ensure button is not opaque
        loginButton.setBorder(new RoundedBorder(15, Color.GREEN));
        backgroundPanel.add(loginButton);

        // Create signup button
        JButton signupButton = new JButton("SignUp");
        signupButton.setBounds(fieldX  -90, fieldY + fieldHeight + 50, fieldWidth -30, fieldHeight);
        signupButton.setBackground(Color.MAGENTA); // Set button background color
        signupButton.setForeground(Color.MAGENTA); // Set button text color
        signupButton.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25)); // Add padding to the button
        signupButton.setFocusPainted(false); // Remove focus indication
        signupButton.setOpaque(false); // Ensure button is not opaque
        signupButton.setBorder(new RoundedBorder(15,Color.MAGENTA));
        backgroundPanel.add(signupButton);

        //Create Cancel Button
        JButton cancel = new JButton("Cancel");
        cancel.setBounds(fieldX + 70 , fieldY + fieldHeight + 240, fieldWidth -30, fieldHeight); //set position of cancel button
        cancel.setForeground(Color.RED); // Add text color
        cancel.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25)); // Add padding to the button
        cancel.setFocusPainted(false);// Remove focus indication
        cancel.setOpaque(false);// Ensure button is not opaque
        cancel.setBorder(new RoundedBorder(15, Color.RED));
        backgroundPanel.add(cancel);

        // Add cancel button event listner
        cancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }
    public void display(){
        setVisible(true);
    }

    private void setFieldStyle(JTextField field) {
        field.setOpaque(false); // Set transparent background
        field.setForeground(Color.WHITE); // Set text color to white

        // Create a rounded border with a dark gray color
        Border roundedBorder = BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.WHITE, 2, true), // Outer border with white color
                BorderFactory.createLineBorder(Color.DARK_GRAY, 1, true) // Inner border with dark gray color
        );
        // Set the rounded border to the field
        field.setBorder(roundedBorder);
        // Set placeholder text color to gray
        field.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (field.getText().equals("Username") || field.getText().equals("Password")) {
                    field.setText("");
                    field.setForeground(Color.WHITE);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (field.getText().isEmpty()) {
                    field.setText(field == usernameField ? "Username" : "Password");
                    field.setForeground(Color.ORANGE);
                }
            }
        });
        // Set initial placeholder text
        field.setText(field == usernameField ? "Username" : "Password");
        field.setForeground(Color.ORANGE);
        field.setEditable(true); // Enable editing
    }


}

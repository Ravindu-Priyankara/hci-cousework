package org.ravindupriyankara;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Objects;

public class signUp extends JFrame{
    private JTextField usernameField, emailField;
    private JPasswordField passwordField;
    private  ImageIcon backgroundImage, logo;
    private JLabel logoLabel;

    public signUp( ) {
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
        setFieldStyle(usernameField, "username"); // Apply custom field style
        backgroundPanel.add(usernameField);

        // Create email label
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setForeground(Color.WHITE); // Set text color to white
        labelWidth = emailLabel.getPreferredSize().width;
        labelHeight = emailLabel.getPreferredSize().height;
        labelY += labelHeight + 20; // Adjust position
        emailLabel.setBounds(labelX, labelY, labelWidth, labelHeight);
        backgroundPanel.add(emailLabel);

        // Create email field
        emailField = new JTextField(20);
        emailField.setOpaque(false); // Set transparent
        fieldHeight = emailField.getPreferredSize().height;
        fieldY += labelHeight + 20; // Adjust position
        emailField.setBounds(fieldX, fieldY, fieldWidth, fieldHeight);
        setFieldStyle(emailField, "email"); // Apply custom field style
        backgroundPanel.add(emailField);

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
        setFieldStyle(passwordField, "password"); // Apply custom field style
        backgroundPanel.add(passwordField);

        // Create signup button
        JButton signupButton = new JButton("SignUp");
        signupButton.setBounds(labelX + 120, fieldY + fieldHeight + 50, fieldWidth - 30, fieldHeight);
        signupButton.setBackground(Color.MAGENTA); // Set button background color
        signupButton.setForeground(Color.MAGENTA); // Set button text color
        signupButton.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25)); // Add padding to the button
        signupButton.setFocusPainted(false); // Remove focus indication
        signupButton.setOpaque(false); // Ensure button is not opaque
        signupButton.setBorder(new RoundedBorder(15, Color.MAGENTA));
        backgroundPanel.add(signupButton);

        // Create signin button
        /*
        JButton loginButton = new JButton("SignIn");
        loginButton.setBounds(fieldX  -90, fieldY + fieldHeight + 50, fieldWidth -30, fieldHeight);
        loginButton.setBackground(Color.GREEN); // Set button background color
        loginButton.setForeground(Color.GREEN); // Set button text color
        loginButton.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25)); // Add padding to the button
        loginButton.setFocusPainted(false); // Remove focus indication
        loginButton.setOpaque(false); // Ensure button is not opaque
        loginButton.setBorder(new RoundedBorder(15,Color.GREEN));
        backgroundPanel.add(loginButton);
         */

        //Create Cancel Button
        JButton cancel = new JButton("Cancel");
        cancel.setBounds(fieldX + 70 , fieldY + fieldHeight + 220, fieldWidth -30, fieldHeight); //set position of cancel button
        cancel.setForeground(Color.RED); // Add text color
        cancel.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25)); // Add padding to the button
        cancel.setFocusPainted(false);// Remove focus indication
        cancel.setOpaque(false);// Ensure button is not opaque
        cancel.setBorder(new RoundedBorder(15, Color.RED));
        backgroundPanel.add(cancel);

        //Create back Button
        JButton back = new JButton("Back");
        back.setBounds(fieldX + -70 , fieldY + fieldHeight + 220, fieldWidth -30, fieldHeight); //set position of cancel button
        back.setForeground(Color.CYAN); // Add text color
        back.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25)); // Add padding to the button
        back.setFocusPainted(false);// Remove focus indication
        back.setOpaque(false);// Ensure button is not opaque
        back.setBorder(new RoundedBorder(15, Color.CYAN));
        backgroundPanel.add(back);

        // Add cancel button event listner
        cancel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });

        // Add back button event listner
        back.addActionListener(e -> {
            login login = new login();
            login.display();
            dispose();
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

    private void setFieldStyle(JTextField field, String fieldType) {
        field.setOpaque(false); // Set transparent background
        field.setForeground(Color.CYAN); // Set text color to white

        // Declare and initialize placeholderText with a default value
        String placeholderText = "";

        // Declare placeholderColor variable
        final Color placeholderColor;

        if (fieldType.equals("username")) {
            placeholderText = "Username";
            placeholderColor = Color.CYAN; // Set placeholder color for username
        } else if (fieldType.equals("password")) {
            placeholderText = "Password";
            placeholderColor = Color.CYAN; // Set placeholder color for password
        } else if (fieldType.equals("email")) {
            placeholderText = "Email";
            placeholderColor = Color.CYAN; // Set placeholder color for email
        } else {
            // Handle unknown field types
            placeholderColor = Color.GRAY; // Default placeholder color
        }

        // Set placeholder text color
        //field.setForeground(placeholderColor);

        // Create a rounded border with a dark gray color
        Border roundedBorder = BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.CYAN, 2, true), // Outer border with white color
                BorderFactory.createLineBorder(Color.RED, 1, true) // Inner border with dark gray color
        );
        // Set the rounded border to the field
        field.setBorder(roundedBorder);

        // Add focus listener to handle placeholder behavior
        String finalPlaceholderText = placeholderText;
        field.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (field.getText().equals(finalPlaceholderText)) {
                    field.setText("");
                    field.setForeground(Color.CYAN);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (field.getText().isEmpty()) {
                    field.setText(finalPlaceholderText);
                    field.setForeground(placeholderColor);
                }
            }
        });

        // Set initial placeholder text
        field.setText(placeholderText);
        field.setEditable(true); // Enable editing
    }


}

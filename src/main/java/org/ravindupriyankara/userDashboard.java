package org.ravindupriyankara;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class userDashboard extends JFrame {

    private JPanel headerPanel, navigationPanel, mainPanel;
    private  ImageIcon backgroundImage;
    private JButton homeButton;
    private JLabel profileLabel, username,
            notificationLabel, emailLabel,
            navlogoLabel, navlogotextLabel;
    public userDashboard() {
        try {
            // Load the background image from the classpath
            backgroundImage = new ImageIcon(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/user-dash-bg.png"))));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load the background image.", e);
        }
        initializeUI();
    }


    private void initializeUI() {
        //setTitle("User Dashboard");
        setUndecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //setLocationRelativeTo(null);

        // Get the screen dimensions
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth() ;
        int screenHeight = (int) screenSize.getHeight() ;

        // Set the size of the frame to match the screen size
        setSize(screenWidth, screenHeight);

        // Create background panel
        JPanel backgroundPanel = new Backround(backgroundImage);
        backgroundPanel.setLayout(null); // Use null layout for precise component positioning
        backgroundPanel.setSize(900, 600); // Set size to match frame size
        add(backgroundPanel);

        // Create and add header panel
        headerPanel = new GradientPanel(new Color(255, 255, 204), new Color(255, 255, 102));
        headerPanel.setLayout(null);
        headerPanel.setOpaque(false); // Make the header panel transparent
        headerPanel.setBounds(50, 0, getWidth(), 50);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding

        // Create and add left navigation bar

        navigationPanel = new GradientPanel(new Color(255, 255,104), new Color(236, 130, 59));


        navigationPanel.setLayout(null);
        navigationPanel.setOpaque(true);// Make the left navigation panel transparent
        navigationPanel.setBounds(0, 0, 50,getHeight());
        navigationPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding

        /*
        navigationPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.magenta, 2), // Outer border
                BorderFactory.createEmptyBorder(5, 5, 5, 5) // Inner padding
        ));

         */

        // Add navigation bar enabling button
        ImageIcon navigationIcon = new ImageIcon(getClass().getResource("/home.png"));
        navigationIcon = resizeImageIcon(navigationIcon, 35, 35);

        // Add image to button
        JButton navigate = new JButton(navigationIcon);

        // Set button size to match icon size
        navigate.setPreferredSize(new Dimension(navigationIcon.getIconWidth(), navigationIcon.getIconHeight()));

        // Set some properties for the button
        navigate.setFocusPainted(false); // Remove the focus border
        navigate.setBorderPainted(false); // Remove the border
        //navigate.setBorder(new RoundedBorder(15, Color.RED));
        navigate.setBounds(0, 3, 50, 50);

        navigate.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Expand navigation panel to 150px width when clicked
                if (navigationPanel.getWidth() == 50) {
                    navigationPanel.setSize(150, getHeight() );
                    headerPanel.setBounds(150, 0, getWidth(), 50);
                    profileLabel.setBounds(getWidth() -200,3,50,50);
                    username.setBounds(getWidth() - 250,5,60,40);
                    notificationLabel.setBounds(getWidth() - 300, 3, 50, 50);
                    emailLabel.setBounds(getWidth() - 350, 3, 50, 50);
                }
                else {
                    navigationPanel.setSize(50, getHeight() );
                    headerPanel.setBounds(50, 0, getWidth(), 50);
                    profileLabel.setBounds(getWidth() -100,3,50,50);
                    username.setBounds(getWidth() - 150,5,60,40);
                    notificationLabel.setBounds(getWidth() - 200, 3, 50, 50);
                    emailLabel.setBounds(getWidth() - 250, 3, 50, 50);
                    navlogotextLabel.setBounds(60,2,90,70);
                }
            }
        });

        // Add button to header section
        headerPanel.add(navigate, BorderLayout.WEST);

        //Add profile png to header panel
        ImageIcon profileIcon = new ImageIcon(getClass().getResource("/profile.png"));
        profileLabel = new JLabel(resizeImageIcon(profileIcon, 30, 30));
        profileLabel.setBounds(getWidth() -100,3,50,50);
        headerPanel.add(profileLabel);

        //Add username to header section
        username = new JLabel();
        username.setText("Ravindu");
        username.setFont(new Font("Arial", Font.BOLD, 12));
        username.setForeground(Color.BLUE);
        //username.setBackground(Color.YELLOW);
        username.setOpaque(false);
        //username.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        username.setHorizontalAlignment(SwingConstants.CENTER);
        //username.setPreferredSize(new Dimension(10, 5));
        username.setBounds(getWidth() - 150,5,60,40);
        headerPanel.add(username);

        // Add notification icon
        ImageIcon notification = new ImageIcon(getClass().getResource("/notification.png"));
        notificationLabel = new JLabel(resizeImageIcon(notification, 30, 30));
        notificationLabel.setBounds(getWidth() - 200, 3, 50, 50);
        headerPanel.add(notificationLabel);

        //Add email icon
        ImageIcon email = new ImageIcon(getClass().getResource("/email.png"));
        emailLabel = new JLabel(resizeImageIcon(email, 30, 30));
        emailLabel.setBounds(getWidth() - 250, 3, 50, 50);
        headerPanel.add(emailLabel);

        //navigation bar designing
        ImageIcon navLogo = new ImageIcon(getClass().getResource("/nav-logo.png"));
        navlogoLabel = new JLabel(resizeImageIcon(navLogo, 50,50));
        navlogoLabel.setBounds(0, 0, 50, 50);
        navigationPanel.add(navlogoLabel);

        //load custom fonts
        FontLoader fontLoader = new FontLoader();
        // Replace "your_custom_font.ttf" with the path to your font file
        fontLoader.loadCustomFont("/Copyduck.ttf");

        //logo text
        navlogotextLabel = new JLabel();
        navlogotextLabel.setText("Senura");
        navlogotextLabel.setFont(new Font("Copyduck", Font.BOLD, 18));
        navlogotextLabel.setForeground(Color.BLUE);
        //navlogotextLabel.setBackground(Color.YELLOW);
        navlogotextLabel.setOpaque(false);
        //navlogotextLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        navlogotextLabel.setHorizontalAlignment(SwingConstants.CENTER);
        navlogotextLabel.setBounds(0,0,0,0);
        navigationPanel.add(navlogotextLabel);

        // Dashboard logo
        ImageIcon dashImage = new ImageIcon(getClass().getResource("/dashboard.png"));
        dashImage = resizeImageIcon(dashImage, 30, 30);

        //Add dash button
        JButton dashButton = new JButton(dashImage);
        dashButton.setPreferredSize(new Dimension(dashImage.getIconWidth(), dashImage.getIconHeight()));// image diemantion set to button size
        dashButton.setOpaque(false);
        dashButton.setBorder(null);
        dashButton.setBounds(0, 70, 50, 50);
        dashButton.setFocusPainted(false); // Remove the focus border
        dashButton.setBorderPainted(false); // Remove the border
        navigationPanel.add(dashButton);

        //dashboard button function
        dashButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); // functions here
            }
        });

        // fernitures
        ImageIcon fernitureImage = new ImageIcon(getClass().getResource("/product.png"));
        fernitureImage = resizeImageIcon(fernitureImage, 35, 35);

        //Add fernitures button
        JButton fernitureButton = new JButton(fernitureImage);
        fernitureButton.setPreferredSize(new Dimension(dashImage.getIconWidth(), dashImage.getIconHeight()));// image diemantion set to button size
        fernitureButton.setOpaque(false);
        fernitureButton.setBorder(null);
        fernitureButton.setBounds(0, 140, 50, 50);
        fernitureButton.setFocusPainted(false); // Remove the focus border
        fernitureButton.setBorderPainted(false); // Remove the border
        navigationPanel.add(fernitureButton);

        //fernitures button function
        fernitureButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); // functions here
            }
        });
        //offers
        ImageIcon offerImage = new ImageIcon(getClass().getResource("/offer.png"));
        offerImage = resizeImageIcon(offerImage, 35, 35);

        //Add offers button
        JButton offerButton = new JButton(offerImage);
        offerButton.setPreferredSize(new Dimension(dashImage.getIconWidth(), dashImage.getIconHeight()));// image diemantion set to button size
        offerButton.setOpaque(false);
        offerButton.setBorder(null);
        offerButton.setBounds(0, 210, 50, 50);
        offerButton.setFocusPainted(false); // Remove the focus border
        offerButton.setBorderPainted(false); // Remove the border
        navigationPanel.add(offerButton);

        //offers button function
        offerButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); // functions here
            }
        });
        //new arrivals
        ImageIcon arrivalImage = new ImageIcon(getClass().getResource("/new-arrivals.png"));
        arrivalImage = resizeImageIcon(arrivalImage, 35, 35);

        //Add offers button
        JButton arrivalButton = new JButton(arrivalImage);
        arrivalButton.setPreferredSize(new Dimension(dashImage.getIconWidth(), dashImage.getIconHeight()));// image diemantion set to button size
        arrivalButton.setOpaque(false);
        arrivalButton.setBorder(null);
        arrivalButton.setBounds(0, 280, 50, 50);
        arrivalButton.setFocusPainted(false); // Remove the focus border
        arrivalButton.setBorderPainted(false); // Remove the border
        navigationPanel.add(arrivalButton);

        //offers button function
        arrivalButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); // functions here
            }
        });
        //notifications
        ImageIcon notificationImage = new ImageIcon(getClass().getResource("/notification.png"));
        notificationImage = resizeImageIcon(notificationImage, 35, 35);

        //Add notification button
        JButton notificationButton = new JButton(notificationImage);
        notificationButton.setPreferredSize(new Dimension(dashImage.getIconWidth(), dashImage.getIconHeight()));// image diemantion set to button size
        notificationButton.setOpaque(false);
        notificationButton.setBorder(null);
        notificationButton.setBounds(0, 350, 50, 50);
        notificationButton.setFocusPainted(false); // Remove the focus border
        notificationButton.setBorderPainted(false); // Remove the border
        navigationPanel.add(notificationButton);

        //notification button function
        notificationButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); // functions here
            }
        });
        //mails
        ImageIcon mailImage = new ImageIcon(getClass().getResource("/gmail.png"));
        mailImage = resizeImageIcon(mailImage, 35, 35);

        //Add mail button
        JButton mailButton = new JButton(mailImage);
        mailButton.setPreferredSize(new Dimension(dashImage.getIconWidth(), dashImage.getIconHeight()));// image diemantion set to button size
        mailButton.setOpaque(false);
        mailButton.setBorder(null);
        mailButton.setBounds(0, 420, 50, 50);
        mailButton.setFocusPainted(false); // Remove the focus border
        mailButton.setBorderPainted(false); // Remove the border
        navigationPanel.add(mailButton);

        //mail button function
        mailButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); // functions here
            }
        });
        //contacts us
        ImageIcon contactImage = new ImageIcon(getClass().getResource("/contact.png"));
        contactImage = resizeImageIcon(contactImage, 35, 35);

        //Add contact button
        JButton contactButton = new JButton(contactImage);
        contactButton.setPreferredSize(new Dimension(dashImage.getIconWidth(), dashImage.getIconHeight()));// image diemantion set to button size
        contactButton.setOpaque(false);
        contactButton.setBorder(null);
        contactButton.setBounds(0, 490, 50, 50);
        contactButton.setFocusPainted(false); // Remove the focus border
        contactButton.setBorderPainted(false); // Remove the border
        navigationPanel.add(contactButton);

        //contact button function
        contactButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); // functions here
            }
        });
        //settings
        ImageIcon settingImage = new ImageIcon(getClass().getResource("/settings.png"));
        settingImage = resizeImageIcon(settingImage, 35, 35);

        //Add settings button
        JButton settingButton = new JButton(settingImage);
        settingButton.setPreferredSize(new Dimension(dashImage.getIconWidth(), dashImage.getIconHeight()));// image diemantion set to button size
        settingButton.setOpaque(false);
        settingButton.setBorder(null);
        settingButton.setBounds(0, 560, 50, 50);
        settingButton.setFocusPainted(false); // Remove the focus border
        settingButton.setBorderPainted(false); // Remove the border
        navigationPanel.add(settingButton);

        //settings button function
        contactButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); // functions here
            }
        });
        //admin
        ImageIcon adminImage = new ImageIcon(getClass().getResource("/admin.png"));
        adminImage = resizeImageIcon(adminImage, 35, 35);

        //Add settings button
        JButton adminButton = new JButton(adminImage);
        adminButton.setPreferredSize(new Dimension(dashImage.getIconWidth(), dashImage.getIconHeight()));// image diemantion set to button size
        adminButton.setOpaque(false);
        adminButton.setBorder(null);
        adminButton.setBounds(0, 630, 50, 50);
        adminButton.setFocusPainted(false); // Remove the focus border
        adminButton.setBorderPainted(false); // Remove the border
        navigationPanel.add(adminButton);

        //settings button function
        adminButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); // functions here
            }
        });
        //logout
        ImageIcon logoutImage = new ImageIcon(getClass().getResource("/arrow.png"));
        logoutImage = resizeImageIcon(logoutImage, 35, 35);

        //Add settings button
        JButton logoutButton = new JButton(logoutImage);
        logoutButton.setPreferredSize(new Dimension(dashImage.getIconWidth(), dashImage.getIconHeight()));// image diemantion set to button size
        logoutButton.setOpaque(false);
        logoutButton.setBorder(null);
        logoutButton.setBounds(0, 700, 50, 50);
        logoutButton.setFocusPainted(false); // Remove the focus border
        logoutButton.setBorderPainted(false); // Remove the border
        navigationPanel.add(logoutButton);

        //settings button function
        logoutButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                login login = new login();
                login.display();
                dispose();
            }
        });
        //if you can add theme changer





        backgroundPanel.add(headerPanel);
        backgroundPanel.add(navigationPanel);


        // Add rounded border to header panel
        headerPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.magenta, 2), // Outer border
                BorderFactory.createEmptyBorder(5, 5, 5, 5) // Inner padding
        ));




    }

    private ImageIcon resizeImageIcon(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image resizedImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImg);
    }

    public void display(){
        setVisible(true);
    }
}

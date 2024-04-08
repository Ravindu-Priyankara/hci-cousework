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
    private dashboardCard dashboardCard;
    private  ImageIcon backgroundImage;
    private JLabel profileLabel, username,
            notificationLabel, emailLabel,
            navlogoLabel, navlogotextLabel,
            dashboardLabel, fernitureLabel,
            offersLabel, arrivalLabel,
            notifiLabel, mailLabel, settingsLabel,
            adminLabel, contactLabel, logoutLabel;
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
        JPanel backgroundPanel = new Background(backgroundImage);
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
                    navlogotextLabel.setBounds(60,2,90,70);
                    dashboardLabel.setBounds(60,62,90,70);
                    fernitureLabel.setBounds(60, 135, 90, 70);
                    offersLabel.setBounds(60, 200, 90, 70);
                    arrivalLabel.setBounds(60,271, 90, 70);
                    notifiLabel.setBounds(60, 344, 90, 70);
                    mailLabel.setBounds(60, 410, 90, 70);
                    contactLabel.setBounds(60, 483, 90, 70);
                    settingsLabel.setBounds(60, 550, 90, 70);
                    adminLabel.setBounds(60, 620, 90, 70);
                    logoutLabel.setBounds(60, 693, 90, 70);
                }
                else {
                    navigationPanel.setSize(50, getHeight() );
                    headerPanel.setBounds(50, 0, getWidth(), 50);
                    profileLabel.setBounds(getWidth() -100,3,50,50);
                    username.setBounds(getWidth() - 150,5,60,40);
                    notificationLabel.setBounds(getWidth() - 200, 3, 50, 50);
                    emailLabel.setBounds(getWidth() - 250, 3, 50, 50);
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
        fontLoader.loadCustomFont("/Bronco.ttf");

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

        //dashboard text
        dashboardLabel = new JLabel();
        dashboardLabel.setText("Dashboard");
        dashboardLabel.setFont(new Font("Bronco", Font.BOLD, 18));
        dashboardLabel.setForeground(new Color(0, 128, 255));
        //dashboardLabel.setBackground(Color.YELLOW);
        dashboardLabel.setOpaque(false);
        //dashboardLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        dashboardLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dashboardLabel.setBounds(0,0,0,0);
        navigationPanel.add(dashboardLabel);

        //dashboard button function
        dashButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                SwingUtilities.invokeLater(() -> {
                    //add card to dashboard
                    dashboardCard = new dashboardCard(); //create card object

                    // enable  cards
                    dashboardCard.welcomeCard.setVisible(true);
                    dashboardCard.items.setVisible(true);
                    dashboardCard.accesories.setVisible(true);
                    dashboardCard.cost.setVisible(true);
                    dashboardCard.itemsList.setVisible(true);
                    dashboardCard.serviceList.setVisible(true);

                    //add cards to background
                    backgroundPanel.add(dashboardCard.welcomeCard);
                    backgroundPanel.add(dashboardCard.items);
                    backgroundPanel.add(dashboardCard.accesories);
                    backgroundPanel.add(dashboardCard.cost);
                    backgroundPanel.add(dashboardCard.itemsList);
                    backgroundPanel.add(dashboardCard.serviceList);

                });
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

        //ferniture text
        fernitureLabel = new JLabel();
        fernitureLabel.setText("Furniture");
        fernitureLabel.setFont(new Font("Bronco", Font.BOLD, 18));
        fernitureLabel.setForeground(new Color(0, 128, 255));
        //fernitureLabel.setBackground(Color.YELLOW);
        fernitureLabel.setOpaque(false);
        //fernitureLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        fernitureLabel.setHorizontalAlignment(SwingConstants.CENTER);
        fernitureLabel.setBounds(0,0,0,0);
        navigationPanel.add(fernitureLabel);

        //fernitures button function
        fernitureButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                /* disable  cards */
                SwingUtilities.invokeLater(() -> {
                    dashboardCard.welcomeCard.setVisible(false);
                    dashboardCard.items.setVisible(false);
                    dashboardCard.accesories.setVisible(false);
                    dashboardCard.cost.setVisible(false);
                    dashboardCard.itemsList.setVisible(false);
                    dashboardCard.serviceList.setVisible(false);

                    // enable cards
                    dashboardCard.chair1.setVisible(true);
                    dashboardCard.desk.setVisible(true);

                    //add card to background panel
                    backgroundPanel.add(dashboardCard.welcomeCard);
                    backgroundPanel.add(dashboardCard.items);
                    backgroundPanel.add(dashboardCard.accesories);
                    backgroundPanel.add(dashboardCard.cost);
                    backgroundPanel.add(dashboardCard.itemsList);
                    backgroundPanel.add(dashboardCard.serviceList);
                    backgroundPanel.add(dashboardCard.chair1);
                    backgroundPanel.add(dashboardCard.desk);
                });


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

        //offer text
        offersLabel = new JLabel();
        offersLabel.setText("Offers");
        offersLabel.setFont(new Font("Bronco", Font.BOLD, 18));
        offersLabel.setForeground(new Color(0, 128, 255));
        //offersLabel.setBackground(Color.YELLOW);
        offersLabel.setOpaque(false);
        //offersLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        offersLabel.setHorizontalAlignment(SwingConstants.CENTER);
        offersLabel.setBounds(0,0,0,0);
        navigationPanel.add(offersLabel);

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

        //arrival text
        arrivalLabel = new JLabel();
        arrivalLabel.setText("New");
        arrivalLabel.setFont(new Font("Bronco", Font.BOLD, 18));
        arrivalLabel.setForeground(new Color(255, 30, 30));
        //arrivalLabel.setBackground(Color.YELLOW);
        arrivalLabel.setOpaque(false);
        //arrivalLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        arrivalLabel.setHorizontalAlignment(SwingConstants.CENTER);
        arrivalLabel.setBounds(0,0,0,0);
        navigationPanel.add(arrivalLabel);

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

        //notification text
        notifiLabel = new JLabel();
        notifiLabel.setText("Notification");
        notifiLabel.setFont(new Font("Bronco", Font.BOLD, 18));
        notifiLabel.setForeground(new Color(0, 128, 255));
        //notifiLabel.setBackground(Color.YELLOW);
        notifiLabel.setOpaque(false);
        //notifiLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        notifiLabel.setHorizontalAlignment(SwingConstants.CENTER);
        notifiLabel.setBounds(0,0,0,0);
        navigationPanel.add(notifiLabel);

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

        //mail text
        mailLabel = new JLabel();
        mailLabel.setText("Mails");
        mailLabel.setFont(new Font("Bronco", Font.BOLD, 18));
        mailLabel.setForeground(new Color(0, 128, 255));
        //mailLabel.setBackground(Color.YELLOW);
        mailLabel.setOpaque(false);
        //mailLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        mailLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mailLabel.setBounds(0,0,0,0);
        navigationPanel.add(mailLabel);

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

        //Contact text
        contactLabel = new JLabel();
        contactLabel.setText("Contact");
        contactLabel.setFont(new Font("Bronco", Font.BOLD, 18));
        contactLabel.setForeground(new Color(0, 128, 255));
        //contactLabel.setBackground(Color.YELLOW);
        contactLabel.setOpaque(false);
        //contactLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        contactLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contactLabel.setBounds(0,0,0,0);
        navigationPanel.add(contactLabel);

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

        //settings text
        settingsLabel = new JLabel();
        settingsLabel.setText("Settings");
        settingsLabel.setFont(new Font("Bronco", Font.BOLD, 18));
        settingsLabel.setForeground(new Color(0, 128, 255));
        //settingsLabel.setBackground(Color.YELLOW);
        settingsLabel.setOpaque(false);
        //settingsLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        settingsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        settingsLabel.setBounds(0,0,0,0);
        navigationPanel.add(settingsLabel);


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

        //Admin text
        adminLabel = new JLabel();
        adminLabel.setText("Admin");
        adminLabel.setFont(new Font("Bronco", Font.BOLD, 18));
        adminLabel.setForeground(new Color(0, 128, 255));
        //adminLabel.setBackground(Color.YELLOW);
        adminLabel.setOpaque(false);
        //adminLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        adminLabel.setHorizontalAlignment(SwingConstants.CENTER);
        adminLabel.setBounds(0,0,0,0);
        navigationPanel.add(adminLabel);

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

        //Add logout button
        JButton logoutButton = new JButton(logoutImage);
        logoutButton.setPreferredSize(new Dimension(dashImage.getIconWidth(), dashImage.getIconHeight()));// image diemantion set to button size
        logoutButton.setOpaque(false);
        logoutButton.setBorder(null);
        logoutButton.setBounds(0, 700, 50, 50);
        logoutButton.setFocusPainted(false); // Remove the focus border
        logoutButton.setBorderPainted(false); // Remove the border
        navigationPanel.add(logoutButton);

        //logout text
        logoutLabel = new JLabel();
        logoutLabel.setText("Logout");
        logoutLabel.setFont(new Font("Bronco", Font.BOLD, 18));
        logoutLabel.setForeground(new Color(255, 30, 30));
        //logoutLabel.setBackground(Color.YELLOW);
        logoutLabel.setOpaque(false);
        //logoutLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        logoutLabel.setHorizontalAlignment(SwingConstants.CENTER);
        logoutLabel.setBounds(0,0,0,0);
        navigationPanel.add(logoutLabel);

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

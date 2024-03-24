package org.ravindupriyankara;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Objects;

public class SplashScreen extends JFrame{
    private final ImageIcon backgroundImage;
    //create constructor for initializeUi
    public SplashScreen() {
        try {
            // Load the background image from the classpath
            backgroundImage = new ImageIcon(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/splashBackground.png"))));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load the background image.", e);
        }

        //call initializeUI methode
        initializeUI();
    }
    private void initializeUI(){
        //add title to splashscreen
        setTitle("Senura Ferniture");
        //add window size
        setSize(900,600);
        // Center the frame on the screen
        setLocationRelativeTo(null);
        // Use BorderLayout for better layout control
        setLayout(new BorderLayout());

        // Create a JLabel with the background image
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setLayout(new BorderLayout());
        add(backgroundLabel, BorderLayout.CENTER);
        // Resize the background image to fit the splash screen window
        backgroundLabel.setPreferredSize(new Dimension(getWidth(), getHeight()));

        //set default closing operator
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Properly dispose of the frame when closed
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }
    // Display function declare for enable visibility of splash screen
    public void display(){
        setVisible(true);
    }
}

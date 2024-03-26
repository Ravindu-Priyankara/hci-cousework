package org.ravindupriyankara;


import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.basic.BasicProgressBarUI;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Objects;

public class SplashScreen extends JFrame{
    private final ImageIcon backgroundImage;
    private JProgressBar progressBar;
    private JLabel progressbarLabel,logoLabel;
    private ImageIcon logo; //logo
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
        //add title to splashscreen enable this
        //setTitle("Senura Ferniture");

        //hide tittle bar
        setUndecorated(true);
        //add window size
        setSize(900,600);
        // Center the frame on the screen
        setLocationRelativeTo(null);
        // Use BorderLayout for better layout control
        setLayout(new BorderLayout());

        //set background color
        setBackground(Color.BLACK);

        // Create background panel
        JPanel backgroundPanel = new Backround(backgroundImage);
        backgroundPanel.setLayout(null); // Use null layout for precise component positioning
        backgroundPanel.setSize(900, 600); // Set size to match frame size
        add(backgroundPanel);

        // Create a JLabel with the background image
        //JLabel backgroundLabel = new JLabel(backgroundImage);
        //backgroundLabel.setLayout(new BorderLayout());
        //add(backgroundLabel, BorderLayout.CENTER);
        // Resize the background image to fit the splash screen window
        //backgroundLabel.setPreferredSize(new Dimension(getWidth(), getHeight()));

        // add logo
        logo = new ImageIcon(getClass().getResource("/logo.png"));
        logoLabel = new JLabel(logo);
        int logoWidth = logo.getIconWidth();
        int logoHeight = logo.getIconHeight();
        int logoX = (backgroundPanel.getWidth() - logoWidth) / 2 ;
        int logoY = (backgroundPanel.getHeight() - logoHeight) / 2;
        logoLabel.setBounds(logoX, logoY, logoWidth, logoHeight);
        backgroundPanel.add(logoLabel);

        //add progressbar label
        progressbarLabel = new JLabel("Gathering stardust and dreams...");
        progressbarLabel.setForeground(Color.WHITE);
        progressbarLabel.setBounds(10, 560, progressbarLabel.getPreferredSize().width, progressbarLabel.getPreferredSize().height);
        backgroundPanel.add(progressbarLabel);

        //Add progressbar
        progressBar = new JProgressBar(0,100);
        progressBar.setPreferredSize(new Dimension(progressBar.getPreferredSize().width,10));
        progressBar.setStringPainted(true);//enable percentage
        progressBar.setForeground(Color.WHITE);
        setProgressBarColors(progressBar); // Set custom colors
        //add(progressBar,BorderLayout.SOUTH);
        progressBar.setBounds(0, 580, 900, 10); // Position at the bottom of the frame
        backgroundPanel.add(progressBar);

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

    //set progressbar value
    public void setProgress(int value){
        progressBar.setValue(value);
        Color color = getColorForPercentage(value);
        progressBar.setForeground(color);
    }

    //get progressbar color
    private Color getColorForPercentage(int percentage){
        if (percentage < 50) {
            return Color.RED; // Red for less than 50%
        } else if (percentage < 80) {
            return Color.YELLOW; // Yellow for less than 80%
        } else {
            return Color.GREEN; // Green for 80% or more
        }
    }
    // Set custom colors for the progress bar
    private void setProgressBarColors(JProgressBar progressBar) {
        progressBar.setUI(new BasicProgressBarUI() {
            protected Color getSelectionBackground() {
                return Color.white;
            }

            protected Color getSelectionForeground() {
                return Color.black;
            }
        });
    }

    //set progressbar label changer
    public void setProgressLabel(int value){

        String[] data = {"Loading... Patience is a virtue!", "Assembling pixels and code into magic...", "One moment while we ignite the engines...",
                "Brewing creativity, just for you...", "Loading... Unraveling mysteries of the digital realm...", "Hold tight, we're forging your experience...",
                "Reticulating splines... just kidding, but almost there!", "Inhale... Exhale... Loading complete!", "Assembling the universe, one line of code at a time...",
                "Done ....."};

        if ((value & 10) == 0 && value >= 10){
            int head = (value / 10) - 1;
            progressbarLabel.setText(data[head]);
        }
    }
}

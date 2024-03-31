package org.ravindupriyankara;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class ObjectDesigner extends JFrame {
    private String object, image;
    private ImageIcon backgroundImage;
    public ObjectDesigner(String object, String image) throws HeadlessException {
        this.object = object;
        this.image = image;
        try {
            // Load the background image from the classpath
            backgroundImage = new ImageIcon(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/object-bg.jpg"))));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load the background image.", e);
        }

        InitialiseUI();
    }
    private void InitialiseUI(){
        setSize(900, 600);// window size define
        setLocationRelativeTo(null); // center to window
        setUndecorated(true); //hide title bar

        // Create background panel
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g.create();

                // Set the opacity level (0.0 to 1.0)
                float opacity = 0.9f;

                // Create an AlphaComposite instance with the specified opacity
                AlphaComposite alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity);

                // Set the composite for the graphics context
                g2d.setComposite(alphaComposite);

                // Draw the background image
                g2d.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);

                g2d.dispose();
            }
        };
        backgroundPanel.setLayout(null); // Use null layout for precise component positioning
        backgroundPanel.setSize(900, 600); // Set size to match frame size
        add(backgroundPanel);

        //load fonts
        FontLoader fontLoader = new FontLoader();
        // Replace "your_custom_font.ttf" with the path to your font file
        fontLoader.loadCustomFont("/Copyduck.ttf");
        fontLoader.loadCustomFont("/Bronco.ttf");
        fontLoader.loadCustomFont("/bageta.ttf");

        //Add title
        JLabel tittleLabel = new JLabel(object);
        tittleLabel.setFont(new Font("bageta", Font.BOLD, 30));
        tittleLabel.setForeground(Color.WHITE);
        //tittleLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        //tittleLabel.setOpaque(false);
        tittleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        tittleLabel.setBounds(25 , 20, getWidth() -50, 50);

        //room type
        JLabel roomType = new JLabel("Room Type: ");
        roomType.setFont(new Font("Copyduck", Font.BOLD, 20));
        roomType.setForeground(Color.WHITE);
        roomType.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        roomType.setBounds(50, 150, 150, 50);


        /*
        ImageIcon objectImage = new ImageIcon(Objects.requireNonNull(getClass().getResource(image)));
        objectImage = resizeImageIcon(objectImage, 100, 100);

        JButton objectButton = new JButton(objectImage);
        objectButton.setPreferredSize(new Dimension(objectImage.getIconWidth(), objectImage.getIconHeight()));// image diemantion set to button size
        objectButton.setOpaque(false);
        objectButton.setBorder(new RoundedBorder(12, Color.BLACK));
        objectButton.setBounds(200, 100, 100, 100);
        objectButton.setFocusPainted(false); // Remove the focus border
        objectButton.setBorderPainted(true);

         */




        //backgroundPanel.add(objectButton); //image button add to background
        backgroundPanel.add(tittleLabel); //title label add to background
        backgroundPanel.add(roomType);// add room type to background panel
    }

    public void display(){
        setVisible(true);
    }
    private ImageIcon resizeImageIcon(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image resizedImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImg);
    }
}
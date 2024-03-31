package org.ravindupriyankara;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class FurnitureCards extends JPanel {
    private JLabel tittleLabel;
    private JTextArea cardBodyLabel;
    private Color startColor;
    private Color endColor;
    public FurnitureCards(LayoutManager layout, String title, Color tittleForeground,
                          String tittleFont, int tittleFontSize, int cardWidth, int cardHeight,
                          int cardX, int cardY, Color startColor, Color endColor, String bodyText,
                          Color bodytextColor, int bodyfontSize, String bodytextFont, String image) {

        this.startColor = startColor;
        this.endColor = endColor;

        setLayout(layout);
        setPreferredSize(new Dimension(cardWidth,cardHeight));
        setBounds(cardX, cardY, cardWidth, cardHeight);

        //initialise fonts
        //load custom fonts
        FontLoader fontLoader = new FontLoader();
        // Replace "your_custom_font.ttf" with the path to your font file
        fontLoader.loadCustomFont("/Copyduck.ttf");
        fontLoader.loadCustomFont("/Bronco.ttf");
        fontLoader.loadCustomFont("/bageta.ttf");

        // initialise tittle
        tittleLabel = new JLabel(title);
        tittleLabel.setFont(new Font(tittleFont, Font.BOLD, tittleFontSize));
        tittleLabel.setForeground(tittleForeground);
        //tittleLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        //tittleLabel.setOpaque(false);
        tittleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        if (layout == null) {
            tittleLabel.setBounds(0, 5, cardWidth, 50);
        }
        //Body label
        cardBodyLabel = new JTextArea(bodyText);
        cardBodyLabel.setFont(new Font(bodytextFont, Font.BOLD, bodyfontSize));
        cardBodyLabel.setForeground(bodytextColor);
        //cardBodyLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        cardBodyLabel.setEditable(false);
        cardBodyLabel.setLineWrap(true); // Enable text wrapping
        cardBodyLabel.setWrapStyleWord(true); // Wrap at word boundaries
        cardBodyLabel.setOpaque(false); // Make the background transparent
        //tittleLabel.setOpaque(false);
        //cardBodyLabel.setHorizontalAlignment(SwingConstants.CENTER);

        if (layout == null) {
            cardBodyLabel.setBounds(10, 100, cardWidth -20 , 100);
        }
        //add image
        if (!Objects.equals(image, "/test.jpg")) {
            ImageIcon cardImage = new ImageIcon(getClass().getResource(image));
            cardImage = resizeImageIcon(cardImage, 100, 100);

            JButton cardButton = new JButton(cardImage);
            cardButton.setPreferredSize(new Dimension(cardImage.getIconWidth(), cardImage.getIconHeight()));// image diemantion set to button size
            cardButton.setOpaque(false);
            cardButton.setBorder(null);
            cardButton.setBounds(100, 210, 100, 100);
            cardButton.setFocusPainted(false); // Remove the focus border
            cardButton.setBorderPainted(false);


            add(cardButton);
        }

        //buy button
        JButton buyButton = new JButton("Buy Now");
        buyButton.setBounds(100, 330, 100, 40);
        buyButton.setBackground(Color.MAGENTA); // Set button background color
        buyButton.setForeground(Color.RED); // Set button text color
        buyButton.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25)); // Add padding to the button
        buyButton.setFocusPainted(false); // Remove focus indication
        buyButton.setOpaque(false); // Ensure button is not opaque
        buyButton.setBorder(new RoundedBorder(15,Color.MAGENTA));


        add(cardBodyLabel);
        add(tittleLabel);
        add(buyButton);

    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        int width = getWidth();
        int height = getHeight();

        // Paint gradient background
        GradientPaint gradientPaint = new GradientPaint(0, 0, startColor, 0, height, endColor);
        g2d.setPaint(gradientPaint);
        g2d.fillRect(0, 0, width, height);

        g2d.dispose();
    }
    private ImageIcon resizeImageIcon(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image resizedImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImg);
    }
}

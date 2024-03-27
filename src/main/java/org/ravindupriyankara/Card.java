package org.ravindupriyankara;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Card extends JPanel {
    private JLabel tittleLabel,cardBodyLabel;
    private Color startColor;
    private Color endColor;
    public Card(LayoutManager layout, String title, Color tittleForeground,
                String tittleFont, int tittleFontSize, int cardWidth, int cardHeight,
                int cardX, int cardY, Color startColor, Color endColor, String bodyText, Color bodytextColor,
                int bodyfontSize, String bodytextFont, String image){
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
        cardBodyLabel = new JLabel(bodyText);
        cardBodyLabel.setFont(new Font(bodytextFont, Font.BOLD, bodyfontSize));
        cardBodyLabel.setForeground(bodytextColor);
        //cardBodyLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        //tittleLabel.setOpaque(false);
        cardBodyLabel.setHorizontalAlignment(SwingConstants.CENTER);

        if (layout == null) {
            cardBodyLabel.setBounds(0, 50, cardWidth, 50);
        }
        //add image
        if (!Objects.equals(image, "null")) {
            ImageIcon cardImage = new ImageIcon(getClass().getResource(image));
            cardImage = resizeImageIcon(cardImage, 50, 50);

            JButton cardButton = new JButton(cardImage);
            cardButton.setPreferredSize(new Dimension(cardImage.getIconWidth(), cardImage.getIconHeight()));// image diemantion set to button size
            cardButton.setOpaque(false);
            cardButton.setBorder(null);
            cardButton.setBounds(120, cardY - 10, 50, 50);
            cardButton.setFocusPainted(false); // Remove the focus border
            cardButton.setBorderPainted(false);

            add(cardButton);
        }
        add(cardBodyLabel);
        add(tittleLabel);
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

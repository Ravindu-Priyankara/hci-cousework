package org.ravindupriyankara;

import javax.swing.*;
import java.awt.*;

public class MediumCards extends JPanel {
    private final JLabel tittleLabel;
    private JLabel cardBodyLabel;
    private Color startColor;
    private Color endColor;

    public MediumCards(LayoutManager layout, int cardWidth,
                       int cardHeight, int cardX, int cardY, String title,
                       int tittleFontSize, String tittleFont, Color tittleForeground,
                       String image1, Color startColor, Color endColor, String item1,
                       String item1Font, int item1FontSize, Color item1Forground, String price1,
                       Color price1Forground, String image2 ,String item2, String price2,
                       String image3 ,String item3, String price3,String image4 ,String item4, String price4,
                       String image5 ,String item5, String price5) {

        this.startColor = startColor;
        this.endColor = endColor;

        setLayout(layout);
        setPreferredSize(new Dimension(cardWidth, cardHeight));
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
        // 1st row
        //image icon
        ImageIcon image1Icon = new ImageIcon(getClass().getResource(image1));
        image1Icon = resizeImageIcon(image1Icon, 50, 50);

        JButton image1Button = new JButton(image1Icon);
        image1Button.setPreferredSize(new Dimension(image1Icon.getIconWidth(), image1Icon.getIconHeight()));// image diemantion set to button size
        image1Button.setOpaque(false);
        image1Button.setBorder(null);
        image1Button.setBounds(10, 80, 50, 50);
        image1Button.setFocusPainted(false); // Remove the focus border
        image1Button.setBorderPainted(false);

        //text icon
        JLabel image1Label = new JLabel(item1);
        image1Label.setFont(new Font(item1Font, Font.BOLD, item1FontSize));
        image1Label.setForeground(item1Forground);
        //image1Label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        //tittleLabel.setOpaque(false);
        image1Label.setHorizontalAlignment(SwingConstants.CENTER);
        image1Label.setBounds(90, 80, 120, 50);

        //price icon
        JLabel priceLabel = new JLabel(price1);
        priceLabel.setFont(new Font(item1Font, Font.BOLD, item1FontSize));
        priceLabel.setForeground(price1Forground);
        priceLabel.setBorder(new RoundedBorder(15,Color.GREEN));
        //tittleLabel.setOpaque(false);
        priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
        priceLabel.setBounds(220, 80, 90, 50);

        //second row
        //image icon
        ImageIcon image2Icon = new ImageIcon(getClass().getResource(image2));
        image2Icon = resizeImageIcon(image2Icon, 50, 50);

        JButton image2Button = new JButton(image2Icon);
        image2Button.setPreferredSize(new Dimension(image2Icon.getIconWidth(), image2Icon.getIconHeight()));// image diemantion set to button size
        image2Button.setOpaque(false);
        image2Button.setBorder(null);
        image2Button.setBounds(10, 160, 50, 50);
        image2Button.setFocusPainted(false); // Remove the focus border
        image2Button.setBorderPainted(false);

        //text icon
        JLabel image2Label = new JLabel(item2);
        image2Label.setFont(new Font(item1Font, Font.BOLD, item1FontSize));
        image2Label.setForeground(item1Forground);
        //image1Label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        //tittleLabel.setOpaque(false);
        image2Label.setHorizontalAlignment(SwingConstants.CENTER);
        image2Label.setBounds(90, 160, 120, 50);

        //price icon
        JLabel price2Label = new JLabel(price2);
        price2Label.setFont(new Font(item1Font, Font.BOLD, item1FontSize));
        price2Label.setForeground(price1Forground);
        price2Label.setBorder(new RoundedBorder(15,Color.GREEN));
        //tittleLabel.setOpaque(false);
        price2Label.setHorizontalAlignment(SwingConstants.CENTER);
        price2Label.setBounds(220, 160, 90, 50);

        //third row
        //image icon
        ImageIcon image3Icon = new ImageIcon(getClass().getResource(image3));
        image3Icon = resizeImageIcon(image3Icon, 50, 50);

        JButton image3Button = new JButton(image3Icon);
        image3Button.setPreferredSize(new Dimension(image3Icon.getIconWidth(), image3Icon.getIconHeight()));// image diemantion set to button size
        image3Button.setOpaque(false);
        image3Button.setBorder(null);
        image3Button.setBounds(10, 240, 50, 50);
        image3Button.setFocusPainted(false); // Remove the focus border
        image3Button.setBorderPainted(false);

        //text icon
        JLabel image3Label = new JLabel(item3);
        image3Label.setFont(new Font(item1Font, Font.BOLD, item1FontSize));
        image3Label.setForeground(item1Forground);
        //image1Label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        //tittleLabel.setOpaque(false);
        image3Label.setHorizontalAlignment(SwingConstants.CENTER);
        image3Label.setBounds(90, 240, 120, 50);

        //price icon
        JLabel price3Label = new JLabel(price3);
        price3Label.setFont(new Font(item1Font, Font.BOLD, item1FontSize));
        price3Label.setForeground(price1Forground);
        price3Label.setBorder(new RoundedBorder(15,Color.GREEN));
        //tittleLabel.setOpaque(false);
        price3Label.setHorizontalAlignment(SwingConstants.CENTER);
        price3Label.setBounds(220, 240, 95, 50);

        //fouth raw
        //image icon
        ImageIcon image4Icon = new ImageIcon(getClass().getResource(image4));
        image4Icon = resizeImageIcon(image4Icon, 50, 50);

        JButton image4Button = new JButton(image4Icon);
        image4Button.setPreferredSize(new Dimension(image4Icon.getIconWidth(), image4Icon.getIconHeight()));// image diemantion set to button size
        image4Button.setOpaque(false);
        image4Button.setBorder(null);
        image4Button.setBounds(10, 320, 50, 50);
        image4Button.setFocusPainted(false); // Remove the focus border
        image4Button.setBorderPainted(false);

        //text icon
        JLabel image4Label = new JLabel(item4);
        image4Label.setFont(new Font(item1Font, Font.BOLD, item1FontSize));
        image4Label.setForeground(item1Forground);
        //image1Label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        //tittleLabel.setOpaque(false);
        image4Label.setHorizontalAlignment(SwingConstants.CENTER);
        image4Label.setBounds(90, 320, 120, 50);

        //price icon
        JLabel price4Label = new JLabel(price4);
        price4Label.setFont(new Font(item1Font, Font.BOLD, item1FontSize));
        price4Label.setForeground(price1Forground);
        price4Label.setBorder(new RoundedBorder(15,Color.GREEN));
        //tittleLabel.setOpaque(false);
        price4Label.setHorizontalAlignment(SwingConstants.CENTER);
        price4Label.setBounds(220, 320, 95, 50);

        //fifth row
        //image icon
        ImageIcon image5Icon = new ImageIcon(getClass().getResource(image5));
        image5Icon = resizeImageIcon(image5Icon, 50, 50);

        JButton image5Button = new JButton(image5Icon);
        image5Button.setPreferredSize(new Dimension(image5Icon.getIconWidth(), image5Icon.getIconHeight()));// image diemantion set to button size
        image5Button.setOpaque(false);
        image5Button.setBorder(null);
        image5Button.setBounds(10, 400, 50, 50);
        image5Button.setFocusPainted(false); // Remove the focus border
        image5Button.setBorderPainted(false);

        //text icon
        JLabel image5Label = new JLabel(item5);
        image5Label.setFont(new Font(item1Font, Font.BOLD, item1FontSize));
        image5Label.setForeground(item1Forground);
        //image5Label.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        //tittleLabel.setOpaque(false);
        image5Label.setHorizontalAlignment(SwingConstants.CENTER);
        image5Label.setBounds(90, 400, 120, 50);

        //price icon
        JLabel price5Label = new JLabel(price5);
        price5Label.setFont(new Font(item1Font, Font.BOLD, item1FontSize));
        price5Label.setForeground(Color.MAGENTA);
        price5Label.setBorder(new RoundedBorder(15,Color.BLUE));
        //tittleLabel.setOpaque(false);
        price5Label.setHorizontalAlignment(SwingConstants.CENTER);
        price5Label.setBounds(220, 400, 95, 50);


        add(tittleLabel);
        add(image1Button);
        add(image1Label);
        add(priceLabel);
        add(image2Button);
        add(image2Label);
        add(price2Label);
        add(image3Button);
        add(image3Label);
        add(price3Label);
        add(image4Button);
        add(image4Label);
        add(price4Label);
        add(image5Button);
        add(image5Label);
        add(price5Label);

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

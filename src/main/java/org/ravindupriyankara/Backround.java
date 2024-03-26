package org.ravindupriyankara;

import javax.swing.*;
import java.awt.*;

public class Backround extends JPanel {
    private ImageIcon backgroundImage;// image icon type variable
    public Backround(ImageIcon backgroundImage){// get baackround image
        this.backgroundImage = backgroundImage; // set background image to protected class variable
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draw background image
        g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
    }
}

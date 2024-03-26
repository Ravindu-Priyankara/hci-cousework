package org.ravindupriyankara;

import java.awt.*;

public class FontLoader {
    // Load and register custom font from file
    protected void loadCustomFont(String fontFilePath) {
        try {
            // Load font file
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream(fontFilePath));

            // Register the font with the GraphicsEnvironment
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);
        } catch (Exception e) {
            e.printStackTrace();
            // Handle font loading errors here
        }
    }
}

package org.ravindupriyankara;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;

public class GradientPanel extends JPanel {
    private Color startColor; //gradient start color
    private Color endColor; //gradient end color

    public GradientPanel(Color startColor, Color endColor) {
        this.startColor = startColor;
        this.endColor = endColor;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Create a gradient paint
        Graphics2D g2d = (Graphics2D) g;
        Point2D start = new Point2D.Float(0, 0);
        Point2D end = new Point2D.Float(0, getHeight());
        float[] dist = {0.0f, 1.0f};
        Color[] colors = {startColor, endColor}; // Use provided colors
        g2d.setPaint(new GradientPaint(start, colors[0], end, colors[1]));
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }
}

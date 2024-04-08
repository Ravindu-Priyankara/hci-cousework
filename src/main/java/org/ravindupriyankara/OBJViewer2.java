package org.ravindupriyankara;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OBJViewer2 extends JPanel {

    private List<Point3D> vertices;
    private double lightX = 1.0; // X-coordinate of the light source
    private double lightY = 1.0; // Y-coordinate of the light source
    private double lightZ = 1.0; // Z-coordinate of the light source

    public OBJViewer2() {
        vertices = new ArrayList<>();
        loadModel("/Users/ravindupriyankara/Home/hci-cousework/src/main/resources/desk2.obj"); // Change "model.obj" to the path of your 3D model file
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.BLACK); // Set line color to black
        // Rotate 180 degrees around the x-axis
        AffineTransform transform = new AffineTransform();
        transform.rotate(Math.PI, getWidth() / 2.0, getHeight() / 2.0);
        g2d.setTransform(transform);

        // Draw the model by connecting vertices
        for (int i = 0; i < vertices.size(); i++) {
            Point3D p1 = vertices.get(i);
            Point3D p2 = vertices.get((i + 1) % vertices.size());
            g2d.setColor(calculateShading(p1, p2));
            g2d.drawLine((int) p1.getX(), (int) p1.getY(), (int) p2.getX(), (int) p2.getY());
        }
    }

    private Color calculateShading(Point3D p1, Point3D p2) {
        // Calculate the vector from the light source to the midpoint of the line segment
        double midX = (p1.getX() + p2.getX()) / 2.0;
        double midY = (p1.getY() + p2.getY()) / 2.0;
        double midZ = (p1.getZ() + p2.getZ()) / 2.0;

        double lightVectorX = lightX - midX;
        double lightVectorY = lightY - midY;
        double lightVectorZ = lightZ - midZ;

        // Normalize the light vector
        double length = Math.sqrt(lightVectorX * lightVectorX + lightVectorY * lightVectorY + lightVectorZ * lightVectorZ);
        lightVectorX /= length;
        lightVectorY /= length;
        lightVectorZ /= length;

        // Calculate the dot product of the normal vector and the light vector
        // Assuming the normal vector is (0, 0, 1) for simplicity
        double dotProduct = lightVectorZ;

        // Use dot product to calculate brightness (0 to 1)
        double brightness = Math.max(0, dotProduct);

        // Use brightness to interpolate between white (maximum brightness) and black (no brightness)
        int shade = (int) (255 * brightness);
        return new Color(shade, shade, shade);
    }

    private void loadModel(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            double minX = Double.MAX_VALUE;
            double minY = Double.MAX_VALUE;
            double maxX = Double.MIN_VALUE;
            double maxY = Double.MIN_VALUE;
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("v ")) {
                    String[] parts = line.split(" ");
                    double x = Double.parseDouble(parts[1]);
                    double y = Double.parseDouble(parts[2]);
                    double z = Double.parseDouble(parts[3]);
                    minX = Math.min(minX, x);
                    minY = Math.min(minY, y);
                    maxX = Math.max(maxX, x);
                    maxY = Math.max(maxY, y);
                    vertices.add(new Point3D(x * 100 + 50, y * 100 + 50, z * 100 ));
                }
            }
            // Center the model within the panel
            double centerX = (minX + maxX) / 2.0;
            double centerY = (minY + maxY) / 2.0;
            double offsetX = getWidth() / 2.0 - centerX;
            double offsetY = getHeight() / 2.0 - centerY;
            for (Point3D vertex : vertices) {
                vertex.translate(offsetX, offsetY);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class Point3D {
        private double x;
        private double y;
        private double z;

        public Point3D(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        public double getZ() {
            return z;
        }

        public void translate(double dx, double dy) {
            x += dx;
            y += dy;
        }
    }

    /*
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("3D Model Viewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(900, 600);
            OBJViewer2 model3DPanel = new OBJViewer2();
            model3DPanel.setBackground(Color.WHITE); // Set background color to white
            frame.add(model3DPanel);
            frame.setVisible(true);
            frame.setLocationRelativeTo(null); // center to window
        });
    }

     */
}


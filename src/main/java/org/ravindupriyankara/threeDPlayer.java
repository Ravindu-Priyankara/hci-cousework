package org.ravindupriyankara;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class threeDPlayer extends JFrame {

    public threeDPlayer() {
        setTitle("Video Player");
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640, 480);
        setLocationRelativeTo(null);

        JButton openButton = new JButton("Open 3d model for click.");
        openButton.addActionListener(e -> {
            // Open the video file using the default media player
            openVideo("/Users/ravindupriyankara/Home/hci-cousework/src/main/resources/out.mp4"); // Replace with your video file path
        });

        getContentPane().add(openButton, BorderLayout.CENTER);
    }

    private void openVideo(String videoPath) {
        File file = new File(videoPath);
        if (file.exists()) {
            try {
                Desktop.getDesktop().open(file);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "File not found: " + videoPath, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /*
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            threeDPlayer player = new threeDPlayer();
            player.setVisible(true);
        });
    }*/
}
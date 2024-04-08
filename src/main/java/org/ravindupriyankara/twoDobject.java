package org.ravindupriyankara;

import javax.swing.*;
import java.awt.*;

public class twoDobject extends JFrame {
    public twoDobject() throws HeadlessException {
        initializeUI();
    }

    private void initializeUI(){
        setSize(900, 600); // define a width and height of window
        setLocationRelativeTo(null);

        //hide tittle bar
        //setUndecorated(true);
        setTitle("Test 2d Object");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        OBJViewer model3DPanel = new OBJViewer();
        model3DPanel.setBackground(Color.WHITE); // Set background color to white
        add(model3DPanel);

    }

    public void display(){
        setVisible(true);
    }
}

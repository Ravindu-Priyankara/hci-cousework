package org.ravindupriyankara;

import javax.swing.*;
import java.awt.*;

public class ObjectDesigner extends JFrame {
    private String object;
    public ObjectDesigner(String object) throws HeadlessException {
        this.object = object;
        InitialiseUI();
    }
    private void InitialiseUI(){
        setSize(900, 600);// window size define
        setLocationRelativeTo(null); // center to window
        setUndecorated(true); //hide title bar
    }
    public void display(){
        setVisible(true);
    }
}

package org.ravindupriyankara;

import javax.swing.*;
import java.awt.*;

public class profilePage extends JFrame {
    public profilePage (){

        InitialiseUI();
    }

    private void InitialiseUI(){
        setTitle("User Profile");
        setSize(250,250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public void display(){
        setVisible(true);
    }
}

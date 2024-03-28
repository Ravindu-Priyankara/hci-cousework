package org.ravindupriyankara;

import javax.swing.*;

public class profilePage extends JFrame {
    public profilePage (){

        InitialiseUI();
    }

    private void InitialiseUI(){
        setTitle("User Profile");
        setSize(250,250);

    }

    public void display(){
        setVisible(true);
    }
}

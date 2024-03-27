package org.ravindupriyankara;

public class Main {
    public static void main(String[] args) {
        /*
        //create object for splashscreen
        SplashScreen splashScreen = new SplashScreen();
        //call display function inside splashscreen
        splashScreen.display();

        // Simulate a task that takes some time

        final int taskDuration = 25000; // milliseconds
        final int progressInterval = 100; // milliseconds
        final int totalSteps = taskDuration / progressInterval;
        int step = 0;

        while (step <= totalSteps) {
            try {
                Thread.sleep(progressInterval); // Simulate some work being done
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Calculate progress percentage
            int progress = (int) ((double) step / totalSteps * 100);
            splashScreen.setProgress(progress);
            splashScreen.setProgressLabel(progress);
            step++;
        }

        // Close the splash screen when the task is complete
        splashScreen.dispose();

        login login = new login();// create class object
        login.display();//call login class after close splashScreen

         */




        userDashboard userDashboard = new userDashboard();
        userDashboard.display();




    }
}
//Avec L'interface Runnable 

package com.example;

import javafx.application.Platform;
import javafx.scene.control.Label;

public class ChronoThreadFx implements Runnable {
    private boolean running=true;
    private int seconds=0;
    private final Label timeLabel;

    public ChronoThreadFx(Label timeLabel){
        this.timeLabel=timeLabel;
    }

    @Override
    public void run()  {
        try{
        while(running){
            Thread.sleep(1000);
            seconds++;
            int h=seconds/3600;
            int m=seconds/60;
            int s=seconds;

            Platform.runLater(timeLabel.setText(String.format(("%02d:%02d:%02d", h, m, s))));


            }
        }
        catch(InterruptedException e){
        }

        public void stopChrono(){
             running=false;
        }
    }






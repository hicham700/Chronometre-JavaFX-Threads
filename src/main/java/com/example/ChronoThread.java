package com.example;

import javafx.application.Platform;
import javafx.scene.control.Label;

public class ChronoThread extends Thread {

    private int seconds = 0;
    private volatile boolean running = true;
    private final Label timeLabel;

    public ChronoThread(Label timeLabel) {
        this.timeLabel = timeLabel;
    }

    @Override
    public void run() {
        try {
            while (running) {
                Thread.sleep(1000);
                seconds++;

                int hrs = seconds / 3600;
                int mins = (seconds % 3600) / 60;
                int secs = seconds % 60;

                String time = String.format("%02d:%02d:%02d", hrs, mins, secs);

                Platform.runLater(() -> timeLabel.setText(time));
            }
        } catch (InterruptedException e) {
        }
    }

    public void stopChrono() {
        running = false;
    }

    public void resetChrono() {
        seconds = 0;
        Platform.runLater(() -> timeLabel.setText("00:00:00"));
    }
}

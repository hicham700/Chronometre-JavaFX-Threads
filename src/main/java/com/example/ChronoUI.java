package com.example;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChronoUI extends Application {
    ChronoThread chronoThread;

    @Override
    public void start(Stage stage) {

         

        // Label du chrono
        Label timeLabel = new Label("00:00:00");
        timeLabel.setStyle("-fx-font-size: 36px;");

        // Boutons
        Button startBtn = new Button("Démarrer");
        Button stopBtn = new Button("Stop");
        Button resetBtn = new Button("Reset");

       startBtn.setOnAction(e -> {
    if (chronoThread == null || !chronoThread.isAlive()) {
        chronoThread = new ChronoThread(timeLabel);
        chronoThread.start();
    }
});

stopBtn.setOnAction(e -> {
    if (chronoThread != null) {
        chronoThread.stopChrono();
    }
});

resetBtn.setOnAction(e -> {
    if (chronoThread != null) {
        chronoThread.stopChrono();
        chronoThread = null;
    }
    timeLabel.setText("00:00:00");
});




        // Layout boutons
        HBox buttons = new HBox(15, startBtn, stopBtn, resetBtn);
        buttons.setAlignment(Pos.CENTER);

        // Layout principal
        VBox root = new VBox(25, timeLabel, buttons);
        root.setAlignment(Pos.CENTER);

        // Scene
        Scene scene = new Scene(root, 350, 200);

        stage.setTitle("Chronomètre");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

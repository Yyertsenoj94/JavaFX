package org.example;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.media.VideoTrack;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * JavaFX App
 */
public class App extends Application {


    Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        Button play = new Button("PLAY");
        Button stop = new Button("STOP");
        Button change = new Button("CHANGE");

        Pane pane = new Pane();
        pane.setPrefSize(500, 500);
        pane.setStyle("-fx-background-color: blue");

        HBox hBox = new HBox();
        hBox.setPrefSize(pane.getPrefWidth(), pane.getPrefHeight());
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(30);
        hBox.getChildren().add(play);
        hBox.getChildren().add(stop);
        hBox.getChildren().add(change);



        //initial setting of the song.

        MusicPlayer musicPlayer = new MusicPlayer();
        musicPlayer.setSong("intro");

        Thread player = new Thread(new Player(musicPlayer));

        //
        play.setOnMouseClicked(e -> {
            player.start();
        });

        stop.setOnMouseClicked(e -> {
            musicPlayer.pause();
        });

        change.setOnMouseClicked(e -> {
            musicPlayer.setSong("different");
            musicPlayer.resume();
        });



        pane.getChildren().add(hBox);
        play.setStyle("");





        scene = new Scene(pane);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toString());










        //======================================how to show video playing.
//        URL mediaUrl = getClass().getResource("/movie.m4v");
//        Media media = new Media(mediaUrl.toExternalForm());
//        MediaPlayer player = new MediaPlayer(media);
//        MediaView view = new MediaView();
//        view.setMediaPlayer(player);
//        view.getMediaPlayer().play();
//        Pane pane = new Pane();
//        pane.setPrefSize(view.getFitHeight(), view.getFitHeight());
//        pane.getChildren().add(view);
//        scene = new Scene(pane);
        //===========================================================

        stage.setScene(scene);
        stage.show();





        //writing to external file.====================================================================
//        Path path = Path.of("./WriteToMe.txt");
//        BufferedWriter bw = Files.newBufferedWriter(path);
//        bw.write("Testing 456");
//        bw.close();
//        ==============================================================================================
//
//        //read from external file=====================================================================
//        FileInputStream fis = new FileInputStream(path.toString());
//        BufferedReader in = new BufferedReader(new InputStreamReader(fis));
//        String readData = in.readLine();
//        System.out.println(readData);
          //==============================================================================================
//
//        Path path = Path.of("./WriteToMe.txt");
//        BufferedWriter bw = Files.newBufferedWriter(path);
//        bw.write("Testing 456");
//        bw.close();
//        FileInputStream fis = new FileInputStream(path.toString());
//        BufferedReader in = new BufferedReader(new InputStreamReader(fis));
//        String readData = in.readLine();
//        System.out.println(readData);
//        ==============================================================================================

    }

//    static void setRoot(String fxml) throws IOException {
//        scene.setRoot(loadFXML(fxml));
//    }


    public static void main(String[] args) {
        launch();
    }

}
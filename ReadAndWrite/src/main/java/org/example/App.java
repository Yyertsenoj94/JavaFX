package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

        URL mediaUrl = getClass().getResource("/movie.m4v");


        Media media = new Media(mediaUrl.toExternalForm());

        MediaPlayer player = new MediaPlayer(media);

        MediaView view = new MediaView();
        view.setMediaPlayer(player);

        view.getMediaPlayer().play();
        Pane pane = new Pane();
        pane.setPrefSize(view.getFitHeight(), view.getFitHeight());
        pane.getChildren().add(view);
        scene = new Scene(pane);

        stage.setScene(scene);
        stage.show();


//
//        //reading a file from resources.
//        ClassLoader cl = App.class.getClassLoader();
//        System.out.println(getClass().getClassLoader().getResource("map.txt"));
//        System.out.println(getClass().getResource("primary.fxml").getPath());
////        File file2 = new File(cl.getResource("../../resources/org.example/map.txt").getFile());
////        if(file2.exists()){
////            System.out.println("Exists");
////        }else{
////            System.out.println("Doesn't exit");
////        }
//
//        File file = new File(App.class.getResource("map.txt").getFile());
//        Scanner scanner = new Scanner(file);
//
//        String test = scanner.nextLine();
//        System.out.println(test);

//        Path path = Path.of(App.class.getResourceAsStream("map.txt").toString());
//        BufferedReader br = Files.newBufferedReader(path);
//        String test = br.readLine();
//        System.out.println(test);

        //writing to external file.
<<<<<<< HEAD
//        Path path = Path.of("./WriteToMe.txt");
//        BufferedWriter bw = Files.newBufferedWriter(path);
//        bw.write("Testing 456");
//        bw.close();
//
//        //read from external file
//        FileInputStream fis = new FileInputStream(path.toString());
//        BufferedReader in = new BufferedReader(new InputStreamReader(fis));
//        String readData = in.readLine();
//        System.out.println(readData);
=======
        Path path = Path.of("./WriteToMe.txt");
        BufferedWriter bw = Files.newBufferedWriter(path);
        bw.write("Testing 456");
        bw.close();
        FileInputStream fis = new FileInputStream(path.toString());
        BufferedReader in = new BufferedReader(new InputStreamReader(fis));
        String readData = in.readLine();
        System.out.println(readData);

    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }
>>>>>>> parent of 0ad501f... adding all updates for pacman

    }

    public static void main(String[] args) {
        launch();
    }

}
package com.example.scrollpanewiki;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        InputStream stream = new FileInputStream("D:\\2DAM\\Desarrollo de interfaces\\Tema1\\coche2.jpg");
        Image image = new Image(stream);

        ImageView imageView = new ImageView();

        imageView.setImage(image);

        imageView.setX(5);
        imageView.setY(0);
        imageView.setFitWidth(595);
        imageView.setPreserveRatio(true);

        ScrollPane scroll = new ScrollPane();
        scroll.setPrefSize(595, 200);

        scroll.setContent(imageView);

        StackPane root = new StackPane();
        root.getChildren().addAll(scroll);
        Scene scene = new Scene(root, 595, 200, Color.BEIGE);
        stage.setTitle("ScrollPane Wiki");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}
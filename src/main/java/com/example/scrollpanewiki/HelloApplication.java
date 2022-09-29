package com.example.scrollpanewiki;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class HelloApplication extends Application {
    private boolean scrollToBottom = false;
    private boolean scrollToTop = false;

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(final Stage stage) throws Exception
    {

        final VBox root = new VBox();
        final ScrollPane scrollPane = new ScrollPane();

        final VBox vBox = new VBox();
        vBox.setAlignment(Pos.BOTTOM_CENTER);

        scrollPane.setContent(vBox);

        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        Button button = new Button("Añadir Texto");
        Button button3 = new Button("Desplazarse Arriba");

        button3.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                scrollToTop = true;
                scrollPane.setVvalue(scrollPane.getVmin());
                System.out.println("Valor Minimo= "+scrollPane.getVmin() + "; Valor Maximo = " + scrollPane.getVmax() + "; Valor General" + scrollPane.getVvalue());
            }
        });

        button.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                vBox.getChildren().add(new Label("Hola"));
                scrollToBottom = true;
                //System.out.println(scrollPane.getVmin() + "; max = " + scrollPane.getVmax() + "; " + scrollPane.getVvalue());
            }
        });

        scrollPane.setVvalue(scrollPane.getVmax());
        scrollPane.vvalueProperty().addListener(new ChangeListener<Number>()
        {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
            {
                if(scrollToBottom)
                {
                    scrollPane.setVvalue(scrollPane.getVmax());
                    scrollToBottom = false;
                }

                if(newValue.doubleValue() ==0)
                {
                    vBox.getChildren().add(new Label("Hola"));
                    System.out.println("Minimo Valor ="+scrollPane.getVmin());
                    //scrollPane.setVvalue(scrollPane.getVmin());
                    scrollToTop = true;
                    System.out.println("Ahora se ve el historial del chat");
                }
            }
        });

        Button button2 = new Button("Desplazarse Abajo");
        button2.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                scrollPane.setVvalue(Double.MAX_VALUE);
            }
        });

        InputStream stream = new FileInputStream("D:\\2DAM\\Desarrollo de interfaces\\Tema1\\coche2.jpg");
        Image image = new Image(stream);

        ImageView imageView = new ImageView();

        imageView.setImage(image);

        imageView.setX(5);
        imageView.setY(0);
        imageView.setFitWidth(595);
        imageView.setPreserveRatio(true);

        ScrollPane scroll = new ScrollPane();

        // Propiedades
        scroll.contentProperty();
        scroll.fitToHeightProperty();
        scroll.fitToWidthProperty();
        scroll.hbarPolicyProperty();
        scroll.pannableProperty();

        root.getChildren().addAll(scrollPane, button, button2, button3);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
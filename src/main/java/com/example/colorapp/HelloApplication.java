package com.example.colorapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.paint.Color;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.text.Text;
import javafx.scene.text.Font;

import java.io.IOException;

public class HelloApplication extends Application {
    Text text = new Text("Adjust the sliders to: SHOW COLORS!");
    ScrollBar red = new ScrollBar();
    ScrollBar green = new ScrollBar();
    ScrollBar blue = new ScrollBar();
    ScrollBar transparency = new ScrollBar();

    @Override
    public void start(Stage stage) throws IOException {
        //Set Up Stage
        text.setFont(new Font("Monospaced", 30));
        StackPane textPane = new StackPane(text);
        textPane.setPadding(new Insets(20, 10, 5, 10));

        //Scroll Bar Setup
        red.setMin(0.0);
        red.setMax(1.0);
        red.setPrefHeight(20);

        green.setMin(0.0);
        green.setMax(1.0);
        green.setPrefHeight(20);

        blue.setMin(0.0);
        blue.setMax(1.0);
        blue.setPrefHeight(20);

        transparency.setMin(0.0);
        transparency.setMax(1.0);
        transparency.setPrefHeight(20);

        //Color Changers
        red.valueProperty().addListener(ov -> setColor());
        green.valueProperty().addListener(ov -> setColor());
        blue.valueProperty().addListener(ov -> setColor());
        transparency.valueProperty().addListener(ov -> setColor());
        transparency.setValue(1);

        // Create Grid
        GridPane scrollPane = new GridPane();
        scrollPane.setAlignment(Pos.CENTER);
        scrollPane.setHgap(5);
        scrollPane.setVgap(5);

        //Create Labels for scrollers
        scrollPane.add(new Label("Red"), 0, 0);
        scrollPane.add(red, 1, 0);

        scrollPane.add(new Label("Green"), 0, 1);
        scrollPane.add(green, 1, 1);

        scrollPane.add(new Label("Blue"), 0, 2);
        scrollPane.add(blue, 1, 2);

        scrollPane.add(new Label("Transparency"), 0, 3);
        scrollPane.add(transparency, 1, 3);

        //Place Nodes
        BorderPane pane = new BorderPane();
        pane.setTop(textPane);
        pane.setCenter(scrollPane);

        //Create and set up Stage
        Scene scene = new Scene(pane, 1000, 1000);
        stage.setTitle("Color App!");
        stage.setScene(scene);
        stage.show();


    }

    public void setColor() {
        text.setFill(new Color(red.getValue(), green.getValue(), blue.getValue(), transparency.getValue()));
    }

    public static void main(String[] args) {
        launch();


    }
}

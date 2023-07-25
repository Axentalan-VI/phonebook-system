package com.example;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;



/**
 * JavaFX App
 */


 
public class App extends Application {

    private static Scene scene;

  static node root;

    



  
    public void start(Stage stage) throws IOException {

        
        Label title = new Label("Phone Book");
        title.setAlignment(Pos.CENTER);
        title.setMaxHeight(1.7976931348623157E308);
        title.setMaxWidth(1.7976931348623157E308);
        title.setPrefHeight(54);
        title.setPrefWidth(682);
        title.setStyle("-fx-background-color: #90450b;");
        title.setTextAlignment(TextAlignment.CENTER);
        title.setTextFill(Color.WHITE);
        title.setFont(new Font("Arial Bold", 24));

        
        ColumnConstraints nameConstraints = new ColumnConstraints();
        nameConstraints.setHgrow(Priority.SOMETIMES);
        nameConstraints.setMinWidth(10);
        nameConstraints.setPrefWidth(100);
        ColumnConstraints numberConstraints = new ColumnConstraints();
        numberConstraints.setHgrow(Priority.SOMETIMES);
        numberConstraints.setMinWidth(10);
        numberConstraints.setPrefWidth(100);
        ColumnConstraints emailConstraints = new ColumnConstraints();
        emailConstraints.setHgrow(Priority.SOMETIMES);
        emailConstraints.setMinWidth(10);
        emailConstraints.setPrefWidth(100);

        RowConstraints nameRowConstraints = new RowConstraints();
        nameRowConstraints.setMinHeight(10);
        nameRowConstraints.setPrefHeight(30);
        nameRowConstraints.setVgrow(Priority.SOMETIMES);
        RowConstraints numberRowConstraints = new RowConstraints();
        numberRowConstraints.setMinHeight(10);
        numberRowConstraints.setPrefHeight(30);
        numberRowConstraints.setVgrow(Priority.SOMETIMES);
        RowConstraints emailRowConstraints = new RowConstraints();
        emailRowConstraints.setMinHeight(10);
        emailRowConstraints.setPrefHeight(30);
        emailRowConstraints.setVgrow(Priority.SOMETIMES);


        Label nameLabel = new Label("Name");
        nameLabel.setAlignment(Pos.CENTER);
        nameLabel.setPrefHeight(110);
        nameLabel.setPrefWidth(208);
        nameLabel.setStyle("-fx-background-color: #90450b;");
        nameLabel.setTextFill(Color.WHITE);
        nameLabel.setFont(new Font("Arial Bold", 14));

        Label numberLabel = new Label("Contact Number");
        numberLabel.setAlignment(Pos.CENTER);
        numberLabel.setPrefHeight(142);
        numberLabel.setPrefWidth(163);
        numberLabel.setStyle("-fx-background-color: #90450b;");
        numberLabel.setTextFill(Color.WHITE);
        numberLabel.setFont(new Font("Arial Bold", 14));

        Label emailLabel = new Label("Email");
        emailLabel.setAlignment(Pos.CENTER);
        emailLabel.setLayoutX(155);
        emailLabel.setLayoutY(10);
        emailLabel.setPrefHeight(142);
        emailLabel.setPrefWidth(163);
        emailLabel.setStyle("-fx-background-color: #90450b;");
        emailLabel.setTextFill(Color.WHITE);
        emailLabel.setFont(new Font("Arial Bold", 14));

        Label name = new Label();
        name.setAlignment(Pos.CENTER);
        name.setPrefHeight(142);
        name.setPrefWidth(163);
        name.setTextFill(Color.BLACK);
        name.setFont(new Font("Arial ", 12));

        Label number = new Label();
        number.setAlignment(Pos.CENTER);
        number.setPrefHeight(142);
        number.setPrefWidth(163);
        number.setTextFill(Color.BLACK);
        number.setFont(new Font("Arial ", 13));

        Label email = new Label();
        email.setAlignment(Pos.CENTER);
        email.setPrefHeight(142);
        email.setPrefWidth(163);
        email.setTextFill(Color.BLACK);
        email.setFont(new Font("Arial ", 13));


        GridPane gridPane = new GridPane();
        gridPane.setLayoutX(124);
        gridPane.setLayoutY(168);
        gridPane.setPrefHeight(202);
        gridPane.setPrefWidth(435);
        gridPane.getColumnConstraints().addAll(nameConstraints,numberConstraints,emailConstraints);
        gridPane.getRowConstraints().addAll(nameRowConstraints,numberRowConstraints,emailRowConstraints);
        gridPane.addColumn(0, nameLabel);
        gridPane.addColumn(1, numberLabel);
        gridPane.addColumn(2, emailLabel);


        if(root!=null){
        name.setText(root.name);
        gridPane.add(name, 0, 1);
       number.setText(root.number);
        gridPane.add(number, 1, 1);
        email.setText(root.email);
        gridPane.add(email, 2, 1);}
        
        
        
        Pane pane = new Pane();
        pane.setPrefHeight(597);
        pane.setPrefWidth(682);
        pane.setStyle("-fx-background-color: white;");
        pane.getChildren().add(title);
        pane.getChildren().add(gridPane);
        

        scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(node ptr) {
        
        root=ptr;
        launch();
    }

}
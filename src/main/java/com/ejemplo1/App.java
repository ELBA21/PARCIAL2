package com.ejemplo1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage ventana) throws IOException {
        ventana.setTitle("ULAGOS CINEMA ULTRA CAPITALISTA");
        HBox contendorH = new HBox();
        VBox contenedor = new VBox();
        Label texto1 = new Label("Hola, este el ejemplo");
        GridPane gridPane = new GridPane();
            gridPane.setHgap(5); // Espacio horizontal entre las celdas
            gridPane.setVgap(5); // Espacio vertical entre las celdas

        Button botonA1 = new Button("A1");//Creacion de boton
        GridPane.setConstraints(botonA1, 0, 0); //Asignacion de boton en grid
        Button botonA2 = new Button("A2");
        GridPane.setConstraints(botonA2, 1, 0);
        Button botonA3 = new Button("A3");
        GridPane.setConstraints(botonA3, 2, 0);
        Button botonA4 = new Button("A4");
        GridPane.setConstraints(botonA4, 3, 0);
        Button botonA5 = new Button("A5");
        GridPane.setConstraints(botonA5, 4, 0);

        Button botonB1 = new Button("B1");
        GridPane.setConstraints(botonB1, 0, 1);
        Button botonB2 = new Button("B2");
        GridPane.setConstraints(botonB2, 1, 1);
        Button botonB3 = new Button("B3");
        GridPane.setConstraints(botonB3, 2, 1);
        Button botonB4 = new Button("B4");
        GridPane.setConstraints(botonB4, 3, 1);
        Button botonB5 = new Button("B5");
        GridPane.setConstraints(botonB5, 4, 1);

        Button botonC1 = new Button("C1");
        GridPane.setConstraints(botonC1, 0, 2);
        Button botonC2 = new Button("C2");
        GridPane.setConstraints(botonC2, 1, 2);
        Button botonC3 = new Button("C3");
        GridPane.setConstraints(botonC3, 2, 2);
        Button botonC4 = new Button("C4");
        GridPane.setConstraints(botonC4, 3, 2);
        Button botonC5 = new Button("C5");
        GridPane.setConstraints(botonC5, 4, 2);
        Button botonD1 = new Button("D1");
        GridPane.setConstraints(botonD1, 0, 3);
        Button botonD2 = new Button("D2");
        GridPane.setConstraints(botonD2, 1, 3);
        Button botonD3 = new Button("D3");
        GridPane.setConstraints(botonD3, 2, 3);
        Button botonD4 = new Button("D4");
        GridPane.setConstraints(botonD4, 3, 3);
        Button botonD5 = new Button("D5");
        GridPane.setConstraints(botonD5, 4, 3);

        Button botonE1 = new Button("E1");
        GridPane.setConstraints(botonE1, 0, 4);
        Button botonE2 = new Button("E2");
        GridPane.setConstraints(botonE2, 1, 4);
        Button botonE3 = new Button("E3");
        GridPane.setConstraints(botonE3, 2, 4);
        Button botonE4 = new Button("E4");
        GridPane.setConstraints(botonE4, 3, 4);
        Button botonE5 = new Button("E5");
        GridPane.setConstraints(botonE5, 4, 4);
//======EN ESTA SECCION PODRAS MODIFICAR LAS FUNCIONES DE LOS BOTONES DADOS=========
        botonA1.setOnAction( e -> {
            System.out.println("TEST");
        });
        botonA2.setOnAction( e -> {
            System.out.println("TEST A2");
        } );       

//=====================================================================================
        contendorH.getChildren().addAll(texto1);
        gridPane.getChildren().addAll(botonA1, botonA2, botonA3, botonA4, botonA5, botonB1, botonB2, botonB3, botonB4, botonB5, botonC1, botonC2, botonC3, botonC4, botonC5, botonD1, botonD2, botonD3, botonD4, botonD5, botonE1, botonE2, botonE3, botonE4, botonE5);
        contenedor.getChildren().addAll(texto1, gridPane);

        Scene escena = new Scene(contenedor, 500, 500);

        ventana.setScene(escena);
        ventana.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
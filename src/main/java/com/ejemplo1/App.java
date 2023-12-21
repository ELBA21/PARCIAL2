package com.ejemplo1;

import javafx.application.Application;
//import javafx.beans.Observable;
//import javafx.beans.value.ChangeListener;
//import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
//import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

import java.io.IOException;
//import java.util.ArrayList;
/**
 * JavaFX App
 */

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage ventana) throws IOException {
        ventana.setTitle("ULAGOS CINEMA ULTRA CAPITALISTA");
        VBox contenedor = new VBox();
        Label texto1 = new Label("Hola, este el ejemplo");
        GridPane gridPane = new GridPane();
            gridPane.setHgap(5); // Espacio horizontal entre las celdas
            gridPane.setVgap(5); // Espacio vertical entre las celdas
//VENTANA DE INICIO
//===========================================================================
        HBox cabezera = new HBox();
            VBox contenedorA1 = new VBox();
                Label espacioa1 = new Label("      ");
                Label espacioa2 = new Label("      ");
                Label espacioa3 = new Label("      ");
                Label espacioa4 = new Label("      ");
                VBox Fechas = new VBox();
                    Label FechaDia = new Label("Dia");
                    ObservableList<Integer> dias = FXCollections.observableArrayList(//Creamos Array pa usarlo luego
                        1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31);
                    ComboBox<Integer> comboDias = new ComboBox<>(dias); //Creamos lista desplegable, que recibe el array de ahora
                    comboDias.setPromptText("Seleccione el dia"); //El texto que sale antes de desplegar
                    comboDias.setOnAction(e -> {
                        int diaSeleccionado = comboDias.getSelectionModel().getSelectedItem(); //Guarda el dato de la lista en una variable YEI! 
                        System.out.println("Selected Option: " + diaSeleccionado); //Escribe en la terminal, solo de prueba, luego llamamos un set algo
                    });


                    Label FechaMes = new Label("Mes");
                    ObservableList<Integer> Mes = FXCollections.observableArrayList(
                        1,2,3,4,5,6,7,8,9,10,11,12);
                    ComboBox<Integer> comboMes = new ComboBox<>(Mes);
                    comboMes.setPromptText("Selecione el Mes");
                    comboMes.setOnAction(e ->{
                        int mesSeleccionado = comboDias.getSelectionModel().getSelectedItem();
                        System.out.println("Mes selecionado: " + mesSeleccionado);
                    });

                    Label FechaAño = new Label("Año");
                    ObservableList<Integer> Años = FXCollections.observableArrayList(
                        2023,2024,2025,2026,2027,2028,2029,2030,2031,2032,2033);
                    ComboBox<Integer> comboAño = new ComboBox<>(Años);
                    comboAño.setPromptText("Seleccione el año");
                    comboAño.setOnAction( e -> {
                        int añoSeleccionado = comboAño.getSelectionModel().getSelectedItem();
                        System.out.println("Año seleccionado: "  + añoSeleccionado);
                    });
                    Fechas.getChildren().addAll(FechaDia, comboDias, FechaMes, comboMes, FechaAño, comboAño);
                contenedorA1.getChildren().addAll(espacioa1,espacioa2,espacioa3, espacioa4,Fechas);

            VBox contenedorA2 = new VBox();
                Label CINE = new Label("CINE");
                CINE.setStyle("-fx-font-size: 64px; -fx-font-weight: bold;-fx-alignment: center;");
                VBox listaPelicuas = new VBox();
                Label ejemplo1 = new Label("Kaguya-sama movie");
                Label ejemplo2 = new Label("EGG KING");
                Label ejemplo3 = new Label("EGG KING RETURN!");
                listaPelicuas.getChildren().addAll(ejemplo1, ejemplo2, ejemplo3);
                contenedorA2.getChildren().addAll(CINE, listaPelicuas);

            VBox contenedorA3 = new VBox();
                Label espaciob1 = new Label("      ");
                Label espaciob2 = new Label("      ");
                Label espaciob3 = new Label("      ");
                Label espaciob4 = new Label("      ");
                Label precioT = new Label("PRECIO");
                Label precio = new Label("3000");
                Button botonIncio = new Button("Click para Inciar");
                contenedorA3.getChildren().addAll(espaciob1,espaciob2, espaciob3, espaciob4, precioT,precio, botonIncio);
        
            cabezera.getChildren().addAll(contenedorA1, contenedorA2, contenedorA3);
            HBox.setMargin(botonIncio, new Insets(100,0,0,0));
            Scene inicio = new Scene(cabezera,500,200);
            ventana.setScene(inicio);
//Asignacion de Peliculas
//============================================================================
        HBox cabezera2 = new HBox();
            VBox sala1 = new VBox();
                Label CinemaS1 = new Label("SALA 1");
                CinemaS1.setStyle("-fx-font-size: 12px; -fx-font-weight: bold;");
                Label matineS1 = new Label("MATINE");
                //ComboBox<String> matineS1ComboBox = new ComboBox<>();
                //matineS1ComboBox.getItems().addAll(Dia.getPeliculas);
                TextField matineS1TextField = new TextField("Nombre pelicula");
                Label vermutS1 = new Label("Vermut");
                TextField vermutS1TextField = new TextField("Nombre pelicula");
                Label vespertinoS1 = new Label("Vespertino");
                TextField vespertinoS1TextField = new TextField("Nombre pelicula");
                sala1.getChildren().addAll(CinemaS1, matineS1,matineS1TextField, vermutS1, vermutS1TextField, vespertinoS1, vespertinoS1TextField);
            VBox sala2 = new VBox();
                Label CinemaS2 = new Label("SALA 2");
                CinemaS2.setStyle("-fx-font-size: 12px; -fx-font-weight: bold;");
                Label matineS2 = new Label("MATINE");
                TextField matineS2TextField = new TextField("Nombre pelicula");
                Label vermutS2 = new Label("Vermut");
                TextField vermutS2TextField = new TextField("Nombre pelicula");
                Label vespertinoS2 = new Label("Vespertino");
                TextField vespertinoS2TextField = new TextField("Nombre pelicula");
                sala2.getChildren().addAll(CinemaS2, matineS2,matineS2TextField, vermutS2, vermutS2TextField, vespertinoS2, vespertinoS2TextField);

            VBox sala3 = new VBox();
                Label CinemaS3 = new Label("SALA 3");
                CinemaS3.setStyle("-fx-font-size: 12px; -fx-font-weight: bold;-fx-alignment: center;");
                Label matineS3 = new Label("MATINE");
                TextField matineS3TextField = new TextField("Nombre pelicula");
                Label vermutS3 = new Label("Vermut");
                TextField vermutS3TextField = new TextField("Nombre pelicula");
                Label vespertinoS3 = new Label("Vespertino");
                TextField vespertinoS3TextField = new TextField("Nombre pelicula");
                Button botonSiguiente = new Button("Siguiente");
                sala3.getChildren().addAll(CinemaS3, matineS3,matineS3TextField, vermutS3, vermutS3TextField, vespertinoS3, vespertinoS3TextField, botonSiguiente);
                botonSiguiente.setOnAction( e -> {
                    System.out.println("TEST");
                });
        cabezera2.getChildren().addAll(sala1,sala2,sala3);
        Scene AsignacionPeliculas = new Scene(cabezera2, 500,200);
    botonIncio.setOnAction( e -> {
        ventana.setScene(AsignacionPeliculas);
    });
//Centro de Compras
//============================================================================
        HBox cabezera3 = new HBox();
            VBox BSala1 = new VBox();
                Label cCompras = new Label("Centro de Compras");
                cCompras.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;-fx-alignment: center;");
                Label Matine = new Label("Matine");
                Matine.setStyle("-fx-font-size: 16px;-fx-alignment: center;");
                Label Vermut = new Label("Vermut");
                Vermut.setStyle("-fx-font-size: 16px;-fx-alignment: center;");
                Label Vespertino = new Label("Vespertino");
                Vespertino.setStyle("-fx-font-size: 16px;-fx-alignment: center;");
                BSala1.getChildren().addAll(cCompras,Matine, Vermut, Vespertino);
            VBox BSala2 = new VBox();
                Label BCinemaS1 = new Label("   Sala 1");
                Button EggKing1 = new Button("Egg King");
                Button KaguyaSama1 = new Button(" Kaguya ");
                Button UP1 = new Button("  UP ");
                BSala2.getChildren().addAll(BCinemaS1, EggKing1, KaguyaSama1,UP1);
            VBox BSala3 = new VBox();
                Label BCinemaS2 = new Label("   Sala 2");
                Button KaguyaSama2 = new Button(" Kaguya ");
                Button EggKing2 = new Button("EGG KING");
                Button UP2 = new Button(" UP ");
                BSala3.getChildren().addAll(BCinemaS2,KaguyaSama2, EggKing2, UP2);
            VBox BSala4 = new VBox();
                Label BCinemaS3  = new Label("    Sala 3");
                Button UP3 = new Button("  UP  ");
                Button EggKing3 = new Button("EggKing");
                Button KaguyaSama3 = new Button(" Kaguya ");
                Button Estadisticas = new Button("Estadisticas");
                BSala4.getChildren().addAll(BCinemaS3,UP3, EggKing3, KaguyaSama3, Estadisticas);

        cabezera3.getChildren().addAll(BSala1, BSala2, BSala3, BSala4);
    Scene centroDeCompras = new Scene(cabezera3,500, 200 );
    botonSiguiente.setOnAction( e -> {  // Se declara accion del boton
        ventana.setScene(centroDeCompras);
    });
//MATRIZ DE ASIENTOS
//========================================================================
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
        botonA1.setOnAction( e -> {System.out.println("TEST A1");});
        botonA2.setOnAction( e -> {System.out.println("TEST A2");});
        botonA3.setOnAction( e -> {System.out.println("TEST A3");});
        botonA4.setOnAction( e -> {System.out.println("TEST A4");}); 
        botonA5.setOnAction( e -> {System.out.println("TEST A5");});

        botonB1.setOnAction( e -> {System.out.println("TEST B1");});
        botonB2.setOnAction( e -> {System.out.println("TEST B2");});
        botonB3.setOnAction( e -> {System.out.println("TEST B3");});
        botonB4.setOnAction( e -> {System.out.println("TEST B4");}); 
        botonB5.setOnAction( e -> {System.out.println("TEST B5");});

        botonC1.setOnAction( e -> {System.out.println("TEST C1");});
        botonC2.setOnAction( e -> {System.out.println("TEST C2");});
        botonC3.setOnAction( e -> {System.out.println("TEST C3");});
        botonC4.setOnAction( e -> {System.out.println("TEST C4");}); 
        botonC5.setOnAction( e -> {System.out.println("TEST C5");});

        botonD1.setOnAction( e -> {System.out.println("TEST D1");});
        botonD2.setOnAction( e -> {System.out.println("TEST D2");});
        botonD3.setOnAction( e -> {System.out.println("TEST D3");});
        botonD4.setOnAction( e -> {System.out.println("TEST D4");}); 
        botonD5.setOnAction( e -> {System.out.println("TEST D5");});

        botonE1.setOnAction( e -> {System.out.println("TEST E1");});
        botonE2.setOnAction( e -> {System.out.println("TEST E2");});
        botonE3.setOnAction( e -> {System.out.println("TEST E3");});
        botonE4.setOnAction( e -> {System.out.println("TEST E4");}); 
        botonE5.setOnAction( e -> {System.out.println("TEST E5");});

//=====================================================================================
        gridPane.getChildren().addAll(botonA1, botonA2, botonA3, botonA4, botonA5, botonB1, botonB2, botonB3, botonB4, botonB5, botonC1, botonC2, botonC3, botonC4, botonC5, botonD1, botonD2, botonD3, botonD4, botonD5, botonE1, botonE2, botonE3, botonE4, botonE5);
        contenedor.getChildren().addAll(texto1, gridPane);
        Scene matrizAsiento = new Scene(contenedor, 500, 500);
        EggKing1.setOnAction(e -> {ventana.setScene(matrizAsiento);});
        KaguyaSama1.setOnAction(e -> {ventana.setScene(matrizAsiento);});
        UP1.setOnAction(e -> {ventana.setScene(matrizAsiento);});

        KaguyaSama2.setOnAction(e -> {ventana.setScene(matrizAsiento);});
        EggKing2.setOnAction(e -> {ventana.setScene(matrizAsiento);});
        UP2.setOnAction(e -> {ventana.setScene(matrizAsiento);});

        UP3.setOnAction(e -> {ventana.setScene(matrizAsiento);});
        EggKing3.setOnAction(e -> {ventana.setScene(matrizAsiento);});
        KaguyaSama3.setOnAction(e -> {ventana.setScene(matrizAsiento);});















        
        ventana.show();
    }


    //Dia dia = new Dia();
    public static void main(String[] args) {
        launch();
    }

}
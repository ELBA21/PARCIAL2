package com.ejemplo1;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
//import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;
//import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import java.util.ArrayList;
import java.io.IOException;
// ventana emergente
import javafx.stage.Modality;
/**
 * JavaFX App
 */

public class App extends Application {

    private static Scene scene;
    private ObservableList<String> listaPeliculas = FXCollections.observableArrayList(); 
    //Esta es una mauski herramienta misteriosa que usaremos mas tarde AJ
    Dia[] diasAux = new Dia[7];

    String[][] peliculas = new String[3][3];
    int[] Fecha = new int[3];
    int Precio;
    int i, j;
    @Override
    public void start(Stage ventana) throws IOException {
        ventana.setTitle("ULAGOS CINEMA ULTRA CAPITALISTA");
        
// ACA DEJARE Declarare Unos cuantos botones de la pagina de Compras
//====================================================================
        //nuronyan los cambio
        //Andresitoxd69 lo movió a la linea 233
//==================================================
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
                        Fecha[0] = comboDias.getSelectionModel().getSelectedItem(); //Guarda el dato de la lista en una variable YEI! 
                        System.out.println("Selected Option: " + Fecha[0]); //Escribe en la terminal, solo de prueba, luego llamamos un set algo
                    });


                    Label FechaMes = new Label("Mes");
                    ObservableList<Integer> Mes = FXCollections.observableArrayList(
                        1,2,3,4,5,6,7,8,9,10,11,12);
                    ComboBox<Integer> comboMes = new ComboBox<>(Mes);
                    comboMes.setPromptText("Selecione el Mes");
                    comboMes.setOnAction(e ->{
                        Fecha[1] = comboDias.getSelectionModel().getSelectedItem();
                        System.out.println("Mes selecionado: " + Fecha[1]);
                    });

                    Label FechaAño = new Label("Año");
                    ObservableList<Integer> Años = FXCollections.observableArrayList(
                        2023,2024,2025,2026,2027,2028,2029,2030,2031,2032,2033);
                    ComboBox<Integer> comboAño = new ComboBox<>(Años);
                    comboAño.setPromptText("Seleccione el año");
                    comboAño.setOnAction( e -> {
                        Fecha[2] = comboAño.getSelectionModel().getSelectedItem();
                        System.out.println("Año seleccionado: "  + Fecha[2]);
                    });
                    Fechas.getChildren().addAll(FechaDia, comboDias, FechaMes, comboMes, FechaAño, comboAño);
                contenedorA1.getChildren().addAll(espacioa1,espacioa2,espacioa3, espacioa4,Fechas);

            VBox contenedorA2 = new VBox();
                Label CINE = new Label("CINE");
                CINE.setStyle("-fx-font-size: 64px; -fx-font-weight: bold;-fx-alignment: center;");
                VBox cajalistaPeliculas = new VBox();
                Button agregarALaLista = new Button("AGREGAR!");
                TextField agregadorDePeliculas = new TextField("Ingrese el nombre de su pelicula :V");
                ListView<String> listView = new ListView<>(listaPeliculas);
                agregarALaLista.setOnAction(e -> {
                    String peliAux = agregadorDePeliculas.getText();
                    if(peliAux.isEmpty()){
                        // Agregar un stage
                    } else {
                        listaPeliculas.add(peliAux);
                        agregadorDePeliculas.clear();
                    }
                });
                cajalistaPeliculas.getChildren().addAll(agregadorDePeliculas, agregarALaLista, listView);
                contenedorA2.getChildren().addAll(CINE, cajalistaPeliculas);

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
       //nuronyan hizo esto
            VBox horariosN = new VBox();
                Label vacioN2 = new Label("         "); //waos esto es estupido, por que no puedo usar el mismo objeto en dos cosas diferentes?
                Label horario1N = new Label("Matine");
                horario1N.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
                
                Label horario2N = new Label("Vermut");
                horario2N.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
                
                Label horario3N = new Label("Vespertino");
                horario3N.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
                Label vacioN3 = new Label(" ");
                Label vacioN4 = new Label(" ");
                Label vacioN5 = new Label(" ");
                //
                Button botonSiguiente = new Button("Siguiente");
                
                //
                
                horariosN.getChildren().addAll(vacioN2, horario1N, vacioN3, horario2N, vacioN4, horario3N, vacioN5, botonSiguiente);

            VBox gSalas = new VBox();
            Label s1 = new Label("      Sala 1             Sala 2             Sala3");
            s1.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
            GridPane salas = new GridPane();
            salas.setHgap(8);
            salas.setVgap(12); // intentare utilizar poderes de 2 o numeros similares para todo, se ve mas bonito
            salas.setPadding(new Insets(4));
            salas.setStyle("-fx-background-color: #F6008B;");

            for (i=0; i<3; i++){
                for (j=0; j<3; j++){
                    ComboBox<String> comboGrid = new ComboBox<>(listaPeliculas);
                    comboGrid.setPromptText("Seleccionar");
                    comboGrid.setStyle("-fx-prompt-text-fill: gray; -fx-font-size: 12px;");
                    salas.add(comboGrid, j, i);
                    final int fil = i;
                    final int col = j;
                    comboGrid.setOnAction(e ->{
                        peliculas[fil][col] = comboGrid.getSelectionModel().getSelectedItem();
                    });
            }
        }

                gSalas.getChildren().addAll(s1, salas);

                cabezera2.getChildren().addAll(horariosN, gSalas);
            Scene AsignacionPeliculas = new Scene(cabezera2, 500,200);
            
            botonIncio.setOnAction( e -> {
                if(Fecha[0]!=0 && Fecha[0]!=0 && Fecha[0]!=0 && listaPeliculas.size() != 0){
                    ArrayList<String> listaPeliculas2 = new ArrayList<>(listaPeliculas);
                    diasAux[0] = new Dia(Fecha, listaPeliculas2, 3000);         //Se crea el objeto tipo Dia
                    ventana.setScene(AsignacionPeliculas);
                }else{
                    // Dar mensaje de error
                }
            });
//ESTADÍSTICAS
//============================================================================
        // se movio abajo
//Centro de Compras
//============================================================================
        HBox cabezera3 = new HBox();
            VBox horariosN2 = new VBox();
            Label espacion = new Label(" "); // all my homies hate " "
            Label matineN = new Label("Matine");
            Label VermutN = new Label("Vermut");
            Label VespertinoN = new Label("Vespertino");
            Button botonStats = new Button("Estadisticas");
            botonStats.setOnAction(b -> estadisticasEmergente());
            horariosN2.getChildren().addAll(espacion, matineN, VermutN, VespertinoN, botonStats);

            VBox losBotones = new VBox();
            Label salasCC = new Label(" SALA 1 SALA 2  SALA 3");

            GridPane botonesCompra = new GridPane();
            botonesCompra.setHgap(8);
            botonesCompra.setVgap(12); // intentare utilizar poderes de 2 o numeros similares para todo, se ve mas bonito
            botonesCompra.setPadding(new Insets(4));
            botonesCompra.setStyle("-fx-background-color: #F6008B;");

            int[] ij = {0, 0}; 
            
            Scene centroDeCompras = new Scene(cabezera3,500, 200 );
            
                botonSiguiente.setOnAction( e -> {  // Se declara accion del boton
                    if(hayVacio(peliculas)){}else{
                        diasAux[0].agregarFunciones(peliculas);
                        for(i=0; i<3; i++){
                            for(j=0; j<3; j++){
                                final int ifi = i;
                                final int jfi = j;
                                Button botonSala = new Button(peliculas[ifi][jfi]);
                                botonesCompra.add(botonSala, ifi, jfi);
                                //
                                botonSala.setOnAction(a -> abrirVentana(ifi, jfi));
                                //

                            }
                        }   
                        

                        losBotones.getChildren().addAll(salasCC, botonesCompra);
                        cabezera3.getChildren().addAll(horariosN2, losBotones);
                        ventana.setScene(centroDeCompras);
                    }

   
    });
//RESUMEN DE COMPRAS
//========================================================================
// ahora es parte de la matriz de asientos
    }
    

    public static void main(String[] args) {
        launch();
    }

    public boolean hayVacio(String[][] matriz){
        int i,j;
        for(i=0; i<3; i++){
            for(j=0; j<3; j++){
                if (matriz[i][j]==null){
                    return true;
                }
            }
        }
        return false;
    }

    public void copiaMatriz(int[][] matriz1, int[][] matriz2){
        int i, j;
        for(i=0; i<5; i++){
            for(j=0; j<5; j++){
                matriz1[i][j] = matriz2[i][j];
            }
        }
    }

    public void arreglaArrays(String strinc, ArrayList<String> array){
        if(array.contains(strinc)){}else{
            array.add(strinc);
        }
    }

    public void abrirVentana(int f, int c){
        int[][] asientosAux = new int[5][5];
        int[] nAsientos = {0};
        ArrayList<String> asientosEsc = new ArrayList<>();
        copiaMatriz(asientosAux, diasAux[0].funciones[f][c].getSala());
        //asientosAux[2][2]=1;

        Stage ventanaEmergente = new Stage();
        ventanaEmergente.initModality(Modality.APPLICATION_MODAL);           
        ventanaEmergente.setTitle("Andres, oh dios mio");

        HBox nuevaVentana = new HBox();
            VBox ventEmergVBox = new VBox();
                Label ventELabel = new Label("ete sech el pepe");
                // toggle buttons
                GridPane gridPane = new GridPane(); // Quien fue el vio que hizo esto?????
                    gridPane.setHgap(5); // Espacio horizontal entre las celdas
                    gridPane.setVgap(5); // Espacio vertical entre las celdas

                String[] filitas ={"A","B","C","D","E"};
                ToggleButton[][] asientitos = new ToggleButton[5][5];
                for(i=0; i<5; i++){
                    for(j=0; j<5; j++){
                        asientitos[i][j] = new ToggleButton(filitas[i]+(j+1));
                        GridPane.setConstraints(asientitos[i][j], j, i);
                        if(asientosAux[i][j]==1){
                            asientitos[i][j].setDisable(true);
                        }
                    }
                }

                for(i=0; i<5; i++){
                    for(j=0; j<5; j++){
                        int finalI = i;
                        int finalJ = j;
                        asientitos[finalI][finalJ].setOnAction( a -> {
                            if(asientitos[finalI][finalJ].isSelected()){
                                System.out.println(filitas[finalI]+(finalJ+1)+" Seleccionado");
                                asientosAux[finalI][finalJ] = 1;
                                nAsientos[0]++;
                                arreglaArrays(asientitos[finalI][finalJ].getText(), asientosEsc);

                            } else {
                                System.out.println(filitas[finalI]+(finalJ+1)+" Sin seleccionar");
                                asientosAux[finalI][finalJ] = 0;
                                nAsientos[0]--;
                                arreglaArrays(asientitos[finalI][finalJ].getText(), asientosEsc);
                            }
                        });
                    }
                }

                for(i=0; i<5; i++){
                    for(j=0; j<5; j++){
                        gridPane.getChildren().addAll(asientitos[i][j]);
                    }
                }
                Button comprar = new Button("Comprar");
                /* 
                HBox fin = new HBox();
                    VBox graciasVBox = new VBox();
                        Label graciasLabel = new Label("Gracias por su compra");
                    graciasVBox.getChildren().addAll(graciasLabel);
                fin.getChildren().addAll(graciasVBox);
                Scene gracias = new Scene(fin);
                */
                comprar.setOnAction(e -> {
                    if(nAsientos[0]!=0){
                        diasAux[0].funciones[f][c].agregarCompra(new Compra(nAsientos[0], asientosEsc,3000*nAsientos[0]));
                        diasAux[0].funciones[f][c].setSala(asientosAux);
                        diasAux[0].funciones[f][c].actualizarGanancia(3000*nAsientos[0]);

                        //ventanaEmergente.setScene(gracias);
                    }
                });
            ventEmergVBox.getChildren().addAll(ventELabel, gridPane, comprar);
        nuevaVentana.getChildren().addAll(ventEmergVBox);
        
        Scene VEScene = new Scene(nuevaVentana, 640, 480);
        ventanaEmergente.setScene(VEScene);

        ventanaEmergente.showAndWait();
    }

    public void estadisticasEmergente(){
        Stage estadisticas = new Stage();
        estadisticas.initModality(Modality.APPLICATION_MODAL);
        estadisticas.setTitle("Estadisticas");

        HBox stats = new HBox();
            VBox cuestion = new VBox();
                Label titulo = new Label("ESTADISTICAS");
                titulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;-fx-alignment: center;");

                GridPane gridStats = new GridPane();
                gridStats.setHgap(8);
                gridStats.setVgap(12); 
                gridStats.setPadding(new Insets(4));
                // vamos a usar un for a facilitar la repeticion de "total" y "ventas"
                //renderiza Ventas
                int[] ventasArray = {3, 6, 9, 12};
                String k = new String("test");
                for(int i: ventasArray){
                    for(int j=1; j<4; j++){
                        Label ventas = new Label("Ventas: " + k);
                        gridStats.add(ventas, j, i);
                    }
                }
                // muestrqa total
                int[] totalArray = {4, 7, 10, 13};
                for(int i: totalArray){
                    for(j=1;j<4;j++){
                        Label total = new Label("Total: " + k);
                        gridStats.add(total, j, i);
                    }
                }
                //renderiza "sala" y su numero 
                for(i=1; i<4; i++){
                    Label sala = new Label("Sala " + i);
                    sala.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;-fx-alignment: center;");
                    gridStats.add(sala, i, 0);
                }
                int[] horariosAndSalas = {2, 5, 8};
                String horariosArray[] = {"Matine", "Vermut", "Vespertino"};
                for(i=0; i<3; i++){
                    Label horarios = new Label(horariosArray[i]);
                    gridStats.add(horarios, 0, horariosAndSalas[i]);

                }
                // total
                Label total = new Label("TOTAL: " + k);
                total.setStyle("-fx-font-size: 12px; -fx-font-weight: bold;-fx-alignment: center;");
                gridStats.add(total, 0, 12);
                for(i=0;i<3;i++){
                    for(j=0; j<3;j++){
                        Label funcionesStats = new Label(k);
                        gridStats.add(funcionesStats, i+1, horariosAndSalas[j]);
                    }
                }

            cuestion.getChildren().addAll(titulo, gridStats);
        stats.getChildren().addAll(cuestion);

        Scene VEStats = new Scene(stats, 640, 480);
        estadisticas.setScene(VEStats);

        estadisticas.showAndWait();

    }
    //Comentario de prueba
}
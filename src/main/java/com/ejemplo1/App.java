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
/**
 * JavaFX App
 */

public class App extends Application {

    private static Scene scene;
    private ObservableList<String> listaPeliculas = FXCollections.observableArrayList(); 
    //Esta es una mauski herramienta misteriosa que usaremos mas tarde AJ
    String[][] peliculas;
    int Precio;
    int i, j;
    @Override
    public void start(Stage ventana) throws IOException {
        String[][] peliculas = new String[3][3];
        int[] Fecha = new int[3];
        ventana.setTitle("ULAGOS CINEMA ULTRA CAPITALISTA");
        VBox contenedor = new VBox();
        Label texto1 = new Label("Hola, este el ejemplo");
        GridPane gridPane = new GridPane();
            gridPane.setHgap(5); // Espacio horizontal entre las celdas
            gridPane.setVgap(5); // Espacio vertical entre las celdas
// ACA DEJARE Declarare Unos cuantos botones de la pagina de Compras
//====================================================================
        //nuronyan los cambio
        GridPane botonesCompra = new GridPane();
        botonesCompra.setHgap(8);
        botonesCompra.setVgap(12); // intentare utilizar poderes de 2 o numeros similares para todo, se ve mas bonito
        botonesCompra.setPadding(new Insets(4));
        botonesCompra.setStyle("-fx-background-color: #F6008B;");

        for(i=0;i<3;i++){
            for(j=0;j<3;j++){
                Button botonSala = new Button(peliculas[i][j]);
                botonesCompra.add(botonSala, j, i);
            }
        }


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
                    comboGrid.setOnAction(e ->{
                        peliculas[i][j] = comboGrid.getSelectionModel().getSelectedItem();
                    });
            }
        }
                gSalas.getChildren().addAll(s1, salas);

                cabezera2.getChildren().addAll(horariosN, gSalas);
            Scene AsignacionPeliculas = new Scene(cabezera2, 500,200);
            botonIncio.setOnAction( e -> {
                if(Fecha[0]!=0 && Fecha[0]!=0 && Fecha[0]!=0 && listaPeliculas.size() != 0){
                    ArrayList<String> listaPeliculas2 = new ArrayList<>(listaPeliculas);
                    Dia dia1 = new Dia(Fecha, listaPeliculas2, 3000);         //Se crea el objeto tipo Dia
                    ventana.setScene(AsignacionPeliculas);
                }else{
                    // Dar mensaje de error
                }
            });
//ESTADÍSTICAS
//============================================================================
        HBox estadisticas = new HBox();
            VBox ESala = new VBox();
                Label eCompras = new Label("Estadísticas");
                eCompras.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;-fx-alignment: center;");
                ESala.getChildren().addAll(eCompras);

            VBox ESala1 = new VBox();
                Label eMatine = new Label("Matine");
                eMatine.setStyle("-fx-font-size: 16px;-fx-alignment: center;");
                Label eVermut = new Label("Vermut");
                eVermut.setStyle("-fx-font-size: 16px;-fx-alignment: center;");
                Label eVespertino = new Label("Vespertino");
                eVespertino.setStyle("-fx-font-size: 16px;-fx-alignment: center;");
                ESala1.getChildren().addAll(eMatine, eVermut, eVespertino);
            VBox ESala2 = new VBox();
                Label eMatine2 = new Label("Matine");
                eMatine2.setStyle("-fx-font-size: 16px;-fx-alignment: center;");
                Label eVermut2 = new Label("Vermut");
                eVermut2.setStyle("-fx-font-size: 16px;-fx-alignment: center;");
                Label eVespertino2 = new Label("Vespertino");
                eVespertino2.setStyle("-fx-font-size: 16px;-fx-alignment: center;");
                ESala2.getChildren().addAll(eMatine2, eVermut2, eVespertino2);
            VBox ESala3 = new VBox();
                Label eMatine3 = new Label("Matine");
                eMatine3.setStyle("-fx-font-size: 16px;-fx-alignment: center;");
                Label eVermut3 = new Label("Vermut");
                eVermut3.setStyle("-fx-font-size: 16px;-fx-alignment: center;");
                Label eVespertino3 = new Label("Vespertino");
                eVespertino3.setStyle("-fx-font-size: 16px;-fx-alignment: center;");
                ESala3.getChildren().addAll(eMatine3, eVermut3, eVespertino3);
            VBox ESala4 = new VBox();
                Label eMatine4 = new Label("Matine");
                eMatine4.setStyle("-fx-font-size: 16px;-fx-alignment: center;");
                Label eVermut4 = new Label("Vermut");
                eVermut4.setStyle("-fx-font-size: 16px;-fx-alignment: center;");
                Label eVespertino4 = new Label("Vespertino");
                eVespertino4.setStyle("-fx-font-size: 16px;-fx-alignment: center;");
                ESala4.getChildren().addAll(eMatine4, eVermut4, eVespertino4);
        estadisticas.getChildren().addAll(ESala,ESala1, ESala2, ESala3, ESala4);
    Scene estadisticasCompra = new Scene(estadisticas,500, 200 );

//Centro de Compras
//============================================================================
        HBox cabezera3 = new HBox();
            VBox horariosN2 = new VBox();
            Label espacion = new Label(" "); // all my homies hate " "
            Label matineN = new Label("Matine");
            Label VermutN = new Label("Vermut");
            Label VespertinoN = new Label("Vespertino");
            horariosN2.getChildren().addAll(espacion, matineN, VermutN, VespertinoN);

            VBox losBotones = new VBox();
            Label salasCC = new Label(" SALA 1 SALA 2  SALA 3");
            losBotones.getChildren().addAll(salasCC, botonesCompra);
            cabezera3.getChildren().addAll(horariosN2, losBotones);
            
            Scene centroDeCompras = new Scene(cabezera3,500, 200 );
                botonSiguiente.setOnAction( e -> {  // Se declara accion del boton
                ventana.setScene(centroDeCompras);
   
    });

//MATRIZ DE ASIENTOS
//========================================================================
        String[] filitas ={"A","B","C","D","E"};
        ToggleButton[][] asientitos = new ToggleButton[5][5];
        for(i=0; i<5; i++){
            for(j=0; j<5; j++){
                asientitos[i][j] = new ToggleButton(filitas[i]+(j+1));
                GridPane.setConstraints(asientitos[i][j], j, i);
            }
        }
//RESUMEN DE COMPRAS
//========================================================================
HBox cabecera4 = new HBox();
    VBox VCompras = new VBox();
        Label resumenCompras = new Label("RESUMEN DE COMPRA");
        resumenCompras.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;-fx-alignment: center;");
        Label rPelicula = new Label("Pelicula: XXXXX");
        
        Label rHora = new Label("Hora: XX:XX");
        
        Label rSala = new Label("Sala: XXXXX");
        
        Label rAsientos = new Label("Asientos: XXXXX");
        
        Label rFecha = new Label("Fecha: XX/XX/XXXX");
        
        Label rTotal = new Label("Total: $ XXXXX");
        
        Label graciasCompra = new Label("¡GRACIAS POR SU COMPRA!");
        graciasCompra.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;-fx-alignment: center;");
    VCompras.getChildren().addAll(resumenCompras,rPelicula,rHora,rSala,rAsientos,rFecha,rTotal,graciasCompra);
cabecera4.getChildren().addAll(VCompras);
Scene resumenDeCompras = new Scene(cabecera4,500, 200 );
//======EN ESTA SECCION PODRAS MODIFICAR LAS FUNCIONES DE LOS BOTONES DADOS=======
        for(i=0; i<5; i++){
            for(j=0; j<5; j++){
                int finalI = i;
                int finalJ = j;
                asientitos[finalI][j].setOnAction( a -> {
                    if(asientitos[finalI][finalJ].isSelected()){
                        System.out.println(filitas[finalI]+(finalJ+1)+" Seleccionado");
                    } else {
                        System.out.println(filitas[finalI]+(finalJ+1)+" Sin seleccionar");
                    }
                });
            }
        }
//=====================================================================================
        for(i=0; i<5; i++){
            for(j=0; j<5; j++){
                gridPane.getChildren().addAll(asientitos[i][j]);
            }
        }
        contenedor.getChildren().addAll(texto1, gridPane);
        Scene matrizAsiento = new Scene(contenedor, 1000, 600);
        //EggKing1.setOnAction(e -> {ventana.setScene(matrizAsiento);});









        
        ventana.show();
    }
    

    public static void main(String[] args) {
        launch();
    }

}
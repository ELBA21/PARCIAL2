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

import java.io.IOException;
/**
 * JavaFX App
 */

public class App extends Application {

    private static Scene scene;
    private ObservableList<String> listaPeliculas = FXCollections.observableArrayList(); 
    //Esta es una mauski herramienta misteriosa que usaremos mas tarde AJ
    int Fecha;
    String[][] peliculas;
    int Precio;

    @Override
    public void start(Stage ventana) throws IOException {
        String[][] peliculas = new String[3][3];
        Integer[] Fecha = new Integer[3];
        ventana.setTitle("ULAGOS CINEMA ULTRA CAPITALISTA");
        VBox contenedor = new VBox();
        Label texto1 = new Label("Hola, este el ejemplo");
        GridPane gridPane = new GridPane();
            gridPane.setHgap(5); // Espacio horizontal entre las celdas
            gridPane.setVgap(5); // Espacio vertical entre las celdas
// ACA DEJARE Declarare Unos cuantos botones de la pagina de Compras
//====================================================================
        Button[][] salasHorariosButton = new Button[3][3];
        Button matineS1Button = new Button("");
        Button vermutS1Button = new Button("");
        Button vespertinoS1Button = new Button("");

        Button matineS2Button = new Button("");
        Button vermutS2Button = new Button("");
        Button vespertinoS2Button = new Button("");

        Button matineS3Button = new Button("");       
        Button vermutS3Button = new Button("");
        Button vespertinoS3Button = new Button("");



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
                    comboDias.setOnAction( e -> {
                        Fecha[0] = comboDias.getValue();
                    });
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
            VBox sala1 = new VBox();
                Label CinemaS1 = new Label("SALA 1");
                CinemaS1.setStyle("-fx-font-size: 12px; -fx-font-weight: bold;");
                Label matineS1 = new Label("MATINE");
                ComboBox<String> matineS1ComboBox = new ComboBox<>(listaPeliculas);
                matineS1ComboBox.setOnAction(e->{
                    peliculas[0][0] = matineS1ComboBox.getValue();
                    matineS1Button.setText(peliculas[0][0]);
                });
                Label vermutS1 = new Label("Vermut");
                ComboBox<String> vermutS1ComboBox = new ComboBox<>(listaPeliculas);
                vermutS1ComboBox.setOnAction( e -> {
                    peliculas[0][1] = vermutS1ComboBox.getValue();
                    vermutS1Button.setText(peliculas[0][1]);
                });
                Label vespertinoS1 = new Label("Vespertino");
                ComboBox<String> vespertinoS1ComboBox = new ComboBox<>(listaPeliculas);
                vespertinoS1ComboBox.setOnAction( e -> {
                    peliculas[0][2] = vespertinoS1ComboBox.getValue();
                    vespertinoS1Button.setText(peliculas[0][1]);
                });
                sala1.getChildren().addAll(CinemaS1, matineS1,matineS1ComboBox, vermutS1, vermutS1ComboBox, vespertinoS1, vespertinoS1ComboBox);


            VBox sala2 = new VBox();
                Label CinemaS2 = new Label("SALA 2");
                CinemaS2.setStyle("-fx-font-size: 12px; -fx-font-weight: bold;");
                Label matineS2 = new Label("MATINE");
                ComboBox<String> matineS2ComboBox = new ComboBox<>(listaPeliculas);
                matineS2ComboBox.setOnAction( e -> {
                    peliculas[1][0] = matineS2ComboBox.getValue();
                    matineS2Button.setText(peliculas[1][0]);
                });
                Label vermutS2 = new Label("Vermut");
                ComboBox<String> vermutS2ComboBox = new ComboBox<>(listaPeliculas);
                vermutS2ComboBox.setOnAction( e -> {
                    peliculas[1][1] = vermutS2ComboBox.getValue();
                    vermutS2Button.setText(peliculas[1][1]);
                });
                Label vespertinoS2 = new Label("Vespertino");
                ComboBox<String> vespertinS2ComboBox = new ComboBox<>(listaPeliculas);
                vespertinS2ComboBox.setOnAction( e -> {
                    peliculas[1][2] = vespertinS2ComboBox.getValue();
                    vespertinoS2Button.setText(peliculas[1][2]);
                });
                sala2.getChildren().addAll(CinemaS2, matineS2,matineS2ComboBox, vermutS2, vermutS2ComboBox, vespertinoS2, vespertinS2ComboBox);

            VBox sala3 = new VBox();
                Label CinemaS3 = new Label("SALA 3");
                CinemaS3.setStyle("-fx-font-size: 12px; -fx-font-weight: bold;-fx-alignment: center;");
                Label matineS3 = new Label("MATINE");
                ComboBox<String> matineS3ComboBox = new ComboBox<>(listaPeliculas);
                matineS3ComboBox.setOnAction( e ->{
                    peliculas[2][0] = matineS3ComboBox.getValue();
                    matineS3Button.setText(peliculas[2][0]);
                });
                Label vermutS3 = new Label("Vermut");
                Label espacioLabeldenuevo = new Label("       ");
                ComboBox<String> vermutS3ComboBox = new ComboBox<>(listaPeliculas);
                vermutS3ComboBox.setOnAction( e -> {
                    peliculas[2][1] = vermutS3ComboBox.getValue();
                    vermutS3Button.setText(peliculas[2][1]);
                });
                Label vespertinoS3 = new Label("Vespertino");
                ComboBox<String> vespertinoS3ComboBox = new ComboBox<>(listaPeliculas);
                vespertinoS3ComboBox.setOnAction( e -> {
                    peliculas[2][2] = vespertinoS3ComboBox.getValue();
                    vespertinoS3Button.setText(peliculas[2][2]);
                });
                Button botonSiguiente = new Button("Siguiente");
                sala3.getChildren().addAll(CinemaS3, matineS3, matineS3ComboBox, vermutS3, vermutS3ComboBox, vespertinoS3, vespertinoS3ComboBox,espacioLabeldenuevo, botonSiguiente);
                botonSiguiente.setOnAction( e -> {
                    System.out.println("TEST");
                });
        cabezera2.getChildren().addAll(sala1,sala2,sala3);
        Scene AsignacionPeliculas = new Scene(cabezera2, 500,200);
    botonIncio.setOnAction( e -> {
        ventana.setScene(AsignacionPeliculas);
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
                GridPane salaBotonesGridPane = new GridPane();
                    salaBotonesGridPane.setHgap(3);
                    salaBotonesGridPane.setVgap(3);
                BSala2.getChildren().addAll(BCinemaS1, matineS1Button, vermutS1Button,vespertinoS1Button);

            VBox BSala3 = new VBox();
                Label BCinemaS2 = new Label("   Sala 2");
                BSala3.getChildren().addAll(BCinemaS2,matineS2Button, vermutS2Button, vespertinoS2Button);

            VBox BSala4 = new VBox();
                Label BCinemaS3  = new Label("    Sala 3");
                Button botonEstadisticas = new Button("Estadisticas");
                botonEstadisticas.setOnAction( e -> {
                    ventana.setScene(estadisticasCompra);
                });
                BSala4.getChildren().addAll(BCinemaS3,matineS3Button, vermutS3Button, vespertinoS3Button,botonEstadisticas);

        cabezera3.getChildren().addAll(BSala1, BSala2, BSala3, BSala4);
    Scene centroDeCompras = new Scene(cabezera3,500, 200 );
    botonSiguiente.setOnAction( e -> {  // Se declara accion del boton
        ventana.setScene(centroDeCompras);
    });

//MATRIZ DE ASIENTOS
//========================================================================
        String[] filitas ={"A","B","C","D","E"};
        ToggleButton[][] asientitos = new ToggleButton[5][5];
        int i,j;
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
        Matine.setStyle("-fx-font-size: 12px;-fx-alignment: center;");
        Label rHora = new Label("Hora: XX:XX");
        Matine.setStyle("-fx-font-size: 12px;-fx-alignment: center;");
        Label rSala = new Label("Sala: XXXXX");
        Matine.setStyle("-fx-font-size: 12px;-fx-alignment: center;");
        Label rAsientos = new Label("Asientos: XXXXX");
        Matine.setStyle("-fx-font-size: 12px;-fx-alignment: center;");
        Label rFecha = new Label("Fecha: XX/XX/XXXX");
        Matine.setStyle("-fx-font-size: 12px;-fx-alignment: center;");
        Label rTotal = new Label("Total: $ XXXXX");
        Matine.setStyle("-fx-font-size: 12px;-fx-alignment: center;");
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
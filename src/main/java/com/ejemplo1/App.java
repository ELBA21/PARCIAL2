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
    //Esta es una mauski herramienta misteriosa que usaremos mas tarde AJOI

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

                /*
                 * 
                 ComboBox<Integer> comboAño = new ComboBox<>(Años);
                    comboAño.setPromptText("Seleccione el año");
                    comboAño.setOnAction( e -> {
                        int añoSeleccionado = comboAño.getSelectionModel().getSelectedItem();
                        System.out.println("Año seleccionado: "  + añoSeleccionado);
                    });
                 */
        HBox cabezera2 = new HBox();
            VBox sala1 = new VBox();
                Label CinemaS1 = new Label("SALA 1");
                CinemaS1.setStyle("-fx-font-size: 12px; -fx-font-weight: bold;");
                Label matineS1 = new Label("MATINE");
                ComboBox<String> matineS1ComboBox = new ComboBox<>(listaPeliculas);
                Label vermutS1 = new Label("Vermut");
                ComboBox<String> vermutS1ComboBox = new ComboBox<>(listaPeliculas);
                Label vespertinoS1 = new Label("Vespertino");
                ComboBox<String> vespertinoS1ComboBox = new ComboBox<>(listaPeliculas);
                sala1.getChildren().addAll(CinemaS1, matineS1,matineS1ComboBox, vermutS1, vermutS1ComboBox, vespertinoS1, vespertinoS1ComboBox);
            VBox sala2 = new VBox();
                Label CinemaS2 = new Label("SALA 2");
                CinemaS2.setStyle("-fx-font-size: 12px; -fx-font-weight: bold;");
                Label matineS2 = new Label("MATINE");
                ComboBox<String> matineS2ComboBox = new ComboBox<>(listaPeliculas);
                Label vermutS2 = new Label("Vermut");
                ComboBox<String> vermutS2ComboBox = new ComboBox<>(listaPeliculas);
                Label vespertinoS2 = new Label("Vespertino");
                ComboBox<String> vespertinS2ComboBox = new ComboBox<>(listaPeliculas);
                sala2.getChildren().addAll(CinemaS2, matineS2,matineS2ComboBox, vermutS2, vermutS2ComboBox, vespertinoS2, vespertinS2ComboBox);

            VBox sala3 = new VBox();
                Label CinemaS3 = new Label("SALA 3");
                CinemaS3.setStyle("-fx-font-size: 12px; -fx-font-weight: bold;-fx-alignment: center;");
                Label matineS3 = new Label("MATINE");
                ComboBox<String> matineS3ComboBox = new ComboBox<>(listaPeliculas);
                Label vermutS3 = new Label("Vermut");
                ComboBox<String> vermutS3ComboBox = new ComboBox<>(listaPeliculas);
                Label vespertinoS3 = new Label("Vespertino");
                ComboBox<String> vespertinoS3ComboBox = new ComboBox<>();
                Button botonSiguiente = new Button("Siguiente");
                sala3.getChildren().addAll(CinemaS3, matineS3, matineS3ComboBox, vermutS3, vermutS3ComboBox, vespertinoS3, vespertinoS3ComboBox, botonSiguiente);
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
                Button botonEstadisticas = new Button("Estadisticas");
                botonEstadisticas.setOnAction( e -> {
                    ventana.setScene(estadisticasCompra);
                });
                BSala4.getChildren().addAll(BCinemaS3,UP3, EggKing3, KaguyaSama3,botonEstadisticas);

        cabezera3.getChildren().addAll(BSala1, BSala2, BSala3, BSala4);
    Scene centroDeCompras = new Scene(cabezera3,500, 200 );
    botonSiguiente.setOnAction( e -> {  // Se declara accion del boton
        ventana.setScene(centroDeCompras);
    });

//MATRIZ DE ASIENTOS
//========================================================================
        ToggleButton botonA1 = new ToggleButton("A1");//Creacion de boton
        GridPane.setConstraints(botonA1, 0, 0); //Asignacion de boton en gridToggleButton
        ToggleButton botonA2 = new ToggleButton("A2");
        GridPane.setConstraints(botonA2, 1, 0);
        ToggleButton botonA3 = new ToggleButton("A3");
        GridPane.setConstraints(botonA3, 2, 0);
        ToggleButton botonA4 = new ToggleButton("A4");
        GridPane.setConstraints(botonA4, 3, 0);
        ToggleButton botonA5 = new ToggleButton("A5");
        GridPane.setConstraints(botonA5, 4, 0);

        ToggleButton botonB1 = new ToggleButton("B1");
        GridPane.setConstraints(botonB1, 0, 1);
        ToggleButton botonB2 = new ToggleButton("B2");
        GridPane.setConstraints(botonB2, 1, 1);
        ToggleButton botonB3 = new ToggleButton("B3");
        GridPane.setConstraints(botonB3, 2, 1);
        ToggleButton botonB4 = new ToggleButton("B4");
        GridPane.setConstraints(botonB4, 3, 1);
        ToggleButton botonB5 = new ToggleButton("B5");
        GridPane.setConstraints(botonB5, 4, 1);

        ToggleButton botonC1 = new ToggleButton("C1");
        GridPane.setConstraints(botonC1, 0, 2);
        ToggleButton botonC2 = new ToggleButton("C2");
        GridPane.setConstraints(botonC2, 1, 2);
        ToggleButton botonC3 = new ToggleButton("C3");
        GridPane.setConstraints(botonC3, 2, 2);
        ToggleButton botonC4 = new ToggleButton("C4");
        GridPane.setConstraints(botonC4, 3, 2);
        ToggleButton botonC5 = new ToggleButton("C5");
        GridPane.setConstraints(botonC5, 4, 2);

        ToggleButton botonD1 = new ToggleButton("D1");
        GridPane.setConstraints(botonD1, 0, 3);
        ToggleButton botonD2 = new ToggleButton("D2");
        GridPane.setConstraints(botonD2, 1, 3);
        ToggleButton botonD3 = new ToggleButton("D3");
        GridPane.setConstraints(botonD3, 2, 3);
        ToggleButton botonD4 = new ToggleButton("D4");
        GridPane.setConstraints(botonD4, 3, 3);
        ToggleButton botonD5 = new ToggleButton("D5");
        GridPane.setConstraints(botonD5, 4, 3);
        
        ToggleButton botonE1 = new ToggleButton("E1");
        GridPane.setConstraints(botonE1, 0, 4);
        ToggleButton botonE2 = new ToggleButton("E2");
        GridPane.setConstraints(botonE2, 1, 4);
        ToggleButton botonE3 = new ToggleButton("E3");
        GridPane.setConstraints(botonE3, 2, 4);
        ToggleButton botonE4 = new ToggleButton("E4");
        GridPane.setConstraints(botonE4, 3, 4);
        ToggleButton botonE5 = new ToggleButton("E5");
        GridPane.setConstraints(botonE5, 4, 4);
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
//======EN ESTA SECCION PODRAS MODIFICAR LAS FUNCIONES DE LOS BOTONES DADOS=========
        botonA1.setOnAction( a -> {
            if(botonA1.isSelected()){
                System.out.println("A1 Seleccionado");
            } else {
                System.out.println("A1 Sin seleccionar");
            }
        });
        botonA2.setOnAction( a -> {
            if(botonA2.isSelected()){
                System.out.println("A2 Seleccionado");
            } else {
                System.out.println("A2 Sin seleccionar");
            }
        });
        botonA3.setOnAction( a -> {
            if(botonA3.isSelected()){
                System.out.println("A3 Seleccionado");
            } else {
                System.out.println("A3 Sin seleccionar");
            }
        });
        botonA4.setOnAction( a -> {
            if(botonA4.isSelected()){
                System.out.println("A3 Seleccionado");
            } else {
                System.out.println("A3 Sin seleccionar");
            }
        });
        botonA5.setOnAction( a -> {
            if(botonA5.isSelected()){
                System.out.println("A3 Seleccionado");
            } else {
                System.out.println("A3 Sin seleccionar");
            }
        });
//================ACA HAY BOTONES DE LA HILERA 'B'================
        botonB1.setOnAction( a -> {
            if(botonB1.isSelected()){
                System.out.println("B1 Seleccionado");
            } else {
                System.out.println("B1 Sin seleccionar");
            }
        });
        botonB2.setOnAction( a -> {
            if(botonB2.isSelected()){
                System.out.println("B2 Seleccionado");
            } else {
                System.out.println("B2 Sin seleccionar");
            }
        });
        botonB3.setOnAction( a -> {
            if(botonB3.isSelected()){
                System.out.println("B3 Seleccionado");
            } else {
                System.out.println("B3 Sin seleccionar");
            }
        });
        botonB4.setOnAction( a -> {
            if(botonB4.isSelected()){
                System.out.println("B4 Seleccionado");
            } else {
                System.out.println("B4 Sin seleccionar");
            }
        });
        botonB5.setOnAction( a -> {
            if(botonB5.isSelected()){
                System.out.println("B5 Seleccionado");
            } else {
                System.out.println("B5 Sin seleccionar");
            }
        });

//============Aca estan los botones de la hilera 'B'==============
        botonC1.setOnAction( e -> {
            if(botonC1.isSelected()){
                System.out.println("C1 Seleccionado");
            }else {
                System.out.println("C1 No selec");
            }
        });
        botonC2.setOnAction( e -> {
            if(botonC2.isSelected()){
                System.out.println("C2 Seleccionado");
            } else {
                System.out.println("C2 No Selec");
            }
        });
        botonC3.setOnAction( e -> {
            if(botonC3.isSelected()){
                System.out.println("C3 Selec");
            } else {
                System.out.println("C3 No Selec");
            }
        });
        botonC4.setOnAction( e -> {
            if(botonC4.isSelected()){
                System.out.println("C4 SELEC");
            } else {
                System.out.println("C4 NO SELEC");
            }
        }); 
        botonC5.setOnAction( e -> {
            if(botonC5.isSelected()){
                System.out.println("C5 SELEC");
            } else {
                System.out.println("C5 No Selec");
            }
        });
// =========== ACA ESTAN LOS DE LA HILERA  'D'=========
        botonD1.setOnAction( e -> {
            if(botonD1.isSelected()){
                System.out.println("D1 SELEC");
            } else{
                System.out.println("D1 NO SELEC"); 
            }
        });
        botonD2.setOnAction( e -> {
            if(botonD2.isSelected()){
                System.out.println("D2 SELEC"); 
            } else {
                System.out.println("D2 NO SELEC"); 
            }

        });
        botonD3.setOnAction( e -> {
            if(botonD3.isSelected()){
                System.out.println("D3 SELEC"); 
            } else {
                System.out.println("D3 No Selec"); 
            }
        });
        botonD4.setOnAction( e -> {
            if(botonD4.isSelected()){
                System.out.println("D4 SELEC"); 
            } else{
                System.out.println("D4 No selec"); 
            }

        }); 
        botonD5.setOnAction( e -> {
            if(botonD5.isSelected()){
                System.out.println("D5 SELEC");
            } else{
                System.out.println("D5 NO SELEC"); 
            }
        });
// =============== ACA ESTAN LOS DE LA HILERA 'E' =======
        botonE1.setOnAction( e -> {
            if(botonE1.isSelected()){
                System.out.println("E1 SELEC"); 
            } else {
                System.out.println("E1 NO SELEC"); 
            }
        });
        botonE2.setOnAction( e -> {
            if(botonE2.isSelected()){
                System.out.println("E1 SELEC"); 
            } else {
                System.out.println("E1 No selec"); 
            }
        });
        botonE3.setOnAction( e -> {
            if(botonE3.isSelected()){
                System.out.println("E3 SELEC");
            } else {
                System.out.println("E3 NO SELEC");
            }
        });
        botonE4.setOnAction( e -> {
            if(botonE4.isSelected()){
                System.out.println("E4 SELEC");
            } else {
                System.out.println("E4 NO SELEC");
            }
        }); 
        botonE5.setOnAction( e -> {
            if(botonE5.isSelected()){
                System.out.println("E5 SELEC");
            } else {
                System.out.println("E5 No Selec");
            }
        });

//=====================================================================================
        gridPane.getChildren().addAll(botonA1, botonA2, botonA3, botonA4, botonA5, botonB1, botonB2, botonB3, botonB4, botonB5, botonC1, botonC2, botonC3, botonC4, botonC5, botonD1, botonD2, botonD3, botonD4, botonD5, botonE1, botonE2, botonE3, botonE4, botonE5);
        contenedor.getChildren().addAll(texto1, gridPane);
        Scene matrizAsiento = new Scene(contenedor, 1000, 600);
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

    public static void main(String[] args) {
        launch();
    }

}
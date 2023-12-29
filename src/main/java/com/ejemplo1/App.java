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
    String[] horariosSA = {"Matine", "Vermut", "Vespertino"};
    String[][] peliculas = new String[3][3];
    int[] Fecha = new int[3];
    int Precio;
    int i, j;
    boolean bisiesto;
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
                        Fecha[1] = comboMes.getSelectionModel().getSelectedItem(); // esto estaba asignado a combo dias por alguna razon
                        System.out.println("Mes selecionado: " + Fecha[1]);
                    });

                    Label FechaAño = new Label("Año");
                    ObservableList<Integer> Anos = FXCollections.observableArrayList();
                    for(int ano=1900; ano<2101; ano++){
                        Anos.add(ano);
                    }
                    ComboBox<Integer> comboAño = new ComboBox<>(Anos);
                    comboAño.setPromptText("Seleccione el año");
                    comboAño.setOnAction( e -> {
                        Fecha[2] = comboAño.getSelectionModel().getSelectedItem();
                        System.out.println("Año seleccionado: "  + Fecha[2]);
                         if(Fecha[2] % 4 == 0 && (Fecha[2] % 100 != 0 || Fecha[2] % 400 == 0)){
                        bisiesto = true;
                        System.err.println("el ano es bisiesto");
                        }
                        else{
                            bisiesto = false;
                        }
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
            Scene inicio = new Scene(cabezera,500,240);
            ventana.setScene(inicio);
            ventana.show();
            System.out.println("ventana setScene(inicio)");
            
//Asignacion de Peliculas
//============================================================================
        HBox cabezera2 = new HBox();
       //nuronyan hizo esto


            VBox gSalas = new VBox();
            GridPane salas = new GridPane();
            salas.setHgap(8);
            salas.setVgap(12); // intentare utilizar poderes de 2 o numeros similares para todo, se ve mas bonito
            salas.setPadding(new Insets(4));
            salas.setStyle("-fx-background-color: #F6008B;");
            Button botonSiguiente = new Button("Siguiente");
            salas.add(botonSiguiente, 3, 5);
            for(i=0; i<3; i++){
                Label horariosAP = new Label(horariosSA[i]);
                horariosAP.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
                salas.add(horariosAP, 0, i+1);
            }
            for(i=0; i<3; i++){
                Label salasAP = new Label("Sala " + (i+1));
                salasAP.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
                salas.add(salasAP, i+1, 0);
            }

            for (i=0; i<3; i++){
                for (j=0; j<3; j++){
                    ComboBox<String> comboGrid = new ComboBox<>(listaPeliculas);
                    comboGrid.setPromptText("Seleccionar");
                    comboGrid.setStyle("-fx-prompt-text-fill: gray; -fx-font-size: 12px;");
                    salas.add(comboGrid, j+1, i+1);
                    final int fil = i;
                    final int col = j;
                    comboGrid.setOnAction(e ->{
                        peliculas[fil][col] = comboGrid.getSelectionModel().getSelectedItem();
                    });
            }
        }

                gSalas.getChildren().addAll(salas);

                cabezera2.getChildren().addAll(gSalas);
            Scene AsignacionPeliculas = new Scene(cabezera2, 900,240);

            botonIncio.setOnAction( e -> {
                System.err.println("check si estan vacios");
                if(Fecha[0]!=0 && Fecha[1]!=0 && Fecha[2]!=0 && listaPeliculas.size() != 0){ //yandere dev momento

                    
                        ArrayList<String> listaPeliculas2 = new ArrayList<>(listaPeliculas);
                        diasAux[0] = new Dia(Fecha, listaPeliculas2 , 3000);         //Se crea el objeto tipo Dia
                        ventana.setScene(AsignacionPeliculas);
                }
                else{
                    // Dar mensaje de error
                }
            
            });
//ESTADÍSTICAS
//============================================================================
        // se movio abajo
//Centro de Compras
//============================================================================
        HBox cabezera3 = new HBox();
            
            VBox losBotones = new VBox();
            GridPane botonesCompra = new GridPane();
            botonesCompra.setHgap(8);
            botonesCompra.setVgap(12); // intentare utilizar poderes de 2 o numeros similares para todo, se ve mas bonito
            botonesCompra.setPadding(new Insets(4));
            botonesCompra.setStyle("-fx-background-color: #F6008B;");
            for(i=0; i<3; i++){
                Label horariosCC = new Label(horariosSA[i]);
                horariosCC.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
                botonesCompra.add(horariosCC, 0, i+1);
            }
            Button botonStats = new Button("Estadisticas");
            botonStats.setOnAction(b -> estadisticasEmergente(peliculas));
            botonesCompra.add(botonStats, 3, 5);

            for(i=0; i<3; i++){
                Label salaCCLabel = new Label("Sala " + (i+1));
                salaCCLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
                botonesCompra.add(salaCCLabel, i+1, 0);
            }
            
            Scene centroDeCompras = new Scene(cabezera3,900, 240 );
            
                botonSiguiente.setOnAction( e -> {  // Se declara accion del boton
                    if(hayVacio(peliculas)){}else{
                        diasAux[0].agregarFunciones(peliculas);
                        for(i=0; i<3; i++){
                            for(j=0; j<3; j++){
                                final int ifi = i;
                                final int jfi = j;
                                Button botonSala = new Button(peliculas[ifi][jfi]);
                                botonesCompra.add(botonSala, jfi+1, ifi+1);  //              ACAAAA ESTABAN DADOS VUELTA EL ifi Y EL jfi LA CTM
                                //
                                botonSala.setOnAction(a -> abrirVentana(ifi, jfi));
                                //

                            }
                        }   
                        

                        losBotones.getChildren().addAll(botonesCompra);
                        cabezera3.getChildren().addAll(losBotones);
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
                Label ventELabel = new Label("Seleccion de Asientos");
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
                comprar.setOnAction(e -> {
                    if(nAsientos[0]!=0){
                        Compra compra = new Compra(nAsientos[0], asientosEsc,3000*nAsientos[0]);
                        System.out.println("Compra creada");
                        diasAux[0].funciones[f][c].agregarCompra(compra);
                        diasAux[0].funciones[f][c].setSala(asientosAux);
                        int totalDeComprasFix = diasAux[0].funciones[f][c].getGanancia();
                        diasAux[0].funciones[f][c].actualizarGanancia(3000*nAsientos[0]);
                        // escena final
                        HBox gracias = new HBox();
                            VBox graciasVBox = new VBox();
                                Label graciasText = new Label("RESUMEN DE COMPRA");
                                graciasText.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;-fx-alignment: center;");
                                Label horario = new Label("horario " + diasAux[0].funciones[f][c].getHorario());
                                Label sala = new Label("Sala " + diasAux[0].funciones[f][c].getNroSala());
                                Label asientos = new Label("Asientos " + compra.getAsientos()); 
                                int[] fechaArray = diasAux[0].getFecha();
                                Label fecha = new Label("Fecha " + fechaArray[0] + "/" + fechaArray[1] + "/" + fechaArray[2]); 
                                Label total = new Label("Total " + (diasAux[0].funciones[f][c].getGanancia() - totalDeComprasFix));
                                Label graciasPorSuCompra = new Label("GRACIAS POR SU COMPRA!!!!1!");
                                graciasPorSuCompra.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;-fx-alignment: center;");
                            graciasVBox.getChildren().addAll(graciasText, horario, sala, asientos, fecha, total, graciasPorSuCompra);
                        gracias.getChildren().addAll(graciasVBox);
                        //
                        Scene finalScene = new Scene(gracias, 400, 200);
                        //
                        ventanaEmergente.setScene(finalScene);

                    }
                });
            ventEmergVBox.getChildren().addAll(ventELabel, gridPane, comprar);
        nuevaVentana.getChildren().addAll(ventEmergVBox);
        
        Scene VEScene = new Scene(nuevaVentana, 240, 240);
        ventanaEmergente.setScene(VEScene);

        ventanaEmergente.showAndWait();
    }

    public void estadisticasEmergente(String[][] peliculas){
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
                for(int i=0; i<3; i++){ //antes usaba foreach pero creo que asi sera mas facil en caso de que tengamos que recorer una matriz luego
                    for(int j=0; j<3; j++){
                        Label ventas = new Label("Ventas: "+ diasAux[0].funciones[i][j].getHistorialCompras().size());
                        gridStats.add(ventas, j+1, ventasArray[i]);
                    }
                }
                // muestrqa total
                int[] totalArray = {4, 7, 10, 13};
                for(i=0; i<3; i++){
                    for(j=0;j<3;j++){
                        Label total = new Label("Total: " + diasAux[0].funciones[i][j].getGanancia());
                        gridStats.add(total, j+1, totalArray[i]);
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
                int totalM = 0;
                for(i=0; i<3; i++){
                    for(j=0;j<3;j++){
                        totalM = totalM +diasAux[0].funciones[i][j].getGanancia();
                    }
                }
                int[] totalSalas = {0, 0, 0}; 
                int[] ventasSalas = {0, 0, 0}; //creo que esto es redundante pero igual
                for(i=0;i<3;i++){
                    for(j=0;j<3;j++){
                        totalSalas[i] = totalSalas[i] + diasAux[0].funciones[j][i].getGanancia();
                    }
                    Label totalSalasLabel = new Label("Total " + totalSalas[i]);
                    gridStats.add(totalSalasLabel, i+1, 13);
                }
                //ventasTotalSalas
                for(i=0;i<3;i++){
                    for(j=0;j<3;j++){
                        ventasSalas[i] = ventasSalas[i] + diasAux[0].funciones[j][i].getHistorialCompras().size();
                    }
                    Label VentasSalasLabel = new Label("Ventas " + ventasSalas[i]);
                    gridStats.add(VentasSalasLabel, i+1, 12);
                }
                Label total = new Label("TOTAL: " + totalM);
                total.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;-fx-alignment: center;");
                gridStats.add(total, 0, 12);
                
                // funcion
                for(i=0;i<3;i++){
                    for(j=0; j<3;j++){
                        Label funcionesStats = new Label(peliculas[j][i]);
                        funcionesStats.setStyle("-fx-font-size: 12px; -fx-font-weight: bold;-fx-alignment: center;");
                        gridStats.add(funcionesStats, i+1, horariosAndSalas[j]);
                    }
                }

            cuestion.getChildren().addAll(titulo, gridStats);
        stats.getChildren().addAll(cuestion);

        Scene VEStats = new Scene(stats, 720, 480);
        estadisticas.setScene(VEStats);

        estadisticas.showAndWait();

    }
    //Comentario de prueba
}
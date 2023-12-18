package com.ejemplo1;
import java.util.ArrayList;

public class Dia {
    int[] fecha;//[3]
    Funcion[][] funciones = new Funcion[3][3];
    ArrayList<String> peliculas = new ArrayList<>();
    int precio;

    public Dia(int[] fecha, ArrayList<String> peliculas, int precio){
        this.fecha = fecha;
        this.peliculas= peliculas;
        this.precio = precio;
    }

    public void agregarFunciones(String[][] peliculas){
        int i,j;
        for(i=0; i<3; i++){
            String horario = "";
            switch (i) {
                    case 0:
                        horario = "matiné";
                        break;
                    case 1:
                        horario = "vermut";
                        break;
                    case 2:
                        horario = "vespertino";
                        break;
                }
            for(j=0; j<3; j++){
                funciones[i][j] = new Funcion(j+1, horario, peliculas[i][j]);
            }
        }
    }

    public int generarGananciaSala(int i){
        int j, gananciaSala = 0;
        for(j=0; j<3; j++){
            gananciaSala += funciones[i][j].getGanancia();
        }
        return gananciaSala;
    }
    public int generarGananciaTotal(){
        int i,j, gananciaTotal = 0;
        for(i=0; i<3; i++){
            for(j=0; j<3; j++){
                gananciaTotal += funciones[i][j].getGanancia();
            }
        }   
        return gananciaTotal;                                 
    }
    public int[] getFecha(){
        return this.fecha;
    }
    public int getPrecio(){
        return this.precio;
    }
    public ArrayList<String> getPeliculas(){
        return this.peliculas;
    }
}

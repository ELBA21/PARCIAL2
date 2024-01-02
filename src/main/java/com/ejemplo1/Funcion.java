package com.ejemplo1;
import java.util.ArrayList;

public class Funcion {
    private int nroSala;
    private int[][] sala = new int[5][5];
    private String horario;
    private String pelicula;
    private ArrayList<Compra> historialCompras = new ArrayList<>();
    private int ganancia;

    public Funcion(int nroSala, String horario, String pelicula){
        this.nroSala = nroSala;
        this.horario = horario;
        this.pelicula = pelicula;
    }

    public void actualizarGanancia(int newSuma){
        ganancia += newSuma;
    }
    public void agregarCompra(Compra compra){
        historialCompras.add(compra);
    }                        
    public int getNroSala(){
        return this.nroSala;
    }
    public int[][] getSala(){
        return this.sala;
    }
    public String getHorario(){
        return this.horario;
    }
    public String getPelicula(){
        return this.pelicula;
    }
    public ArrayList<Compra> getHistorialCompras(){
        return this.historialCompras;
    }
    public int getGanancia(){
        return this.ganancia;
    }   

    public void setSala(int[][] matriz){
        int i, j;
        for(i=0; i<5; i++){
            for(j=0; j<5; j++){
                this.sala[i][j] = matriz[i][j];
            }
        }
    }
}

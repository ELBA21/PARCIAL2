package com.ejemplo1;
import java.util.ArrayList;
public class Compra {
    private int cantAsientos;
    ArrayList<String> asientos = new ArrayList<>();

    private int costo;

    public Compra(int cantAsientos, ArrayList<String> asientos, int costo){
        this.cantAsientos = cantAsientos;
        this.asientos = asientos;
        this.costo = costo;
    }

    public int getCosto(){
        return this.costo;
    }
    public int getCantAsientos(){
        return this.cantAsientos;
    }
    public ArrayList<String> getAsientos(){
        return this.asientos;
    }
}
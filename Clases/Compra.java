public class Compra {
    private int cantAsientos;
    private String asientos[];
    private int costo;

    public Compra(int cantAsientos, String asientos[], int costo){
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
    public String[] getAsientos(){
        return this.asientos;
    }
}

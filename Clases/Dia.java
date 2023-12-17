public class Dia {
    int fecha;
    Funcion funciones[][];//[5][5]
    String peliculas[];
    int precio;

    public Dia(int fecha, String peliculas[], int precio){
        this.fecha = fecha;
        this.peliculas= peliculas;
        this.precio = precio;
    }
    public void agregarFunciones(){
        //
    }
    public void generarGananciaTotal(){
        //
    }
    public void generarGananciaDia(){
        //
    }
    public int getFecha(){
        return this.fecha;
    }
    public int getPrecio(){
        return this.precio;
    }
}

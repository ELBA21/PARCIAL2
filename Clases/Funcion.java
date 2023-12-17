public class Funcion {
    private int nroSala;
    private int sala[][]; // Declaración corregida
    private String horario;
    private String pelicula;
    private Compra historialCompras[]; // Punto y coma añadido
    private int ganancia;

    public Funcion(int nroSala, int sala[][], String horario, String pelicula, Compra historialCompras[], int ganancia){
        this.nroSala = nroSala;
        this.sala = sala;
        this.horario = horario;
        this.pelicula=pelicula;
        this.historialCompras = historialCompras;
        this.ganancia = ganancia;
    }
    public void actualizarSala(){
        //a
    }
    public void actualizarGanancia(){
        //a
    }
    public void agregarCompra(){
        //q
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
    public String getPelicua(){
        return this.pelicula;
    }
    public Compra[] getHistorialCompras(){
        return this.historialCompras;
    }
    public int getGanancia(){
        return this.ganancia;
    }   
}

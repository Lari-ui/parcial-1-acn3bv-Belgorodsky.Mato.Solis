package Parcial1_Belgorodsky_Mato_Solis;
public abstract class vehiculo implements calculable {
    protected String patente;
    protected String marca;
    protected String modelo;
    protected int horas;

    public vehiculo(String patente, String marca, String modelo, int horas) {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.horas = horas;
    }

    public abstract double calcularCosto();
    public abstract int getEspacios();

    public String getPatente() {
        return patente;
    }

public void mostrarDatos() {
    System.out.println("Patente: " + patente +
                       " Marca: " + marca +
                       " Modelo: " + modelo +
                       " Horas: " + horas);
}    
}
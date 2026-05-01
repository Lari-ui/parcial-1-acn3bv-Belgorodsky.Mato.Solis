package src;

public abstract class Vehiculo implements Calculable, Mostrable {
    protected String patente;
    protected String marca;
    protected String modelo;
    protected int horas;

    public Vehiculo(String patente, String marca, String modelo, int horas) {
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

    @Override
    public void mostrarDatos() {
        System.out.println("Patente: " + patente +
                " Marca: " + marca +
                " Modelo: " + modelo +
                " Horas: " + horas);
    }
}

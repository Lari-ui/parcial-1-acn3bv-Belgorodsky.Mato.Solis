public abstract class vehiculo {
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
}
public class Camion extends vehiculo {

    public Camion(String patente, String marca, String modelo, int horas) {
        super(patente, marca, modelo, horas);
    }

    @Override
    public double calcularCosto() {
        return horas * 1500;
    }

    @Override
    public int getEspacios() {
        return 4;
    }
}
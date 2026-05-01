public class Auto extends vehiculo {

    public Auto(String patente, String marca, String modelo, int horas) {
        super(patente, marca, modelo, horas);
    }

    @Override
    public double calcularCosto() {
        return horas * 1000;
    }

    @Override
    public int getEspacios() {
        return 2;
    }
}
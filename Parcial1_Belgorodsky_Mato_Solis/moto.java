package Parcial1_Belgorodsky_Mato_Solis;

public class moto extends vehiculo {

    public moto(String patente, String marca, String modelo, int horas) {
        super(patente, marca, modelo, horas);
    }

    @Override
    public double calcularCosto() {
        return horas * 700;
    }

    @Override
    public int getEspacios() {
        return 1;
    }
} 


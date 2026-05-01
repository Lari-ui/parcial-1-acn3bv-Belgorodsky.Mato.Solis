package Parcial1_Belgorodsky_Mato_Solis;
import java.util.ArrayList;
import java.util.List;

public class garage {
    private int capacidadMaxima;
    private int espaciosOcupados;
    private List<vehiculo> vehiculos;

    public garage(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.vehiculos = new ArrayList<>();
    }

    public boolean ingresarVehiculo(vehiculo v) {
        if (espaciosOcupados + v.getEspacios() <= capacidadMaxima) {
            vehiculos.add(v);
            espaciosOcupados += v.getEspacios();
            return true;
        }
        return false;
    }

    public vehiculo egresarVehiculo(String patente) {
        for (vehiculo v : vehiculos) {
            if (v.getPatente().equals(patente)) {
                vehiculos.remove(v);
                espaciosOcupados -= v.getEspacios();
                return v;
            }
        }
        return null;
    }

    public void listarVehiculos() {
        for (vehiculo v : vehiculos) {
            System.out.println(v.getPatente());
        }
    }

    public int espaciosDisponibles() {
        return capacidadMaxima - espaciosOcupados;
    }
}


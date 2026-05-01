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

public void ingresarVehiculo(vehiculo v) 
    throws GarageLlenoException, PatenteDuplicadaException {

    if (existeVehiculo(v.getPatente())) {
        throw new PatenteDuplicadaException("Patente duplicada");
    }

    if (espaciosOcupados + v.getEspacios() > capacidadMaxima) {
        throw new GarageLlenoException("No hay espacio disponible");
    }

    vehiculos.add(v);
    espaciosOcupados += v.getEspacios();
}

public vehiculo egresarVehiculo(String patente) 
    throws VehiculoNoEncontradoException {

    for (vehiculo v : vehiculos) {
        if (v.getPatente().equalsIgnoreCase(patente)) {
            vehiculos.remove(v);
            espaciosOcupados -= v.getEspacios();
            return v;
        }
    }

    throw new VehiculoNoEncontradoException("Vehículo no encontrado");
}

    public void listarVehiculos() {
        if (vehiculos.isEmpty()) {
        System.out.println("No hay vehículos estacionados.");
        return;
    }
        
        for (vehiculo v : vehiculos) {
            v.mostrarDatos();
        }
    }

    public int espaciosDisponibles() {
        return capacidadMaxima - espaciosOcupados;
    }

    public int getCapacidadMaxima() {
    return capacidadMaxima;
}

    public int getEspaciosOcupados() {
    return espaciosOcupados;
}

    public boolean existeVehiculo(String patente) {
    for (vehiculo v : vehiculos) {
        if (v.getPatente().equalsIgnoreCase(patente)) {
            return true;
        }
    }
    return false;
}

public void mostrarReporte() {
    int motos = 0, autos = 0, camiones = 0;
    double total = 0;

    for (vehiculo v : vehiculos) {
        if (v instanceof moto) motos++;
        if (v instanceof Auto) autos++;
        if (v instanceof Camion) camiones++;

        total += v.calcularCosto();
    }
    
    System.out.println("----- REPORTE -----");
    System.out.println("Total vehículos: " + vehiculos.size());
    System.out.println("Motos: " + motos);
    System.out.println("Autos: " + autos);
    System.out.println("Camiones: " + camiones);
    System.out.println("Recaudación total: $" + total);
}
}


package src;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Garage {
    private int capacidadMaxima;
    private int espaciosOcupados;
    private List<Vehiculo> vehiculos;

    public Garage(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.vehiculos = new ArrayList<>();
    }

    public void ingresarVehiculo(Vehiculo vehiculo)
            throws GarageLlenoException, PatenteDuplicadaException {
        if (vehiculo == null) {
            throw new IllegalArgumentException("Vehículo inválido");
        }

        if (existeVehiculo(vehiculo.getPatente())) {
            throw new PatenteDuplicadaException("Patente duplicada");
        }

        if (espaciosOcupados + vehiculo.getEspacios() > capacidadMaxima) {
            throw new GarageLlenoException("No hay espacio disponible");
        }

        vehiculos.add(vehiculo);
        espaciosOcupados += vehiculo.getEspacios();
    }

    public Vehiculo egresarVehiculo(String patente)
            throws VehiculoNoEncontradoException {
        Iterator<Vehiculo> iterator = vehiculos.iterator();

        while (iterator.hasNext()) {
            Vehiculo vehiculo = iterator.next();
            if (vehiculo.getPatente().equalsIgnoreCase(patente)) {
                iterator.remove();
                espaciosOcupados -= vehiculo.getEspacios();
                return vehiculo;
            }
        }

        throw new VehiculoNoEncontradoException("Vehículo no encontrado");
    }

    public void listarVehiculos() {
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehículos estacionados.");
            return;
        }

        for (Vehiculo vehiculo : vehiculos) {
            vehiculo.mostrarDatos();
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
        if (patente == null || patente.trim().isEmpty()) {
            return false;
        }

        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getPatente().equalsIgnoreCase(patente)) {
                return true;
            }
        }

        return false;
    }

    public void mostrarReporte() {
        int motos = 0;
        int autos = 0;
        int camiones = 0;
        double total = 0;

        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo instanceof Moto) {
                motos++;
            } else if (vehiculo instanceof Auto) {
                autos++;
            } else if (vehiculo instanceof Camion) {
                camiones++;
            }

            total += vehiculo.calcularCosto();
        }

        System.out.println("----- REPORTE -----");
        System.out.println("Total vehículos: " + vehiculos.size());
        System.out.println("Motos: " + motos);
        System.out.println("Autos: " + autos);
        System.out.println("Camiones: " + camiones);
        System.out.println("Recaudación total: $" + total);
    }
}

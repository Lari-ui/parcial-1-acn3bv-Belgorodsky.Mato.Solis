package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int capacidad = leerEnteroPositivo(sc, "Capacidad del garage: ");
            Garage garage = new Garage(capacidad);

            int opcion;
            do {
                System.out.println("\n1. Ingresar");
                System.out.println("2. Egresar");
                System.out.println("3. Listar");
                System.out.println("4. Espacios libres");
                System.out.println("5. Reportes");
                System.out.println("0. Salir");

                opcion = leerEnteroRango(sc, "Opción: ", 0, 5);

                switch (opcion) {
                    case 1:
                        ingresarVehiculo(sc, garage);
                        break;
                    case 2:
                        egresarVehiculo(sc, garage);
                        break;
                    case 3:
                        garage.listarVehiculos();
                        break;
                    case 4:
                        mostrarEstado(garage);
                        break;
                    case 5:
                        garage.mostrarReporte();
                        break;
                    default:
                        break;
                }
            } while (opcion != 0);
        }
    }

    private static void ingresarVehiculo(Scanner sc, Garage garage) {
        int tipo = leerEnteroRango(sc, "Tipo (1 Moto, 2 Auto, 3 Camion): ", 1, 3);
        String patente = leerTextoNoVacio(sc, "Patente: ");
        String marca = leerTextoNoVacio(sc, "Marca: ");
        String modelo = leerTextoNoVacio(sc, "Modelo: ");
        int horas = leerEnteroPositivo(sc, "Horas: ");

        Vehiculo vehiculo;
        if (tipo == 1) {
            vehiculo = new Moto(patente, marca, modelo, horas);
        } else if (tipo == 2) {
            vehiculo = new Auto(patente, marca, modelo, horas);
        } else {
            vehiculo = new Camion(patente, marca, modelo, horas);
        }

        try {
            garage.ingresarVehiculo(vehiculo);
            System.out.println("Vehículo ingresado correctamente");
        } catch (PatenteDuplicadaException | GarageLlenoException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void egresarVehiculo(Scanner sc, Garage garage) {
        String patente = leerTextoNoVacio(sc, "Patente: ");

        try {
            Vehiculo salida = garage.egresarVehiculo(patente);
            System.out.println("Vehículo egresado correctamente");
            salida.mostrarDatos();
            System.out.println("Costo: $" + salida.calcularCosto());
        } catch (VehiculoNoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void mostrarEstado(Garage garage) {
        System.out.println("----- ESTADO DEL GARAGE -----");
        System.out.println("Capacidad total: " + garage.getCapacidadMaxima());
        System.out.println("Espacios ocupados: " + garage.getEspaciosOcupados());
        System.out.println("Espacios disponibles: " + garage.espaciosDisponibles());
    }

    private static int leerEnteroPositivo(Scanner sc, String mensaje) {
        while (true) {
            int valor = leerEntero(sc, mensaje);
            if (valor > 0) {
                return valor;
            }
            System.out.println("Error: el valor debe ser mayor a 0");
        }
    }

    private static int leerEnteroRango(Scanner sc, String mensaje, int minimo, int maximo) {
        while (true) {
            int valor = leerEntero(sc, mensaje);
            if (valor >= minimo && valor <= maximo) {
                return valor;
            }
            System.out.println("Opción inválida");
        }
    }

    private static int leerEntero(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                int valor = Integer.parseInt(sc.nextLine().trim());
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Error: ingreso inválido");
            }
        }
    }

    private static String leerTextoNoVacio(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = sc.nextLine().trim();
            if (!texto.isEmpty()) {
                return texto;
            }
            System.out.println("Error: el campo no puede estar vacío");
        }
    }
}

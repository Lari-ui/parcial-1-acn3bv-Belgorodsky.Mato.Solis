package src;

import java.util.Scanner;

public class Main {
    private static final String LINEA = "==================================================";
    private static final String TITULO = "SISTEMA DE GARAJE";

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            mostrarEncabezado();
            int capacidad = leerEnteroPositivo(sc, "Capacidad del garage: ");
            Garage garage = new Garage(capacidad);

            int opcion;
            do {
                mostrarMenu(garage);
                opcion = leerEnteroRango(sc, "Opcion: ", 0, 5);

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
                if (opcion != 0) {
                    System.out.println();
                }
            } while (opcion != 0);

            System.out.println("\nFin del sistema.");
        }
    }

    private static void ingresarVehiculo(Scanner sc, Garage garage) {
        System.out.println("\n--- Ingreso de vehiculo ---");
        int tipo = leerEnteroRango(sc, "Tipo (1 Moto, 2 Auto, 3 Camion): ", 1, 3);
        String patente = leerTextoNoVacio(sc, "Patente: ");
        String marca = leerTextoNoVacio(sc, "Marca: ");
        String modelo = leerTextoNoVacio(sc, "Modelo: ");
        int horas;
        while (true) {
            try {
                horas = leerHoras(sc);
                break;
            } catch (HorasInvalidasException e) {
                System.out.println(e.getMessage());
            }
        }

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
            System.out.println("Vehiculo ingresado correctamente.");
        } catch (PatenteDuplicadaException | GarageLlenoException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void egresarVehiculo(Scanner sc, Garage garage) {
        System.out.println("\n--- Egreso de vehiculo ---");
        String patente = leerTextoNoVacio(sc, "Patente: ");

        try {
            Vehiculo salida = garage.egresarVehiculo(patente);
            System.out.println("Vehiculo egresado correctamente.");
            salida.mostrarDatos();
            System.out.println("Costo: $" + salida.calcularCosto());
        } catch (VehiculoNoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void mostrarEstado(Garage garage) {
        System.out.println("\n--- Estado del garage ---");
        System.out.printf("Capacidad total: %d%n", garage.getCapacidadMaxima());
        System.out.printf("Espacios ocupados: %d%n", garage.getEspaciosOcupados());
        System.out.printf("Espacios disponibles: %d%n", garage.espaciosDisponibles());
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

    private static int leerHoras(Scanner sc) throws HorasInvalidasException {
        int horas = leerEntero(sc, "Horas: ");
        if (horas <= 0) {
            throw new HorasInvalidasException("Horas invalidas");
        }
        return horas;
    }

    private static int leerEnteroRango(Scanner sc, String mensaje, int minimo, int maximo) {
        while (true) {
            int valor = leerEntero(sc, mensaje);
            if (valor >= minimo && valor <= maximo) {
                return valor;
            }
            System.out.println("Opcion invalida.");
        }
    }

    private static int leerEntero(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                int valor = Integer.parseInt(sc.nextLine().trim());
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Error: ingreso invalido");
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
            System.out.println("Error: el campo no puede estar vacio.");
        }
    }

    private static void mostrarEncabezado() {
        System.out.println(LINEA);
        System.out.println(TITULO);
        System.out.println("Registro, egreso y control de espacios");
        System.out.println(LINEA);
    }

    private static void mostrarMenu(Garage garage) {
        System.out.println();
        System.out.println("Garage: " + garage.getEspaciosOcupados() + "/" + garage.getCapacidadMaxima() + " ocupados");
        System.out.println("1. Ingresar vehiculo");
        System.out.println("2. Egresar vehiculo");
        System.out.println("3. Listar vehiculos");
        System.out.println("4. Ver estado");
        System.out.println("5. Ver reportes");
        System.out.println("0. Salir");
    }
}

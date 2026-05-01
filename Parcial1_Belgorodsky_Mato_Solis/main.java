package Parcial1_Belgorodsky_Mato_Solis;

import java.util.Scanner;

public class main {
    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Capacidad del garage: ");
        int capacidad = sc.nextInt();

        garage garage = new garage(capacidad);

        int opcion;

        do {
            System.out.println("\n1. Ingresar");
            System.out.println("2. Egresar");
            System.out.println("3. Listar");
            System.out.println("4. Espacios libres");
            System.out.println("0. Salir");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Tipo (1 Moto, 2 Auto, 3 Camion): ");
                    int tipo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Patente: ");
                    String patente = sc.nextLine();
                    System.out.print("Marca: ");
                    String marca = sc.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = sc.nextLine();
                    System.out.print("Horas: ");
                    int horas = sc.nextInt();

                    vehiculo v = null;

                    if (tipo == 1) v = new moto(patente, marca, modelo, horas);
                    if (tipo == 2) v = new Auto(patente, marca, modelo, horas);
                    if (tipo == 3) v = new Camion(patente, marca, modelo, horas);

                    if (garage.ingresarVehiculo(v)) {
                        System.out.println("OK");
                    } else {
                        System.out.println("Sin espacio");
                    }
                    break;

                case 2:
                    sc.nextLine();
                    System.out.print("Patente: ");
                    String pat = sc.nextLine();

                    vehiculo salida = garage.egresarVehiculo(pat);

                    if (salida != null) {
                        System.out.println("Costo: $" + salida.calcularCosto());
                    } else {
                        System.out.println("No encontrado");
                    }
                    break;

                case 3:
                    garage.listarVehiculos();
                    break;

                case 4:
                    System.out.println("----- ESTADO DEL GARAGE -----");
                    System.out.println("Capacidad total: " + garage.getCapacidadMaxima());
                    System.out.println("Espacios ocupados: " + garage.getEspaciosOcupados());
                    System.out.println("Espacios disponibles: " + garage.espaciosDisponibles());
                     break;
            }

        } while (opcion != 0);
    }
}

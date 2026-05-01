package Parcial1_Belgorodsky_Mato_Solis;

import java.util.Scanner;

public class main {
    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Capacidad del garage: ");
        int capacidad = sc.nextInt();

        garage garage = new garage(capacidad);

        int opcion = -1;

        //carga de menu
        do {
            System.out.println("\n1. Ingresar");
            System.out.println("2. Egresar");
            System.out.println("3. Listar");
            System.out.println("4. Espacios libres");
            System.out.println("5. Reportes");
            System.out.println("0. Salir");

        //valida que se ingrese una opcion correcta del menu   
        try {
            opcion = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Error: ingreso inválido");
        sc.nextLine();
        continue;
        }

        if (opcion < 0 || opcion > 5) {
            System.out.println("Opción inválida");
        continue;
        }

            switch (opcion) {
                case 1:
                    System.out.println("Tipo (1 Moto, 2 Auto, 3 Camion): ");
            int tipo;
        
        //valida opcion valida del menu TIPO
            try {
             tipo = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Error: tipo inválido");
                sc.nextLine();
            continue;
            }

            if (tipo < 1 || tipo > 3) {
               System.out.println("Tipo inválido");
            continue;
            }
                   sc.nextLine();

// PATENTE
String patente;
while (true) {
    System.out.print("Patente: ");
    patente = sc.nextLine();

    if (patente.isEmpty()) {
        System.out.println("Error: la patente no puede estar vacía");
    } else {
        break;
    }
}

// MARCA
String marca;
while (true) {
    System.out.print("Marca: ");
    marca = sc.nextLine();

    if (marca.isEmpty()) {
        System.out.println("Error: la marca no puede estar vacía");
    } else {
        break;
    }
}

// MODELO
String modelo;
while (true) {
    System.out.print("Modelo: ");
    modelo = sc.nextLine();

    if (modelo.isEmpty()) {
        System.out.println("Error: el modelo no puede estar vacío");
    } else {
        break;
    }
}
            
System.out.print("Horas: ");
int horas=-1;

// Primero validás tipo de dato
try {
    horas = sc.nextInt();
} catch (Exception e) {
    System.out.println("Error: ingreso inválido");
    sc.nextLine();
    continue;
}

// Después validás lógica de negocio
try {
    if (horas <= 0) {
        throw new HorasInvalidasException("Horas inválidas");
    }
} catch (HorasInvalidasException e) {
    System.out.println(e.getMessage());
    continue;
}

                    vehiculo v = null;

                    if (tipo == 1) v = new moto(patente, marca, modelo, horas);
                    if (tipo == 2) v = new Auto(patente, marca, modelo, horas);
                    if (tipo == 3) v = new Camion(patente, marca, modelo, horas);

                try {
                     garage.ingresarVehiculo(v);
                     System.out.println("Vehículo ingresado correctamente");
                } catch (PatenteDuplicadaException e) {
                    System.out.println(e.getMessage());
                } catch (GarageLlenoException e) {
                    System.out.println(e.getMessage());
                }
                break;

                case 2:
                    sc.nextLine();
                    System.out.print("Patente: ");
                    String pat = sc.nextLine();

                try {
                    vehiculo salida = garage.egresarVehiculo(pat);
                    System.out.println("Costo: $" + salida.calcularCosto());
                } catch (VehiculoNoEncontradoException e) {
                     System.out.println(e.getMessage());
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

                case 5:
                    garage.mostrarReporte();
                    break;
            }

        } while (opcion != 0);
    }
}

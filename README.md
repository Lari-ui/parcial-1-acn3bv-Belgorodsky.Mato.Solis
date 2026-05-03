# parcial-1-acn3bv-Belgorodsky.Mato.Solis

# Sistema de Garage

Sistema de consola desarrollado en Java para administrar un garage con capacidad limitada.

Permite ingresar vehiculos, egresarlos, listar los vehiculos estacionados, consultar el estado del garage y generar reportes.

## Ejecucion

Desde una terminal o desde la terminal integrada de Visual Studio Code:

```powershell
javac -d out src\*.java
java -cp out src.Main
```

## Funcionalidades

- Definir la capacidad maxima del garage.
- Ingresar motos, autos y camiones.
- Validar que haya espacio disponible.
- Validar que no existan patentes duplicadas.
- Validar que las horas ingresadas sean correctas.
- Egresar vehiculos por patente.
- Calcular el costo de estadia.
- Listar vehiculos estacionados.
- Ver espacios ocupados y disponibles.
- Generar un reporte general del garage.

## Estructura del proyecto

```text
parcial-1-acn3bv-Belgorodsky.Mato.Solis/
├── docs/
│   └── Caso_de_usos.pdf
│   └── UML.pdf
│   └── decisiones_diseno.txt
├── src/
│   ├── Auto.java
│   ├── Calculable.java
│   ├── Camion.java
│   ├── Garage.java
│   ├── GarageLlenoException.java
│   ├── HorasInvalidasException.java
│   ├── Main.java
│   ├── Mostrable.java
│   ├── Moto.java
│   ├── PatenteDuplicadaException.java
│   ├── Vehiculo.java
│   └── VehiculoNoEncontradoException.java
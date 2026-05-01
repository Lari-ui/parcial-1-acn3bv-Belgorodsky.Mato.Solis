# parcial-1-acn3bv-Belgorodsky.Mato.Solis

## Examen
- Parcial 1 - Programacion Avanzada
- AÑO LECTIVO: 2026
- DOCENTES: Bruno, Emmanuel

## Descripcion
Sistema de gestion de garage desarrollado en Java con POO, herencia, polimorfismo, interfaces, colecciones y manejo de excepciones.

## Funcionalidades
- Registrar ingreso de vehiculos
- Registrar egreso de vehiculos
- Listar vehiculos estacionados
- Mostrar estado del garage
- Generar reportes basicos

## Modelo
- `Vehiculo` como clase base
- `Moto`, `Auto` y `Camion` como subclases
- `Calculable` y `Mostrable` como interfaces
- `Garage` como clase de gestion principal

## Validaciones
- Patente unica
- Horas mayores a 0
- Campos no vacios
- No ingresar vehiculos sin espacio disponible
- No egresar vehiculos inexistentes
- Opciones invalidas del menu

## Excepciones
- `GarageLlenoException`
- `PatenteDuplicadaException`
- `VehiculoNoEncontradoException`
- `HorasInvalidasException`

## Reportes
- Cantidad total de vehiculos
- Cantidad por tipo
- Espacio ocupado
- Espacio libre
- Recaudacion total estimada

## Estructura del proyecto
- `src/` codigo fuente
- `uml/` documentacion UML
- `CONSIGNA.md` consigna del parcial

## Ejecucion
Compilar y ejecutar la clase `Main` dentro del paquete `src`.

## Entrega
- Codigo fuente completo
- Documento UML en PDF
- README.md
- Fundamentacion de decisiones de diseño
- Repositorio Git con commits progresivos

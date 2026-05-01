# parcial-1-acn3bv-Belgorodsky.Mato.Solis

EXAMEN: 
Parcial 1 
AÑO LECTIVO: 
2026 
DOCENTES: 
Bruno, Emmanuel  
1 
Parcial 1 – Programación avanzada 
EXAMEN PARCIAL 1 – Programación Avanzada. 
Formato de entrega: 
El parcial se puede entregar de forma grupal o individual. 
Deberá ser entregado en un archivo comprimido con el nombre y apellido del 
alumno. 
El archivo comprimido deberá contener: 
● Código fuente completo del proyecto 
● Documentación UML (PDF) 
● Archivo README.md 
● Archivo .txt con fundamentación de decisiones de diseño 
● Link al repositorio Git utilizado durante el desarrollo 
Desarrollo de la consigna: 
Una empresa dedicada a la administración de espacios de estacionamiento desea 
desarrollar un sistema que permita gestionar el ingreso, permanencia y salida de 
vehículos dentro de un garage. 
Cada vehículo contará con una identificación compuesta por patente, marca, modelo 
y horas estimadas de permanencia. Dependiendo del tipo de vehículo, este ocupará 
una cantidad distinta de espacios dentro del garage y tendrá un costo por hora 
específico. 
El sistema deberá permitir registrar el ingreso de vehículos, controlar la 
disponibilidad de espacio, gestionar la salida de los mismos y calcular el costo total 
de su permanencia. 
Al iniciar el programa, se deberá registrar el garage indicando su capacidad máxima 
de espacios. Luego, el sistema permitirá operar mediante un menú interactivo por 
consola. 
Funcionamiento del sistema: 
Una vez iniciado el programa: 
1. Se inicializa el garage con una capacidad máxima. 
2. Se podrán registrar vehículos indicando: 
○ tipo de vehículo (Moto, Auto o Camión) 
Parcial 1 – Programación avanzada 
2 
○ patente 
○ marca 
○ modelo 
○ horas estimadas 
3. El sistema deberá validar que exista espacio suficiente antes de permitir el 
ingreso. 
4. Dependiendo del tipo de vehículo: 
○ Moto → ocupa 1 espacio → $700/hora 
○ Auto → ocupa 2 espacios → $1000/hora 
○ Camión → ocupa 4 espacios → $1500/hora 
5. El sistema deberá permitir: 
○ registrar ingreso de vehículo 
○ registrar salida de vehículo 
○ listar vehículos estacionados 
○ visualizar estado del garage 
○ generar reportes 
Al finalizar una operación (por ejemplo, la salida de un vehículo), se deberá mostrar 
un resumen con la información correspondiente. 
Módulo de Vehículos 
El sistema deberá modelar distintos tipos de vehículos: 
● Moto 
● Auto 
● Camión 
Requisitos 
Cada vehículo debe tener: 
● patente (única) 
● marca 
● modelo 
● horas estimadas de permanencia 
Jerarquía 
Debe existir: 
● Clase base: Vehiculo 
● Subclases: 
○ Moto 
○ Auto 
Parcial 1 – Programación avanzada 
3 
○ Camion 
Comportamientos obligatorios 
Cada vehículo debe poder: 
● calcular su costo 
● informar su espacio ocupado 
● mostrar sus datos 
Módulo de Garage 
El garage será el núcleo del sistema. 
Características 
● Tiene una capacidad máxima de espacios 
● Administra los vehículos estacionados 
Espacio ocupado por tipo 
● Moto → 1 espacio 
● Auto → 2 espacios 
● Camión → 4 espacios 
Funcionalidades 
El sistema debe permitir: 
● Registrar ingreso de vehículo 
● Registrar salida de vehículo 
● Listar vehículos estacionados 
● Mostrar estado del garage 
Estado del garage 
Debe mostrar: 
● Capacidad total 
● Espacio ocupado 
● Espacio disponible 
Módulo de Cálculo de Costos 
4 
Parcial 1 – Programación avanzada 
El sistema debe calcular el costo de cada vehículo en función de: 
● horas estimadas 
● tarifa por tipo 
Tarifas 
● Moto → $700/hora 
● Auto → $1000/hora 
● Camión → $1500/hora 
Requisito clave 
Debe utilizarse polimorfismo, evitando estructuras tipo: 
if (tipo == "Auto") ... 
Interfaces 
El sistema debe incorporar al menos una interfaz. 
Ejemplo sugerido 
public interface Calculable { 
double calcularCosto(); 
} 
También puede agregarse: 
public interface Mostrable { 
void mostrarDatos(); 
} 
Colecciones 
Los vehículos deben almacenarse en una colección, por ejemplo: 
ArrayList<Vehiculo> 
El sistema debe permitir: 
● agregar vehículos 
5 
Parcial 1 – Programación avanzada 
● eliminar vehículos 
● recorrer la colección 
● buscar por patente 
Validaciones 
El sistema debe validar correctamente todos los datos ingresados. 
No permitido: 
● patentes duplicadas 
● horas ≤ 0 
● campos vacíos 
● ingreso sin espacio disponible 
● salida de vehículo inexistente 
● opciones inválidas en menú 
● tipos de datos incorrectos 
Excepciones 
El sistema debe manejar errores sin finalizar la ejecución. 
Uso obligatorio de: 
● try-catch 
● excepciones estándar 
Excepciones personalizadas: 
● GarageLlenoException 
● PatenteDuplicadaException 
● VehiculoNoEncontradoException 
● HorasInvalidasException 
Reportes 
El sistema debe incluir reportes básicos. 
Reportes mínimos 
6 
Parcial 1 – Programación avanzada 
● cantidad total de vehículos 
● cantidad por tipo 
● espacio ocupado 
● espacio libre 
● recaudación total estimada 
Interfaz por Consola 
El sistema debe ejecutarse mediante un menú interactivo. 
Ejemplo 
=== SISTEMA DE GARAGE === 
1. Registrar ingreso 
2. Registrar salida 
3. Listar vehículos 
4. Estado del garage 
5. Reportes 
6. Salir 
Documentación UML 
Deberá realizar la documentación UML completa del sistema desarrollado. 
Se espera que se grafique la totalidad del sistema, representando su estructura y 
comportamiento de forma clara y organizada. 
Requisitos 
Deberá incluir obligatoriamente: 
● Diagrama de Clases 
● Diagrama de Casos de Uso 
Los diagramas deberán: 
7 
Parcial 1 – Programación avanzada 
● Representar correctamente las clases, relaciones y funcionalidades del 
sistema 
● Reflejar el diseño implementado en el código 
● Ser claros, ordenados y coherentes con la solución desarrollada 
Formato de entrega 
● La documentación deberá entregarse en formato PDF 
● Deberá ubicarse dentro de la carpeta /docs del proyecto 
● El archivo deberá tener un nombre claro y representativo del contenido 
Control de Versiones (Git) 
El parcial debe desarrollarse utilizando Git. 
Requisitos 
● Repositorio en: 
○ GitHub / GitLab / Bitbucket 
● Acceso para el docente 
● Uso de commits 
Buenas prácticas 
● commits progresivos 
● mensajes descriptivos 
Criterios de evaluación: 
Se valorará: 
● correcto uso de Programación Orientada a Objetos 
● implementación de herencia y polimorfismo 
● uso adecuado de interfaces 
● manejo de colecciones 
● validaciones de negocio 
● manejo de excepciones 
● funcionamiento del sistema 
● claridad y organización del código 
● documentación UML 
● uso de control de versiones 
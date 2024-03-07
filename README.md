# SISTEMA DE GESTION DE EMPLEADOS
***
Este programa permite realizar altas, bajas, edición y consultas de los empleados de la empresa, así como también filtrar los datos por el cargo que ocupan los empleados. Agiliza la gestión y tratamiento de los datos almacenados en la base de datos.
***
## Tecnologías utilizadas:
- Java
- JPA
- Base de datos relacional MySQL.

## Como descargar el proyecto:
1. Clonar el repositorio del proyecto en la pc local. Ejecutar el siguiente comando: 
	git clone https://github.com/Patito02/BaezPatricia_pruebatec1.git
2. Desde el IDE importar el proyecto.
3. Crear una base de datos y hacer la conexión desde el IDE para la persistencia de los datos.
4. Ejecuta la aplicación.

##Supuestos
Al realizar la creación de un empleado se supone que el usuario va a ingresar fechas anteriores o iguales al día de la carga ya que son fechas de inicio laboral del empleado. Lo mismo se aplica cuando se hace la edición de las fechas. Además, no podrían ser fechas anteriores al comienzo de la vida de la empresa.
En la creación verifica si el empleado ya existe, aunque se supone que el usuario sabe que no está registrado en el sistema.
Al realizar una edición o eliminación se supone que el usuario conoce los Id de los empleados activos, pero se agregó la opción de obtener un listado de los empleados para facilitar la búsqueda.

## Utilización de la aplicación
Desde el menú inicial permite elegir entre las siguientes opciones: 
1. Agregar un nuevo empleado
Se deben ingresar los datos del nuevo empleado: Nombre, Apellido, Cargo, Salario y Fecha de Inicio.
2. Listar todos los empleados
Esta opción simplemente muestra todos los empleados en estado Activo que están registrados en la base de datos.
3. Actualizar información de un empleado
Pide ingresar el id del empleado a modificar y luego pregunta cuál es el dato a modificar: Nombre, Apellido, Cargo, Salario o Fecha de Inicio. 
4. Eliminar un empleado
Solicita ingresar el id del empleado a eliminar. 
5. Buscar empleados por cargo
Pide ingresar el cargo por el cual se desea filtrar y muestra un listado de todos los empleados activos con ese cargo.
6. Salir
Por último está la opción de salir del sistema desde el menú principal.

## Explicación de métodos
En la clase Metodo se encuentran todos los métodos utilizados.
La creación de un Empleado se realiza luego de la comprobación de la integridad de los datos ingresados y de los datos ya registrados.
El listado de los empleados vigentes se realiza luego de la comprobación del estado Activo de los empleados de la base de datos.
La edición de los empleados se realiza luego de comprobar su existencia en la base de datos y su estado Activo como empleados. Se pueden modificar solamente los datos personales del empleado. No se pueden editar los datos del Id y Estado de los empleados.
Para la eliminación de empleados se realizó un borrado lógico, por lo que el valor del campo Estado es true al crearse un nuevo Empleado y al eliminarse cambia a false, esto sólo sucede tras la comprobación de la existencia y el estado activo del empleado.
Para la búsqueda de los Cargos de los empleados se creó un método que utiliza una query para traer los datos ya filtrados desde la base de datos y optimizar el funcionamiento del programa.

### Desarrolladores y creadores
La desarrolladora de este programa no se hace responsable por el mal uso del software. Queda prohibida la alteración del código fuente y su venta sin autorización de la creadora.

### Consultas y Sugerencias
Ante alguna consulta o sugerencia por favor enviar un mensaje a la siguiente dirección de correo electrónico: patriciabaez1987@gmail.com

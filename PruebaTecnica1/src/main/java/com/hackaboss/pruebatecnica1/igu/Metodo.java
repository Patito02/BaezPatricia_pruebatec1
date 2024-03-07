package com.hackaboss.pruebatecnica1.igu;

import com.hackaboss.pruebatecnica1.logica.Controladora;
import com.hackaboss.pruebatecnica1.logica.Empleado;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Metodo {

    Controladora control = new Controladora();
    Scanner scannerInt = new Scanner(System.in);
    Scanner scannerString = new Scanner(System.in);
    String nombreEmp, apellidoEmp, cargoEmp;
    int dia = 0, mes = 0, anio = 0, salarioEmp = 0;
    boolean fechaValida;
    LocalDate fechaEmp;

    public Metodo() {
    }

    public void crearEmpleado() {

        List<Empleado> listaCreacion = new ArrayList<Empleado>();
        String ingresaOtro = "";

        do {
            System.out.println("Ingrese los datos del empleado");
            insertarNombreEmp();
            insertarApellidoEmp();
            insertarCargoEmp();
            insertarSalarioEmp();
            insertarFechaInicioEmp();
            
            boolean existe = control.empleadoExiste(nombreEmp, apellidoEmp);

            if (existe) {
                System.out.println("El empleado ya esta registrado en la base de datos.");
                consultaListarEmpleados();
            } else if(!existe && fechaValida){
                listaCreacion.add(new Empleado(1, nombreEmp, apellidoEmp,
                        cargoEmp, salarioEmp, fechaEmp));
                System.out.println("Empleado ingresado correctamente.");
            }

            System.out.println("Desea ingresar otro empleado? Si/No");
            ingresaOtro = scannerString.nextLine();

        } while (ingresaOtro.equalsIgnoreCase("Si"));

        for (Empleado emp : listaCreacion) {
            control.crearEmpleado(emp);
        }
    }

    public void listarEmpleados() {

        List<Empleado> listaEmpleados = control.traerEmpleados();
        if(listaEmpleados.isEmpty()){
            System.out.println("No hay empleados para listar.");
        } else {
            System.out.println("La lista de empleados es: ");
            for (Empleado emp : listaEmpleados) {
                System.out.println("ID: " + emp.getId() + ", Nombre: " + emp.getNombre() + ", Apellido: "
                        + emp.getApellido() + ", Cargo: " + emp.getCargo() + ", Salario: "
                        + emp.getSalario() + ", Fecha de Inicio: " + emp.getFechaInicio());
            }
        }
        
    }

    public void editarEmpleado() {

        boolean salirEditar = false;

        while (!salirEditar) {
            
            consultaListarEmpleados();
            System.out.println("Ingrese el id del empleado a modificar: ");
            int modifEmp = scannerInt.nextInt();
            Empleado empleEditar = control.traerEmpleado(modifEmp);
            
            if(empleEditar == null){
                System.out.println("No es un id válido");
            } else if (empleEditar.getEstado()==false){
                System.out.println("Empleado no existe en sistema");
            } else {
                System.out.println("Que desea modificar?"
                    + "\n1. Nombre"
                    + "\n2. Apellido"
                    + "\n3. Cargo"
                    + "\n4. Salario"
                    + "\n5. Fecha de Inicio");
                
                System.out.println("Ingrese su opción: ");
                int opcion = scannerInt.nextInt();

                switch (opcion) {
                    case 1:
                        insertarNombreEmp();
                        empleEditar.setNombre(nombreEmp);
                        break;
                    case 2:
                        insertarApellidoEmp();
                        empleEditar.setApellido(apellidoEmp);
                        break;
                    case 3:
                        insertarCargoEmp();
                        empleEditar.setCargo(cargoEmp);
                        break;
                    case 4:
                        insertarSalarioEmp();
                        empleEditar.setSalario(salarioEmp);
                        break;
                    case 5:
                        insertarFechaInicioEmp();
                        empleEditar.setFechaInicio(fechaEmp);
                        break;
                    default:
                        System.out.println("Ingrese una opción válida");
                        break;
                }
                if (opcion >0 && opcion<5 ){
                    control.editarEmpleado(empleEditar);
                    System.out.println("Cambios guardados.");
                } else if(opcion==5 && fechaValida==true){
                    control.editarEmpleado(empleEditar);
                    System.out.println("Cambios guardados.");
                }
            }
            
            System.out.println("Desea finalizar la edición? Si/No");
            String salir = scannerString.nextLine();
            if (salir.equalsIgnoreCase("Si")) {
                salirEditar = true;
            }
        }
    }

    public void eliminarEmpleado() {

        consultaListarEmpleados();
        System.out.println("Ingrese el id del empleado a eliminar: ");
        int idEmp = scannerInt.nextInt();
        Empleado empleEliminar = control.traerEmpleado(idEmp);
        
        if(empleEliminar == null){
            System.out.println("No es un id válido");
        } else if (empleEliminar.getEstado()==false){
            System.out.println("Empleado no existe en sistema");
        } else {
            control.eliminarEmpleado(empleEliminar);
            System.out.println("Se ha eliminado el registro");
        }

    }

    public void buscarCargoEmpleado() {

        boolean salirBuscar = false;

        while (!salirBuscar) {

            int coincide = 0;
            consultaListarEmpleados();
            
            System.out.println("Elegir el cargo por el cual quiere filtrar: ");
            String cargoBuscado = scannerString.nextLine();
            
            while (cargoBuscado.isEmpty()) {
                System.out.println("Por favor ingrese un cargo");
                cargoBuscado = scannerString.nextLine();
            }

            List<Empleado> listaEmpleados = control.buscarCargo(cargoBuscado);
            for (Empleado emp : listaEmpleados) {
                System.out.println("ID: " + emp.getId() + ", Nombre: " + emp.getNombre()
                        + ", Cargo: " + emp.getCargo() + ", Salario: " + emp.getSalario()
                        + ", Fecha de Inicio: " + emp.getFechaInicio());
                coincide++;
            }
            if (coincide == 0) {
                System.out.println("No hay coincidencias.");
            }

            System.out.println("Desea listar otro cargo? Si/No");
            String salir = scannerString.nextLine();
            if (salir.equalsIgnoreCase("No")) {
                salirBuscar = true;
            }
        }

    }

    public void insertarNombreEmp() {
        
        System.out.println("Nombre: ");
        nombreEmp = scannerString.nextLine();
        while (nombreEmp.isEmpty()) {
            System.out.println("Por favor ingrese un nombre: ");
            nombreEmp = scannerString.nextLine();
        }
    }

    public void insertarApellidoEmp() {
        
        System.out.println("Apellido: ");
        apellidoEmp = scannerString.nextLine();
        while (apellidoEmp.isEmpty()) {
            System.out.println("Por favor ingrese un apellido: ");
            apellidoEmp = scannerString.nextLine();
        }
    }

    public void insertarCargoEmp() {
        
        System.out.println("Cargo: ");
        cargoEmp = scannerString.nextLine();
        while (cargoEmp.isEmpty()) {
            System.out.println("Por favor ingrese un cargo: ");
            cargoEmp = scannerString.nextLine();
        }
    }

    public void insertarSalarioEmp() {
        
        System.out.println("Salario: ");
        salarioEmp = scannerInt.nextInt();
        while (salarioEmp <= 0) {
            System.out.println("Por favor ingrese un salario: ");
            salarioEmp = scannerInt.nextInt();
        }
    }

    public void insertarFechaInicioEmp() {
        
        System.out.println("Fecha de Inicio--> Dia: ");
        dia = scannerInt.nextInt();
        System.out.println("Fecha de Inicio--> Mes: ");
        mes = scannerInt.nextInt();
        System.out.println("Fecha de Inicio--> Año: ");
        anio = scannerInt.nextInt();
        
        if (validarFecha(anio, mes, dia)) {
            fechaEmp = LocalDate.of(anio, mes, dia);
            fechaValida = true;
        } else {
            fechaValida = false;
        }
        
    }

    public boolean validarFecha(int anio, int mes, int dia) {
        try {
            LocalDate fechaEmp = LocalDate.of(anio, mes, dia);
            LocalDate fechaHoy = LocalDate.now();
            
            if(fechaEmp.isBefore(fechaHoy)){
                return true;
            } else {
                System.out.println("La fecha no es válida");
                return false;
            }
        } catch (Exception e) {
            System.out.println("La fecha no es válida");
            return false;
        }
    }

    public void consultaListarEmpleados() {
        System.out.println("Desea listar los datos de empleados? Si/No");
        String opc = scannerString.nextLine();
        if (opc.equalsIgnoreCase("Si")) {
            listarEmpleados();
        }
    }

    void salirSistema() {
        System.exit(0);
    }
}

package com.hackaboss.pruebatecnica1.igu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    
    public Menu() {
     
    Metodo metodo = new Metodo();
    Scanner scannerInt = new Scanner(System.in);
    Scanner scannerString = new Scanner(System.in);
        
        int opcion;
        boolean salirSistema = false;
        try{
            while(!salirSistema){

                do {
                    System.out.println("******************************************************");
                    System.out.println("*   Bienvenido al sistema de gestión de empleados    *");
                    System.out.println("******************************************************");

                    System.out.println("Seleccione la opción deseada: "
                            + "\n1. Agregar un nuevo empleado"
                            + "\n2. Listar todos los empleados"
                            + "\n3. Actualizar información de un empleado"
                            + "\n4. Eliminar un empleado"
                            + "\n5. Buscar empleados por cargo"
                            + "\n6. Salir");

                    System.out.println("\nIngrese la selección: ");
                    opcion = scannerInt.nextInt();

                    switch (opcion) {
                    case 1:
                        metodo.crearEmpleado();
                        break;
                    case 2:
                        metodo.listarEmpleados();
                        break;
                    case 3:
                        metodo.editarEmpleado();
                        break;
                    case 4:
                        metodo.eliminarEmpleado();
                        break;
                    case 5:
                        metodo.buscarCargoEmpleado();
                        break;
                    case 6:
                        metodo.salirSistema();
                        break;
                    default:
                        System.out.println("Ingrese una opcion válida");
                    }

                } while (opcion < 1 || opcion > 5);

                System.out.println("---------------------------------------------------------------------------------------------");
                System.out.println("Desea salir del sistema? Si/No :");
                String salir = scannerString.nextLine();

                if (salir.equalsIgnoreCase("Si")){
                    salirSistema = true;
                }

            }
        }catch(InputMismatchException e){
            System.out.println("Error en el tipo de dato ingresado.");
            Menu menu = new Menu();
        }
    }
}

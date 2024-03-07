package com.hackaboss.pruebatecnica1.persistencia;

import com.hackaboss.pruebatecnica1.logica.Empleado;
import com.hackaboss.pruebatecnica1.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {
    
    EmpleadoJpaController empleJpa = new EmpleadoJpaController();
    
    public void crearEmpleado(Empleado emple) {
        empleJpa.create(emple);
    }

    public List<Empleado> traerEmpleados() {
        return empleJpa.findEmpleadoExisten();
    }

    public Empleado traerEmpleado(int id) {
        return empleJpa.findEmpleado(id);
    }

    public void editarEmpleado(Empleado emple) {
        try {
            empleJpa.edit(emple);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarEmpleado(Empleado emple) {
        try {
            emple.setEstado(false);
            empleJpa.edit(emple);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (Exception ex) { 
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Empleado> buscarCargo(String cargo) {
        return empleJpa.findByCargo(cargo);
    }

    public boolean empleadoExiste(String nombre, String apellido) {
        return empleJpa.empleadoExiste(nombre,apellido);
    }


}

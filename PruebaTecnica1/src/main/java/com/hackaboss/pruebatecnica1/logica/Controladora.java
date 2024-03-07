package com.hackaboss.pruebatecnica1.logica;

import com.hackaboss.pruebatecnica1.persistencia.ControladoraPersistencia;
import java.util.List;

public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    public void crearEmpleado(Empleado emple) {
        controlPersis.crearEmpleado(emple);
    }

    public List<Empleado> traerEmpleados() {
        return controlPersis.traerEmpleados();
    }

    public Empleado traerEmpleado(int id) {
        return controlPersis.traerEmpleado(id);
    }

    public void editarEmpleado(Empleado emple) {
        controlPersis.editarEmpleado(emple);
    }

    public void eliminarEmpleado(Empleado emple) {
            controlPersis.eliminarEmpleado(emple);
    }

    public List<Empleado> buscarCargo(String cargoBuscado) {
        return controlPersis.buscarCargo(cargoBuscado);
    }

    public boolean empleadoExiste(String nombre, String apellido) {
        return controlPersis.empleadoExiste(nombre,apellido);
    }

    
}

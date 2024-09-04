package co.tarjetaCredito.servicios;

import java.util.List;

import co.tarjetaCredito.entidades.Empleado;


public interface EmpleadoServ {
    
    public boolean saveEmpleado(Empleado empleado);

    List<Empleado> obtenerEmpleados();

    boolean validarEmpleado(String correo, String contrasena);

    List<Empleado> buscarCorreo(String correo);

    Empleado exexistsByEmpleado(String correo);
}

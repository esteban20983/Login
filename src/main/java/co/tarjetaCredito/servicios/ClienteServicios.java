package co.tarjetaCredito.servicios;

import co.tarjetaCredito.entidades.Cliente;

public interface ClienteServicios {
    Cliente guardarCliente(Cliente cliente);
    
    Cliente obtenerCliente(Integer serial);

    Cliente modificarCliente(Integer serial, Cliente cliente);

    boolean eliminarCliente(Integer serial);

    Cliente validarCliente( String tipo, String correo, String contrasena, String password);

    Cliente validarCliente(String tipo, String correo, String contrasena);
}

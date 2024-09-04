package co.tarjetaCredito.Imp;

import co.tarjetaCredito.servicios.ClienteServicios;
import co.tarjetaCredito.entidades.Cliente;
import co.tarjetaCredito.entidades.Empleado;
import co.tarjetaCredito.repositorios.ClienteRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientesIMPL implements ClienteServicios {

    @Autowired
    private ClienteRepo clienteRepo;

    @Override
    public Cliente guardarCliente(Cliente cliente) {
        List<Cliente> emp = this.clienteRepo.findByCorreo(cliente.getCorreo());
        if (emp.size()>0) {
            return null;
        }else{
            return clienteRepo.save(cliente);
        }
    }

    @Override
    public Cliente obtenerCliente(Integer id) {
        Optional<Cliente> clienteOpt = clienteRepo.findById(id);
        return clienteOpt.orElse(null);
    }

    @Override
    public Cliente modificarCliente(Integer serial, Cliente cliente) {
        if (clienteRepo.existsById(serial)) {
            return clienteRepo.save(cliente);
        }
        return null;
    }

    @Override
    public boolean eliminarCliente(Integer serial) {
        if (clienteRepo.existsById(serial)) {
            clienteRepo.deleteById(serial);
            return true;
        }
        return false;
    }

    @Override
    public Cliente validarCliente(String correo, String contrasena) {
        List<Cliente> cliente = (List<Cliente>) this.clienteRepo.findByCorreo(correo);
        for(Cliente objemp: cliente) {
            if(objemp.getContrasena().equals(contrasena)){
                return objemp;
            }else{
                return null;
            }
        }
        return null;
    }
}

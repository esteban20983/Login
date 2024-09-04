package co.tarjetaCredito.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.tarjetaCredito.entidades.Cliente;

@Repository
public interface ClienteRepo extends CrudRepository<Cliente, Integer>{

    List<Cliente> findByCorreo(String correo);
    
}

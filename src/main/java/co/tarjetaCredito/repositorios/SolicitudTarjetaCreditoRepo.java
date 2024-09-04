package co.tarjetaCredito.repositorios;

import org.springframework.stereotype.Repository;

import co.tarjetaCredito.entidades.Cliente;
import co.tarjetaCredito.entidades.SolicitudTarjetaCredito;

import org.springframework.data.repository.CrudRepository;
import java.util.List;


@Repository
public interface SolicitudTarjetaCreditoRepo extends CrudRepository<SolicitudTarjetaCredito, Integer>{
    
    SolicitudTarjetaCredito findByCliente(Cliente cliente);

}

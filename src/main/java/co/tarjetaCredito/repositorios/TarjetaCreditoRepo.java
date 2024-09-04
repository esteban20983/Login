package co.tarjetaCredito.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.tarjetaCredito.entidades.Cliente;
import co.tarjetaCredito.entidades.TarjetaCredito;
import java.util.List;


@Repository
public interface TarjetaCreditoRepo extends CrudRepository<TarjetaCredito,Integer>{
    
    TarjetaCredito findByCliente(Cliente cliente);
}

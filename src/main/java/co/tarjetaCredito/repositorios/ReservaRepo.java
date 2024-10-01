package co.tarjetaCredito.repositorios;

import co.tarjetaCredito.entidades.Cliente;
import co.tarjetaCredito.entidades.Reservas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReservaRepo extends JpaRepository<Reservas,Long> {

}



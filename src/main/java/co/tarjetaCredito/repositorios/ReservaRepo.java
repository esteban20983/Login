package co.tarjetaCredito.repositorios;

import co.tarjetaCredito.entidades.Reservas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepo extends JpaRepository<Reservas,Long> {

}

package co.tarjetaCredito.Imp;

import co.tarjetaCredito.entidades.Cliente;
import co.tarjetaCredito.entidades.Reservas;
import co.tarjetaCredito.repositorios.ReservaRepo;
import co.tarjetaCredito.servicios.ReservaServicios;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.List;
import java.util.Optional;


@Service

public class ReservaIMPL implements ReservaServicios {
    @Autowired
    private ReservaRepo reservaRepo;

    @Transactional
    public void guardarReserva(Reservas reservas, Cliente cliente) {
        reservas.setCliente(cliente);
        reservaRepo.save(reservas);
    }

}

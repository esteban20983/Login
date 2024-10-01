package co.tarjetaCredito.servicios;


import co.tarjetaCredito.entidades.Cliente;
import co.tarjetaCredito.entidades.Reservas;

public interface ReservaServicios{
    void guardarReserva(Reservas reservas, Cliente cliente);
}


package co.tarjetaCredito.servicios;

import org.hibernate.mapping.List;
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties.Web.Client;

import co.tarjetaCredito.entidades.Cliente;
import co.tarjetaCredito.entidades.TarjetaCredito;

public interface TarjetaCreditoServ {

    TarjetaCredito guardarTarjeta(TarjetaCredito tarjeta);

    TarjetaCredito findByCliente(Cliente cl);
}

package co.tarjetaCredito.Imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.tarjetaCredito.entidades.Cliente;
import co.tarjetaCredito.entidades.TarjetaCredito;
import co.tarjetaCredito.repositorios.TarjetaCreditoRepo;
import co.tarjetaCredito.servicios.TarjetaCreditoServ;

@Service
public class TarjetaCreditoImp implements TarjetaCreditoServ {

    @Autowired
    private TarjetaCreditoRepo tarjetaRepo;

    @Override
    public TarjetaCredito guardarTarjeta(TarjetaCredito tarjeta) {
      return tarjetaRepo.save(tarjeta);
    }

    @Override
    public TarjetaCredito findByCliente(Cliente cl) {
      return tarjetaRepo.findByCliente(cl);
    }
    
}

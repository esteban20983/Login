package co.tarjetaCredito.Imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.qos.logback.core.joran.conditional.ElseAction;
import co.tarjetaCredito.entidades.Cliente;
import co.tarjetaCredito.entidades.SolicitudTarjetaCredito;
import co.tarjetaCredito.repositorios.SolicitudTarjetaCreditoRepo;
import co.tarjetaCredito.servicios.SolicitudTarjetaCreditoServ;

@Service
public class SolicitudTarjetaCreditoImp implements SolicitudTarjetaCreditoServ {

    @Autowired
    private SolicitudTarjetaCreditoRepo solicitudTarjetaCreditoRepo;

    @Override
    public List<SolicitudTarjetaCredito> listadoSolicitudes() {
        return (List<SolicitudTarjetaCredito>) this.solicitudTarjetaCreditoRepo.findAll();
    }

    @Override
    public SolicitudTarjetaCredito obtenSolicitudTarjetaCredito(Integer id) {
        Optional<SolicitudTarjetaCredito> solicitudOptional = solicitudTarjetaCreditoRepo.findById(id);
            SolicitudTarjetaCredito solicitud = solicitudOptional.get();
            return solicitud;
    }

    @Override
    public void actualizarSolicitud(SolicitudTarjetaCredito solicitud) {
        this.solicitudTarjetaCreditoRepo.save(solicitud);
    }

    @Override
    public SolicitudTarjetaCredito validarCliente(Cliente cliente) {
        SolicitudTarjetaCredito SL = solicitudTarjetaCreditoRepo.findByCliente(cliente);
        if (SL != null) {
            return SL;
        }else{
            return null;
        }
    
    }

    @Override
    public void guardarSolicitud(SolicitudTarjetaCredito sl) {
        solicitudTarjetaCreditoRepo.save(sl);
    }
    
}

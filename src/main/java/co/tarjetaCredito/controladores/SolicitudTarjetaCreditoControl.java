package co.tarjetaCredito.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.tarjetaCredito.entidades.EstadoSolicitud;
import co.tarjetaCredito.entidades.SolicitudTarjetaCredito;
import co.tarjetaCredito.entidades.TarjetaCredito;
import co.tarjetaCredito.repositorios.EstadoSolicitudRepo;
import co.tarjetaCredito.servicios.SolicitudTarjetaCreditoServ;
import co.tarjetaCredito.servicios.TarjetaCreditoServ;

@Controller
public class SolicitudTarjetaCreditoControl {
    
    @Autowired
    private SolicitudTarjetaCreditoServ solicitudesServ;
    @Autowired
    private EstadoSolicitudRepo estadoSolicitudRepo;
    @Autowired
    private TarjetaCreditoServ tarjetaCreditoServ;

    TarjetaCredito tarjetaCredito =  new TarjetaCredito();

    @GetMapping("/detalles/{id}")
    public String verDetallesSolicitud(@PathVariable("id") Integer id, Model model) {
        System.out.println(solicitudesServ.obtenSolicitudTarjetaCredito(id));
        model.addAttribute("solicitudes", solicitudesServ.obtenSolicitudTarjetaCredito(id));
        return "/detalles_solicitud";
    }

    @PostMapping("/aprobarSolicitud")
    public String aprobarSolicitud(@RequestParam("idSolicitud") Integer idSolicitud, Model model) {
        SolicitudTarjetaCredito solicitud = solicitudesServ.obtenSolicitudTarjetaCredito(idSolicitud);
        EstadoSolicitud estado = estadoSolicitudRepo.findById(2).orElse(null);
        solicitud.setEstado(estado);
        solicitudesServ.actualizarSolicitud(solicitud);
        TarjetaCredito tarjeta = new TarjetaCredito();

        tarjeta.setCliente(solicitud.getCliente());
        tarjeta.setEstado(solicitud.getEstado());
        tarjeta.setLimite(0);
        tarjeta.setNumeroCuotas(0);
        tarjeta.setSaldo(0);
        tarjetaCredito = tarjetaCreditoServ.guardarTarjeta(tarjeta);
        System.out.println(tarjetaCredito);
        return "/frmtarjetacredito";
    }

    @PostMapping("/guardarTarjetaCredito")
    public String guardarTarjetaCredito(@RequestParam("limite") double limite, 
    @RequestParam("cuotas") int cuotas,
    Model model) {
        tarjetaCredito.setSaldo(limite);
        tarjetaCredito.setLimite(limite);
        tarjetaCredito.setNumeroCuotas(cuotas);
        tarjetaCreditoServ.guardarTarjeta(tarjetaCredito);
        model.addAttribute("solicitudes",solicitudesServ.listadoSolicitudes());
        return "/inicio";
    }

    /*
        */
    // Método para rechazar la solicitud
    @PostMapping("/rechazarSolicitud")
    public String rechazarSolicitud(@RequestParam("idSolicitud") Integer idSolicitud, Model model) {
        SolicitudTarjetaCredito solicitud = solicitudesServ.obtenSolicitudTarjetaCredito(idSolicitud);
        EstadoSolicitud estado = estadoSolicitudRepo.findById(3).orElse(null);
        solicitud.setEstado(estado);
        solicitudesServ.actualizarSolicitud(solicitud);
        model.addAttribute("solicitudes",solicitudesServ.listadoSolicitudes());
        return "/inicio";
    }
}

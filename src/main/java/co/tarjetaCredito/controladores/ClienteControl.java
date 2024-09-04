package co.tarjetaCredito.controladores;

import co.tarjetaCredito.servicios.ClienteServicios;
import co.tarjetaCredito.servicios.SolicitudTarjetaCreditoServ;
import co.tarjetaCredito.servicios.TarjetaCreditoServ;
import co.tarjetaCredito.Imp.ClientesIMPL;
import co.tarjetaCredito.entidades.Cliente;
import co.tarjetaCredito.entidades.Empleado;
import co.tarjetaCredito.entidades.EstadoSolicitud;
import co.tarjetaCredito.entidades.SolicitudTarjetaCredito;
import co.tarjetaCredito.entidades.TarjetaCredito;
import co.tarjetaCredito.repositorios.EstadoSolicitudRepo;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;





@Controller
public class ClienteControl {

    @Autowired
    private ClienteServicios clienteServicios;
    @Autowired
    private EstadoSolicitudRepo estadoSolicitudRepo;
    @Autowired
    private SolicitudTarjetaCreditoServ solicitudesServ;
    @Autowired
    private TarjetaCreditoServ tarjetaCreditoServ;

    Cliente validador;

    @PostMapping("/validar/cliente")
    public String mostrarFormularioRegistro(@RequestParam("email") String email,
    @RequestParam("password") String password,Model model) {
        validador = this.clienteServicios.validarCliente(email, password);
        SolicitudTarjetaCredito sl = solicitudesServ.validarCliente(validador);
        if (validador != null) {
            if (sl != null) {
                if (sl.getEstado().getSerial() == 1) {
                    return "/estadopendientesolicitud";
                }
                if(sl.getEstado().getSerial() == 3){
                    return "/estadorechazado";
                }
                if (sl.getEstado().getSerial() == 2) {
                    TarjetaCredito tr = tarjetaCreditoServ.findByCliente(sl.getCliente());
                    model.addAttribute("serial", tr.getSerial());
                    model.addAttribute("cliente", tr.getCliente().getNombre());
                    model.addAttribute("saldo", tr.getSaldo());
                    model.addAttribute("limite", tr.getLimite());
                    model.addAttribute("numeroCuotas", tr.getNumeroCuotas());
                    model.addAttribute("estado", tr.getEstado().getDescripcion());
                    return "/accionesCliente";
                }
            }
            return "/frmSolicitud";
        } else {
            return "/cliente";
        }
    }

    @GetMapping("/registroCliente")
    public String mostrarFormulario(Model model) {
        // Crear un objeto Cliente y enviarlo a la vista
        model.addAttribute("cliente", new Cliente());
        return "/registroCliente";
    }
    
    @GetMapping("/validarCliente")
    public String validarCliente() {
        return "/cliente";
    }



    @PostMapping("/guardarCliente")
    public String guardarCliente(
            @RequestParam("nombre") String nombre,
            @RequestParam("telefono") double telefono,
            @RequestParam("correo") String correo,
            @RequestParam("contrasena") String contrasena,
            @RequestParam("direccion") String direccion) {
        
        Cliente cl = new Cliente();
        cl.setNombre(nombre);
        cl.setCorreo(correo);
        cl.setContrasena(contrasena);
        cl.setTelefono(telefono);
        cl.setDireccion(direccion);
        Cliente clt = this.clienteServicios.guardarCliente(cl);
        if (clt != null) {
            return "/cliente";
        }else{
            return "/registroCliente";
        }
        
    }
    
    @PostMapping("/guardar/solicitud")
    public String guardarSolicitud(
            @RequestParam("sueldoMensual") double sueldoMensual) {
        SolicitudTarjetaCredito sl = new SolicitudTarjetaCredito();
         EstadoSolicitud estado = estadoSolicitudRepo.findById(1).orElse(null);
        sl.setCliente(validador);
        sl.setEstado(estado);
        sl.setFechaCreacion(LocalDate.now());
        sl.setSueldomensual(sueldoMensual);
        SolicitudTarjetaCredito validarSolicitud = solicitudesServ.validarCliente(sl.getCliente());
        System.out.println(validarSolicitud);
        if(validarSolicitud == null){
            solicitudesServ.guardarSolicitud(sl);
            return "/index";
        }else{
            return "/frmSolicitud";
        }

    }

    public String validarEmpleado() {
        return "/cliente";
    }

}

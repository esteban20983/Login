package co.tarjetaCredito.controladores;

import co.tarjetaCredito.servicios.ClienteServicios;

import co.tarjetaCredito.Imp.ClientesIMPL;
import co.tarjetaCredito.entidades.Cliente;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;





@Controller
public class ClienteControl {

    @Autowired
    private ClienteServicios clienteServicios;

    Cliente validador;

    @PostMapping("/validar/cliente")
    public String mostrarFormularioRegistro(@RequestParam("email") String email,
    @RequestParam("password") String password,Model model) {
        validador = this.clienteServicios.validarCliente(email, password);
        if (validador != null) {
            
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

}

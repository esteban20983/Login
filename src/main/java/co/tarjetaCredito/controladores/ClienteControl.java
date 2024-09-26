package co.tarjetaCredito.controladores;

import co.tarjetaCredito.servicios.ClienteServicios;

import co.tarjetaCredito.Imp.ClientesIMPL;
import co.tarjetaCredito.entidades.Cliente;

import java.time.LocalDate;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class ClienteControl {

    @Autowired
    private ClienteServicios clienteServicios;

    Cliente validador;

        @PostMapping("/validar/cliente")
        public String mostrarFormularioRegistro (
                @RequestParam("tipo") String tipo,
                @RequestParam("email") String email,
                @RequestParam("password") String password, RedirectAttributes redirectAttributes, HttpSession session){
            validador = this.clienteServicios.validarCliente(tipo, email, password);
            if (validador != null && tipo.equals("Cliente")) {
                session.setAttribute("clienteLogueado", validador); // Guardar el cliente en sesión
                return "/servicios";
            } else {
                redirectAttributes.addFlashAttribute("errorMensaje", "Las credenciales son incorrectas o tipo de usuario no coinciden.");
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
            @RequestParam("direccion") String direccion,
            @RequestParam("tipo") String tipo,
            Model model) {

        Cliente cl = new Cliente();
        cl.setNombre(nombre);
        cl.setCorreo(correo);
        cl.setContrasena(contrasena);
        cl.setTelefono(telefono);
        cl.setDireccion(direccion);
        cl.setTipo(tipo);

        Cliente clt = this.clienteServicios.guardarCliente(cl);
        if (clt != null) {
            model.addAttribute("successMessage", "Cliente registrado con éxito.");
            return "cliente"; // Redirige a la página de cliente
        } else {
            model.addAttribute("errorMessage", "El correo ya está en uso.");
            return "registroCliente"; // Regresa a la página de registro
        }
    }




}

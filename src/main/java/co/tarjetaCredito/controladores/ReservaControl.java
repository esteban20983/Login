package co.tarjetaCredito.controladores;

import co.tarjetaCredito.entidades.Cliente;
import co.tarjetaCredito.entidades.Reservas;
import co.tarjetaCredito.repositorios.ClienteRepo;
import co.tarjetaCredito.repositorios.ReservaRepo;
import co.tarjetaCredito.servicios.ReservaServicios;
import jakarta.servlet.http.HttpSession;
import org.hibernate.sql.model.ModelMutationLogging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReservaControl {
        @Autowired
        private ReservaServicios reservaServicios;

        @GetMapping("/reservas/crear")
        public String mostrarFormularioReserva(Model model, HttpSession session) {
            Cliente cliente = (Cliente) session.getAttribute("clienteLogueado");
            if (cliente == null) {
                return "redirect:/ValidarCliente";
            }
            model.addAttribute("reserva", new Reservas());
            return "frmSolicitud";
        }


        @PostMapping("/reservas/crear")
        public String registrarReserva(@ModelAttribute Reservas reserva, HttpSession session) {
            Cliente cliente = (Cliente) session.getAttribute("clienteLogueado");
            if (cliente != null) {
                reservaServicios.guardarReserva(reserva, cliente);
                session.setAttribute("MensajeExito", "La reserva se guardo con exito");
                return "redirect:/frmSolicitud";
            }
            return "redirect:/ValidarCliente";
        }




}

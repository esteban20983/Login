package co.tarjetaCredito.controladores;

import co.tarjetaCredito.entidades.Cliente;
import co.tarjetaCredito.entidades.Reservas;
import co.tarjetaCredito.repositorios.ClienteRepo;
import co.tarjetaCredito.repositorios.ReservaRepo;
import co.tarjetaCredito.servicios.ReservaServicios;
import jakarta.servlet.http.HttpSession;

import java.sql.Date;
import java.time.LocalDate;

import org.hibernate.sql.model.ModelMutationLogging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        public String registrarReserva(
            @RequestParam("DiasHospedaje") Integer diasHospedaje,
            @RequestParam("FechaReserva") Date FechaReserva,
            @RequestParam("NumAdultos") Integer NumAdultos,
            @RequestParam("NumNiños") Integer NumNiños,
            HttpSession session) {
            System.out.println(diasHospedaje+"dias");
            Cliente cliente = (Cliente) session.getAttribute("clienteLogueado");
            Reservas reserva = new Reservas();
            reserva.setCliente(cliente);
            reserva.setDiasHospe(diasHospedaje);
            reserva.setFecha(FechaReserva);
            reserva.setNumAdultos(NumAdultos);
            reserva.setNumNinos(NumNiños);
            System.out.println(reserva.getCliente()+"wasp");
            System.out.println(reserva+"reservaaaaaa");
            if (cliente != null) {
                reservaServicios.guardarReserva(reserva, cliente);
                session.setAttribute("MensajeExito", "La reserva se guardo con exito");
                return "redirect:/frmSolicitud";
            }
            return "redirect:/ValidarCliente";
        }




}

package co.tarjetaCredito.controladores;

import co.tarjetaCredito.entidades.Cliente;
import co.tarjetaCredito.entidades.Reservas;
import co.tarjetaCredito.repositorios.ClienteRepo;
import co.tarjetaCredito.repositorios.ReservaRepo;
import co.tarjetaCredito.servicios.ReservaServicios;
import jakarta.servlet.http.HttpSession;

import java.sql.Date;
import java.sql.SQLOutput;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;

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

    @GetMapping("/reservar/desayuno")
    public String reservarDesayuno() {
        return "/desayuno";
    }


    @PostMapping("/reservas/crear")
    public String registrarReserva(
            @RequestParam("DiasHospedaje") Integer diasHospedaje,
            @RequestParam("FechaReserva") Date FechaReserva,
            @RequestParam("NumAdultos") Integer NumAdultos,
            @RequestParam("NumNiños") Integer NumNiños,
            HttpSession session) {
        System.out.println(diasHospedaje + "dias");
        Cliente cliente = (Cliente) session.getAttribute("clienteLogueado");
        Reservas reserva = new Reservas();
        reserva.setCliente(cliente);
        reserva.setDiasHospe(diasHospedaje);
        reserva.setFecha(FechaReserva);
        reserva.setNumAdultos(NumAdultos);
        reserva.setNumNinos(NumNiños);
        System.out.println(reserva.getCliente() + "wasp");
        System.out.println(reserva + "reservaaaaaa");
        if (cliente != null) {
            session.setAttribute("NumAdultos", NumAdultos);
            session.setAttribute("NumNinos", NumNiños);
            reservaServicios.guardarReserva(reserva, cliente);
            return "redirect:/reservas/confirmar";
        }
        return "redirect:/ValidarCliente";
    }

    @GetMapping("/reservas/confirmar")
    public String confirmarReserva(HttpSession session, Model model) {
        Integer adultos = (Integer) session.getAttribute("NumAdultos");
        Integer ninos = (Integer) session.getAttribute("NumNinos");

        // VALOR TOTAL
        float valorAdulto = 100000.0f;
        float valorNino = 60000.0f;
        float opAdul= (adultos * valorAdulto);
        float opNino = (ninos * valorNino);
        float valorTotal = opAdul + opNino;

        // FORMATO EN MILES
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
        String valorTotalFormateado = numberFormat.format(valorTotal);
        System.out.println("VALOR TOTAL: " + valorTotalFormateado);

        //VALOR DEL 30%
        double pagoInicial = valorTotal * 0.3;

        //FORMATO EN MILES
        NumberFormat numberFormat2 = NumberFormat.getNumberInstance(Locale.US);
        String pagoInicialFormateado = numberFormat2.format(pagoInicial);
        System.out.println("Pago INICIAL: " + pagoInicialFormateado);


        model.addAttribute("NumAdultos", adultos);
        model.addAttribute("NumNinos", ninos);
        model.addAttribute("valorTotalFormateado", valorTotalFormateado);
        model.addAttribute("pagoInicialFormateado", pagoInicialFormateado);

        return "pagoReserva";
    }

    @GetMapping("/reservas/pago")
    public String pagoReserva(HttpSession session, Model model) {
        double valorTotalForm = (Double) session.getAttribute("valorTotalFormateado");
        double pagoInicialForm = (Double) session.getAttribute("pagoInicialFormateado");

        model.addAttribute("valorTotalFormateado", valorTotalForm);
        model.addAttribute("pagoInicialFormateado", pagoInicialForm);

        return "pagoReserva";
    }
}

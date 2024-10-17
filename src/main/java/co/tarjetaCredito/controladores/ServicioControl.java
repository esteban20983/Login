package co.tarjetaCredito.controladores;

import jdk.jfr.Category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.time.LocalDate;

@Controller
public class ServicioControl {
    @GetMapping("/servicios")
        public String servicios() {
        return "servicios";
        }

        @GetMapping("/reservar/desayuno")
        public String reservarDesayuno() {
            return "/desayuno";
        }
    
        @GetMapping("/reservar/almuerzo")
        public String reservarAlmuerzo() {
            return "/almuerzo";
        }
    
        @GetMapping("/reservar/bar")
        public String reservarBar() {
            return "/bar";
        }

         @GetMapping("/reservar/desayuno/pancakes")
        public String obtenerPedido(Model model) {
            
            LocalDate fechaActual = LocalDate.now();
            String detalle = "pancakes con sirope de arce y frutas frescas."; 
            double costo = 100.50; 

            // Agregar las variables al modelo
            model.addAttribute("fecha", fechaActual);
            model.addAttribute("detalle", detalle);
            model.addAttribute("costo", costo);
    
            return "/confirmarPedido"; 
        }
}

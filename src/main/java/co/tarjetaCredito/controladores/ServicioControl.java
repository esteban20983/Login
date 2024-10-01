package co.tarjetaCredito.controladores;

import jdk.jfr.Category;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServicioControl {
    @GetMapping("/servicios")
        public String servicios() {
        return "servicios";
        }
}

 package co.tarjetaCredito.controladores;


import java.sql.SQLOutput;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import co.tarjetaCredito.entidades.Empleado;
import co.tarjetaCredito.repositorios.EmpleadoRepo;
import co.tarjetaCredito.servicios.EmpleadoServ;
import co.tarjetaCredito.servicios.SolicitudTarjetaCreditoServ;

import org.springframework.ui.Model;

@Controller
 public class EmpleadoControl {

    @Autowired
    private EmpleadoServ empleadoServ;

    @Autowired
    private SolicitudTarjetaCreditoServ solicitudTarjetaCreditoServ;

    @PostMapping("/guardarEmpleadocontrol")
    public String registrarEmpleado(
            @RequestParam("nombre") String nombre,
            @RequestParam("email") String email,
            @RequestParam("password") String password) {
        
        Empleado emp = new Empleado();
        emp.setNombre(nombre);
        emp.setCorreo(email);
        emp.setContrasena(password);

        boolean validador = this.empleadoServ.saveEmpleado(emp);
        if (validador) {
            return "/empleado";
        }else{
            return "/registroEmpleado";
        }
        
    }

    @PostMapping("/validar/empleado")
    public String validarEmpleado(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
        boolean validador = this.empleadoServ.validarEmpleado(email, password);
        if (validador) {
            System.err.println(solicitudTarjetaCreditoServ.listadoSolicitudes());
            model.addAttribute("solicitudes",solicitudTarjetaCreditoServ.listadoSolicitudes());
            return "/inicio";
        } else {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "/empleado";
        }
    }
    @GetMapping("/registroEmpleadocontrol")
    public String getMethodName() {
        return "/registroEmpleado";
    }
    
    @GetMapping("/validarEmpleado")
    public String validarEmpleado() {
        return "/empleado";
    }

    

}
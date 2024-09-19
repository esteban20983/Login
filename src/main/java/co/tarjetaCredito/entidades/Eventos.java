package co.tarjetaCredito.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Eventos")
public class Eventos {
    @Id
    @SequenceGenerator(name = "SEQ_EVENTOS", sequenceName = "SEQ_EVENTOS", allocationSize = 1)
    @Column(name = "ID_EVENTO")
    private Long Serial;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Fecha")
    private LocalDate fecha;
    @Column(name = "Tipo")
    private String tipo;
    @Column(name = "COSTO")
    private Double Costo;

    public Long getSerial() {
        return Serial;
    }

    public void setSerial(Long serial) {
        Serial = serial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getCosto() {
        return Costo;
    }

    public void setCosto(Double costo) {
        Costo = costo;
    }

    @Override
    public String toString() {
        return "Eventos{" +
                "Serial=" + Serial +
                ", nombre='" + nombre + '\'' +
                ", fecha=" + fecha +
                ", tipo='" + tipo + '\'' +
                ", Costo=" + Costo +
                '}';
    }
}

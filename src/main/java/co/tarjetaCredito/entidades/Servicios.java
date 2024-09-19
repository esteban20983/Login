package co.tarjetaCredito.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Servicios")
public class Servicios {
    @Id
    @SequenceGenerator(name = "SEQ_SERVICIOS", sequenceName = "SEQ_SERVICIOS", allocationSize = 1)
    @Column(name = "ID_PEDIDO")
    private Long Serial;
    @Column(name="Nombre")
    private String Nombre;
    @Column(name = "Tipo")
    private String Tipo;
    @Column(name = "Costo")
    private Double costo;

    public Long getSerial() {
        return Serial;
    }

    public void setSerial(Long serial) {
        Serial = serial;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Servicios{" +
                "Serial=" + Serial +
                ", Nombre='" + Nombre + '\'' +
                ", Tipo='" + Tipo + '\'' +
                ", costo=" + costo +
                '}';
    }
}

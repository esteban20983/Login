package co.tarjetaCredito.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Inventario")
public class Inventario {
    @Id
    @SequenceGenerator(name = "SEQ_INVETARIO", sequenceName = "SEQ_INVENTARIO", allocationSize = 1)
    @Column(name = "ID_INVENTARIO")
    private Long Serial;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "TIPO")
    private String tipo;
    @Column(name = "COSTO")
    private Double costo;
    @Column(name = "CANT_DISPO")
    private Integer cantidadDispo;

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public Integer getCantidadDispo() {
        return cantidadDispo;
    }

    public void setCantidadDispo(Integer cantidadDispo) {
        this.cantidadDispo = cantidadDispo;
    }

    @Override
    public String toString() {
        return "Inventario{" +
                "Serial=" + Serial +
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", costo=" + costo +
                ", cantidadDispo=" + cantidadDispo +
                '}';
    }
}

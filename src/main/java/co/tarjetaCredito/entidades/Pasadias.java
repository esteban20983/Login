package co.tarjetaCredito.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Pasadias")
public class Pasadias implements Serializable {

    @Id
    @SequenceGenerator(name = "SEQ_PASADIAS", sequenceName = "SEQ_PASADIAS", allocationSize = 1)
    @Column(name = "ID_PASADIA")
    private Long Serial;
    @Column(name = "FECHA")
    private LocalDate fecha;
    @Column(name = "TIPO")
    private String tipo;
    @Column(name = "COSTO")
    private Double costo;

    public Long getSerial() {
        return Serial;
    }

    public void setSerial(Long serial) {
        Serial = serial;
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
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Pasadias{" +
                "Serial=" + Serial +
                ", fecha=" + fecha +
                ", tipo='" + tipo + '\'' +
                ", costo=" + costo +
                '}';
    }
}



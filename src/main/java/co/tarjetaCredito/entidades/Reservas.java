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
@Table(name="RESERVAS")
public class Reservas {
    @Id
    @SequenceGenerator(name = "SEQ_RESERVAS", sequenceName = "SEQ_RESERVAS", allocationSize = 1)
    @Column(name = "ID_RESERVA")
    private Long Serial;
    @Column(name="FECHA_RESERVA")
    private LocalDate Fecha;
    @Column(name = "NUM_ADULTOS")
    private Integer NumAdultos;
    @Column(name = "NUM_NIÑOS")
    private Integer NumNinos;
    @Column(name = "DIAS_HOSPE")
    private Integer DiasHospe;
    @Column(name = "METODO_PAGO")
    private String metodo;

    public Long getSerial() {
        return Serial;
    }

    public void setSerial(Long serial) {
        Serial = serial;
    }

    public LocalDate getFecha() {
        return Fecha;
    }

    public void setFecha(LocalDate fecha) {
        Fecha = fecha;
    }

    public Integer getNumAdultos() {
        return NumAdultos;
    }

    public void setNumAdultos(Integer numAdultos) {
        NumAdultos = numAdultos;
    }

    public Integer getNumNinos() {
        return NumNinos;
    }

    public void setNumNinos(Integer numNinos) {
        NumNinos = numNinos;
    }

    public Integer getDiasHospe() {
        return DiasHospe;
    }

    public void setDiasHospe(Integer diasHospe) {
        DiasHospe = diasHospe;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    @Override
    public String toString() {
        return "Reservas{" +
                "Serial=" + Serial +
                ", Fecha=" + Fecha +
                ", NumAdultos=" + NumAdultos +
                ", NumNinos=" + NumNinos +
                ", DiasHospe=" + DiasHospe +
                ", metodo='" + metodo + '\'' +
                '}';
    }
}

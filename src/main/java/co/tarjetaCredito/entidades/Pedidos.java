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
@Table(name = "Pedidos")
public class Pedidos {

    @Id
    @SequenceGenerator(name = "SEQ_PEDIDOS", sequenceName = "SEQ_PEDIDOS", allocationSize = 1)
    @Column(name = "ID_PEDIDO")
    private Long Serial;
    @Column(name="FECHA_PAGO")
    private LocalDate Fecha;
    @Column(name = "DETALLE")
    private String Detalle;
    @Column(name = "COSTO")
    private Double Costo;

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

    public String getDetalle() {
        return Detalle;
    }

    public void setDetalle(String detalle) {
        Detalle = detalle;
    }

    public Double getCosto() {
        return Costo;
    }

    public void setCosto(Double costo) {
        Costo = costo;
    }

    @Override
    public String toString() {
        return "Pedidos{" +
                "Serial=" + Serial +
                ", Fecha=" + Fecha +
                ", Detalle='" + Detalle + '\'' +
                ", Costo=" + Costo +
                '}';
    }
}

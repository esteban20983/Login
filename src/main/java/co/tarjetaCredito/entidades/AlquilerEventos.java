package co.tarjetaCredito.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "AlquilerEventos")
public class AlquilerEventos {
    @Id
    @SequenceGenerator(name = "SEQ_ALQUILER", sequenceName = "SEQ_ALQUILER", allocationSize = 1)
    @Column(name = "ID_ALQUILER")
    private Long Serial;
    @Column(name = "Costo")
    private Double Costo;

    public Long getSerial() {
        return Serial;
    }

    public void setSerial(Long serial) {
        Serial = serial;
    }

    public Double getCosto() {
        return Costo;
    }

    public void setCosto(Double costo) {
        Costo = costo;
    }

    @Override
    public String toString() {
        return "AlquilerEventos{" +
                "Serial=" + Serial +
                ", Costo=" + Costo +
                '}';
    }
}

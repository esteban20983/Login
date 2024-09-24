package co.tarjetaCredito.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


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

    @ManyToOne
    @JoinColumn(name = "ID_RESERVA" , nullable = true)
    private Reservas reservas;   // alquiler a reservas muchos-1 ok

    @ManyToOne
    @JoinColumn(name = "ID_EVENTO")
    private Eventos eventos; //ALQUILER A EVENTOS MUCHOS-1 ok

    
    @Override
    public String toString() {
        return "AlquilerEventos{" +
                "Serial=" + Serial +
                ", Costo=" + Costo +
                '}';
    }
}

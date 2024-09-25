package co.tarjetaCredito.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="RESERVAS")
public class Reservas implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_RESERVA")
    @SequenceGenerator(name = "SEQ_RESERVA", sequenceName = "SEQ_RESERVA", allocationSize = 1)
    @Column(name = "ID_RESERVA")
    private Long Serial;
    @Column(name = "DIAS_HOSPE")
    private Integer DiasHospe;
    @Column(name="FECHA_RESERVA")
    private Date Fecha;
    @Column(name = "NUM_ADULTOS")
    private Integer NumAdultos;
    @Column(name = "NUM_NIÑOS")
    private Integer NumNinos;


    //RELACION DE TABLAS
    @ManyToOne
    @JoinColumn(name = "CLI_CODIGO", nullable = true)    // RESERVA A CLIENTE muchos-1 ok
    private Cliente cliente; 

    @Override
    public String toString() {
        return "Pedidos{" +
                "Serial=" + Serial +
                ", Fecha=" + Fecha +
                ", numadul='" + NumAdultos + '\'' +
                ", numni=" + NumNinos +
                ", cliente=" + cliente +
                '}';
    }
}

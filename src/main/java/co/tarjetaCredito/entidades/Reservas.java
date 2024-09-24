package co.tarjetaCredito.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="RESERVAS")
public class Reservas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_RESERVA")
    private Long Serial;
    @Column(name = "DIAS_HOSPE")
    private Integer DiasHospe;
    @Column(name="FECHA_RESERVA")
    private LocalDate Fecha;
    @Column(name = "NUM_ADULTOS")
    private Integer NumAdultos;
    @Column(name = "NUM_NIÑOS")
    private Integer NumNinos;


    //RELACION DE TABLAS
    @ManyToOne
    @JoinColumn(name = "CLI_CODIGO", nullable = true)    // RESERVA A CLIENTE muchos-1 ok
    private Cliente cliente;

    @OneToMany(mappedBy = "reservas")    // RESERVA A PEDIDOS 1 -mucho ok
    private List<Pedidos> pedidos;

    @OneToMany(mappedBy = "reservas")
    private List<AlquilerEventos> alquilerEventos;  //reservas a alquiler 1-muchos ok

    @Override
    public String toString() {
        return "Reservas{" +
                "NumNinos=" + NumNinos +
                ", NumAdultos=" + NumAdultos +
                ", Fecha=" + Fecha +
                ", DiasHospe=" + DiasHospe +
                ", Serial=" + Serial +
                '}';
    }
}

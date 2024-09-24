package co.tarjetaCredito.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "ID_RESERVA", nullable = true)    //pedidos a reserva muchos-1 ok
    private Reservas reservas;

    @ManyToOne
    @JoinColumn(name="ID_SERVICIO")
    private Servicios servicios; // pedido a servicios muchos a 1 ok

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

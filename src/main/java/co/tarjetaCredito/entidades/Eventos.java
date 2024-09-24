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
@Table(name = "Eventos")
public class Eventos {
    @Id
    @SequenceGenerator(name = "SEQ_EVENTOS", sequenceName = "SEQ_EVENTOS", allocationSize = 1)
    @Column(name = "ID_EVENTO")
    private Long Serial;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Fecha")
    private LocalDate fecha;
    @Column(name = "Tipo")
    private String tipo;
    @Column(name = "COSTO")
    private Double Costo;

    @OneToMany(mappedBy = "eventos")
    private List<AlquilerEventos> alquilereventos; // Eventos a alquiler de 1-muchos ok


    @Override
    public String toString() {
        return "Eventos{" +
                "Serial=" + Serial +
                ", nombre='" + nombre + '\'' +
                ", fecha=" + fecha +
                ", tipo='" + tipo + '\'' +
                ", Costo=" + Costo +
                '}';
    }
}

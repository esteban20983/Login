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

    @ManyToOne
    @JoinColumn(name = "ID_SERVICIO")
    private Servicios servicios; //inventario a servicios muchos-1 ok

    @ManyToOne
    @JoinColumn(name = "ID_CABAÑA")
    private Cabañas cabañas; //Inventario a cabañas mucchos-1 ok

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

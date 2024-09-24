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
@Table(name = "Cabañas")

public class Cabañas {
    @Id
    @SequenceGenerator(name = "SEQ_CABAÑAS", sequenceName = "SEQ_CABAÑAS", allocationSize = 1)
    @Column(name = "ID_CABAÑA")
    private Long Serial;
    @Column(name = "NUM_CABANAS")
    private Integer numCabanas;
    @Column(name = "TIPO")
    private String tipo;
    @Column(name = "ESTADO")
    private String estado;
    @Column(name = "CAPACIDAD")
    private Integer cApacidad;

    @OneToMany(mappedBy = "cabañas")
    private List<Inventario> inventarios; // Cabaña a inventario 1 - Muchos ok


    @Override
    public String toString() {
        return "Cabañas{" +
                "Serial=" + Serial +
                ", numCabanas=" + numCabanas +
                ", tipo='" + tipo + '\'' +
                ", estado='" + estado + '\'' +
                ", cApacidad=" + cApacidad +
                '}';
    }
}

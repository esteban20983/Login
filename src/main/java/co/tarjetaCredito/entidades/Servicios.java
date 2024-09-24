package co.tarjetaCredito.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Servicios")
public class Servicios {
    @Id
    @SequenceGenerator(name = "SEQ_SERVICIOS", sequenceName = "SEQ_SERVICIOS", allocationSize = 1)
    @Column(name = "ID_SERVICIO")
    private Long Serial;
    @Column(name="Nombre")
    private String Nombre;
    @Column(name = "Tipo")
    private String Tipo;
    @Column(name = "Costo")
    private Double costo;

    @OneToMany (mappedBy = "servicios" )//SERVICIOS A PEDIDOS 1-muchos ok
    private List<Pedidos> pedidos;

    @OneToMany(mappedBy = "servicios")// servicios a inventario 1 - muchos ok
    private List<Inventario> inventarios;


    @Override
    public String toString() {
        return "Servicios{" +
                "Serial=" + Serial +
                ", Nombre='" + Nombre + '\'' +
                ", Tipo='" + Tipo + '\'' +
                ", costo=" + costo +
                '}';
    }
}

package co.tarjetaCredito.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Pasadias")
public class Pasadias implements Serializable {

    @Id
    @SequenceGenerator(name = "SEQ_PASADIAS", sequenceName = "SEQ_PASADIAS", allocationSize = 1)
    @Column(name = "ID_PASADIA")
    private Long Serial;
    @Column(name = "FECHA")
    private LocalDate fecha;
    @Column(name = "TIPO")
    private String tipo;
    @Column(name = "COSTO")
    private Double costo;

    //RELACIÓN TABLAS
    @ManyToOne
    @JoinColumn(name = "CLI_CODIGO") // pasadia a cliente muchos-1 ok
    private Cliente cliente;
}



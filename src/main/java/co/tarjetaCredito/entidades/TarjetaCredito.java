package co.tarjetaCredito.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tarjeta_credito")
public class TarjetaCredito implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_tarjeta_credito")
    @SequenceGenerator(name = "SEQ_tarjeta_credito", sequenceName = "SEQ_tarjeta_credito", allocationSize = 1)
    @Column(name = "TRJ_CODIGO")
    private long serial;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Column(name = "saldo_actual")
    private double saldo;

    @Column(name = "limiteCredito")
    private double limite;

    @Column(name = "limite_cuotas")
    private Integer numeroCuotas;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private EstadoSolicitud estado;
}

package co.tarjetaCredito.entidades;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "estado_solicitud")
public class EstadoSolicitud implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_estado_solicitud")
    @SequenceGenerator(name = "SEQ_estado_solicitud", sequenceName = "SEQ_estado_solicitud", allocationSize = 1)
    @Column(name = "EST_CODIGO")
    private long serial;

    @Column(name = "EST_DESCRIPCION")
    private String descripcion;
}

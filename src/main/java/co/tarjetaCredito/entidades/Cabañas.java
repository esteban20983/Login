package co.tarjetaCredito.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    public Long getSerial() {
        return Serial;
    }

    public void setSerial(Long serial) {
        Serial = serial;
    }

    public Integer getNumCabanas() {
        return numCabanas;
    }

    public void setNumCabanas(Integer numCabanas) {
        this.numCabanas = numCabanas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getcApacidad() {
        return cApacidad;
    }

    public void setcApacidad(Integer cApacidad) {
        this.cApacidad = cApacidad;
    }

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

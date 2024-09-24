package co.tarjetaCredito.entidades;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Cliente")
public class Cliente implements Serializable {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CLIENTE")
    @SequenceGenerator(name = "SEQ_CLIENTE", sequenceName = "SEQ_CLIENTE", allocationSize = 1)
    @Column(name = "CLI_CODIGO")
    private long serial;
    @Column(name = "CLI_nombre")
    private String nombre;
    @Column(name = "CLI_telefono")
    private double telefono;
    @Column(name = "CLI_correo")
    private String correo;
    @Column(name = "CLI_contrasena")
    private String contrasena;
    @Column(name = "CLI_direccion")
    private String direccion;
    @Column(name = "CLI_TIPO")
    private String tipo;

    // RELACION DE TABLAS CLIENTE
    @OneToMany(mappedBy = "cliente")    // cliente a reserva 1 - muchos ok
    private List<Reservas> reservas;

    @OneToMany(mappedBy = "cliente")    //cliente a pasadias 1 a muchos ok
    private List<Pasadias> pasadias;



    @Override
    public String toString() {
        return "Cliente{" +
                "serial=" + serial +
                ", nombre='" + nombre + '\'' +
                ", telefono=" + telefono +
                ", correo='" + correo + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", direccion='" + direccion + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}

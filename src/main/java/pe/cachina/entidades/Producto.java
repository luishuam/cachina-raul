package pe.cachina.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre_prod")
    private String nombre;
    @Column(name = "descripcion_prod")
    private String descripcion;
    @Column(name = "fecha_obtencion")
    private LocalDate fecha;
    private BigDecimal precio;
    private int stock;
    @Column(name = "estado_prod")
    private Boolean estado;

}

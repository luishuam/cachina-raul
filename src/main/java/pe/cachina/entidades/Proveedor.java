package pe.cachina.entidades;

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
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre_prove")
    private String nombre;
    @Column(name = "descripcion_prove")
    private String descripcion;
    @Column(name = "dni_prove", unique = true)
    private String dni;
    private String categoria;
    @Column(name = "estado_prove")
    private Boolean estado;
}

package mx.edu.utez.sagym.modelo.ejercicio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.sagym.modelo.ejercicio_asignado.EjercicioAsignado;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ejercicios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Ejercicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_ejercicio;

    @Column(nullable = false, unique = true, length = 100)
    private String nombre;
    @Column(length = 300)
    private String descripcion;

    @Column(nullable = false,columnDefinition = "TINYINT DEFAULT 1")
    private Boolean activo;
    @OneToMany(mappedBy = "ejercicio")
    @JsonIgnore
    private Set<EjercicioAsignado>  ejercicioAsignado;

    @OneToMany(mappedBy = "rutina")
    @JsonIgnore
    private Set<EjercicioAsignado>  ejercicioAsignadoR;



}

package mx.edu.utez.sagym.modelo.rutina;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.sagym.modelo.ejercicio_asignado.EjercicioAsignado;
import mx.edu.utez.sagym.modelo.usuario.Usuario;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "rutinas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Rutina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_rutina;

    @Column(nullable = false, length = 100)
    private String nombre_rutina;

    @Column(nullable = false,columnDefinition = "TINYINT DEFAULT 1")
    private Boolean activo;

    @ManyToOne
    @JoinColumn(name = "fk_instructor")
    private Usuario instructor;

    @OneToMany(mappedBy = "ejercicio")
    @JsonIgnore
    private Set<EjercicioAsignado> ejercicioAsignado;
}

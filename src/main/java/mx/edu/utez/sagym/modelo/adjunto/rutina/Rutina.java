package mx.edu.utez.sagym.modelo.rutina;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.sagym.modelo.ejercicio.Ejercicio;
import mx.edu.utez.sagym.modelo.usuario.Usuario;

import javax.persistence.*;
import java.util.List;
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
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre_rutina;

    @Column(nullable = false, columnDefinition = "TINYINT DEFAULT 1")
    private Boolean activo;

    @ManyToOne
    @JoinColumn(name = "id_instructor")
    private Usuario instructor;

    @ManyToMany
    @JoinTable( name = "ejercicios_asignados",joinColumns = @JoinColumn(name = "id_rutina"),
            inverseJoinColumns = @JoinColumn(name = "id_ejercicio"))
    Set<Ejercicio> linkEjercicio;
}

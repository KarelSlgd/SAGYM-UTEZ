package mx.edu.utez.sagym.modelo.ejercicio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.sagym.modelo.rutina.Rutina;

import javax.persistence.*;
import java.util.List;
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
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String nombre;

    @Column(nullable = false, columnDefinition = "TINYINT DEFAULT 1")
    private Boolean activo;

    @ManyToMany(mappedBy = "linkEjercicio")
    @JsonIgnore
    Set<Rutina> linkRutina;

}

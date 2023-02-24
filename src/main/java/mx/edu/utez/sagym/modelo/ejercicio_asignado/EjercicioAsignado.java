package mx.edu.utez.sagym.modelo.ejercicio_asignado;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.sagym.modelo.ejercicio.Ejercicio;
import mx.edu.utez.sagym.modelo.rutina.Rutina;

import javax.persistence.*;

@Entity
@Table(name = "ejercicios_asignados")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EjercicioAsignado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_asignacion;

    @Column(nullable = false)
    private Integer repeticiones;
    @ManyToOne
    @JoinColumn(name = "fk_rutina")
    private Rutina rutina;
    @ManyToOne
    @JoinColumn(name = "fk_ejercicio")
    private Ejercicio ejercicio;

    @Column(nullable = false,columnDefinition = "TINYINT DEFAULT 1")
    private Boolean activo;

}

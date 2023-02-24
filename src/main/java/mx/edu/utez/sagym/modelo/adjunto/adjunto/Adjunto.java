package mx.edu.utez.sagym.modelo.adjunto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.sagym.modelo.ejercicio.Ejercicio;

import javax.persistence.*;

@Entity
@Table(name = "elementos_adjuntos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Adjunto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre_archivo;

    @Column(nullable = false, length = 150)
    private String enlace;

    @Column(nullable = false, columnDefinition = "TINYINT DEFAULT 1")
    private Boolean activo;

    @ManyToOne
    @JoinColumn(name = "id_ejercicios")
    private Ejercicio ejercicio;
}

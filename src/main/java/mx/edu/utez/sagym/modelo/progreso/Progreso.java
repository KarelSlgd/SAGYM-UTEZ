package mx.edu.utez.sagym.modelo.progreso;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.sagym.modelo.rutina.Rutina;
import mx.edu.utez.sagym.modelo.usuario.Usuario;

import javax.persistence.*;

@Entity
@Table(name = "progresos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Progreso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_progreso;

    @Column(nullable = false)
    private Integer progreso_dia;

    @Column(nullable = false)
    private Integer meta_dia;

    @Column(nullable = false)
    private Integer porcentaje_dia;

    @Column(nullable = false)
    private Integer dias_avance;

    @Column(nullable = false)
    private Integer dias_meta;

    @Column(length = 300)
    private String anotaciones;

    @ManyToOne
    @JoinColumn(name = "fk_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "fk_rutina")
    private Rutina rutina;

    @Column(nullable = false,columnDefinition = "TINYINT DEFAULT 1")
    private Boolean activo;

}

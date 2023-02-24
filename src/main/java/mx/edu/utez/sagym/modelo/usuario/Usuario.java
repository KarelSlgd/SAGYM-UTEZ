package mx.edu.utez.sagym.modelo.usuario;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.sagym.modelo.rol.Rol;
import mx.edu.utez.sagym.modelo.progreso.Progreso;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String apellido_paterno;

    @Column(nullable = false, length = 50)
    private String apellido_materno;

    @Column(nullable = false, length = 100)
    private String correo;

    @Column(nullable = false, length = 200)
    private String contrasena;

    @Column(nullable = false, length = 10)
    private String telefono;

    @Column(length = 5)
    private Integer peso;

    @Column(length = 5)
    private Integer altura;

    @Column(nullable = false,columnDefinition = "TINYINT DEFAULT 1")
    private Boolean activo;

    @ManyToOne
    @JoinColumn(name = "rol")
    private Rol rol;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private Set<Progreso> progresoU;

    @OneToMany(mappedBy = "rutina")
    @JsonIgnore
    private Set<Progreso> progresoR;

}

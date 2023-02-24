package mx.edu.utez.sagym.modelo.usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.sagym.modelo.rol.Rol;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String apellido_paterno;

    @Column(nullable = false, length = 50)
    private String apellido_materno;

    @Column(nullable = false, length = 100)
    private String correo;

    @Column(nullable = false, length = 100)
    private String contrasena;

    @Column(nullable = false, length = 10)
    private Character telefono;

    @Column(length = 5)
    private Integer peso;

    @Column(length = 5)
    private Integer altura;

    @Column(nullable = false, columnDefinition = "TINYINT DEFAULT 1")
    private Boolean activo;

    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;


}

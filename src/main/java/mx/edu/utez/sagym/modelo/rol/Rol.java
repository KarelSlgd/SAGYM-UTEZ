package mx.edu.utez.sagym.modelo.rol;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_rol;

    @Column(nullable = false, length = 100)
    private String nombre_rol;

    @Column(nullable = false,columnDefinition = "TINYINT DEFAULT 1")
    private Boolean activo;
}

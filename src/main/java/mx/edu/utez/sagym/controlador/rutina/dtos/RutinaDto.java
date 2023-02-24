package mx.edu.utez.sagym.controlador.rutina.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.sagym.modelo.ejercicio.Ejercicio;
import mx.edu.utez.sagym.modelo.rutina.Rutina;
import mx.edu.utez.sagym.modelo.usuario.Usuario;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RutinaDto {
    private Long id;
    private String nombre_rutina;
    private Boolean activo;

    private Usuario instructor;

    private Set<Ejercicio> ejercicio;

    public Rutina getRutina(){
        return new Rutina(getId(),getNombre_rutina(),getActivo(),getInstructor(),getEjercicio());
    }
}

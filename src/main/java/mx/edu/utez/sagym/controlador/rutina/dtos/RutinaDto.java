package mx.edu.utez.sagym.controlador.rutina.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.sagym.modelo.rutina.Rutina;
import mx.edu.utez.sagym.modelo.usuario.Usuario;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RutinaDto {
    private Long id_rutina;
    private String nombre_rutina;
    private Boolean activo;
    private Usuario instructor;

    public Rutina getRutina(){
        return new Rutina(getId_rutina(),getNombre_rutina(),getActivo(),getInstructor(),null);
    }
}

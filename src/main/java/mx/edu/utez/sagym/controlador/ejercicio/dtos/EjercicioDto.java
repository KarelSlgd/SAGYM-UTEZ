package mx.edu.utez.sagym.controlador.ejercicio.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.sagym.modelo.ejercicio.Ejercicio;
import mx.edu.utez.sagym.modelo.rutina.Rutina;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EjercicioDto {
    private Long id;
    private String nombre;
    private Boolean activo;

    public Ejercicio getEjercicio(){
            return new Ejercicio(getId(),getNombre(),getActivo(),null);
    }
}

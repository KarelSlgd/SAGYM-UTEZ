package mx.edu.utez.sagym.controlador.ejercicio.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.sagym.modelo.ejercicio.Ejercicio;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EjercicioDto {

    private Long id_ejercicio;
    private String nombre;
    private String descripcion;
    private Boolean activo;

    public Ejercicio getEjercicio(){
       return new Ejercicio(getId_ejercicio(),getNombre(),getDescripcion(),getActivo(),null,null);
    }
}

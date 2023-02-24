package mx.edu.utez.sagym.controlador.adjunto.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.sagym.modelo.adjunto.Adjunto;
import mx.edu.utez.sagym.modelo.ejercicio.Ejercicio;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AdjuntoDto {

    private Long id;
    private String nombre_archivo;
    private String enlace;
    private Boolean activo;

    private Ejercicio ejercicio;

    public Adjunto getAdjunto(){
        return new Adjunto(getId(),getNombre_archivo(),getEnlace(),getActivo(),getEjercicio());
    }
}

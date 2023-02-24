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

    private Long id_elemento;
    private String nombre_archivo;
    private String enlace;
    private String tipo_elemento;
    private Boolean activo;
    private Ejercicio ejercicio;

    public Adjunto getAdjunto(){
        return new Adjunto(getId_elemento(),getNombre_archivo(),getEnlace(),getTipo_elemento(),getActivo(),getEjercicio());
    }
}

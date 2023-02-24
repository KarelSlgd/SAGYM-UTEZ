package mx.edu.utez.sagym.controlador.usuario.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.sagym.modelo.rol.Rol;
import mx.edu.utez.sagym.modelo.usuario.Usuario;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UsuarioDto {
    private Long id_usuario;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String correo;
    private String contrasena;
    private String telefono;
    private Integer peso;
    private Integer altura;
    private Boolean activo;
    private Rol rol;

    public Usuario getUsuario(){
        return new Usuario(getId_usuario(),getNombre(),getApellido_paterno(),getApellido_materno(),getCorreo(),getContrasena(),getTelefono(),getPeso(),getAltura(),getActivo(),getRol(),null,null);
    }

}

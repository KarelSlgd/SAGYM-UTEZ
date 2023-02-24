package mx.edu.utez.sagym.servicios.usuario;

import mx.edu.utez.sagym.modelo.usuario.Usuario;
import mx.edu.utez.sagym.modelo.usuario.UsuarioRepository;
import mx.edu.utez.sagym.utiles.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    @Transactional(readOnly = true)
    public Response<List<Usuario>> getAll(){
        return new Response<>(
                this.repository.findAll(), false, 200, "Correcto"
        );
    }

    @Transactional(readOnly= true)
    public Response<Usuario> getOne(Long id) {
        if(this.repository.existsById(id)){
            return new Response<>(
                    this.repository.findById(id).get(), false,200, "Correcto"
            );
        }
        return new Response<>(
                null,true,400,"No se encontro el usuario"
        );

    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Usuario> insert(Usuario category){
        return new Response<>(
                this.repository.saveAndFlush(category), false,200,"Usuario registrado correctamente"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Usuario> update(Usuario category){
        if(this.repository.existsById(category.getId())){
            return new Response<>(
                    this.repository.saveAndFlush(category), false,200,"Usuario actualizado correctamente"
            );
        }
        return new Response<>(
                null,true,400,"No se encontro el usuario"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Boolean> delete(Long id){
        if(this.repository.existsById(id)){
            return new Response<>(
                    this.repository.updateStatusById(false, id), false,200,"Usuario eliminado correctamente"
            );
        }
        return new Response<>(
                null,true,400,"No se encontro el usuario"
        );
    }
}

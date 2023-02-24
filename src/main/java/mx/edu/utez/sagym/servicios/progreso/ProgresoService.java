package mx.edu.utez.sagym.servicios.progreso;
import mx.edu.utez.sagym.modelo.progreso.Progreso;
import mx.edu.utez.sagym.modelo.progreso.ProgresoRepository;
import mx.edu.utez.sagym.utiles.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class ProgresoService {
    @Autowired
    private ProgresoRepository repository;

    @Transactional(readOnly = true)
    public Response<List<Progreso>> getAll(){
        return new Response<>(
                this.repository.findAll(), false, 200, "Correcto"
        );
    }

    @Transactional(readOnly= true)
    public Response<Progreso> getOne(Long id) {
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
    public Response<Progreso> insert(Progreso progreso){
        return new Response<>(
                this.repository.saveAndFlush(progreso), false,200,"Usuario registrado correctamente"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Progreso> update(Progreso progreso){
        if(this.repository.existsById(progreso.getId_progreso())){
            return new Response<>(
                    this.repository.saveAndFlush(progreso), false,200,"Usuario actualizado correctamente"
            );
        }
        return new Response<>(
                null,true,400,"No se encontro el usuario"
        );
    }

}

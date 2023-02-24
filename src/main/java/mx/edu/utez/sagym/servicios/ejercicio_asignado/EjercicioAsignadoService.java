package mx.edu.utez.sagym.servicios.ejercicio_asignado;

import mx.edu.utez.sagym.modelo.ejercicio_asignado.EjercicioAsignado;
import mx.edu.utez.sagym.modelo.ejercicio_asignado.EjercicioAsignadoRepository;
import mx.edu.utez.sagym.utiles.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;


@Service
@Transactional
public class EjercicioAsignadoService {
    @Autowired
    private EjercicioAsignadoRepository repository;
    @Transactional(readOnly = true)
    public Response<List<EjercicioAsignado>> getAll(){
        return new Response<>(
                this.repository.findAll(), false, 200, "Correcto"
        );
    }

    @Transactional(readOnly= true)
    public Response<EjercicioAsignado> getOne(Long id) {
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
    public Response<EjercicioAsignado> insert(EjercicioAsignado ejercicioAsignado){
        return new Response<>(
                this.repository.saveAndFlush(ejercicioAsignado), false,200,"Usuario registrado correctamente"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<EjercicioAsignado> update(EjercicioAsignado ejercicioAsignado){
        if(this.repository.existsById(ejercicioAsignado.getId_asignacion())){
            return new Response<>(
                    this.repository.saveAndFlush(ejercicioAsignado), false,200,"Usuario actualizado correctamente"
            );
        }
        return new Response<>(
                null,true,400,"No se encontro el usuario"
        );
    }
}

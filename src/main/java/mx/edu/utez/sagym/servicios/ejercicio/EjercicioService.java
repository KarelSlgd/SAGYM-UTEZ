package mx.edu.utez.sagym.servicios.ejercicio;

import mx.edu.utez.sagym.modelo.ejercicio.Ejercicio;
import mx.edu.utez.sagym.modelo.ejercicio.EjercicioRepository;
import mx.edu.utez.sagym.utiles.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EjercicioService {

    @Autowired
    private EjercicioRepository repository;

    @Transactional(readOnly = true)
    public Response<List<Ejercicio>> getAll(){
        return new Response<>(
                this.repository.findAll(), false, 200, "Correcto"
        );
    }
    @Transactional(readOnly= true)
    public Response<Ejercicio> getOne(Long id) {
        if(this.repository.existsById(id)){
            return new Response<>(
                    this.repository.findById(id).get(), false,200, "Correcto"
            );
        }
        return new Response<>(
                null,true,400,"No se encontro el ejercicio"
        );

    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Ejercicio> insert(Ejercicio ejercicio){
        Optional<Ejercicio> exist = this.repository.findByNombre(ejercicio.getNombre());
        if (exist.isPresent())
            return new Response<>(
                    null, true, 400,"El ejercicio ya fue registrado"
            );
        return new Response<>(
                this.repository.saveAndFlush(ejercicio), false,200,"Ejercicio registrado correctamente"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Ejercicio> update(Ejercicio ejercicio){
        if(this.repository.existsById(ejercicio.getId_ejercicio())){
            return new Response<>(
                    this.repository.saveAndFlush(ejercicio), false,200,"Ejercicio actualizado correctamente"
            );
        }
        return new Response<>(
                null,true,400,"No se encontro el ejercicio"
        );
    }

}

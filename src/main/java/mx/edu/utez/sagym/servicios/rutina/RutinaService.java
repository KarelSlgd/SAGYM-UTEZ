package mx.edu.utez.sagym.servicios.rutina;

import mx.edu.utez.sagym.modelo.rutina.Rutina;
import mx.edu.utez.sagym.modelo.rutina.RutinaRepository;
import mx.edu.utez.sagym.utiles.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RutinaService {
    @Autowired
    private RutinaRepository repository;

    @Transactional(readOnly = true)
    public Response<List<Rutina>> getAll() {
        return new Response<>(
                this.repository.findAll(), false, 200, "Correcto"
        );
    }

    @Transactional(readOnly = true)
    public Response<Rutina> getOne(Long id) {
        if (this.repository.existsById(id)) {
            return new Response<>(
                    this.repository.findById(id).get(), false, 200, "ok"
            );
        }
        return new Response<>(
                null, true, 400, "No se encontro la rutina"
        );

    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Rutina> insert(Rutina category) {
        return new Response<>(
                this.repository.saveAndFlush(category), false, 200, "Rutina registrada correctamente"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Rutina> update(Rutina category) {
        if (this.repository.existsById(category.getId())) {
            return new Response<>(
                    this.repository.saveAndFlush(category), false, 200, "Rutina actualizada correctamente"
            );
        }
        return new Response<>(
                null, true, 400, "No se encontro la rutina"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Boolean> delete(Long id) {
        if (this.repository.existsById(id)) {
            return new Response<>(
                    this.repository.updateStatusById(false, id), false, 200, "Rutina eliminada correctamente"
            );
        }
        return new Response<>(
                null, true, 400, "No se encontro la rutina"
        );
    }

}

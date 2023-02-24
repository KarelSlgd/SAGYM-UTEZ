package mx.edu.utez.sagym.servicios.adjuntos;

import mx.edu.utez.sagym.modelo.adjunto.Adjunto;
import mx.edu.utez.sagym.modelo.adjunto.AdjuntoRepository;
import mx.edu.utez.sagym.utiles.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Transactional
public class AdjuntoService {
    @Autowired
    private AdjuntoRepository repository;

    @Transactional(readOnly = true)
    public Response<List<Adjunto>> getAll() {
        return new Response<>(
                this.repository.findAll(), false, 200, "Correcto"
        );
    }

    @Transactional(readOnly = true)
    public Response<Adjunto> getOne(Long id) {
        if (this.repository.existsById(id)) {
            return new Response<>(
                    this.repository.findById(id).get(), false, 200, "Correcto"
            );
        }
        return new Response<>(
                null, true, 400, "No se encontro el elemento adjunto"
        );
    }

    /*
    {
            "nombre_archivo": "Foto",
            "enlace": "www.google.com",
            "tipo_elemento": "png",
            "activo": true,
            "ejercicio": {
                "id_ejercicio": 2,
                "nombre": "Mancuernas",
                "descripcion": "Utilizar pesas",
                "activo": true
            }
    }
     */

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Adjunto> insert(Adjunto adjunto) {
        return new Response<>(
                this.repository.saveAndFlush(adjunto), false,200,"Usuario registrado correctamente"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public Response<Adjunto> update(Adjunto adjunto) {
        if (this.repository.existsById(adjunto.getId_elemento())) {
            return new Response<>(
                    this.repository.saveAndFlush(adjunto), false, 200, "Elemento adjunto actualizado correctamente"
            );
        }
        return new Response<>(
                null, true, 400, "No se encontro el elemento adjunto"
        );
    }




}

package mx.edu.utez.sagym.controlador.progreso;

import mx.edu.utez.sagym.modelo.ejercicio_asignado.EjercicioAsignado;
import mx.edu.utez.sagym.modelo.progreso.Progreso;
import mx.edu.utez.sagym.servicios.progreso.ProgresoService;
import mx.edu.utez.sagym.utiles.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/progreso")
@CrossOrigin(origins = {"*"})
public class ProgresoController {
    @Autowired
    private ProgresoService service;

    @GetMapping("/")
    public ResponseEntity<Response<List<Progreso>>> getAll() {
        return new ResponseEntity<>(
                this.service.getAll(), HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<Progreso>> getOne(
            @PathVariable("id") Long id
    ) {
        return new ResponseEntity<>(this.service.getOne(id), HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<Response<Progreso>> insert(@RequestBody Progreso progreso) {
        return new ResponseEntity<>(
                this.service.insert(progreso), HttpStatus.CREATED
        );
    }

    @PutMapping("/")
    public ResponseEntity<Response<Progreso>> update(@RequestBody Progreso progreso) {
        return new ResponseEntity<>(
                this.service.update(progreso), HttpStatus.OK
        );
    }
}

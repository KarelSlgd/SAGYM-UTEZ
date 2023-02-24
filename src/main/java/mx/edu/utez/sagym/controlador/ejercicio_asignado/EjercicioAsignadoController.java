package mx.edu.utez.sagym.controlador.ejercicio_asignado;

import mx.edu.utez.sagym.modelo.ejercicio_asignado.EjercicioAsignado;
import mx.edu.utez.sagym.servicios.ejercicio_asignado.EjercicioAsignadoService;
import mx.edu.utez.sagym.utiles.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ejer_asig")
@CrossOrigin(origins = {"*"})
public class EjercicioAsignadoController {

    @Autowired
    private EjercicioAsignadoService service;
    //http://localhost:8080/api/ejer_asig/
    @GetMapping("/")
    public ResponseEntity<Response<List<EjercicioAsignado>>> getAll() {
        return new ResponseEntity<>(
                this.service.getAll(), HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<EjercicioAsignado>> getOne(
            @PathVariable("id") Long id
    ) {
        return new ResponseEntity<>(this.service.getOne(id), HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<Response<EjercicioAsignado>> insert(@RequestBody EjercicioAsignado ejercicioAsignado) {
        return new ResponseEntity<>(
                this.service.insert(ejercicioAsignado), HttpStatus.CREATED
        );
    }

    @PutMapping("/")
    public ResponseEntity<Response<EjercicioAsignado>> update(@RequestBody EjercicioAsignado ejercicioAsignado) {
        return new ResponseEntity<>(
                this.service.update(ejercicioAsignado), HttpStatus.OK
        );
    }
}

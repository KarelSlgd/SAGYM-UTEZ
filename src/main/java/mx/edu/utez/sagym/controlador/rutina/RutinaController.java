package mx.edu.utez.sagym.controlador.rutina;

import mx.edu.utez.sagym.modelo.rutina.Rutina;
import mx.edu.utez.sagym.servicios.rutina.RutinaService;
import mx.edu.utez.sagym.utiles.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rutina")
@CrossOrigin(origins = {"*"})
public class RutinaController {

    @Autowired
    private RutinaService service;
    //http://localhost:8080/api/rutina/
    @GetMapping("/")
    public ResponseEntity<Response<List<Rutina>>> getAll() {
        return new ResponseEntity<>(
                this.service.getAll(), HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<Rutina>> getOne(
            @PathVariable("id") Long id
    ) {
        return new ResponseEntity<>(this.service.getOne(id), HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<Response<Rutina>> insert(@RequestBody Rutina rutina) {
        return new ResponseEntity<>(
                this.service.insert(rutina), HttpStatus.CREATED
        );
    }

    @PutMapping("/")
    public ResponseEntity<Response<Rutina>> update(@RequestBody Rutina rutina) {
        return new ResponseEntity<>(
                this.service.update(rutina), HttpStatus.OK
        );
    }
}

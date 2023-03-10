package mx.edu.utez.sagym.controlador.adjunto;

import mx.edu.utez.sagym.modelo.adjunto.Adjunto;
import mx.edu.utez.sagym.servicios.adjuntos.AdjuntoService;
import mx.edu.utez.sagym.utiles.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/adjunto")
@CrossOrigin(origins = {"*"})
public class AdjuntoController {
    @Autowired
    private AdjuntoService service;

    //http://localhost:8080/api/adjunto/

    @GetMapping("/")
    public ResponseEntity<Response<List<Adjunto>>> getAll() {
        return new ResponseEntity<>(
                this.service.getAll(), HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<Adjunto>> getOne(
            @PathVariable("id") Long id
    ) {
        return new ResponseEntity<>(this.service.getOne(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Response<Adjunto>> insert(@RequestBody Adjunto adjunto) {
        return new ResponseEntity<>(
                this.service.insert(adjunto), HttpStatus.CREATED
        );
    }

    @PutMapping("/")
    public ResponseEntity<Response<Adjunto>> update(@RequestBody Adjunto adjunto) {
        return new ResponseEntity<>(
                this.service.update(adjunto), HttpStatus.OK
        );
    }
}

package mx.edu.utez.sagym.controlador.rutina;

import mx.edu.utez.sagym.modelo.ejercicio.Ejercicio;
import mx.edu.utez.sagym.modelo.rutina.Rutina;
import mx.edu.utez.sagym.servicios.rutina.RutinaService;
import mx.edu.utez.sagym.utiles.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rutina")
@CrossOrigin(origins = {"*"})
public class RutinaController {

    @Autowired
    private RutinaService service;

    @GetMapping("/")
    public ResponseEntity<Response<List<Rutina>>> getAll() {
        return new ResponseEntity<>(
                this.service.getAll(), HttpStatus.OK
        );
    }
}

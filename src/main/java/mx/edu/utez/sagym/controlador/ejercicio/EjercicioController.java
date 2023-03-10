package mx.edu.utez.sagym.controlador.ejercicio;

import mx.edu.utez.sagym.modelo.ejercicio.Ejercicio;
import mx.edu.utez.sagym.servicios.ejercicio.EjercicioService;
import mx.edu.utez.sagym.utiles.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ejercicio")
@CrossOrigin(origins = {"*"})
public class EjercicioController {


    @Autowired
    private EjercicioService service;


    //http://localhost:8080/api/ejercicio/
    @GetMapping("/")
    public ResponseEntity<Response<List<Ejercicio>>> getAll() {
        return new ResponseEntity<>(
                this.service.getAll(), HttpStatus.OK
        );
    }

    //http://localhost:8080/api/ejercicio/1
    @GetMapping("/{id}")
    public ResponseEntity<Response<Ejercicio>> getOne(
            @PathVariable("id") Long id
    ) {
        return new ResponseEntity<>(this.service.getOne(id), HttpStatus.OK);
    }

    /*
    {
        "nombre": "Mancuernas",
        "descripcion": "Utilizar pesas",
        "activo": true
    }
     */
    @PostMapping("/")
    public ResponseEntity<Response<Ejercicio>> insert(@RequestBody Ejercicio ejercicio) {
        return new ResponseEntity<>(
                this.service.insert(ejercicio), HttpStatus.CREATED
        );
    }

    /*
    {
        "id_ejercicio": 3,
        "nombre": "Mancuernas",
        "descripcion": "Primero realizar repeticiones con un brazo y luego con el otro",
        "activo": true
    }
     */
    @PutMapping("/")
    public ResponseEntity<Response<Ejercicio>> update(@RequestBody Ejercicio ejercicio) {
        return new ResponseEntity<>(
                this.service.update(ejercicio), HttpStatus.OK
        );
    }


}

package mx.edu.utez.sagym.controlador.usuario;
import mx.edu.utez.sagym.modelo.usuario.Usuario;
import mx.edu.utez.sagym.servicios.usuario.UsuarioService;
import mx.edu.utez.sagym.utiles.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin(origins = {"*"})
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    //http://localhost:8080/api/usuario/

    @GetMapping("/")
    public ResponseEntity<Response<List<Usuario>>> getAll() {
        return new ResponseEntity<>(
                this.service.getAll(), HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<Usuario>> getOne(
            @PathVariable("id") Long id
    ) {
        return new ResponseEntity<>(this.service.getOne(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Response<Usuario>> insert(@RequestBody Usuario usuario) {
        return new ResponseEntity<>(
                this.service.insert(usuario), HttpStatus.CREATED
        );
    }

    @PutMapping("/")
    public ResponseEntity<Response<Usuario>> update(@RequestBody Usuario usuario) {
        return new ResponseEntity<>(
                this.service.update(usuario), HttpStatus.OK
        );
    }

}

package mx.edu.utez.sagym.modelo.rol;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface RolRepository extends JpaRepository<Rol,Long> {
}

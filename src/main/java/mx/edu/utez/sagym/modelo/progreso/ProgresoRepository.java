package mx.edu.utez.sagym.modelo.progreso;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProgresoRepository extends JpaRepository<Progreso,Long> {

    Optional<Progreso> findById(Long id);
}

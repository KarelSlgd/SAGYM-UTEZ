package mx.edu.utez.sagym.modelo.ejercicio_asignado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EjercicioAsignadoRepository extends JpaRepository<EjercicioAsignado, Long> {

    Optional<EjercicioAsignado> findById(Long id);
}

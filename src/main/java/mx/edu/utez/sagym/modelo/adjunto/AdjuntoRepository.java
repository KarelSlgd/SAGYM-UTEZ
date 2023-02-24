package mx.edu.utez.sagym.modelo.adjunto;

import mx.edu.utez.sagym.modelo.ejercicio.Ejercicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface AdjuntoRepository extends JpaRepository<Adjunto,Long> {

    Optional<Adjunto> findById(Long id);

    Optional<Adjunto> findByEjercicio (Ejercicio ejercicio);
    @Query(value = "UPDATE elementos_adjuntos SET activo = :activo WHERE id = :id", nativeQuery = true)
    boolean updateStatusById(@Param("activo") Boolean status, @Param("id") Long id);
}

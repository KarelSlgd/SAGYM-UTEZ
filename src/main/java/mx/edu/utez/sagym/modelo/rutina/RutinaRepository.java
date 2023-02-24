package mx.edu.utez.sagym.modelo.rutina;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface RutinaRepository extends JpaRepository<Rutina, Long> {

    Optional<Rutina> findById(Long id);

    @Query(value = "UPDATE rutinas SET activo = :activo WHERE id = :id", nativeQuery = true)
    boolean updateStatusById(@Param("activo") Boolean status, @Param("id") Long id);

}

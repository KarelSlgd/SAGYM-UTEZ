package mx.edu.utez.sagym.modelo.ejercicio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface EjercicioRepository extends JpaRepository<Ejercicio, Long> {

    Optional<Ejercicio> findById(Long id);

    Optional<Ejercicio> findByNombre(String nombre);

    @Query(value = "UPDATE ejercicios SET activo = :activo WHERE id = :id", nativeQuery = true)
    boolean updateStatusById(@Param("activo") Boolean status, @Param("id") Long id);
}

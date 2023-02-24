package mx.edu.utez.sagym.modelo.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    Optional<Usuario> findById(Long id);

    @Query(value = "UPDATE usuarios SET activo = :activo WHERE id = :id", nativeQuery = true)
    boolean updateStatusById(@Param("activo") Boolean status, @Param("id") Long id);

}

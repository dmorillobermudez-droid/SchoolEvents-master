package Repositorios;

import es.safareyes.schoolevents.Modelos.RolEnum;
import es.safareyes.schoolevents.Modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByEmail(String email);

    Optional<Usuario> findByUsername(String username);

    Boolean existsByEmail(String email);

    Boolean existsByUsername(String username);

    List<Usuario> findByRol(RolEnum rol);
}
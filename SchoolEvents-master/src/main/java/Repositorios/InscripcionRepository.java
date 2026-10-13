package Repositorios;

import es.safareyes.schoolevents.Modelos.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, Integer> {

    List<Inscripcion> findByUsuarioId(Integer idUsuario);

    List<Inscripcion> findByEventoId(Integer idEvento);

    Optional<Inscripcion> findByEventoIdAndUsuarioId(Integer idEvento, Integer idUsuario);

    Boolean existsByEventoIdAndUsuarioId(Integer idEvento, Integer idUsuario);

    List<Inscripcion> findByEstado(String estado);
}
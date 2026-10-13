package es.safareyes.schoolevents.Repositorios;

import es.safareyes.schoolevents.Modelos.Inscripcion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {

    // 11. GET /api/v1/usuarios/me/eventos?tipo=[cite: 2]
    @Query(value = "SELECT i.* FROM Inscripcion i " +
            "WHERE i.id_usuario = :idUsuario " +
            "AND (:tipo IS NULL OR i.estado = :tipo)",
            nativeQuery = true)
    List<Inscripcion> findAgendaUsuario(@Param("idUsuario") Long idUsuario, @Param("tipo") String tipo);

    // 12. GET /api/v1/eventos/{id}/inscripciones[cite: 2]
    @Query(value = "SELECT i.* FROM Inscripcion i " +
            "WHERE i.id_evento = :idEvento " +
            "ORDER BY i.fecha ASC",
            nativeQuery = true)
    Page<Inscripcion> findInscripcionesPorEvento(@Param("idEvento") Long idEvento, Pageable pageable);
}
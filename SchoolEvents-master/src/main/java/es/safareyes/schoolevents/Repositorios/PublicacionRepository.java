package es.safareyes.schoolevents.Repositorios;

import es.safareyes.schoolevents.Modelos.Publicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicacionRepository extends JpaRepository<Publicacion, Long> {

    // 15. GET /api/v1/eventos/{id}/publicaciones[cite: 2]
    @Query(value = "SELECT p.* FROM Publicacion p " +
            "WHERE p.id_evento = :idEvento " +
            "ORDER BY p.id_publicacion DESC",
            nativeQuery = true)
    List<Publicacion> findPublicacionesPorEvento(@Param("idEvento") Long idEvento);

    List<Publicacion> findByEventoId(int i);
}
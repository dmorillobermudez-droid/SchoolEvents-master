package es.safareyes.schoolevents.Repositorios;

import es.safareyes.schoolevents.Modelos.Evento;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {

    // 1. GET /api/v1/eventos (Listado paginado con filtros)[cite: 2]
    @Query(value = "SELECT e.* FROM Evento e " +
            "WHERE (:idCategoria IS NULL OR e.id_categoria = :idCategoria) " +
            "AND (:estado IS NULL OR e.estado = :estado)",
            nativeQuery = true)
    Page<Evento> findEventosConFiltros(@Param("idCategoria") Long idCategoria,
                                       @Param("estado") String estado,
                                       Pageable pageable);

    // 2. GET /api/v1/eventos/calendario?mes=&anio= (Eventos del mes)[cite: 2]
    @Query(value = "SELECT e.* FROM Evento e " +
            "WHERE EXTRACT(MONTH FROM e.fecha_inicio) = :mes " +
            "AND EXTRACT(YEAR FROM e.fecha_inicio) = :anio " +
            "ORDER BY e.fecha_inicio ASC",
            nativeQuery = true)
    List<Evento> findEventosPorMesYAnio(@Param("mes") int mes, @Param("anio") int anio);

    // 3. GET /api/v1/eventos/{id} (Detalle del evento)[cite: 2]
    @Query(value = "SELECT e.* FROM Evento e WHERE e.id_evento = :idEvento", nativeQuery = true)
    Evento findDetalleEvento(@Param("idEvento") Long idEvento);

    List<Evento> findByEstado(String activo);
}